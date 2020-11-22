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

