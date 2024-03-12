FROM eclipse-temurin:21-jre-jammy

RUN adduser --system --group --no-create-home newuser

WORKDIR /home/app

COPY target/app.jar .

EXPOSE 8080

USER newuser

ENTRYPOINT ["java","-jar","app.jar"]
