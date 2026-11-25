# 👥 Employee Directory (Work in Progress 🚧)

A full stack Employee Directory app built with **Spring Boot, Angular and PostgreSQL**.

This is a learning project. I'm using it to practice real-world backend concerns: **exception handling, pagination, sorting and filtering**.

## ✅ Done
- Create, get and delete employee APIs
- Global exception handling with `@ControllerAdvice` and custom error responses
- [PostgreSQL integration, if done]

## 🔄 Roadmap
- [ ] Update employee API
- [ ] DTOs + request validation (`@Valid`)
- [ ] Pagination & sorting with `Pageable`
- [ ] Search and filter by department / name
- [ ] Angular UI with a paginated table
- [ ] Profile image upload
- [ ] Unit tests (JUnit 5 + Mockito)

## 📂 Structure

    backend/   → Spring Boot REST API
    frontend/  → Angular app

## 🛠 Tech Stack
Java · Spring Boot · Spring Data JPA · PostgreSQL · Angular · TypeScript · Maven

## 📡 API Endpoints (so far)

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees` | Create employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| DELETE | `/api/employees/{id}` | Delete employee |

*Change these paths to match your controller.*

## ⚠️ Error Response Format

    {
      "timestamp": "2026-11-12T10:15:30",
      "status": 404,
      "error": "Not Found",
      "message": "Employee not found with id: 10"
    }
