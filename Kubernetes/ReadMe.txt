https://www.youtube.com/watch?v=xi4VLYrwFgg&list=PL6XT0grm_TfhFKUv_KI_DTVr0TCincl1r&ab_channel=GauravSharma
https://www.youtube.com/watch?v=bhBSlnQcq2k&ab_channel=Amigoscode
https://www.youtube.com/watch?v=X48VuDVv0do&ab_channel=TechWorldwithNana

======== About Kubernates ========
- Kubelet process is a kubernates process to help clusters to communicate each other, run task etc
- 'API server' container runs on mater and is an entry point to kubernates cluster. UI. API and CLI all communicate to 'API Server'
- 'Controller Manager' container runs on master and keeps track of whats happening in the cluster like for eg., container dies etc
- 'Scheduler' container runs on master and is responsible for scheduling containers on nodes based on work load and available resources on each node
- 'etcd' componed in master has all the data of current state of kubernates cluster, data, status data of all nodes, etc. Backup and restore is done by etcd 
- 'Virtual Network' on master help to communicate master and nodes 
- Atleast 1 master and 1 node 
- In k8s, POD do abstraction over containers
- Each POD gets its own IP address
- Swap memory should be off
- ReplicationController: If u have created 5 replica for a POD then it will check that 5 replicas are maintained or not. If not than if will create.



====== K8s Components=========
- 'Volumes' component is used to map phusical storage (like physical device, harddisk, cloud storage etc) to POD 
- 'Deployment' component is used to define how many replica for the POD is required. It can also scale up or down replicas. Its abstraction for POD 
- 'Service' component in K8s is used set permanent IP address to each POD so in case any if any container dies 
  and a new container is created than the IP will be same . It do load balancing as well
  - 'External Service' in K8s open up accesssibility through external sources like browsers
- ConfigMap: to set the configuration like URL etc
- Secret: Its like configMap but to store things like passwords. etc. Data store is in base64 encoded
- Data stored in ConfigMap/Secret file can be used in POD using env variables or properties files
- 'StatefulSet' component (for stateful applications like Databases) is to replicate and to  handling Databases. It handles database data in case of container crash etc 
- 'Ingress' component is used to route traffic into the cluster 
- Namespace is cluster inside a cluster


======= Setting up kubernates ========
https://linuxconfig.org/how-to-install-kubernetes-on-ubuntu-20-04-focal-fossa-linux
- All master and worker must have minimum 2 processor
- Swap should be off for all nodes in kubernate cluster
  - To check: `free -h`
  - To turn off: `swapoff -a`
  - To avoid swap to turn on after reboot: comment or remove all swap entries from `/etc/fstab`
- Hostname should be different for all nodes
- Check UUID for all node `cat /sys/class/dmi/id/product_uuid`. All should be unique
- Install supported docker for kubernates
  - For ubuntu: https://docs.docker.com/engine/install/ubuntu/
- Setup kubernates using `kubeadm` or any other method
  - For kubeadm: https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/
- Setup POD network for cluster on master using any method
  - for eg. Using Flannel: `kubeadm init --pod-network-cidr=10.244.0.0/16`
  - one you run above command, you can see commands to copy some files on master and run on slave
  - check status by `kubectl get nodes -A` and all should be `running` if not up than run `kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml`
- Set bash auto complete for kubectl
  - apt install bash-completion
  - kubectl completion bash > ~/.kube/kubecom.sh
  - source ~/.kube/kubecom.sh
  - vim ~/.profile and paste this at last `source ~/.kube/kubecom.sh`
- To fix x509 certificate problem
  - export KUBECONFIG=/etc/kubernetes/kubelet.conf

========= Extra/Commands =========

- To get result in:
    - yaml: kubectl get pods -o yaml
    - json: kubectl get pods -o json
- To convert string values to base64 encode for Secret file: echo -n 'PASSWORD' | base64
- To reset slave in case it failed to become slave: `kubeadm reset`
- Terminal to POD: kubectl exec -it POD_NAME --/bin/bash
- To watch live status of deployment creation: kubectl get pod --watch
- Explaination:
    - Less explaination: kubectl explain [pod][service][cluster][deployment]
    - Nested explaination for all keys: kubectl explain [pod][service][cluster][deployment] --recursive
    - To automatically get yml file: kubectl run NEW_PPOD_NAME --dry-run --image=IMAGE_NAME -o yaml
- Cluster: 
    - Get info: kubectl cluster-info 
- Deployment: 
    - Create: kubectl create deployment Name_OF_DEPLOYMENT --name=IMAGE_NAME (Eg., kubectl create deployment nginx-deployment --image=nginx)
    - Delete:
    - Show: kubectl get deployment
- Get:
    - All deployment: kubectl get deployment 
    - Everything: kubectl get all
    - Logs: kubectl logs POD_NAME  (Get pode name from `kubectl get pod`)
    - Service: kubectl get service
    - Status for node: kubectl get nodes [-A]
    - Status for pods: kubectl get pod [-o wide] [-A]
- Description:
    - POD: kubectl describe pod POD_NAME 
    - Service: kubectl describe service SERVICE_NAME
- ConfigMap:
    - Create: kubectl apply -f CONFIG_MAP_FILE.yml
    - Delete: kubectl delete -f CONF_FILE_NAME 
- Secrets:
    - Create: kubectl apply -f SECRET_FILE.yml
    - get all secrets: kubectl get secret 
- Namespace: 
    - Create: kubectl create namespace NAMESPACE_NAME 
    - Get all namespace: kubectl get namespace 
- POD: 
    - Create: kubectl run NEW_PPOD_NAME --image=IMAGE_NAME
    - Create using yaml: kubectl apply -f FILE.yaml
    - Delete: kubectl delete pod POD_NAME 
    - Delet All: kubectl delete pods --all
- Label: 
    - Add: kubectl label pod POD_NAME labelKEY=labelVALUE
    - Update: kubectl label --overwrite pod POD_NAME labelKEY=labelVALUE
    - Delete: kubectl label pod POD_NAME labelKEY-
    - To add label to all pods in same namespace: kubectl label pods --all labelKEY=labelVALUE
- Service:
    - Create internal service (Cluster IP): kubectl expose pod POD_NAME ---port=INCOMING_PORT_OF_CLUSTER --target-port=REDIRECT_PORT_OF_CLUSTER --name SERVICE_NAME
    - Create external service (NodePort): kubectl expose pod POD_NAME --type=NodePort ---port=INCOMING_PORT_OF_CLUSTER --target-port=REDIRECT_PORT_OF_CLUSTER --name SERVICE_NAME
    - Delete: kubectl delete services SERVICE_NAME
- ReplicationController:
    - Get all: kubectl get replicationcontrollers
    - Delete including POD: kubectl delete rc REPLICA_CONTROLLER_NAME
    - Delete ReplicationController not the POD created by it: kubectl delete rc --cascade=false REPLICA_CONTROLLER_NAME
    - Scale: 
        - kubectl scale rc --replicas=4 REPLICA_CONTROLLER_NAME
        or
        - kubectl edit rc REPLICA_CONTROLLER_NAME  (This will open as yml file and edit and save)
        or 
        - Edit in the yaml file and run 
            - kubectl replace -f REPLICA_CONTROLLER_NAME.yml (Too scale down)
            - kubectl apply -f REPLICA_CONTROLLER_NAME.yml (Too scale up)

- Extra:
    - To run command in specific conatiner of POD: kubectl exec pod-name -c CONTAINER_NAME env  (CONTAINER_NAME from yml file)
    - 

