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

# Microsservices de configuracao

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