https://rancher.com/docs/rancher/v2.x/en/overview/architecture/

HA: Highly Available
RKE: Rancher Kubernetes Engine
K8: Kubernates
RMC: Rancher Management Clusyter

Rancher: 
    - Rancher is a distributed microservice-based application, that runs as a Kubernetes app. 
    - The Kubernetes management software is also known as Rancher, but we often refer to it as "Rancher Server" for clarity.
    - Rancher has two Kubernetes distributions - RKE and K3s. 
    - RKE stands for "Rancher Kubernetes Engine" and runs upstream Kubernetes entirely in Docker containers.
    - Rancher Server acts as server capacity with K8 as its client and these clients are also called downstream clusters.
    - When rancher is deployed in RKE cluster that cluster is called RMC

Rancher Server:
    - Components:
        - API Server
        - an Authentication proxy
        - one cluster controller for each cluster that Rancher manages
        - etcd: Rancher Server Data Store

- Downstream clusters managed by Rancher run a Cluster Agent that bridges between the Cluster Controller and the Kubernetes API server that runs inside of the cluster, and they run a Node Agent on every node
  in the cluster to handle node-specific activities.

Communication with Downstream Clusters:
    - Authentication Proxy
        - Receive request from user
        - Authenticate the user
        - Forwards the request to kubernates on behalf of the user
        - API server performs the authorization of the request
        - Authentication:
            - Who are you?
            - Handled by Rancher
        - Authorization:
            - What are you allowed to do?
            - Handled by K8
    - Cluster Controller:
        - The cluster controller runs in the Rancher Server environment
        - One cluster controller per K8 cluster
        - Cluster COntroler is responsible for:
            - Watches for resource changes in the downstream cluster
            - Brings the current state of the downstream cluster to the desired state
            - Configures access control policies to clusters and projects
            - Provisions clusters by calling the required Docker machine drivers and Kubernetes engines, such as RKE and GKE
        - The Cluster Controller connects to the Cluster Agent by default. If the Cluster Agent is unavailable, it can use a Node Agent as a fallback channel.
    - Cluster Agent
        - Each downstream cluster has an agent that opens a tunnel back to the controller that's running on the Rancher server cluster.
        - Cluster Agent is responsible for:
            - Connecting to the Kubernetes API of Rancher-launched Kubernetes clusters
            - Managing workloads, pod creation and deployment within each cluster
            - Applying the roles and bindings defined in each cluster’s global policies
            - Communicating through the tunnel between the cluster and Rancher server about events, stats, node info, and health
    - Node Agent:
        - The Node Agent runs as a DaemonSet, launching one Pod on every node in the cluster
        - Its primary function is to interact with node-specific functions, such as upgrading Kubernetes or restoring etcd snapshots.
        - If the Cluster Agent is unavailable, one of the Node Agents will establish a tunnel back to the Rancher Server and take over the Cluster Agent role.
    - Authorized Cluster Endpoint:
        - Communicates directly to downstream servers if rancher server is down
        - The Authorized Cluster Endpoint exists so that users can communicate with a cluster if Rancher itself is down and the Authentication Proxy is unavailable, or so that users can communicate directly with a cluster
            that is geographically closer to them instead of adding additional latency by proxying through the Rancher Server in another location.
        - When communicating with the Authorized Cluster Endpoint, all security boundaries for the user are maintained. 

---------------------------------------------------------------------------------------------------------
Setting up Rancher:
    - https://rancher.com/docs/rke/latest/en/installation/
    - There are two ways to install Rancher:
        - a standalone way that’s good for sandbox environments
        - deploys Rancher into a highly available Kubernetes cluster using RKE
    - RKE is both a Kubernetes distribution and an installer. The installer runs on a local workstation or shared management host, and you use it to provision a cluster over SSH. 
    - Steps:
        - Download RKE from https://github.com/rancher/rke/releases
        - Copy to:
            - MacOS/Linux: Copy the binary to /usr/local/bin/ and add chmod +x and test using 'rke --version'
            - Windows: Copy the binary to C:\bin\ and add to Path
        - The SSH user is in the Docker group
        - Swap is disabled on any worker nodes

- Important Points
    - The Rancher management server can be installed only on Rancher 2.4 it can only be installed on K3s and RKE.
        - K3s is designed to be a single binary of less than 40MB that completely implements the Kubernetes API
        - Rancher can manage any CNCF certified Kubernetes distribution.
        - Minimum number of Kubernetes nodes needed for a Rancher Server installation is 1
    - RKE is 100% upstream Kubernetes, certified by the Cloud Native Computing Foundation
