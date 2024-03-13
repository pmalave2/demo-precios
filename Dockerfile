FROM maven:3.9-eclipse-temurin-21-jammy as build-step

WORKDIR /home/buildapp

COPY . .

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-jammy

RUN adduser --system --group --no-create-home newuser

WORKDIR /home/app

COPY --from=build-step /home/buildapp/target/app.jar .

EXPOSE 8080

USER newuser

ENTRYPOINT ["java","-jar","app.jar"]
