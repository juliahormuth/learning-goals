FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Faz o build
RUN mvn clean package -DskipTests

# Etapa 2: Runtime (executa o JAR)
FROM eclipse-temurin:21-jdk

# Define diretório de trabalho
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
