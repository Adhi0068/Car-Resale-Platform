🚗 Car Resale Platform

A backend web application built using Java, Spring Boot, and MySQL for managing the buying and selling of used cars.  
The platform provides secure user authentication, vehicle listings, booking management, and integration with AWS for storage.

---

🧱 Tech Stack
- Language: Java 17  
- Framework: Spring Boot  
- ORM: Hibernate / Spring Data JPA  
- Database: MySQL  
- Authentication: Spring Security with JWT  
- DevOps Tools: Docker, AWS (EC2, S3), Linux  
- Build Tool: Maven
- IDE: Intellij IDEA

---

⚙️ Features
✅ User registration and authentication (JWT-based)  
✅ Add, update, and delete car listings  
✅ Upload vehicle images to AWS S3  
✅ Book and manage test drives  
✅ Role-based access control (Admin / User)  
✅ API documentation with Swagger/Postman
✅ Containerized with Docker for easy deployment  

---

🧩 Project Structure
Car-Resale-Platform/
├── src/
│ ├── main/
│ │ ├── java/com/example/
│ │ │ ├── controller/ # REST controllers
│ │ │ ├── entity/ # JPA entities
│ │ │ ├── repository/ # Data access layer
│ │ │ ├── service/ # Business logic
│ │ │ └── config/ # Security & AWS configs
│ │ └── resources/
│ │ ├── application.yml # App configuration
│ │ └── static/templates/
│ └── test/
└── pom.xml # Maven dependencies
