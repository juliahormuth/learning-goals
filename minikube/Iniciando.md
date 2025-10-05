# Minikube

- Inicializar (criar): `minikube start --driver=<DRIVER>`. Ex: `minikube start --driver=docker`

- Virtualbox, hyperv e docker

- Saber o status: `minikube status`

- Parar o minikube: `minikube stop`

- Iniciar novamente: `minikube start --driver=docker`

- Se quiser excluir o cluster: `minikube delete`

## Dashboard

- O Minikube disponibiliza uma Dashboard onde podemos ver os servicos, pods, etc.

- Comando: `minikube dashboard`

- Para obter apenas a URL: `minikube dashboard --url`

## Deployment

- Após criar o container com o projeto e enviar ao Docker Hub, é necessário rodar o projeto no Kubernetes

- Para isso vamos precisamos criar um `Deployment`, que é onde rodamos os containers das aplicacoes nos `Pods`

- Comando: `kubectl create deployment <name> --image=<IMAGE>`

- Assim, o projeto é orquestrado pelo Kubernetes

- Se o Deployment falhar, tente: `kubectl delete deployment <name>` e tente criar novamente

- Para checar se tudo está correto, use: `kubectl get deployments` e ai nao precisa ver pelo dashboard.

- Mais detalhes: `kubectl describe deployments`
