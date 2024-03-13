# Precios Demo

## Decisions about the Microservice

* I followed a <a href="https://www.baeldung.com/hexagonal-architecture-ddd-spring">DDD</a> approach for the app software design. I decided this to have a better code structure and a clear separation for the business logic.
* Java Criteria API is used to query data in a programmatic way.

## How to run
* Clone this repository with Git
* Follow one of this ways:

##### Docker
* Install Docker
* Build image from [Dockerfile](Dockerfile)
```bash
docker build -t sampleapp:v1 .
```
* Run container
```bash
docker run -p 8080:8080 sampleapp:v1
```
##### Without Docker
* Install [Java 21 JDK](https://adoptium.net/) and [Maven](https://maven.apache.org/download.cgi)
* Run the command:
```bash
mvn clean spring-boot:run
```
<br />
The service will receive requests throw the endpoint <a href="http://localhost:8080/prices">http://localhost:8080/prices</a>.
<br />
<br />
You can use this <a href="req.http">Useful Requests</a> to make calls to the endpoint using any REST client like:

* <a href="https://marketplace.visualstudio.com/items?itemName=humao.rest-client">REST Client</a> on <a href="https://code.visualstudio.com/">VSCode</a>
* <a href="https://www.postman.com/">Postman</a>
* cURL
* Swagger, via URL http://localhost:8080/swagger-ui/
