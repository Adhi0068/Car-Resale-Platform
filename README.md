# 🚗 Car Resale Platform

A backend web application built using Java, Spring Boot, and MySQL for managing the buying and selling of used cars.  
The platform provides secure user authentication, vehicle listings, booking management, and integration with AWS for storage.

---

## 🧱 Tech Stack
- Language: Java 17  
- Framework: Spring Boot  
- ORM: Hibernate / Spring Data JPA  
- Database: MySQL  
- Authentication: Spring Security with JWT  
- DevOps Tools: Docker, AWS (S3), Linux  
- Build Tool: Maven
- IDE: Intellij IDEA
- Depolyment: AWS EC2

---

## ⚙️ Features

✅ User registration and authentication (JWT-based)  
✅ Add, update, and delete car listings  
✅ Upload vehicle images to AWS S3  
✅ Book and manage test drives  
✅ Role-based access control (Admin / User)  
✅ API documentation with Swagger/Postman  
✅ Containerized with Docker for easy deployment  





















````markdown
# 🚗 Car Resale Platform

A backend web application built using **Java**, **Spring Boot**, and **MySQL** for managing the buying and selling of used cars.  
It provides secure user authentication, vehicle listing management, agent allocation, and image uploads using **AWS S3**.  
The application follows RESTful architecture, uses **Spring Security with JWT**, and is containerized with **Docker** for smooth deployment.

---

## 📑 Quick Links
- 🧱 [Project Overview](#-project-overview)
- ⚙️ [Tech Stack](#-tech-stack)
- 🚀 [How to Run](#-how-to-run)
- 📘 [API Documentation](#-api-documentation)
- 🧠 [Future Enhancements](#-future-enhancements)
- 👨‍💻 [Author](#-author)
- 🏷️ [License](#-license)

---

## 🧱 Project Overview

The **Car Resale Platform** enables users to buy and sell used cars efficiently.  
It supports multiple roles such as users, agents, and managers, allowing:
- **Users** to sign up, browse vehicles, and schedule test drives.  
- **Managers/Agents** to manage listings, verify details, and handle bookings.  
- **Admins** to maintain system integrity and user control.

The project demonstrates real-world backend design skills, including:
- REST API design and development with **Spring Boot**
- Authentication and authorization with **Spring Security (JWT)**
- Database design and ORM with **Hibernate / Spring Data JPA**
- File storage integration with **AWS S3**
- CI/CD, containerization, and cloud deployment awareness

---

## ⚙️ Tech Stack
- Language: Java 17  
- Framework: Spring Boot  
- ORM: Hibernate / Spring Data JPA  
- Database: MySQL  
- Authentication: Spring Security with JWT  
- DevOps Tools: Docker, AWS (S3), Linux  
- Build Tool: Maven
- IDE: Intellij IDEA
- Depolyment: AWS EC2


---

## 🚀 How to Run

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Adhi0068/Car-Resale-Platform.git
cd Car-Resale-Platform
````

### 2️⃣ Configure Database

Edit your `application.properties` or `application.yml` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/car_resale
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Access Locally

* Application: `http://localhost:8080`
* Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 📘 API Documentation

[![View in Postman](https://img.shields.io/badge/View%20in-Postman-orange?logo=postman)](https://documenter.getpostman.com/view/40974598/2sB3WpRM1J)

Explore the complete API reference and usage guide in the Postman documentation:
🔗 **[Car Resale Platform Postman Documentation](https://documenter.getpostman.com/view/40974598/2sB3WpRM1J)**

### API Categories

* 🔐 **Authentication APIs** – Signup, Login, OTP validation (JWT-based security)
* 🚘 **Car Management APIs** – Add, update, delete, and search car listings
* 📸 **File Upload APIs** – Upload car photos to AWS S3
* 🧑‍💼 **Agent APIs** – Assign and manage agents for customer bookings
* 📊 **Utility APIs** – Upload Excel data, search by PIN code, etc.

---

## 🧩 Project Structure

```
Car-Resale-Platform/
├── src/
│   ├── main/
│   │   ├── java/com/example/spinny/
│   │   │   ├── controller/         # REST Controllers
│   │   │   ├── entity/             # JPA Entities
│   │   │   ├── repository/         # Data Access Layer
│   │   │   ├── service/            # Business Logic
│   │   │   └── config/             # Security & AWS Configurations
│   │   └── resources/
│   │       ├── application.yml     # App Configurations
│   │       ├── static/            
│   │       └── templates/          
│   └── test/                     
└── pom.xml                         # Maven Dependencies
```

---

## 🧠 Further Enhancements

* 🔄 **Microservices** architecture for modular scalability
* 📨 Notification service using **Kafka** or **RabbitMQ**
* ⚙️ Set up **CI/CD pipelines** with GitHub Actions

---
