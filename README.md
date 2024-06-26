#  ClusteredData Warehouse API


### API Reference


## Create new FXDeal

```http
  POST http://localhost:8080/api/fx-deal
```

| Parameter         | Type            | Description                                   |
|:------------------|:----------------|:----------------------------------------------|
| `id`              | `string`        | **Required**. id of deal                      |
| `orderingCurrencyIsoCode`         | `string`        | **Required**. orderingCurrencyIsoCode of deal |
| `toCurrencyIsoCode`     | `string`        | **Required**. toCurrencyIsoCode of deal       |
| `dealTimestamp`      | `TIMESTAMP` | **Required**. dealTimestamp of deal           |
| `dealAmount` | `Double`        | **Required**. dealAmount of deal              |



### Tech Stack


**Server:** Spring boot 3

**Database:** Postgres 15

### Testing

- **JUnit 5:**
    - The project employs JUnit 5 for unit testing.
    - Extensive test coverage ensures robustness, achieving 100% coverage.

- **Mockito:**
    - Mockito is utilized for efficient mocking in unit tests.

### Dockerization

The application is Dockerized using a multi-stage Dockerfile, optimizing the Docker image size and ensuring efficient deployment.

### Docker Compose

Docker Compose is employed to orchestrate the deployment of two services:
- The Spring Boot application [PORT 8080].
- Postgres 15, serving as the database [PORT 5432].

## Running the Application

# Run Docker Compose 
make run

# Run Docker Compose (detached)
make run-detached

## Stop the Application
make down


```
  Salaheddine Azarg
```
