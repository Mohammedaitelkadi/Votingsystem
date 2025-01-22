# Distributed Electronic Voting System

This project implements a distributed electronic voting system using Java technologies such as **RMI**, **Kafka**, and **Multithreading**. The system supports remote authentication, real-time vote processing, and scalability to handle multiple users simultaneously.

---

## Features

- **Remote User Authentication**: Secure login for users via RMI.
- **Vote Casting**: Users can vote for their desired candidates.
- **Duplicate Vote Prevention**: Ensures each user can vote only once.
- **Real-time Vote Processing**: Uses Kafka for asynchronous and distributed message handling.
- **Scalability**: Supports multiple concurrent users with multithreading.

---

## Technologies Used

- **Java RMI**: For remote method invocation and user authentication.
- **Apache Kafka**: To manage distributed message processing for votes.
- **Multithreading**: To handle multiple users concurrently.
- **SLF4J with Logback**: For structured and configurable logging.
- **IntelliJ IDEA**: For development and testing.

---

## Architecture

1. **RMI Server**:
   - Authenticates users.
   - Handles vote casting and forwards valid votes to Kafka.

2. **Kafka**:
   - Processes votes in real-time via topics (e.g., `votes`, `results`).

3. **Kafka Consumer**:
   - Aggregates votes and displays real-time results in the console.

---

## How to Run

### Prerequisites
- **JDK** (Java Development Kit) installed.
- **Apache Kafka** and **Zookeeper** set up and running.
- **IntelliJ IDEA** for development.

### Steps
1. **Start Zookeeper**:
   ```bash
   .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. **Start Kafka**:
   ```bash
   .\bin\windows\kafka-server-start.bat .\config\server.properties
### 3. **Run the RMI Server**
   - Run the `RMIServer` class to start the RMI server for authentication.

### 4. **Run the Kafka Consumer**
   - Run the `VoteConsumer` class to start consuming votes from the Kafka topic.

### 5. **Send Votes via Producer**
   - Use the Kafka console producer to send votes to the `votes` topic:
     ```bash
     .\bin\windows\kafka-console-producer.bat --topic votes --bootstrap-server localhost:9092
     ```
