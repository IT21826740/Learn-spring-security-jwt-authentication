# Spring Security JWT Authentication

**Spring Security JWT Authentication** is a secure, token-based authentication system built using Spring Boot. It demonstrates how to implement login, role-based access control, and stateless session management using JWT tokens.

## 🌟 Features

* 🔐 **JWT-based Authentication** with `Authorization: Bearer <token>`
* 👤 **Role-based Access Control** using `@RolesAllowed`
* 📂 Endpoints for:

  * Public access
  * Authenticated users
  * Admin-only access
* ⚙️ Secure password storage using `BCryptPasswordEncoder`
* 🔄 Stateless session management

## 🔧 Technologies Used

### Backend

* Java 17+
* Spring Boot
* Spring Security
* JWT (via `jjwt`)
* Lombok
* SLF4J (Logging)
* Maven

## 📁 Project Structure

```
spring-security-jwt-authentication/
│
├── controller/
│   ├── AuthController.java          # Handles login and token generation
│   ├── TestController.java          # Various access-controlled endpoints
│   └── dto/
│       └── AuthRequestDto.java      # DTO for login credentials
│
├── security/
│   ├── AppUserDetailsService.java   # Custom UserDetailsService
│   ├── JwtUtil.java                 # JWT utility functions
│   ├── JwtFilter.java               # Extracts and validates tokens
│   └── SecurityConfig.java          # Security configurations and filters
│
├── model/
│   ├── User.java                    # JPA entity for system users
│   └── Authority.java               # Role entity
│
├── repository/
│   └── UserRepository.java          # DB access for users
│
└── SpringSecurityJwtAuthenticationApplication.java  # Entry point
```

---

## 🛠️ Steps to Run the Project

1️⃣ **Clone the Repository**

```bash
git clone https://github.com/your-username/spring-security-jwt-authentication.git
cd spring-security-jwt-authentication
```

2️⃣ **Run the Spring Boot Application**

* Make sure your database is running (e.g., MySQL/PostgreSQL if configured).
* Start the app with:

```bash
mvn spring-boot:run
```

3️⃣ **Login to Get JWT Token**

Use a tool like [Postman](https://www.postman.com/) or `curl`:

```bash
POST http://localhost:8080/login
Content-Type: application/json

{
  "username": "your-username",
  "password": "your-password"
}
```

Response:

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

4️⃣ **Access Secured Endpoints**

Attach the JWT token in headers:

```
Authorization: Bearer <your-token-here>
```

Examples:

* `/public` - accessible by anyone
* `/restricted` - authenticated users only
* `/user` - users with `ROLE_USER`
* `/admin` - users with `ROLE_ADMIN`
* `/profile` - users with either `ROLE_USER` or `ROLE_ADMIN`

---

## 🧪 Testing

* Manual testing with Postman/cURL.
* Add test cases using Spring Boot Test for:

  * `JwtUtil`
  * `AppUserDetailsService`
  * Endpoint authorization

---

## 🔐 Security Highlights

* Uses `BCryptPasswordEncoder` for secure password hashing.
* Stateless session management (`STATELESS`).
* Filters all requests through a custom `JwtFilter`.
* Restricts access with `@RolesAllowed`.

---
