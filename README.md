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
* build image from [Dockerfile](Dockerfile)
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
The service will be receiving requests throw the endpoint http://localhost:8080/prices

And you can use this [Useful Requests](req.http) to make calls to the endpoint.

You can use [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client) on [VSCode](https://code.visualstudio.com/), or [Postman](https://www.postman.com/).
