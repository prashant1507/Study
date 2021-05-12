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
- ReplicationController: If u have created 5 replica for a POD then it will check that 5 replicas are maintained or not. If not than if will create. Selector are not mandatory
- ReplicaSet: 
    - Selector are mandatory
    - Equality Based Selector: matchLabels
    - Set Based Selector: matchExpressions
- Kubernates creates a unique value called Hash value so in order to identify PODS in case they have same labels
- RevisionHistoryLimit: 
    - is the maximum number of revisions that will be maintained in the StatefulSet’s revision history. 
    - The revision history consists of all revisions not represented by a currently applied StatefulSetSpec version. 
    - The default value is 10.
- RecreateStrategy: It recreates replica but there is downtime
- Namespace:
    - Provide ccapability to create virtual clusters in a K8 cluster. (Like different different VMs). And these clusters are namespace 
    - Namespaces in K8s:
        - kube-node-lease: Manage heartbeat to check if nodes are available
        - kube-public: Created by K8 and creates resources that are suppose to be available publically. User dont need authentication
            - E.g., People can access https://192.168.0.115:6443/api/v1/namespaces/kube-public/configmaps/cluster-info to see cluster info
        - kube-system: Management PODs. Created by K8s
        - default: Create by K8 to run PODs 
        - Custom: Created by user to run PODs
    - Names are unique in each namespace. Eg., TEST_NAME can be used in NAMESPACE1 and NAMESPACE2
- In K8 resoucres are: PODs, nodes, etc
- Taints and Tolerance:


====== K8s Components=========
- 'Volumes' component is used to map phusical storage (like physical device, harddisk, cloud storage etc) to POD 
- 'Deployment' component:
  - Helps in avoiding down time in case of application update 
  - It can also scale up or down replicas
  - Define how many replica for the POD is required.
  - Helps in rollback. 
      - ReCreate Strategy: 
          - During update it do not delete old replicas. 
          - For the old one it makes replicat set to 0 so in future if we want to rollback than simply change 0 to required replica.
          - This Strategy will have some downtime
      - Rolling Update:
          - It starts create one new pod and make 0 in old pod and so on 
          - It make replica 0 one by one not all together. Same for roll back
          - No downtime
  - Its abstraction for POD 
- 'Service' component in K8s is used set permanent IP address to each POD so in case any if any container dies 
  and a new container is created than the IP will be same . It do load balancing as well
  - 'External Service' in K8s open up accesssibility through external sources like browsers
- ConfigMap: to set the configuration like URL etc
- Secret: Its like configMap but to store things like passwords. etc. Data store is in base64 encoded
- Data stored in ConfigMap/Secret file can be used in POD using env variables or properties files
- 'StatefulSet' component (for stateful applications like Databases) is to replicate and to  handling Databases. It handles database data in case of container crash etc 
- 'Ingress' component is used to route traffic into the cluster 
- Namespace"
    - Its a cluster inside a cluster (like virtual machines)
    - ResourceQuota:
        - can be used to set limits to namespace
        - Compute based resource quota: Defining resouses like cpu, memory for a namespace 
        - Object based resoucre quota: Defining objects like pods, configmap, replica, etc
    - LimitRange:
        - To define default requests and limits for PODs created in the namespace
- Rollout (update) will only happen if the changes are done only for POD's spec section otherwise wont happen.
    - For eg., If in previous deployment replica was 2 and if you change replica to 4 in new dpeloyment thaan roolout won't happen
- POD:
    - POD is a collection of containers and its storage inside a node of a K8 cluster
    - If requests is not defined but limits is defined than by default requests=limits
    - Use of the selector: kubectl get pods --selector 'LABEL_NAME in (LABEL_VALUE)'
- ConfigMap: https://kubernetes.io/docs/concepts/configuration/configmap/
    - To give configuration of the application
- Secrets: https://kubernetes.io/docs/concepts/configuration/secret/
    - Store upto 1MB of data 
    - All data is encrypted. encode to base64 
    - Types:
        - docker-registry: A Kubernetes cluster uses the Secret of docker-registry type to authenticate with a container registry to pull a private image.
        - TLS: Kubernetes provides a builtin Secret type kubernetes.io/tls for to storing a certificate and its associated key that are typically used for TLS
        - Generic
    
======= Setting up kubernates ========
https://linuxconfig.org/how-to-install-kubernetes-on-ubuntu-20-04-focal-fossa-linux
- All master and worker must have minimum 2 processor
- Swap should be off for all nodes in kubernate cluster
  - To check: `free -h`
  - To turn off: `swapoff -a`
  - To avoid swap to turn on after reboot: comment or remove all swap entries from `/etc/fstab`
