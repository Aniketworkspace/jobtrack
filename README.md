# JobTrack

A backend application for managing job applications and interview progress.

## Overview

JobTrack is a Spring Boot REST API designed to help users manage their job applications.

The application provides APIs to create, view, update, search, and delete jobs and job applications while keeping track of application status, applied dates, notes, and associated jobs.

## Features

- Job CRUD operations
- Job application CRUD operations
- DTO-based request and response handling
- Request validation
- Global exception handling
- Custom exception handling
- Pagination
- Sorting
- Dynamic job search using JPA Specifications
- Job and application entity relationship
- RESTful API design
- HTTP status code handling
- Environment-based database password configuration

## Tech Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation

## Project Structure

```text
src/main/java/com/aniket/jobtrack
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
├── config
└── JobtrackApplication.java
```

## API Endpoints

### Jobs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/jobs` | Create a job |
| GET | `/jobs` | Get jobs with pagination and sorting |
| GET | `/jobs/{id}` | Get a job by ID |
| DELETE | `/jobs/{id}` | Delete a job |
| GET | `/jobs/search` | Search jobs dynamically |

### Applications

| Method | Endpoint | Description |
|---|---|---|
| POST | `/applications` | Create an application |
| GET | `/applications` | Get applications with pagination and sorting |
| GET | `/applications/{id}` | Get an application by ID |
| PUT | `/applications/{id}` | Update an application |
| DELETE | `/applications/{id}` | Delete an application |

## Pagination and Sorting

The API supports pagination and sorting using Spring Data `Pageable`.

Example:

```text
GET /jobs?page=0&size=5
```

Sort example:

```text
GET /jobs?page=0&size=5&sort=salary,desc
```

Applications also support pagination and sorting:

```text
GET /applications?page=0&size=5&sort=appliedDate,desc
```

## Dynamic Job Search

JobTrack provides dynamic job searching using Spring Data JPA Specifications.

Supported search parameters include:

- Company name
- Job title
- Application status

Example:

```text
GET /jobs/search?companyName=amazon
```

Multiple filters can also be combined:

```text
GET /jobs/search?companyName=amazon&jobTitle=Backend Developer&status=APPLIED
```

## Database

JobTrack uses MySQL with Spring Data JPA and Hibernate.

The main entities are:

- `Job`
- `Application`

The relationship between them is:

```text
Job
 |
 | 1
 |
 |------< Application
           *
```

A single job can have multiple applications, while each application belongs to one job.

The `applications` table contains a foreign key referencing the `jobs` table.

## Validation and Exception Handling

The application uses Jakarta Validation for validating incoming request data.

Examples include:

- Required fields
- Non-blank strings
- Positive salary values
- Valid application data

Global exception handling is implemented using `@RestControllerAdvice`.

The API provides appropriate HTTP responses for common errors such as:

- `400 Bad Request`
- `404 Not Found`

## DTO Architecture

JobTrack uses Data Transfer Objects to separate the API layer from the database entities.

The request and response flow is:

```text
Client
  ↓
Request DTO
  ↓
Controller
  ↓
Service
  ↓
Entity
  ↓
Repository
  ↓
Database
```

For responses:

```text
Database
  ↓
Entity
  ↓
Service
  ↓
Response DTO
  ↓
Controller
  ↓
Client
```

This prevents database entities and relationships from being directly exposed through the API.

## Configuration

The application uses an environment variable for the database password instead of hardcoding credentials.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobtrack_db
spring.datasource.username=root
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Set the `DB_PASSWORD` environment variable before running the application.

## How to Run

### Prerequisites

- Java 21
- MySQL 8+
- Maven
- IntelliJ IDEA or another Java IDE

### Steps

1. Clone the repository.
2. Create the MySQL database:

```sql
CREATE DATABASE jobtrack_db;
```

3. Configure the `DB_PASSWORD` environment variable.
4. Update the database configuration if required.
5. Run the Spring Boot application using IntelliJ IDEA or Maven.
6. The API will be available at:

```text
http://localhost:8080
```

## Future Improvements

Planned improvements include:

- Spring Security
- JWT-based authentication
- User registration and login
- Role-based authorization
- Swagger / OpenAPI documentation
- Unit and integration testing
- JUnit and Mockito
- Improved API documentation
- Additional filtering and search capabilities

## Author

**Aniket Thakur**

Bachelor's in Computer Science Engineering