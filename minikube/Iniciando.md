# Minikube

- Inicializar (criar): `minikube start --driver=<DRIVER>`. Ex: `minikube start --driver=Docker`

- Virtualbox, hyperv e docker

- Saber o status: `minikube status`

- Parar o minikube: `minikube stop`

- Iniciar novamente: `minikube start --driver=Docker`

## Dashboard

- O Minikube disponibiliza uma Dashboard onde podemos ver os servicos, pods, etc.

- Comando: `minikube dashboard`

- Para obter apenas a URL: `minikube dashboard --url`

## Deployment

- Após criar o container com o projeto, é necessário rodar o projeto no Kubernetes

- Para isso vamos precisamos criar um `Deployment`, que é onde rodamos os containers das aplicacoes nos `Pods`.

- Comando: `kubectl create deployment <name> --image=<IMAGE>`

- Assim, o projeto é orquestrado pelo Kubernetes.
