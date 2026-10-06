# Network

É possível criar networks para que o Container possa se comunicar com uma API Externa, com o Host ou com outros Containers.

## Tipos de Network:

- Externa: Conexao com servidor remoto

- Host: Comunicacao com seu Host

- Entre containers: Utilizacao do driver `bridge` que permite a conexao entre dois ou mais container.

## Tipos de drivers:

- Bridge: Default. Utilizados quando containers precisam de conectar.

- Host: Conexao com a máquina host do docker.

- macvlan: Permite a conexao a um container por um MAC address.

- none: Remove todas as conexoes de rede de um container.

- Plugins: Permite extensoes de terceiros para criar outras redes.

## Comandos básicos:

- Listar Networks: `docker network ls`
- Criar Networks: `docker network create networkName`
- Criar rede com driver especifico: `docker network create -d driverName networkName`
- Remover network: `docker network rm networkName` **Tomar cuidado com os containers conectados**
- Remover redes em massa: `docker network prune`

## Conexao Externa

- Os containers podem se conectar livremente ao mundo externo. Ex: API Open Source.

## Conectando dois ou mais containers

- Crie um rede, ex: `docker network create networkName`
- Crie os container com e no comando `docker run` adicione `--network networkName`
- Digamos que um container seja de MySQL chamado `mysql_api_container` e o outro seja uma aplicacao Spring Boot, dessa forma o Spring Boot consegue se conectar ao MySQL colocando `mysql_api_container` na propriedade `MYSQL_HOST` em application.properties, pois ambas estao na mesma rede.

## Conectando um container manualmente a Network

- `docker network connect networkName containerName`
- Ou seja, crie primeiro os containers, como o MySQL e a aplicacao Spring Boot e depois sim colocamos elas em uma Network para se comunicarem.

- `docker inspect containerId` para ver os detalhes e se ele já está na Network.

## Desconectar um container manualmente a Network

Dessa forma, as aplicacoes saem da Network.

- `docker network disconnect networkName containerName`

# Olhar detalhes da rede:

Detalhes da rede como Containers conectados, se é IPV6 e etc.

- `docker network inspect networkName`
