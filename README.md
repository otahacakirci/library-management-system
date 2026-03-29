#  Library Management System

A RESTful library management API developed with Spring Boot.

---

##  Features

- Add a new book
- List all books
- Get a book by ID
- Update book information
- Delete a book
- In-memory database integration with H2

---

##  Technologies Used

| Technology | Purpose |
|---|---|
| Java | Programming language |
| Spring Boot | Application framework |
| Spring Web | REST API layer |
| Spring Data JPA | Database integration |
| H2 Database | In-memory database |
| Maven | Build & dependency management |
| Git & GitHub | Version control |

---

##  Project Structure

```text
src/main/java/com/osman/librarymanagement
├── controller
├── entity
├── repository
└── service
```

---

##  API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/books` | Get all books |
| `GET` | `/api/books/{id}` | Get book by ID |
| `POST` | `/api/books` | Create a new book |
| `PUT` | `/api/books/{id}` | Update a book |
| `DELETE` | `/api/books/{id}` | Delete a book |

### Example JSON

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "publicationYear": 2008
}
```

---

##  Database

This project uses the **H2 in-memory database** for development and testing.

**H2 Console:**
```
http://localhost:8080/h2-console
```

---

##  What I Learned

While building this project, I practiced:

- ✅ REST API development
- ✅ CRUD operations
- ✅ Layered architecture
- ✅ Spring Boot fundamentals
- ✅ Database integration with JPA
- ✅ Testing endpoints with API tools

---

##  How to Run

1. Open the project in **IntelliJ IDEA**
2. Run `LibraryManagementApplication.java`
3. Test the endpoints using **Postman** or **IntelliJ HTTP Client**

---

##  Author

**Osman Taha Çakırcı**
