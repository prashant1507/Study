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
  default = "true"
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
  default     = "ubuntu_18"
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
  description = "DNS IP"
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
  default     = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDdXjYaA5NEBoM/N3yY+3RDP+7dv78LlUHfBDv73L/HP6v321lb1gWz5dezAti/AMa073I7qIYBX7FesPvni6zJ0C1XuNkEjDXia1Qtb8S0KtJZf3g+4eYKkKHEmRZHWI0cuwwkRFN/DsqCBeo1iAz0wzhNkgHXJBICCva0XsKFbNGYO+4u403qOekVkT7CxEQB+e1xFmfZ+N+WFdXwfqWy48aNUomq1OAC7rOwAtbBE9U9XRwYWvF+Ad/tpgVBkObqoX1G5agDAEnqTo/uYx7kR6uK4s69+6hzfnRpoH+LyvEjkvi241RU0/AiTjDiT2W+T/6cryRKxd9vBYzAbgFVy6tG15tlgJPBfVRCNQ+dVoxuRvPT6Ur/k9G2RZj3vqaYi4gCh5N6Yx+ZCfXgO8dsxlT1GiJL6zU2lWMjYiY7AYGWl6m5JZvcQeTYQsPABR10bgiFsvW216QvDW7vbtJ3xgthCZGYGgaFamdNzodFMXiSwWcIHges0nkZmxhJZqc= user@ubuntu20"
}

variable "ssh_user" {
  default = "user"
}

variable "ssh_password" {
  default = "password"
}

# Ansible inventory file
variable "ansible_inventory_template" {
  description = "Ansible inventory file template path"
  default = "../../ansible/resources/inventory.tmpl"
}

variable "ansible_inventory" {
  description = "Ansible inventory path"
  default = "../../ansible/inventory"
}