# My learning goals

These are my learning goals before I get married :)

> Marque `[x]` quando concluir um tópico. Tópicos com link já têm anotações neste repositório.

## Domains and Topics

<details>
<summary>1. Fundamentals</summary>

- [ ] [**Fundamentals**](fundamentals/redme.md)
  - [ ] [Binary](fundamentals/binary.md)
  - [ ] [How the computer works](fundamentals/how-computer-works.md)
  - [ ] [Compiled vs interpreted languages](fundamentals/languages.md)
- [ ] Programming logic
- [ ] Algorithms and data structures
- [ ] Programming paradigms
- [ ] Web fundamentals
- [ ] Git

</details>

<details>
<summary>2. Object-Oriented Programming & Java</summary>

- [ ] **Object-oriented programming**
  - [ ] [Classes and objects](java/poo/class-and-objects/ClassAndObject.java)
- [ ] [Collections API](java/collections/README.md)
- [ ] [Exceptions](java/exceptions/README.md)
- [ ] [Immutability](java/immutability/README.md)
- [ ] [Stream API](java/stream-api/README.md)
- [ ] [CDI](java/cdi/README.md)
- [ ] [JPA](java/jpa/README.md)

</details>

<details>
<summary>3. Databases</summary>

- [ ] **SQL**
  - [ ] CRUD
  - [ ] Relationships
  - [ ] ACID
  - [ ] Transactions

</details>

<details>
<summary>4. Architecture & Design</summary>

- [ ] [**SOLID**](solid)
  - [ ] [Single Responsibility Principle](solid/srp/SingleResponsabilityPrinciple.md)
  - [ ] Open/Closed Principle
  - [ ] Liskov Substitution Principle
  - [ ] Interface Segregation Principle
  - [ ] Dependency Inversion Principle
- [ ] Design Patterns
- [ ] Clean Architecture
- [ ] [Microservices](microservices/ModelosArquiteturais.md)
- [ ] API and integrations

</details>

<details>
<summary>5. Security</summary>

- [ ] Security fundamentals
- [ ] [Session vs JWT](authentication/Session-vs-Jwt.md)

</details>

<details>
<summary>6. DevOps & Containers</summary>

- [ ] [**Docker**](docker/Index.md)
  - [ ] [Image](docker/image/Image.md)
  - [ ] [Dockerfile instructions](docker/dockerfile/Instructions.md)
  - [ ] [Volumes](docker/Volume.md)
  - [ ] [Networks](docker/networks/Network.md)
  - [ ] [Docker Compose](docker/docker-compose/DockerCompose.md)
- [ ] [Docker Swarm](docker-swarm/Orquestracao.md)
- [ ] [YML](yml/test.yml)
- [ ] [**Kubernetes**](kubernetes/Conceito.md)
  - [ ] [Deployment](kubernetes/Deployment.md)
  - [ ] [Minikube](minikube/Iniciando.md)
- [ ] Jenkins

</details>

<details>
<summary>7. Cloud & Infra — <a href="https://github.com/juliahormuth/Ads-Platform">Ads Platform</a> (Terraform/AWS)</summary>

Tópicos pendentes do [Guia de Estudos](https://github.com/juliahormuth/Ads-Platform/blob/main/GUIA_DE_ESTUDOS.md), em ordem de prioridade.

- [ ] **1. Redes** (comece aqui)
  - [ ] O que é uma sub-rede e por que dividir uma VPC
  - [ ] Notação CIDR (`/16`, `/24`) — quantos IPs cabem, por que `10.0.1.0/24` e `10.0.2.0/24` não colidem
  - [ ] Sub-rede pública vs privada — a diferença é a route table (rota `0.0.0.0/0` pro Internet Gateway)
  - [ ] Alta disponibilidade / multi-AZ (duas sub-redes em AZs diferentes)
  - [ ] Internet Gateway vs NAT Gateway
- [ ] **2. Security Groups**
  - [ ] Security group é *stateful*
  - [ ] SG encadeado (referenciar outro SG em vez de CIDR)
  - [ ] Security Group (instância/ENI) vs Network ACL (sub-rede)
- [ ] **3. Load Balancer / ALB**
  - [ ] O que é um ALB e por que fica na sub-rede pública
  - [ ] Target group com `target_type = "ip"` (Fargate) vs `instance`
  - [ ] Health check — como o ALB decide se o container está saudável
- [ ] **4. ECS / Fargate**
  - [ ] ECS vs Fargate vs modo EC2
  - [ ] Task Definition vs Service vs Cluster
  - [ ] `network_mode = "awsvpc"` — uma ENI e IP por task
  - [ ] Execution role vs task role
- [ ] **5. IAM**
  - [ ] Trust policy (`assume_role_policy`) vs policy anexada
  - [ ] Principal de serviço (`ecs-tasks.amazonaws.com`)
- [ ] **6. RDS**
  - [ ] `db_subnet_group` (mínimo 2 AZs)
  - [ ] `publicly_accessible = false` — acesso só de dentro da VPC
  - [ ] AWS Secrets Manager / SSM Parameter Store para a senha do banco
- [ ] **7. Terraform**
  - [ ] Providers, resources e data sources
  - [ ] Referências implícitas e grafo de dependências
  - [ ] `terraform.tfvars` e variáveis sensíveis
  - [ ] Outputs
- [ ] **8. CI/CD**
  - [ ] Fluxo do `deploy.yml`: build → push ECR → nova task definition → `update-service --force-new-deployment`
  - [ ] Separação de responsabilidades: Terraform cria a infra, o pipeline só troca a imagem

</details>

<details>
<summary>8. <a href="https://github.com/juliahormuth/postgraduate-software-engineering">Postgraduate</a></summary>

- [ ] **Backend Architecture**
  - [ ] MVC
  - [ ] MVVM
  - [ ] DDD
  - [ ] Clean Architecture
  - [ ] Microservices
- [ ] **DevOps**
  - [ ] GitHub Actions
  - [ ] Docker
  - [ ] Kubernetes

</details>

<details>
<summary>9. Frontend</summary>

- [ ] Deixa a vida me levar
- [ ] [JavaScript review](react/js-review/review.js)

</details>

<details>
<summary>10. Languages</summary>

- [ ] English review
- [ ] German review

</details>
