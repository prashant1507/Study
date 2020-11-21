# Configure VSphere Provider
terraform {
  required_version = ">=0.13.5"
  required_providers {
    vsphere = "> 1.16.0"
  }
}
provider "vsphere" {
  user           = var.vsphere_client_user
  password       = var.vsphere_client_password
  vsphere_server = var.vsphere_client_server
  # If you have a self-signed cert
  allow_unverified_ssl = var.allow_unverified_ssl
}

# Define VMware vSphere details
data "vsphere_datacenter" "var_ESxi_Datacenter" {
  name = var.vsphere_datacenter
}

data "vsphere_datastore" "var_datastore" {
  name          = var.vsphere_datastore
  datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_compute_cluster" "var_cluster" {
  name          = var.vsphere_cluster
  datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_network" "var_network" {
  name          = var.vsphere_vm_network
  datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_virtual_machine" "var_template" {
  name          = var.vm_template_name
  datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

resource "vsphere_virtual_machine" "vm" {

  # To create more than 1 vm clone
  # count            = 2
  # name             = format("terraform-%s-%s", var.vm_template_name, count.index + 1)

  name             = format("terraform-%s", var.vm_template_name)
  resource_pool_id = data.vsphere_compute_cluster.var_cluster.resource_pool_id
  datastore_id     = data.vsphere_datastore.var_datastore.id

  num_cpus = var.num_cpu
  memory   = var.memory
  guest_id = data.vsphere_virtual_machine.var_template.guest_id

  scsi_type = data.vsphere_virtual_machine.var_template.scsi_type

  network_interface {
    network_id   = data.vsphere_network.var_network.id
    adapter_type = data.vsphere_virtual_machine.var_template.network_interface_types[0]
  }

  disk {
    label            = var.disk_label
    size             = data.vsphere_virtual_machine.var_template.disks.0.size
    eagerly_scrub    = data.vsphere_virtual_machine.var_template.disks.0.eagerly_scrub
    thin_provisioned = data.vsphere_virtual_machine.var_template.disks.0.thin_provisioned
  }

  clone {
    template_uuid = data.vsphere_virtual_machine.var_template.id

    # Below is to customize for cloned VM
    # customize {
    #   linux_options {
    #     host_name = var.host_name
    #     domain    = var.domain_name
    #     time_zone = var.time_zone 
    #   }

    # network_interface {
    #   ipv4_address = var.ipv4_address
    #   ipv4_netmask = var.ipv4_netmask
    #   dns_server_list = [ var.dns_server_list ]
    # }

    # ipv4_gateway = var.ipv4_gateway
    # }
  }

  # To copy public key
  provisioner "remote-exec" {
    inline = [
      "systemd-machine-id-setup",
      "mkdir -p /home/${var.ssh_user}/.ssh",
      "touch /home/${var.ssh_user}/.ssh/authorized_keys",
      "echo ${var.ssh_public_key} >> /home/${var.ssh_user}/.ssh/authorized_keys",
      "chown ${var.ssh_user}:${var.ssh_user} -R /home/${var.ssh_user}/.ssh",
      "chmod 700 /home/${var.ssh_user}/.ssh",
      "chmod 600 /home/${var.ssh_user}/.ssh/authorized_keys"
    ]
  }

  # To do ssh 
  connection {
    host     = self.default_ip_address
    type     = "ssh"
    user     = var.ssh_user
    password = var.ssh_password
  }
}

# resource "vsphere_virtual_machine_snapshot" "vm_snapshot" {
#   virtual_machine_uuid = vsphere_virtual_machine.vm.clone[0].template_uuid
#   snapshot_name        = "snapshot_name"
#   description          = "This is Demo Snapshot"
#   memory               = "true"
#   quiesce              = "true"
#   remove_children      = "false"
#   consolidate          = "true"
# }

# The Ansible inventory file
resource "local_file" "ansible_inventory" {
  content = templatefile(var.ansible_inventory_template,
    {
      ip_address = vsphere_virtual_machine.vm.guest_ip_addresses[0],
      user       = var.ssh_user,
      password   = var.ssh_password
    }
  )
  filename = var.ansible_inventory
}

output "ipv4_address" {
  value = vsphere_virtual_machine.vm.guest_ip_addresses[0]
}