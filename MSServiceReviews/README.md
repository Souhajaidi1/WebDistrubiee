# ServiceReviews Microservice

The ServiceReviews microservice is designed to handle service reviews, allowing users to submit and retrieve reviews for various services. It includes functionality to calculate average ratings for services, making it a valuable tool for service quality assessment.

## Table of Contents

1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Prerequisites](#prerequisites)
4. [Getting Started](#getting-started)
5. [Configuration](#configuration)
6. [Endpoints](#endpoints)
7. [Advanced Function: Calculate Average Reviews](#advanced-function-calculate-average-reviews)
8. [Testing](#testing)
9. [Contributing](#contributing)
10. [License](#license)

## Project Overview

The ServiceReviews microservice focuses on the management of service reviews. It provides various endpoints for creating, updating, and retrieving reviews. Additionally, it offers an advanced function to calculate the average ratings for services.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Spring Cloud Gateway (for API gateway functionality)
- Spring Cloud Eureka Client (for service discovery)
- MySQL Database
- Maven for project management

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) 8 or later installed.
- Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.
- MySQL Database running locally or accessible with proper configurations.
- Service registry and discovery (Eureka server) running locally or accessible with proper configurations.

## Getting Started

1. Clone this repository:

    ```sh
    git clone https://github.com/your-username/MSServiceReviews.git
    ```

2. Open the project in your preferred IDE.

3. Configure the `application.properties` or `application.yml` file with your database and Eureka server settings.

4. Build and run the project from your IDE or using Maven:

    ```sh
    mvn spring-boot:run
    ```

## Configuration

- You must configure your MySQL database details in the `application.properties` or `application.yml` file to enable data storage.

- Ensure that the Eureka server is running and that the microservice registers itself with Eureka.

## Endpoints

The ServiceReviews microservice provides the following endpoints:

- **POST /reviews/add-review:** Create a new service review.
- **PUT /reviews/update-review/{id}:** Update an existing service review by specifying the review's ID.
- **GET /reviews/get-review/{id}:** Retrieve a service review by its unique ID.
- **GET /reviews/all-reviews:** Retrieve a list of all service reviews.
- **DELETE /reviews/delete-review/{id}:** Delete a service review by specifying the review's ID.

## Advanced Function: Calculate Average Reviews

One of the key features of this microservice is the ability to calculate average ratings for services. You can use the `/reviews/calculate-average-rating/{serviceId}` endpoint to obtain the average rating for a specific service by providing its `serviceId`.

Example:

- **GET /reviews/calculate-average-rating/123:** Calculate the average rating for the service with `serviceId` 123.

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

## Controller

The ServiceReviews microservice employs a controller responsible for handling various HTTP requests related to service reviews. This controller is designed to manage the creation, retrieval, updating, and deletion of service reviews. It also provides an advanced function to calculate the average ratings for services. Below is an overview of the key controller functions:

### Create a New Service Review

- **Endpoint**: `POST /reviews/add-review`
- **Description**: Use this endpoint to submit a new service review. Provide the required information such as `rating`, `reviewText`, and optionally a `serviceId` to associate the review with a specific service.

### Update an Existing Service Review

- **Endpoint**: `PUT /reviews/update-review/{id}`
- **Description**: This endpoint allows you to update an existing service review by specifying the review's ID in the path and providing the updated details in the request body.

### Retrieve a Service Review

- **Endpoint**: `GET /reviews/get-review/{id}`
- **Description**: Retrieve a specific service review by its unique ID. Simply specify the review's ID in the path to obtain the desired review.

### Retrieve All Service Reviews

- **Endpoint**: `GET /reviews/all-reviews`
- **Description**: This endpoint retrieves a list of all service reviews. You can use this to get an overview of all the reviews submitted.

### Delete a Service Review

- **Endpoint**: `DELETE /reviews/delete-review/{id}`
- **Description**: Delete a service review by specifying its unique ID in the path. This action removes the selected review permanently.

### Calculate Average Ratings for Services

- **Endpoint**: `GET /reviews/calculate-average-rating/{serviceId}`
- **Description**: One of the advanced functions provided by this microservice is the ability to calculate average ratings for services. Use this endpoint by specifying the `serviceId` for the service you want to assess. The service will return the average rating for that service based on its reviews.

The controller serves as the primary interface for interacting with service reviews, offering a comprehensive set of features for managing and analyzing user feedback. Whether you need to create, update, retrieve, or delete reviews, or calculate average ratings, this controller has you covered.
