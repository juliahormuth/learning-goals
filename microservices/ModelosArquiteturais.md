# Modelos Arquiteturas de Microservices

- Conforme o passar dos anos, evoluimos de sistemas monolíticos para Microsservices, sendo assim, podemos ter mais de um front-end e mais de um back-end compondo a arquitetura. Além disso, agora podemos ter no backend, além dos microsservices, microagentes (agentes inteligentes). Que sao servicos inteligentes e autonomos que podemos utilizar para tomar decisoes, otimizar fluxos, em pontos estratégicos em que essa automacao faca sentido.

# Benefícios de Microservices

- Manuntenibilidade
- Alta disponibilidade
- Flexbilidade Tecnologicas -> Técnologia adequada
- Independencia das Equipes
- Melhor performance
- Divisao da Complexidade de negócio
- Automento da resiliencia
- Isolamento da Modelagem de dados
- Agentes inteligentes e Autonomos
- etc

# Categorias
- Microsservices de Negócios (User Servie, Notification Service, etc)
- Microsservices de configuracoes (Service registry, Config Server, API Gategay e etc)
- Microsservices de agentes (FraudeDetection Agent, Recomendation Agent e etc )

# Padroes configuracao em Microsservices

## Padrao API Gateway
- API Gateway é um microsservices de configuracao sem regras de negócio mas com responsabilidades específicas, sendo uma porta de entrada da arquitetura, centralizando todas as entradas (Requests para diferentes microsservicos que vem do front-end, por exemplo), que internamente recebe as requisicoes e direciona para os respectivos microsservices para que cada um responda com seus respectivos processamentos, elevando o grau de maturidade na arquitetura.
- Além de roteamento, ele pode fazer o balanceamento de cargas quando tiverem múltiplas instanceas atividades de determinados microsservicos, autenticacao e etc.
- Spring Cloud Gateway em conjunto com Spring Boot é bom para isso (Possi integracao com o Service Registry).

## Padrao Registry Discovery
- O Servico de Registry Discovery que implementa o Registry Discovery Pattern entra quando por exemplo o API Gateway preisa saber a porta, o ID, a instancia e etc de um microsservico para enviar uma requisicao, principalmente quando há duas instancias do mesmo servico, exemplo duas instancias do Payment Service.
- Recebe todos os microsservices da arquitetura para serem registrados e consequentemente entregar de forma dinamica e flexivel para o API Gateway.
- Ex: Notification Service sobe mais uma instancia, logo o API Gateway já sabe disso pelo Registry Discovery para realizar o balanceamento de carga.
- Spring Cloud Discovery/Netflix em conjunto com Spring Boot e Spring Cloud LoadBalancer (adicionando mais o padrao de Balanceamento de carga) é bom para isso.

- **Preocupacoes transversais**: Preocupacoes que se desdobram pela arquitetura como um todo.

## Spring Cloud Discovery
- Instancias podem ser registradasem um servidor Eureka: Eureka server.
- Os Eureka Clients podem descobrir essas instancias quando necessário.
- Dashboard Eureka para controle e visualizacao dos servicos registrados.

## Padrao Global Config
- Servico para centralizar os diferentes arquivos de configuracao dos diferentes microservices do sistema. Tendo em vista que, além do número grande de microsservices, todos podem ter diferentes arquivos de configuracao tanto para ambiente de desenvolvimento, quanto de producao e etc. Ficando inviável cuidar deles em cada projeto separadamente. Além disso, ajuda na alta disponibilidade, já que nele podemos trocar configuracoes sem parar os microsservicos das regras de negócio.
- Pode ser implementado com Spring Boot + Spring Cloud Config.

## Padrao de Observabilidade
- Monitoramente e controle.

## Padrao Log Aggregation
- Cada microsservico gera seus próprios logs em seus próprios arquivos a cada execucao.
- Por isso é necessário uma única base para salvar/agregar os logs que sao gerados.
- Melhor controle, gerar alerta e etc.
- Essa base esta conectada com todos os servicos da arquitetura pois se trata de uma preocupacao transversal.
- Pode ser implementado com Logback (padrao Spring) ou Log4j2, podendo enviar pro ElasticSearch.

## Padrao Metrics
- Para verificar o status, infos, métricas específicas, request mappings mapeadoss e etc podemos utilizar o Spring Actuator, disponibilizando diversas ferramentas para observarmos essas informacoes.

## Padrao Distributed Tracing
- Como temos diversos microsservicos, cada qual com sua própria base de dados, dados distribuídos pela arquitetura, tendo que lidar com sincronia, replicacao de dados e etc.
Ex: O servico de User Service tem que se comunicar com o Payment Service, para analisar o que está acontecendo e quais servicos foram acionados implementamos o Distributed Tracing Pattern, para saber quem fez parte da acao.
- Podemos usar de identificadores únicos para categorizar estas operacoes de forma individual e estes IDS também podem ser armazenados em uma base específica para isso. Fazendo também parte de uma preocupacao transversal.
- Pode ser implementado com o Spring Observability.
- Spring Observability: Baseado em Micrometer e Micrometer Tracing, é o antigo Spring Cloud Sleuth e tem integracao com o Spring Actuator. É compatível com o Zipkin para a visualizacao de todos estes rastradores.

## Padroes de resiliencia em Microsservicos

# Padrao Circuit Breaker
- É possível que User Service e Payment Service se comuniquem de forma síncrona, por exemplo. Caso um deles fique fora do ar, nao é possível realizar a acao e isso também pode gerar mais erros posteriores que vem de novas requisicoes do backend, gerando falhas em cascata. Por isso é importante detectarmos esses pontos de falha e probabilidades de falhas. Nesse caso o Circuit Breaker vai realmente agir como um "disjuntor" para que traga fluxos alternativos quando um determinado microsservice está fora do ar, previndo falhas destes microsservices e até mesmo do restante da arquitetura.
- Pode ser implementado com Spring Circuit Breaker + Resilience4j e Spring Retry.
