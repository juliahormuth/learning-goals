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

## Pods

- Pods sao onde os containers sao executados

- Para verificar usamos: `kubectl get pods`

- Mais detalhes: `kubectl describe pods`

## Configuracao

- `kubectl config view`

## Service

- É quem possibilita expor os Pods para o mundo externo. É uma entidade separada dos pods, que os expoem para uma rede.

- `kubectl expose deployment <name> --type=<TIPO> --port<PORT>`

- Tem diversos tipos, mais o `LoadBalancer` é o mais comum.

- E uma porta para o servico a ser consumido.

- Para ver os servicos disponíveis: `kubectl get services`

- Obter informacoes: `kubectl describe services/<name>`

## Gerando IP de acesso

- Para acessar nosso servico: `minikube service <name>`

- Dessa forma, o IP aparece no nosso terminal.

- E assim, o projeto está rodando pelo Kubernetes.
