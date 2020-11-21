{
    "Download the latest version with the command": "wget https://releases.hashicorp.com/terraform/0.12.24/terraform_0.12.24_linux_amd64.zip",
    "Install zip with the command": "sudo apt-get install zip -y",
    "Unzip the Terraform download with the command": "unzip terraform*.zip",
    "Finally, move the executable with the command": "sudo mv terraform /usr/local/bin",
    "Test to make sure the installation works with the command": "terraform version",

    // Prepare environament to use terraform with VSpehere
    "Link": "https://www.youtube.com/watch?v=B2SLundu-SE&ab_channel=sysadmintutorials",
    "Setup ESxi": "Install VCSA on vmware",
    "Setup VCenter": "Setup VCenter"
}

terraform init
terraform plan
terraform apply [--auto-approve]
terraform destroy [--auto-approve]
to use tfvar file: terraform plan --var-file=path.tfvar
to format all tf file: terraform fmt
to refresh: terraform refresh


Examples: https://github.com/diodonfrost/terraform-vsphere-examples

Ansible+Terraform: https://github.com/DevOpsPlayground/Hands-on-with-Terraform-and-Ansible#check-instance-is-running
