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

This project is licensed under the MIT License - see the [LICENSE](LICENSE)