# BOWT-WS

Java Spring Boot web service for the BOWT application: BOWT-GUI

## Install

```
mvn clean package
```

## Run on local

First, start a database as described bellow.

```
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## Run BOWT database using Docker

This will start an empty database. The schema will be created when started the application.

```
docker run -d -e POSTGRES_HOST_AUTH_METHOD=trust -e POSTGRES_USER=bowt -e POSTGRES_PASSWORD=bowt -e POSTGRES_DB=bowt -p 5432:5432 postgres:13
```

Warning, the schema will be dropped and re-created each time the application starts.

To change this behavior, change the value of `spring.jpa.hibernate.ddl-auto` and `spring.datasource.initialization-mode` in the `application.yml`
file.