# 🛒 E-Commerce Order Management Platform

A Spring Boot REST API application that simulates an enterprise-level e-commerce backend. The application provides product management, customer management, order placement, inventory management, and order history functionalities while following a layered architecture commonly used in enterprise Java applications.

---

## 🚀 Features

* Product Management

  * Create Product
  * View Product
  * View All Products

* Customer Management

  * Create Customer
  * View Customer
  * View All Customers

* Order Management

  * Place Customer Orders
  * Retrieve Customer Order History

* Inventory Management

  * Automatically reduces product stock after successful order placement

* Validation

  * Bean Validation using Jakarta Validation

* Exception Handling

  * Centralized Global Exception Handling

* API Documentation

  * Swagger / OpenAPI Integration

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Spring Security
* H2 Database
* Maven
* Swagger OpenAPI
* Git
* GitHub

---

## 🏗️ Architecture

```
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
H2 Database
```

---

## 📊 Entity Relationship

```
Customer
    │
    │ 1
    ▼
CustomerOrder
    │
    │ 1
    ▼
OrderItem
    │
    │
    ▼
Product
```

---

## 📌 REST APIs

### Product APIs

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| POST   | /api/products      | Create Product    |
| GET    | /api/products      | Get All Products  |
| GET    | /api/products/{id} | Get Product By Id |

---

### Customer APIs

| Method | Endpoint            | Description        |
| ------ | ------------------- | ------------------ |
| POST   | /api/customers      | Create Customer    |
| GET    | /api/customers      | Get All Customers  |
| GET    | /api/customers/{id} | Get Customer By Id |

---

### Order APIs

| Method | Endpoint                          | Description                |
| ------ | --------------------------------- | -------------------------- |
| POST   | /api/orders/place                 | Place Order                |
| GET    | /api/orders/customer/{customerId} | Get Customer Order History |

---

## 📷 Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

---

## ▶️ Running the Project

Clone the repository

```bash
git clone <repository-url>
```

Navigate to the project

```bash
cd ecommerce-order-management-platform
```

Run the application

```bash
mvn spring-boot:run
```

Open Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🔮 Future Enhancements

* JWT Authentication
* PostgreSQL Integration
* Docker Support
* Redis Caching
* Kafka Event Processing
* JUnit & Mockito Testing
* GitHub Actions CI/CD
* AWS Deployment

---

## 👩‍💻 Author

**Anjali Bhogireddy**

Backend Developer | Java | Spring Boot | REST APIs
