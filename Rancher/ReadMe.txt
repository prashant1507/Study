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

