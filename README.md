# Quiz Microservices Project 🎯

This project is a **microservices-based system** built with **Spring Boot**, demonstrating service communication, load balancing, and API Gateway routing.  

The system consists of:
- **Question Service** – Handles question-related CRUD operations.
- **Quiz Service** – Manages quizzes and communicates with the Question Service.
- **Service Registry** – Uses **Eureka** for service discovery.
- **API Gateway** – Routes external requests to respective services and provides load balancing.
- **Feign Client** – For inter-service communication between Quiz Service and Question Service.

---

## 🏗️ Architecture

- The **API Gateway** acts as a single entry point.
- Services register themselves in the **Eureka Server**.
- **Feign Client** enables the Quiz Service to call endpoints of the Question Service.
- **Load Balancing** ensures even distribution of requests.

---

## 🚀 Features

- Microservices-based architecture  
- Service discovery with **Eureka**  
- API Gateway for routing and filtering  
- **Feign Client** for declarative REST calls  
- Load balancing for service instances  
- Separation of responsibilities: Quiz & Question services  

---

---

## ⚙️ Technologies Used

- **Java 17**  
- **Spring Boot**  
- **Spring Cloud (Eureka, Gateway, OpenFeign, LoadBalancer)**  
- **Maven**  
- **REST APIs**  

---



