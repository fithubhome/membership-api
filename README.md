# Membership API
The Membership API code 

# Running locally with Docker
- `mvn clean install` (ensure .JAR is available)
- `docker-compose up --build` (create/start containers)

# Interacting with MySQL inside container using Docker Desktop's Exec console:
- `mysql --user=root --password=password memberships` (connects to MySQL service)
- `show databases;` (shows databases/schemas)
- `use membeships` (selects database/schema "memberships")
- `show tables` (shows tables in currently selected database/schema)
- `select * from membership_history;`
- `select * from membership_type;`
- etc.
