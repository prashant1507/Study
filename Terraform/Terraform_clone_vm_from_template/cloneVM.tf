# Configure VSphere Provider
provider "vsphere" {
  version        = "1.24.2"
  user           = var.vsphere_client_user
  password       = var.vsphere_client_password
  vsphere_server = var.vsphere_client_server
  # If you have a self-signed cert
  allow_unverified_ssl = var.allow_unverified_ssl
}

#### Create a virtual machine
# Define VMware vSphere
data "vsphere_datacenter" "var_ESxi_Datacenter" {
    name = var.vsphere_datacenter
}

data "vsphere_datastore" "var_datastore" {
    name = var.vsphere_datastore
    datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_compute_cluster" "var_cluster" {
    name = var.vsphere_cluster
    datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_network" "var_network" {
    name = var.vsphere_vm_network
    datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}

data "vsphere_virtual_machine" "var_template" {
    name = var.vm_template_name
    datacenter_id = data.vsphere_datacenter.var_ESxi_Datacenter.id
}


resource "vsphere_virtual_machine" "vm" {
  name             = "terraform-test"
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
    label            = "disk0"
    size             = data.vsphere_virtual_machine.var_template.disks.0.size
    eagerly_scrub    = data.vsphere_virtual_machine.var_template.disks.0.eagerly_scrub
    thin_provisioned = data.vsphere_virtual_machine.var_template.disks.0.thin_provisioned
  }

  clone {
    template_uuid = data.vsphere_virtual_machine.var_template.id

    # Below is to customize VM
    # customize {
    #   linux_options {
    #     host_name = "terraform-test"
    #     domain    = ""
    #   }

    #   network_interface {
    #     ipv4_address = "192.168.0.200"
    #     ipv4_netmask = 24
    #   }
        
    #   ipv4_gateway = "192.168.0.1"
    # }
  }
}

