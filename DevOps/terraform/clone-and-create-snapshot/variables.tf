variable "vsphere_client_user" {
  type        = string
  description = "Username for VSphere"
}

variable "vsphere_client_password" {
  description = "Password for VSphere"
}

variable "vsphere_client_server" {
  description = "VSphere URL"
}

variable "allow_unverified_ssl" {
}

variable "vsphere_datacenter" {
  description = "VMWare vSphere datacenter"
  default     = "ESxi_Datacenter"
}

variable "vsphere_datastore" {
  description = "VMWare vSphere datastore"
  default     = "datastore1"
}

variable "vsphere_cluster" {
  description = "VMWare vSphere cluster"
  default     = "ESxi_Cluster"
}

variable "vsphere_vm_network" {
  description = "VMWare vSphere network"
  default     = "VM Network"
}

variable "vm_template_name" {
  description = "Template Name"
}

variable "vm_name" {
  description = "vm name"
  default = "vm-machine"
}

variable "num_cpu" {
  type        = number
  description = "Number of CPUs"
  default     = 2
}

variable "memory" {
  description = "Memory for vm"
  default     = 2024
}

variable "host_name" {
  description = "Hostname of VM"
  default     = "testHostname"
}

variable "domain_name" {
  description = "Domanin for the VM"
  default     = ""
}

variable "time_zone" {
  description = "Timezone for VM"
  default     = "Asia/Dubai"
}

variable "ipv4_address" {
  description = "IPv4 address"
  default     = "192.168.0.205"
}

variable "ipv4_netmask" {
  description = "IPv4 netmask for VM"
  type        = number
  default     = 24
}

variable "dns_server_list" {
  description = "DNS Server IP"
  default     = "192.168.0.1"
}

variable "ipv4_gateway" {
  description = "IPv4 gateway for VM"
  default     = "192.168.0.1"
}

variable "disk_label" {
  description = "Disk name of VM"
  default     = "disk0"
}

variable "ssh_public_key" {
  description = "SSH Keys"
}

variable "ssh_user" {
  description = "User in vm"
  default     = "user"
}

variable "ssh_password" {
  description = "Password of user in vm"
}

variable "connection_type" {
  default = "ssh"
}

# Ansible files
variable "ansible_inventory_template" {
  description = "Ansible inventory file template path"
}

variable "ansible_inventory" {
  description = "Ansible inventory path"
}

variable "ansible_variable_file_template" {
  description = "Ansible variable file template path"
}

variable "ansible_variable_file" {
  description = "Ansible variables file path"
}