Membership Type API

Overview

This project includes a REST API controller for managing membership types. The controller, MembershipTypeController, provides endpoints for CRUD operations on membership types, including retrieving all membership types, retrieving a membership type by ID, creating a new membership type, updating an existing membership type, and deleting a membership type.

Prerequisites
Java 8 or later
Maven or Gradle for dependency management
Spring Boot
Endpoints

Get All Membership Types
URL: /membershipType
Method: GET
Response:
Status: 200 OK
Body: List of MembershipType objects

Get Membership Type by ID
URL: /membershipType/{id}
Method: GET
Path Variable: id (integer)
Response:
Status: 200 OK (if found)
Status: 404 Not Found (if not found)
Body: MembershipType object (if found)

Create Membership Type
URL: /membershipType
Method: POST
Body: MembershipType object
Response:
Status: 200 OK (if created)
Status: 404 Not Found (if already exists)
Body: Created MembershipType object

{
"name": "Gold",
"duration": 12,
"price": 99.99
}

Update Membership Type
URL: /membershipType
Method: PUT
Body: MembershipType object
Response:
Status: 200 OK (if updated)
Status: 404 Not Found (if not found)
Body: Updated MembershipType object
{
"id": 1,
"name": "Platinum",
"duration": 12,
"price": 149.99
}

URL: /membershipType/{id}
Method: DELETE
Path Variable: id (integer)
Response:
Status: 200 OK (if deleted)
Status: 404 Not Found (if not found)
Body: null
