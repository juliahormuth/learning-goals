# Docker Compose

É uma ferramenta para rodar múltiplos containers, precisando apenas de UM arquivo de configuracao, que orquestra tudo. Dessa forma, podemos rodar múltiplos `builds` e `runs` com um comando e em projetos maiores é essencial.

- É necessário criar o arquivo `docker-compose.yml`
- Este arquivo possui algumas chaves importantes como:

1. version: versao do Compose
2. services: Containers/Servicos que rodam nessa aplicacao.
3. volumes: Possivel adicao de volumes.
4. networks: Para redes

- Rodar o Compose: `docker compose up`
- Rodar o Compose em Background: `docker compose up -d`
- Para Container em Background: `docker compose down`
- Para olhar: `docker ps -a`
- Verificacao dos servicos do Compose: `docker-compose ps`

## Variáveis de Ambiente no Compose

- Para projetos públicos.

- Os arquivos de variáveis de Ambiente devem ser .env
- No Docker-Compose.yml é necesssário declarar onde está o arquivo . A propriedae utilizada no Docker-Compose.yml é a `env_file` como uma lista, apontando o caminho do arquivo a partir do arquivo Docker-Compose.yml (normalmente na raiz do projeto). A diferenca é que no arquivo .env, a propriedade do valor é separado por `=`e nao por `:`.

## Networks no Compose

- Ele cria automaticamente uma rede Bridge entre os containers, mas é possível isolar as redes com chaves networks. Desta forma, conectar apenas os containers desejados.

** É possível fazer o build com compose em tempo real**
Isso é bom para fazermos mudancas no projeto e ver em tempo real sem precisar rodar o compose todo novamente.
