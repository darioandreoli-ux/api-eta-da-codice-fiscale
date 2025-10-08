# Usa un'immagine Java 17 leggera
FROM eclipse-temurin:17-jdk-alpine

# Imposta la working directory
WORKDIR /app

# Copia il codice sorgente
COPY . .

# Compila il progetto Maven (senza test)
RUN ./mvnw clean package -DskipTests

# Espone la porta (Render ne userà una dinamica)
EXPOSE 8080

# Comando di avvio
CMD ["java", "-jar", "target/api-eta-da-codice-fiscale-0.0.1-SNAPSHOT.jar"]
