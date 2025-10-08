# Usa immagine base Maven + Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Imposta la working directory
WORKDIR /app

# Copia i file di progetto e costruisci l'app (senza test)
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Secondo stage: immagine leggera per esecuzione
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia il JAR compilato dal primo stage
COPY --from=build /app/target/api-eta-da-codice-fiscale-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta (Render userà una dinamica)
EXPOSE 8080

# Avvia l'app Spring Boot
CMD ["java", "-jar", "app.jar"]