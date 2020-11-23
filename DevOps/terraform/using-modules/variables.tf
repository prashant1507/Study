variable "vsphere_client_user" {
  type        = string
  description = "Username for VSphere"
  default     = "administrator@vsphere.local"
}

variable "vsphere_client_password" {
  description = "Password for VSphere"
  default     = "S0ssw0rd@19"
}

variable "vsphere_client_server" {
  description = "VSphere URL"
  default     = "192.168.0.201"
}

variable "allow_unverified_ssl" {
  default = true
}

# Ansible files
variable "ansible_inventory_template" {
  description = "Ansible inventory file template path"
  default     = "../clone-and-create-snapshot/resources/inventory.tmpl"
}

variable "ansible_inventory" {
  description = "Ansible inventory path"
  default     = "../../ansible/resources/inventory"
}

variable "ansible_variable_file_template" {
  description = "Ansible variable file template path"
  default     = "../clone-and-create-snapshot/resources/variables.tmpl"
}

variable "ansible_variable_file" {
  description = "Ansible variables file path"
  default     = "../../ansible/resources/variables.json"
}

variable "ssh_key" {
  default = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCwCzL+VBOpWN5xoKGD3Dr6SobQblA/B/z5a2U5p/onxy162oC84afsWxoxWqkRpygjhMVut25W4Lf57GvGYSIRz2z4xjv0zrpa3GcIeUNNCpojeYclhDH/rdllSWQ4+IFDepDxZrkmJtJv6l/TJg8ZPOxEzWtIuqQPpoRztgvf1/MJqYoskrgYUhd8AS1h/tS9A03LC88ItpPyHewLy4+rJdpzohH6W5PE39n/dpa7zThooJEpX+bCx748yQEDhUpkcqomt8eTVbvt8sqgYyAlKRFmJTrSvmn4P79WsgXRcYBupRPSoFjJnzb6vSbAMZwR8/hAHEJNH2bEYYJdQlVz shibu@Ubuntu64bit"
}

