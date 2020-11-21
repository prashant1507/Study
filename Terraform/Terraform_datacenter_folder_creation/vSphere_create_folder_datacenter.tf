# Configure VSphere Provider
provider "vsphere" {
  user           = var.vsphere_client_user
  password       = var.vsphere_client_password
  vsphere_server = var.vsphere_client_server

  # If you have a self-signed cert
  allow_unverified_ssl = true
} 

# Creating a new datacenter and folder in the new datacenter
resource "vsphere_datacenter" "datacenter-variable-name" {
  name = "datacenter-name"
}

resource "vsphere_folder" "folder-in-datacenter-name" {
  path = "datacenter-name-folder"
  type = "vm"
  datacenter_id = vsphere_datacenter.datacenter-variable-name.moid
}