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

resource "vsphere_virtual_machine" "vm" {
  name             = "terraform-test"
  resource_pool_id = data.vsphere_compute_cluster.var_cluster.resource_pool_id
  datastore_id     = data.vsphere_datastore.var_datastore.id

  num_cpus = 2
  memory   = 2024
  guest_id = "ubuntu20NewVM"

  network_interface {
    network_id = data.vsphere_network.var_network.id
  }

  disk {
    label = "disk0"
    size  = 5
  }
}