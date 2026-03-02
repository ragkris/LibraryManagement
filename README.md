# Library Management System

## Project Description

The Library Management System is a Java-based application designed to manage the core operations of a library in an efficient and structured manner. The system enables librarians to maintain records of books, manage library members (patrons), and handle the lending and return processes of books.

This project focuses on applying Object-Oriented Programming (OOP) concepts and software design principles to develop a modular and scalable system without the use of external databases or APIs. The system maintains all required data in memory using appropriate Java Collection frameworks such as List, Map, and Set.

The application provides functionalities to:
- Add, update and remove books from the library inventory
- Search for books by title, author or BookId
- Register and manage library patrons
- Track borrowing history of patrons
- Issue and return books
- Maintain availability status of books


## Class Diagram
![class diagram](images\class-diagram.png)


---

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 17 or later
- command prompt

---

### Compile the Project

1. Open a terminal in the project root directory.


- Clean and compile code using maven
````
C:\Users\Kavitha\IdeaProjects\LibraryManagement>mvn clean compile
````
![Sources Txt file](images\mvn clean compile.jpg)


### Run the Project

````
C:\Users\Kavitha\IdeaProjects\LibraryManagement>mvn exec:java
````
![Run the Program](images\output.jpg)
