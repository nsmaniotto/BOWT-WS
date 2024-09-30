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

# Improvements

Bellow sections describe possible improvements to this project

## Optimisation

- [BOAT] Add cache on boat resources access
- [BOAT] Add specification on BoatRepository to filter boats
- [DB] Consider switching to a more relevant DBMS to better fit the future needs of this project

## Data model / Data source

- [BOAT] Enrich boat data model with more attributes (e.g. boat creator, update date)
- [BOAT] Use external source (e.g. API, import batch) to provide the user with existing boats
- [AUTH] Add role to users
- [MISC] Insert user/boat entries at server start (e.g. Liquibase)
- [MISC] Make database persistent to not erase users and boats at each restart

## Security

- [AUTH] Remove JWT secret key from application.yml
- [DB] Remove raw password from application.yml

## Testing

- [MISC] add unit tests
- [MISC] add integration tests on controllers to validate both OK and KO scenarios
- [MISC] Add architecture tests (e.g. ArchUnit) to set rules on project structure