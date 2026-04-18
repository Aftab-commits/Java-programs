# Delivery System

## Java OOP Project  
Package: Delivery | Language: Java

---

## Project Overview

The Delivery System is a console-based Java application that simulates a food delivery platform similar to services like Foodpanda. It models real-world entities such as restaurants, menu items, and customer orders using Object-Oriented Programming principles.

The system allows a central delivery platform to manage multiple restaurants across different cities. Each restaurant has its own menu, and customers can place orders, which are processed independently. The design strongly focuses on data integrity, encapsulation, and object independence through deep copying.

---

## Key OOP Concepts Demonstrated

### Composition vs Aggregation

- **Composition (Strong Ownership)**
  - `Restaurant → MenuItem`
  - `Order → MenuItem`
  - Restaurants fully own their menu items.
  - Orders own their own copies of items.
  - If parent object is removed, child objects conceptually do not exist independently.

- **Aggregation (Weak Relationship)**
  - `DeliverySystem → Restaurant[]`
  - DeliverySystem only references restaurants.
  - Restaurants exist independently of the system.

---

### Deep Copy & Copy Constructors

All major classes implement copy constructors to ensure complete independence between objects.

- Prevents shared references
- Avoids unintended modifications
- Ensures safe duplication of objects

Example logic:
- Copy each `MenuItem` individually instead of copying references
- Copy `Restaurant` menus into new independent lists
- Copy `Order` items into separate memory

---

### Encapsulation & Defensive Copying

- All fields are declared `private`
- Access is controlled via getter methods
- Mutable lists are never returned directly

Instead:
- A new copied list is returned to protect internal data

This ensures external code cannot modify internal state of objects.

---

### ArrayList Usage

ArrayList is used as the main dynamic data structure:

- Restaurant stores menu items dynamically
- Order stores purchased items
- DeliverySystem filters restaurants by city using lists

Advantages:
- Dynamic resizing
- Easy insertion/removal
- Flexible data handling

---

### StringBuilder Optimization

All display and `toString()` methods use `StringBuilder` instead of string concatenation.

Reason:
- More efficient in loops
- Reduces creation of unnecessary string objects
- Produces cleaner formatted output

---

### Static Fields & Auto-Increment IDs

- Order IDs are generated using a static counter
- Every new order gets a unique ID automatically
- Even copied orders receive unique identifiers

This ensures:
- No duplicate order IDs
- Proper tracking of all orders

---

### Method Overriding

- `toString()` → used for formatted output of all classes
- `equals()` → used in MenuItem for logical comparison (not reference-based)

This allows:
- Correct removal of items from lists
- Clean and readable console output

---

### Final Fields & Immutability

Some values are made `final` to ensure they never change:

- Order ID
- Customer name
- Core system references

This improves:
- Data safety
- Predictability of objects

---

## Class Overview

| Class | Role | Key Concepts |
|------|------|-------------|
| MenuItem | Represents a dish | Copy constructor, equals(), encapsulation |
| Restaurant | Holds menu items | Composition, ArrayList, filtering |
| Order | Represents customer order | Deep copy, static ID, total calculation |
| DeliverySystem | Manages restaurants | Aggregation, search, display |
| Tester | Runs the system | Demonstration and testing |

---

## Project Structure

Delivery/
├── MenuItem.java
├── Restaurant.java
├── Order.java
├── DeliverySystem.java
└── Tester.java

---

## How to Run

1. Place all files inside the `Delivery` package folder  
2. Compile the project.
3. Run the program.


---

## Output Includes

- Restaurant listings by city  
- Menu display with categories  
- Order placement and billing  
- Deep copy verification  
- System-wide demonstration  

---



# Ride Booking System

## Java OOP Project — Inheritance & Polymorphism  
Language: Java | Paradigm: Object-Oriented Programming

---

## Project Overview

The Ride Booking System is a console-based Java application that simulates a ride-hailing platform. It demonstrates how inheritance and polymorphism can be used to design scalable and reusable systems.

- Models two ride types: Economy and Premium  
- Uses an abstract base class `Ride` to define shared structure  
- Subclasses implement their own fare calculation logic  
- Demonstrates runtime polymorphism using a `Ride[]` array  
- All rides are handled through a unified interface  

The system focuses on clean OOP design rather than UI or database integration.

---

## Key OOP Concepts Demonstrated

### Inheritance

- `EconomyRide` and `PremiumRide` inherit from `Ride`
- Shared attributes are defined once in the parent class:
  - rideID, customerName, distance, baseFare
- Subclasses reuse and extend functionality instead of rewriting it

This reduces code duplication and improves maintainability.

---

### Abstract Class & Abstract Method

The `Ride` class is abstract, meaning it cannot be instantiated directly.

- It defines a blueprint for all ride types  
- Contains an abstract method `calculateFare()`  
- Forces all subclasses to implement their own fare logic  

This ensures consistency while allowing flexibility in implementation.

---

### Method Overriding & Polymorphism

Each subclass overrides key methods like:

- `calculateFare()`
- `display()`

This enables runtime polymorphism:

- A `Ride[]` array can hold different ride types  
- The correct method is chosen automatically at runtime  
- Same method call produces different behavior depending on object type  

This is the core feature enabling flexible system design.

---

### super Keyword Usage

The `super` keyword is used in two important ways:

- `super()` → calls parent constructor to initialize shared fields  
- `super.display()` → reuses parent display logic before adding subclass-specific details  

This avoids duplication and builds layered functionality.

---

### Static Fields

- A static variable `totalRides` tracks total rides created  
- Shared across all objects of the `Ride` class  

This demonstrates class-level state instead of object-level state.

---

### Encapsulation

- All fields in `Ride` are private  
- Access is controlled through getter methods  
- Prevents direct modification of internal data  

Some fields are protected to allow controlled subclass access where needed.

---

### Final Fields

- Pricing values like rate per km and comfort fee are declared `final`  
- Ensures fare rules cannot be modified after initialization  

This improves reliability and prevents accidental changes.

---

## Fare Logic Summary

| Ride Type     | Formula |
|---------------|--------|
| EconomyRide    | baseFare + (distance × ratePerKm) |
| PremiumRide    | baseFare + (distance × ratePerKm) + comfortFee |

---

## Class Overview

| Class | Role | Key Concepts |
|------|------|-------------|
| Ride | Abstract base class | Abstraction, static fields, encapsulation |
| EconomyRide | Basic ride type | Inheritance, method overriding |
| PremiumRide | Premium ride type | Inheritance, final fields, override |
| Tester | Runs system | Polymorphism, runtime binding |

---

## Project Structure
(default package)
├── Ride.java
├── EconomyRide.java
├── PremiumRide.java
└── Tester.java


---

## How to Run

Since the project uses the default package:

### Compile:

### Run:


---

## Output Includes

- Ride details for Economy and Premium rides  
- Calculated fares for each ride type  
- Demonstration of polymorphism (same call, different behavior)  
- Total number of rides created  

