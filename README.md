#  Library Management System API

A RESTful API built with Spring Boot for managing books in a library system.
This project demonstrates production-ready backend practices including validation, global exception handling, DTO architecture, PostgreSQL integration, and API documentation with Swagger.

---

##  Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Swagger (OpenAPI)
* Jakarta Validation

---

##  Features

* CRUD operations for books
* Layered architecture (Controller / Service / Repository)
* DTO-based request handling
* Request validation with meaningful error responses
* Global exception handling (400 / 404 management)
* PostgreSQL database integration
* Interactive API documentation with Swagger

---

##  Project Structure

```text
src/main/java/com/example/librarymanagementsystem
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

---

##  API Endpoints

| Method | Endpoint        | Description       |
| ------ | --------------- | ----------------- |
| GET    | /api/books      | Get all books     |
| GET    | /api/books/{id} | Get book by ID    |
| POST   | /api/books      | Create a new book |
| PUT    | /api/books/{id} | Update a book     |
| DELETE | /api/books/{id} | Delete a book     |

---

##  Example Request

```json
{
  "title": "Clean Code",
  "author": "Robert Martin",
  "publishedYear": 2008
}
```

---

##  Validation & Error Handling

Example validation error response:

```json
{
  "timestamp": "2026-03-30T10:00:00",
  "status": 400,
  "errors": {
    "title": "Title cannot be blank",
    "publishedYear": "Published year cannot be greater than 2100"
  }
}
```

Example not found response:

```json
{
  "timestamp": "2026-03-30T10:00:00",
  "status": 404,
  "error": "Book not found with id: 9999"
}
```

---

##  API Documentation (Swagger)

After running the application, Swagger UI is available at:

http://localhost:8080/swagger-ui/index.html

You can test all endpoints directly from the browser.

---

##  Database (PostgreSQL via Docker)

Run PostgreSQL using Docker:

```bash
docker run --name library-postgres -e POSTGRES_DB=librarydb -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:16
```

---

## ️ Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

---

##  Purpose

This project was built to strengthen backend development skills and demonstrate:

* Clean API design
* Proper error handling
* Real-world backend architecture
* Database integration
* API documentation practices

---

##  Author

Osman Taha Çakırcı
