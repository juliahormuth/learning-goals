# Docker Compose

É uma ferramenta para rodar múltiplos containers, precisando apenas de UM arquivo de configuracao, que orquestra tudo. Dessa forma, podemos rodar múltiplos `builds` e `runs` com um comando e em projetos maiores é essencial.

- É necessário criar o arquivo `docker-compose.yml`
- Este arquivo possui algumas chaves importantes como:

1. version: versao do Compose
2. services: Containers/Servicos que rodam nessa aplicacao.
3. volumes: Possivel adicao de volumes.
4. networks: Para redes
