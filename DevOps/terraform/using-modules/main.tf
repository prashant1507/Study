# Configure VSphere Provider
terraform {
  required_version = ">=0.12.0"
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

module "vm1" {
  source                         = "../clone-and-create-snapshot"
  vm_template_name               = "ubuntu_18_server"
  ssh_password                   = "password"
  ssh_public_key                 = var.ssh_key
  ansible_inventory_template     = var.ansible_inventory_template
  ansible_inventory              = var.ansible_inventory
  ansible_variable_file_template = var.ansible_variable_file_template
  ansible_variable_file          = var.ansible_variable_file
  vsphere_client_user            = var.vsphere_client_user
  vsphere_client_password        = var.vsphere_client_password
  vsphere_client_server          = var.vsphere_client_server
  allow_unverified_ssl           = var.allow_unverified_ssl

  ipv4_address = "192.168.0.207"
  vm_name      = "vm1"
}

module "vm2" {
  source                         = "../clone-and-create-snapshot"
  vm_template_name               = "ubuntu_18_server"
  ssh_password                   = "password"
  ssh_public_key                 = var.ssh_key
  ansible_inventory_template     = var.ansible_inventory_template
  ansible_inventory              = var.ansible_inventory
  ansible_variable_file_template = var.ansible_variable_file_template
  ansible_variable_file          = var.ansible_variable_file
  vsphere_client_user            = var.vsphere_client_user
  vsphere_client_password        = var.vsphere_client_password
  vsphere_client_server          = var.vsphere_client_server
  allow_unverified_ssl           = var.allow_unverified_ssl

  ipv4_address = "192.168.0.208"
  vm_name      = "vm2"
  num_cpu      = 1
  host_name    = "testvm2"
}