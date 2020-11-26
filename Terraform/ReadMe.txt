{
    "Download the latest version with the command": "wget https://releases.hashicorp.com/terraform/0.13.5/terraform_0.13.5_linux_amd64.zip",
    "Install zip with the command": "sudo apt-get install zip -y",
    "Unzip the Terraform download with the command": "unzip terraform*.zip",
    "Finally, move the executable with the command": "sudo mv terraform /usr/local/bin",
    "Test to make sure the installation works with the command": "terraform version",

    // Prepare environament to use terraform with VSpehere
    "Link": "https://www.youtube.com/watch?v=B2SLundu-SE&ab_channel=sysadmintutorials",
    "Setup ESxi": "Install VCSA on vmware",
    "Setup VCenter": "Setup VCenter"
}

// To fix Ubuntu 18 and 20 customization problem
1.rm -f /etc/resolv.conf
2.ln -s /run/systemd/resolve/resolv.conf /etc/resolv.conf
3. Open the tmp.conf under /usr/lib/tmpfiles.d/tmp.conf file.
4. Comment the line below
		#D /tmp 1777 root root -
5. If you have open-vm-tools installed, open the /lib/systemd/system/open-vm-tools.service file. In certain version path may be different the use find command locate the file 
                Add this line “After=dbus.service” under [Unit]

terraform init
terraform plan
terraform apply [--auto-approve]
terraform destroy [--auto-approve]
to use tfvar file: terraform plan --var-file=path.tfvar
to format all tf file: terraform fmt
to refresh: terraform refresh
to store plan: terraform plan -out plan
to run from plan: terraform apply plan
to delete particular snapshot: terraform destroy -target=vsphere_virtual_machine_snapshot.vm_snapshot[0]

Examples: https://github.com/diodonfrost/terraform-vsphere-examples
        Examples using module: https://github.com/Terraform-VMWare-Modules/terraform-vsphere-vm

Ansible+Terraform: https://github.com/DevOpsPlayground/Hands-on-with-Terraform-and-Ansible#check-instance-is-running
                   https://coffay.haus/pages/terraform+ansible/
                   
Book: https://cdn2.hubspot.net/hubfs/5041972/Digital/Devops%20Automation%20with%20Terraform%20and%20VMware.pdf
