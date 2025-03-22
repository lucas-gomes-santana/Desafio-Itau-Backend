FROM maven:3.8-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

COPY --from=build /app/target/desafio-0.0.1-SNAPSHOT.jar ./desafio.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "desafio.jar"]