variable "vsphere_client_user" {
  default = "administrator@vsphere.local"
}

variable "vsphere_client_password" {
  type        = string
  description = "vSphere password"
  default     = "S0ssw0rd@19"
}

variable "vsphere_client_server" {
  default = "192.168.0.198"
}