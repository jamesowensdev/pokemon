# Deploying the `pokemon_catalogue` PostgreSQL Schema

This document explains how to set up the database for the `pokemon_catalogue` project on another device. Follow the steps below to deploy the schema and get the database running.

---

## Prerequisites

1. **PostgreSQL** (version 10 or higher recommended)
    - Installation guide: [PostgreSQL Downloads](https://www.postgresql.org/download/)
2. **Command-line Access**:
    - Access to `psql` for executing SQL commands.
3. **Schema File**:
    - Ensure you have the `schema.sql` file.

---

## Steps to Deploy the Schema

### 1. Install PostgreSQL
If PostgreSQL is not already installed:
- **Linux**: Use your package manager (e.g., `apt` for Ubuntu/Debian or `yum` for Red Hat-based systems).
- **macOS**: Use Homebrew:
  ```bash
  brew install postgresql
  ```
- **Windows**: Download the installer from [PostgreSQL Downloads](https://www.postgresql.org/download/).

---

### 2. Create a New Database
1. Start the PostgreSQL service.
2. Open a terminal and log in as the PostgreSQL superuser:
   ```bash
   psql -U postgres
   ```
3. Create the database:
   ```sql
   CREATE DATABASE pokemon_catalogue;
   ```

---

### 3. Load the Schema
1. Place the `schema.sql` file in an accessible directory.
2. Run the following command to load the schema into the new database:
   ```bash
   psql -U postgres -d pokemon_catalogue -f schema.sql
   ```

---

### 4. Verify the Schema
1. Log in to the database:
   ```bash
   psql -U postgres -d pokemon_catalogue
   ```
2. Check the tables:
   ```sql
   \dt
   ```

---

## Optional: Seed Data
If a seed data file (e.g., `seed-data.sql`) is provided, you can use it to populate the database with initial data:
```bash
psql -U postgres -d pokemon_catalogue -f seed-data.sql
```

---

## Troubleshooting


2. **Permission Denied**:
    - Ensure the user executing commands has the necessary privileges.

3. **Connection Issues**:
    - Verify that PostgreSQL is running and listening on the correct port (default is `5432`).

### Useful Commands
- Drop and recreate the database:
  ```bash
  psql -U postgres
  DROP DATABASE pokemon_catalogue;
  CREATE DATABASE pokemon_catalogue;
  ```

- List all databases:
  ```sql
  \l
  ```

- List all tables:
  ```sql
  \dt
  ```

---

