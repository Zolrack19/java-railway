FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]

# FROM eclipse-temurin:21-jdk as build

# COPY . /app
# WORKDIR /app

# RUN chmod +x mvnw
# RUN ./mvnw package -DskipTests
# RUN mv -f target/*.jar app.jar

# FROM eclipse-temurin:21-jre

# ARG PORT
# ENV PORT=${PORT}

# COPY --from=build /app/app.jar .

# RUN useradd runtime
# USER runtime

# ENTRYPOINT ["java", "-Dserver.port=${PORT}", "-jar", "app.jar"]