- Hostname should be different for all nodes
- Check UUID for all node `cat /sys/class/dmi/id/product_uuid`. All should be unique
- Install supported docker for kubernates on node and master
  - For ubuntu: https://docs.docker.com/engine/install/ubuntu/
- Setup kubernates using `kubeadm` or any other method node and master
  - For kubeadm: https://kubernetes.io/docs/setup/production-environment/tools/kubeadm/install-kubeadm/
- Setup POD network for cluster on master using any method on master 
  - for eg. Using Flannel: `kubeadm init --pod-network-cidr=10.244.0.0/16`
  - one you run above command, you can see commands to copy some files on master and run on slave
  - Note: If getting error - `The connection to the server localhost:8080 was refused - did you specify the right host or port?`
    ```
        $ mkdir -p $HOME/.kube
        $ sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
        $ sudo chown $(id -u):$(id -g) $HOME/.kube/config
    ```
  - check status by `kubectl get nodes -A` and all should be `running` if not up than run `kubectl apply -f https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml`  (Ref Link: https://coreos.com/flannel/docs/latest/kubernetes.html)
- Set bash auto complete for kubectl
  - apt install bash-completion
  - kubectl completion bash > ~/.kube/kubecom.sh
  - source ~/.kube/kubecom.sh
  - vim ~/.profile and paste this at last `source ~/.kube/kubecom.sh`
- To fix x509 certificate problem
  - export KUBECONFIG=/etc/kubernetes/kubelet.conf
- Set static IP for master 
  - https://www.techrepublic.com/article/how-to-configure-a-static-ip-address-in-ubuntu-server-18-04/

============= Tips ===============
- Kubernates documentation with examples
- just add --help to get more info 
    - For eg.,
        - kubectl create secret generic --help
        - kubectl create secret --help
- get sample yaml content for any object like pod, secret, etc
    - For e.g,
        - kubectl create ns ns1 --dry-run=client -o yaml
- for volumnes mount, The FileOrFolder mode does not create the parent directory of the file. If the parent directory of the mounted file does not exist, the pod fails to start
- To pull from https://quay.io/ just add quay.io/<Image_Name>

 
========= Extra/Commands =========
- Add new node: kubeadm token create --print-join-command
- To remove node from master (or clean files created by kubeadm init or kubeadm join): kubeadm reset
- To get result in:
    - yaml: kubectl get pods -o yaml
    - json: kubectl get pods -o json
- To convert string values to base64 encode for Secret file: echo -n 'PASSWORD' | base64
- To reset slave in case it failed to become slave: `kubeadm reset`
- Terminal to POD's with 1 container: kubectl exec -it POD_NAME /bin/bash
- Terminal to POD's with multiple container: kubectl exec POD_NAME -c CONTAINER_NAME -it /bin/bash
- Terminal to POD's container: kubectl exec pod-name -c CONTAINER_NAME env  (CONTAINER_NAME from yml file)
- To watch live status of deployment creation: kubectl get pod --watch
- Node:
    - Add Label: kubectl label node WORKER_NAME LABEL_KEY=LABEL_NAME 
    - Remove Lable: kubectl label node WORKER_NAME LABEL_KEY-
- Explaination:
    - Less explaination: kubectl explain [pod][service][cluster][deployment]
    - Nested explaination for all keys: kubectl explain [pod][service][cluster][deployment] --recursive
    - To automatically get yml file: kubectl run NEW_PPOD_NAME --dry-run --image=IMAGE_NAME -o yaml
- ConfigMap:
    - Get: kubectl get configmap
    - Create: kubectl create configmap CONFIG_MAP_NAME --from-literal=KEY="VALUE" --from-literal=KEY2="VALUE2"
    - Delete: kubectl delete configmap CONFIG_MAP_NAME
    - Create from properties file: kubectl create configmap CONFIG_MAP_NAME --from-file==PROPERTIES_FILE_NAME.properties --from-file==PROPERTIES_FILE_NAME2.properties
    - Create from all properties file in a directory: kubectl create configmap CONFIG_MAP_NAME --from-file=FOLDER_NAME/
    - Create from ENV variables: kubectl create configmap CONFIG_MAP_NAME --from-env-file=FILE_NAME.sh
- Secrets: 
    - Get: kubectl get secrets
    - Create secret with keys for each file in folder: kubectl create secret generic SECRET_NAME --from-file=path/to/folder
    - Using literal: kubectl create secret generic SECRET_NAME --from-literal=key1=supersecret --from-literal=key2=topsecret
    - Create secrets with combination of file and literal: kubectl create secret generic SECRET_NAME --from-file=ssh-privatekey=path/to/id_rsa --from-literal=passphrase=topsecret
    - ENV file: kubectl create secret generic SECRET_NAME --from-env-file=path/to/bar.env
    - Create secrets from file: kubectl create secret generic SECRET_NAME --from-file=path/to/file.properties
- Cluster: 
    - Get info: kubectl cluster-info 
- Deployment: 
    - Explain: kubectl explain deployment
    - Create: kubectl create deployment Name_OF_DEPLOYMENT --name=IMAGE_NAME (Eg., kubectl create deployment nginx-deployment --image=nginx)
    - Delete: kubectl delete deployments DEPLOYMENT_NAME
    - Show: kubectl get deployment
    - Add record for update: kubectl apply -f DEPLOYMENT_NAME --record  (This will add command as in record)
- Rollback and Rollout:
    - To rollback: kubectl rollback undo deployment DEPLOYMENT_NAME  (This will rollback to last version)
    - To rollback to specific revision: kubectl rollback undo deployment DEPLOYMENT_NAME --to-revision=REVISION_NUMBER deployment DEPLOYMENT_NAME  (This will rollback to specific version) (REVISION_NUMBER = kubectl rollback history deployment DEPLOYMENT_NAME)
    - To check rollout (new) status: kubectl rollout status deployment DEPLOYMENT_NAME
    - Pause: kubectl rollout pause deployment DEPLOYMENT_NAME
    - Resume: kubectl rollout resume deployment DEPLOYMENT_NAME
- Get: 
    - kubectl get deployment|service|pod|namespace
    - All deployment: kubectl get deployment 
    - Everything: kubectl get all
    - Logs: kubectl logs POD_NAME  (Get pode name from `kubectl get pod`)
    - Service: kubectl get service
    - Status for node: kubectl get nodes [-A]
    - Status for pods: kubectl get pod [-o wide] [-A]
- Describe:
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
    - Delete: kubectl delete namespaces NAMESPACE_NAME
    - Get all namespace: kubectl get namespace 
    - Get supported resources by namespace: kubectl api-resources
    - To create pod in a namespace: kubectl apply -f FILE.yml --nampespace NAMESPACE_NAME
    - View PODs in namespace: kubectl get pods -n NAMESPACE_NAME
    - View all namespaces: kubectl get pods --all-namespaces
    - To delete POD from namespace: kubectl delete pod pod-name -n NAMESPACE_NAME
    - To enter in namespace: kubectl config set-context --current --namespace=NAMESPACE_NAME
    - Limit Range:
        - Delete: kubectl delete limitranges LIMIT_RANGE_NAME
    - ResourceQuota
        - Delete: kubectl delete resourcequotas QUOTA_NAME
- ResourceQuota:
    - Delete: kubectl delete resourcequotas QUOTA_NAME
- POD: 
    - Explain: kubectl explain pod
    - Create: kubectl run NEW_PPOD_NAME --image=IMAGE_NAME
    - Create using yaml: kubectl apply -f FILE.yaml
    - Delete: kubectl delete pod POD_NAME 
    - Delet All: kubectl delete pods --all
- Label: 
    - Add: kubectl label pod POD_NAME labelKEY=labelVALUE
    - Update: kubectl label --overwrite pod POD_NAME labelKEY=labelVALUE
    - Delete: kubectl label pod POD_NAME labelKEY
    - Set label to node: kubectl label nodes <node-name> <label-key>=<label-value>
    - To add label to all pods in same namespace: kubectl label pods --all labelKEY=labelVALUE
- Service:
    - Explain: kubectl explain service
    - Create internal service (Cluster IP and is by default): kubectl expose pod POD_NAME ---port=INCOMING_PORT_OF_CLUSTER --target-port=REDIRECT_PORT_OF_CLUSTER --name SERVICE_NAME
    - Create external service (NodePort): kubectl expose pod POD_NAME --type=NodePort ---port=INCOMING_PORT_OF_CLUSTER --target-port=REDIRECT_PORT_OF_CLUSTER --name SERVICE_NAME
        Port range for NodePort: 30000-32767
    - Delete: kubectl delete services SERVICE_NAME
    - Service is accessable from all namespace. Either by DNS name (name of service in same namespace / complete path to sevice like `curl SERVICE_NAME.NAMESPACE_NAME.svc.cluster.local` from aanother nampespace) or IP:PORT
- ReplicationController:
    - Explain: kubectl explain rc
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
- ReplicaSet:
    - Explain: kubectl explain rs
    - Delete including POD: kubectl delete rs REPLICA_SET_NAME
    - More details: kubectl get rs -o wide
- Taints and Tolerance:
    - Taint is on node and Tolerate is on POD
    - Create taint: kubectl taint node NODE_NAME KEY_NAME=KEY_VALUE:NoSchedule
    - Taint=taintName, Tolerance=taintName - tolerance will check taint with name taintName and schedule it on that node where taint is set. Not recommended 
- Extra:
    - To run command in specific conatiner of POD: kubectl exec pod-name -c CONTAINER_NAME env  (CONTAINER_NAME from yml file)
    