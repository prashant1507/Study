variable "vsphere_client_user" {
  description = "Username for VSphere"
  default     = "administrator@vsphere.local"
}

variable "vsphere_client_password" {
  type        = string
  description = "Password for VSphere"
  default     = "S0ssw0rd@19"
}

variable "vsphere_client_server" {
  description = "VSphere URL"
  default     = "192.168.0.198"
}

variable "allow_unverified_ssl" {
  default = "true"
}

variable "vsphere_datacenter" {
  type        = string
  description = "VMWare vSphere datacenter"
  default     = "ESxi_Datacenter"
}

variable "vsphere_datastore" {
  type        = string
  description = "VMWare vSphere datastore"
  default     = "datastore1"
}

variable "vsphere_cluster" {
  type        = string
  description = "VMWare vSphere cluster"
  default     = "ESxi_Cluster"
}

variable "vsphere_vm_network" {
  type        = string
  description = "VMWare vSphere network"
  default     = "VM Network"
}

variable "vm_template_name" {
  type        = string
  description = "Template Name"
  default     = "ubuntu_20"
}

variable "num_cpu" {
  type        = number
  description = "Number of CPUs"
  default     = 2
}

variable "memory" {
  type        = number
  description = "Memory for vm"
  default     = 1024
}
