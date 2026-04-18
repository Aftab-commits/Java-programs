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

## Delivery System — Java OOP Project
