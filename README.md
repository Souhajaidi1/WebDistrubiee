# Service Order Microservice

The Service Order microservice is designed to manage service orders, including creating, updating, and retrieving service orders, as well as sending notifications via email when new service orders are created.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Endpoints](#endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create and manage service orders.
- Retrieve service orders by their unique ID.
- Update existing service orders.
- Delete service orders.
- Retrieve service orders by order date.
- Retrieve service orders by status.
- Send email notifications for newly created service orders.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Spring Web
- Spring Mail for sending emails
- Maven for project management
- H2 Database for development (you can switch to other databases for production)

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or later installed.
- Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- Maven for managing project dependencies.
- SMTP server details for sending email notifications.

## Getting Started

1. Clone this repository:

    ```sh
    git clone https://github.com/your-username/service-order-microservice.git
    ```

2. Open the project in your preferred IDE.

3. Configure the application.properties or application.yml file with your SMTP server settings for sending emails.

4. Build and run the project from your IDE or using Maven:

    ```sh
    mvn spring-boot:run
    ```

## Configuration

- You must configure your SMTP server details in the `application.properties` or `application.yml` file to enable email notifications.

## Endpoints

- **GET /service-orders/list-serviceorder:** Retrieve a list of all service orders.

- **GET /service-orders/OneService/{id}:** Retrieve a service order by its unique ID.

- **POST /service-orders/add-serviceorder:** Create a new service order.

- **PUT /service-orders/update-serviceorder/{id}:** Update an existing service order.

- **DELETE /service-orders/delete-serviceorder/{id}:** Delete a service order.

- **GET /service-orders/ServiceOrdersByOrderDate:** Retrieve a list of service orders by order date.

- **GET /service-orders/ServiceOrdersByStatus:** Retrieve a list of service orders by status.

- **POST /service-orders/send-test-email:** Send a test email to verify email functionality.

## Testing

You can test the functionality of this microservice by using tools like Postman or curl to send HTTP requests to the provided endpoints.

## Contributing

Contributions are always welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the project.

2. Create your feature branch: `git checkout -b feature/your-feature`.

3. Commit your changes: `git commit -m 'Add some feature'`.

4. Push to the branch: `git push origin feature/your-feature`.

5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

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
