# Prestation De Service Microservice Project

This project is a Spring Boot microservice that provides services related to "Prestation De Service." It includes various controller functions to manage and search for prestations. Additionally, it's integrated with Eureka for service discovery.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Controller Functions](#controller-functions)
3. [Integration with Eureka](#integration-with-eureka)
4. [References and Documentation](#references-and-documentation)

## Project Overview

The "Prestation De Service Microservice" is designed to offer a set of APIs to manage and retrieve information about service offerings. It utilizes the Spring Boot framework and is integrated with Eureka for service registration and discovery.

## Controller Functions

### 1. Get All Prestations

- **Endpoint**: `/prestations/AllPrestations`
- **HTTP Method**: GET
- **Description**: Retrieves a list of all prestations. Optionally, you can provide pagination parameters `page` and `pageSize` to limit the number of results.

### 2. Get All Prestations with Pagination

- **Endpoint**: `/prestations/AllPrestationsPagination`
- **HTTP Method**: GET
- **Description**: Retrieves a paginated list of prestations. You can provide the `page` and `pageSize` parameters to specify the page number and the number of results per page.

### 3. Get Prestation by ID

- **Endpoint**: `/prestations/one-prestation/{id}`
- **HTTP Method**: GET
- **Description**: Retrieves a specific prestation by its ID.

### 4. Create a Prestation

- **Endpoint**: `/prestations/add-prestation`
- **HTTP Method**: POST
- **Description**: Creates a new prestation by providing the request body with the required details.

### 5. Update a Prestation

- **Endpoint**: `/prestations/update/{id}`
- **HTTP Method**: PUT
- **Description**: Updates an existing prestation by specifying the ID in the path and providing the updated details in the request body.

### 6. Delete a Prestation

- **Endpoint**: `/prestations/delete/{id}`
- **HTTP Method**: DELETE
- **Description**: Deletes a prestation with the specified ID.

### 7. Search Prestations

- **Endpoint**: `/prestations/search`
- **HTTP Method**: GET
- **Description**: Searches for prestations based on criteria such as `type`, `minTarification`, and `maxTarification`.

## Integration with Eureka

This microservice is integrated with Eureka, which is a service registry for locating other microservices. Eureka allows for dynamic service registration and discovery. When this microservice starts, it registers itself with Eureka, and other services can discover and communicate with it.

To enable Eureka integration, you should configure the Eureka client in your `application.properties` or `application.yml` file with the Eureka server's URL.

Example `application.properties` configuration:

```properties
spring.application.name=msprestation
eureka.client.service-url.default-zone=http://eureka-server-url:8761/eureka
##Please replace placeholders like `http://eureka-server-url:8761/eureka` with the actual URL of your Eureka server. You can also include instructions for installing and running the project as needed.

## Integration with API Gateway

This microservice is also designed to work in tandem with an API Gateway, which serves as a central point for routing and managing HTTP requests to various microservices. The API Gateway helps in handling cross-cutting concerns such as authentication, load balancing, and request routing.

### Configuration

The API Gateway configuration is defined in the `application.yml` file. Here's an example of a typical configuration for an API Gateway:

```yaml
# API Gateway Configuration
server:
  port: 8080

spring:
  application:
    name: api-gateway

eureka:
  client:
    service-url:
      defaultZone: http://eureka-server-url:8761/eureka

zuul:
  routes:
    prestation-service:
      path: /prestations/**
      serviceId: msprestation
