Notes Application – Spring Boot (Backend)

This is a Notes Management Backend Application built using Spring Boot, Spring Web MVC, Spring Data JPA, and MySQL.
It supports full CRUD operations on notes using REST APIs.

---

Features

Create a new note

View all notes

Get note by ID

Update note by ID

Delete note by ID

Custom exception (InvalidNoteIdException)

Logging using SLF4J

Optional usage with Optional<>

CORS enabled for frontend connections

MySQL database integration

---

Project Structure

src/main/java/com/codegnan/
│
├── Entity
│   └── Note.java
│
├── repository
│   └── NoteRepository.java
│
├── service
│   ├── NoteService.java
│   └── NoteServiceImpl.java
│
├── controller
│   └── NoteController.java
│
├── exception
│   └── InvalidNoteIdException.java
│
└── NoteApplication.java


---

Technologies Used

Java 17

Spring Boot 4

Spring Web MVC

Spring Data JPA

MySQL

Maven (Build Tool)



---

Database Configuration (application.properties)

spring.application.name=Note

spring.datasource.url=jdbc:mysql://localhost:3306/notesdb?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


---

How to Run

1️.Start MySQL Server

Ensure MySQL is running on your machine.

2️.Run Spring Boot application

 run the main class:

NoteApplication.java

Backend will start at:

http://localhost:8080

---

REST API Endpoints

Method	Endpoint	Description

POST	/api/notes	Create a note
GET	/api/notes	Get all notes
GET	/api/notes/{id}	Get note by ID
PUT	/api/notes/{id}	Update note
DELETE	/api/notes/{id}	Delete note by ID

---

Custom Exception

InvalidNoteIdException

Thrown when a note with the provided ID does not exist.

noteRepository.findById(id)
    .orElseThrow(() -> new InvalidNoteIdException("Note not found with ID: " + id));


---

CORS Support

To allow frontend access:

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notes")
public class NoteController { }
