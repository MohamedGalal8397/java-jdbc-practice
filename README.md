# java-jdbc-practice

JDBC with the DAO pattern against MySQL/SQL Server: connections, CRUD, prepared statements.

**Stack:** Java, JDBC, Maven

## Contents

Each folder is a small, self-contained exercise.

- `employee-dao-2`
- `employee-dao-mysql`
- `northwind-customers-dao`

## Run

Open any exercise folder in IntelliJ IDEA (or run `mvn compile exec:java` for Maven ones) and run its `Main` class.

## Configuration

Credentials are read from environment variables (`DB_PASSWORD`, `RABBITMQ_PASSWORD`, `MINIO_SECRET_KEY`); the defaults in the config are for a local development setup only.

---

Part of my Java backend learning path — see my other repositories for more.
