#  Library Management System

A full-stack library management application built with **Spring Boot** (backend) and **Vanilla JavaScript** (frontend).  
This project demonstrates production-ready practices including layered architecture, validation, global exception handling, CORS configuration, and interactive API documentation with Swagger.

---

##  Tech Stack

### Backend
* Java 17
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Swagger / OpenAPI 3
* Jakarta Validation

### Frontend
* HTML5
* CSS3
* Vanilla JavaScript (Fetch API)

---

##  Features

* Full CRUD operations for books (Create, Read, Update, Delete)
* Layered architecture (Controller / Service / Repository)
* DTO-based request handling
* Request validation with meaningful error responses
* Global exception handling (400 / 404 management)
* CORS configuration for local frontend-backend communication
* PostgreSQL database integration
* Interactive API documentation with Swagger UI
* Responsive frontend UI served via Spring Boot static resources

---

##  Project Structure

```
library-management/
├── src/
│   └── main/
│       ├── java/com/osman/library_management/
│       │   ├── config/
│       │   │   ├── CorsConfig.java
│       │   │   └── OpenApiConfig.java
│       │   ├── controller/
│       │   │   └── BookController.java
│       │   ├── dto/
│       │   │   └── BookRequestDto.java
│       │   ├── entity/
│       │   │   └── Book.java
│       │   ├── exception/
│       │   │   ├── GlobalExceptionHandler.java
│       │   │   └── ResourceNotFoundException.java
│       │   ├── repository/
│       │   │   └── BookRepository.java
│       │   ├── service/
│       │   │   └── BookService.java
│       │   └── LibraryManagementApplication.java
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   ├── app.js
│           │   └── style.css
│           └── application.properties
```

---

##  API Endpoints

| Method | Endpoint          | Description        |
|--------|-------------------|--------------------|
| GET    | /api/books        | Get all books      |
| GET    | /api/books/{id}   | Get book by ID     |
| POST   | /api/books        | Create a new book  |
| PUT    | /api/books/{id}   | Update a book      |
| DELETE | /api/books/{id}   | Delete a book      |

---

##  Example Request Body

```json
{
  "title": "Clean Code",
  "author": "Robert Martin",
  "publishedYear": 2008
}
```

---

##  Validation & Error Handling

**Validation error (400):**
```json
{
  "timestamp": "2026-03-30T10:00:00",
  "status": 400,
  "errors": {
    "title": "Title cannot be blank.",
    "publishedYear": "Published Year cannot be null."
  }
}
```

**Not found error (404):**
```
Book not found with id: 9999
```

**Validation rules:**
* `title` — required, 2–100 characters
* `author` — required, 2–60 characters
* `publishedYear` — required, between 1000 and 2100

---

##  Database (PostgreSQL via Docker)

```bash
docker run --name library-postgres \
  -e POSTGRES_DB=librarydb \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  -d postgres:16
```

---

##  Running the Application

```bash
mvn clean install
mvn spring-boot:run
```

Once running:

| URL | Description |
|-----|-------------|
| `http://localhost:8080` | Frontend UI |
| `http://localhost:8080/swagger-ui/index.html` | Swagger API Docs |

> **Note:** The frontend can also be opened separately via Live Server at `http://127.0.0.1:5500`. CORS is configured to allow both origins.

---

##  API Documentation (Swagger)

All endpoints are documented and testable directly from the browser via Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

##  Author

**Osman Taha Çakırcı**