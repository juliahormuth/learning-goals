# Dockerfile

## FROM imageName

- FROM: indica a imagem base.

- As name: dá um nome a esta etapa de build.

## WORKDIR /app

- Define o diretório de trabalho dentro do container.

- Tudo o que você fizer a partir daqui (COPY, RUN, etc.) acontece dentro de /app.

## COPY pom.xml .

- Copia arquivos do host para dentro do container na pasta /app. (Arquivo origem pom.xml para . (ponto solto) que significa para a raiz da pasta /app).

## COPY src ./src

- Copia a pasta src do projeto local (host) para dentro do Container em /app/src.
- Se eu nao definisse a pasta, os arquivos seriam jogados para a pasta raiz /app.

# RUN mvn clean package -DskipTests

- RUN: executa um comando dentro do container em tempo de build.

- Aqui rodamos o Maven para gerar o .jar da aplicação, pulando os testes (-DskipTests).

# FROM eclipse-temurin:21-jdk

- Agora a imagem só do java sem o maven, pois nao é preciso o maven em producao.

# WORKDIR /app

- Definicao novamente do diretório

# COPY --from=builder /app/target/\*.jar app.jar

- Copia o arquivo .jar gerado na etapa `builder` para esta etapa.

`multi-stage build:` compilar em uma imagem e rodar em outra.

# EXPOSE 8080

- Indica que o container vai escutar na porta 8080.

# ENTRYPOINT ["java", "-jar", "app.jar"]

- ENTRYPOINT: define o comando padrão que será executado quando o container rodar.
- É como se ele executasse: `java -jar app.jar`
