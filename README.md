# Precios Demo

## Decisions about the Microservice

* I followed a DDD approach, I decided this to have a better code structure and a clear separation for the business logic.

## How to run

#### Docker
* Install Docker, [Java 21 JDK](https://adoptium.net/) and [Maven](https://maven.apache.org/download.cgi)
* Build app
```bash
mvn clean package
```
* Build image from [Dockerfile](Dockerfile)
```bash
docker build -t sampleapp:v1 .
```
* Run container
```bash
docker run -p 8080:8080 sampleapp:v1
```
#### Without Docker
* Install [Java 21 JDK](https://adoptium.net/) and [Maven](https://maven.apache.org/download.cgi)
* Run the command:
```bash
mvn clean spring-boot:run
```
<br />
<br />
The service will be receiving requests throw the endpoint <a href="http://localhost:8080/prices">http://localhost:8080/prices</a>.
<br />
<br />
And you can use this <a href="req.http">Useful Requests</a> to make calls to the endpoint using any REST client like <a href="https://marketplace.visualstudio.com/items?itemName=humao.rest-client">REST Client</a> on <a href="https://code.visualstudio.com/">VSCode</a>, <a href="https://www.postman.com/">Postman</a> or cURL.
