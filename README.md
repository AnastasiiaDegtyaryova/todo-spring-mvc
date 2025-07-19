# Todo List App (Spring MVC + Hibernate + MySQL)

## Features

- View tasks with pagination
- Create / edit / delete tasks
- Filter by "assigned to"
- Column sorting
- Field validation (required description)
- Containerized with Docker

## Tech Stack

- Java 21
- Maven
- Spring MVC
- Hibernate (JPA)
- Thymeleaf
- MySQL 8
- Docker & Docker Compose
- Tomcat 9 (via Docker)
---

## Running with Docker

1. Clone the repository

```bash
git clone https://github.com/AnastasiiaDegtyaryova/todo-spring-mvc.git
cd todo-spring-mvc
```
2. Start the application
```bash
docker-compose down -v
docker-compose up --build
```
3. Access the app:

Web UI: http://localhost:8080/

MySQL DB: localhost:3307 (username: root, password: Password1.)

Port 3306 is mapped to 3307 to avoid conflicts with local MySQL.