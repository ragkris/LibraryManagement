
# Design Considerations

---

## 1. Object Oriented Programming Concepts Used

The Library Management System is designed using core Object Oriented Programming (OOP) principles such as Encapsulation, Inheritance, Abstraction and Polymorphism.

### Encapsulation
Encapsulation is achieved by restricting direct access to class attributes and exposing them through getter and setter methods.

For example, the `Book` class encapsulates attributes such as:
- Book ID
- Title
- Author
- Publication Year
- Availability Status

This ensures controlled access and modification of book information.

---

### Abstraction
Abstraction is implemented using interfaces such as:
- `SearchStrategy`
- `Observer`

These interfaces define expected behaviour without exposing implementation details.

Concrete classes such as:
- `TitleSearch`
- `AuthorSearch`
- `BookIdSearch`

implement the `SearchStrategy` interface to provide specific search functionality.

---

### Inheritance
Inheritance is used in the search functionality where multiple search classes inherit behaviour from the `SearchStrategy` interface.

Example:
- `TitleSearch implements SearchStrategy`
- `AuthorSearch implements SearchStrategy`
- `BookIdSearch implements SearchStrategy`

Similarly, the `PatronObserver` class implements the `Observer` interface to receive notifications when reserved books become available.

---

### Polymorphism
Polymorphism is demonstrated by treating different search implementations uniformly through the `SearchStrategy` interface.

This allows dynamic selection of search logic at runtime using the `SearchFactory` class without changing client code.

---

## 2. Application of SOLID Principles

The system design follows SOLID principles to ensure maintainability and scalability.

### Single Responsibility Principle (SRP)
Each class is responsible for a single functionality.

Examples:
- `InventoryService` manages book inventory
- `LendingService` handles book checkout and return
- `ReservationService` manages reservations
- `RecommendationService` provides book recommendations

---

### Open Closed Principle (OCP)
The search functionality is implemented using the Strategy Pattern, allowing new search types to be added without modifying existing classes.

---

### Liskov Substitution Principle (LSP)
All concrete search classes such as `TitleSearch` and `AuthorSearch` can be used interchangeably wherever `SearchStrategy` is referenced without affecting system behaviour.

---

### Interface Segregation Principle (ISP)
The `Observer` interface exposes only the necessary `update()` method required for reservation notifications.

This ensures implementing classes are not forced to depend on unused methods.

---

### Dependency Inversion Principle (DIP)
High level modules such as `LendingService` depend on abstractions rather than concrete implementations by interacting with interfaces such as:
- `SearchStrategy`
- `Observer`

---

## 3. Design Patterns Implemented

### Strategy Pattern
The Strategy Pattern is used to implement flexible book search functionality.

Different search algorithms such as:
- Search by Title
- Search by Author
- Search by BookID

are encapsulated into separate classes implementing the `SearchStrategy` interface.

This enables runtime selection of search behaviour without modifying existing logic.

---

### Observer Pattern
The Observer Pattern is implemented in the reservation system.

When a book is currently unavailable, patrons can reserve it and are added to a waitlist.

Once the book is returned, the `ReservationService` automatically notifies all registered observers (`PatronObserver`) about its availability.

---

### Factory Pattern
The Factory Pattern is used through the `SearchFactory` class to dynamically create appropriate search strategy objects based on user input without exposing object creation logic.

---

## 4. Use of Java Collections Framework

Java Collection classes are used to efficiently manage and retrieve system data.

- `Map<String, Book>` is used in `InventoryService` to store and retrieve books based on BookID.
- `List<Loan>` is used in the `Patron` class to maintain borrowing history.
- `Map<String, List<Observer>>` is used in `ReservationService` to manage reservation waitlists for books.
- `Set<String>` is used in `RecommendationService` to store unique author preferences for generating book recommendations.

These collections provide efficient data management and improve system performance.

---

## 5. Logging Framework

The system uses the SLF4J logging framework with Logback implementation to log important system events and errors.

Logging is used to record:
- Book checkout and return events
- Reservation and notification processes
- Error conditions such as attempting to checkout an unavailable book

Logs are written to both console and external log files, enabling easier debugging and monitoring of system activities.

---

This ensures the system is maintainable, scalable and adheres to best software engineering practices.