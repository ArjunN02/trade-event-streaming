# Trade Event Streaming System

This is a backend system for simulating and processing real-time trade events using **Spring Boot**, **Apache Kafka**, and **PostgreSQL**. It provides a REST API to generate dummy trade data, produces it to a Kafka topic, consumes the data via a Kafka listener, and persists it to a PostgreSQL database.

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot**
- **Apache Kafka** (with ZooKeeper)
- **PostgreSQL**
- **Postman** (for API testing)

---

## 📌 Features

- REST endpoint to generate random trade events
- Kafka-based trade message production and consumption
- Persistence of consumed trade events into PostgreSQL
- Script automation to start the full pipeline (Kafka, Spring Boot, API call)


