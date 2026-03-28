# Coinflow API

A robust, production-ready REST API for a digital wallet and money transfer system. 

## What is this project?
Coinflow is a backend banking engine that allows users to create digital wallets, check their balances, and transfer money securely between accounts. It is built using Java, Spring Boot, and PostgreSQL, and runs containerized via Docker.

## Why I built it
To Learn Backend Systems using JAVA.

This project focuses on building a fault-tolerant system with an emphasis on:
* ACID Compliance: Using Spring's `@Transactional` boundaries to ensure that money is never lost or duplicated if a database crash occurs mid-transfer.
* Data Integrity: Implementing Jakarta Input Validation to block bad data (like negative transfer amounts) before it hits the business logic.
* Professional Error Handling: Utilizing `@ControllerAdvice` to catch exceptions globally and return clean, standardized JSON error messages instead of leaking server stack traces.
* Auditability: Designing an immutable transaction ledger that permanently records every transfer.

## Tech Stack
* Framework: Spring Boot 3
* Language: Java 17+
* Database: PostgreSQL (Containerized)
* Infrastructure: Docker & Docker Compose
* Libraries: Spring Data JPA, Hibernate, Lombok, Jakarta Validation

## How to Run Locally
1. Ensure you have Docker and Docker Desktop installed and running.
2. Start the database by running `docker-compose up -d`.
3. The application will automatically connect to the database and create the necessary tables on startup.
4. Run the Spring Boot application via your IDE or the command line (`./mvnw spring-boot:run`).
5. The API will be available at `http://localhost:8080`.