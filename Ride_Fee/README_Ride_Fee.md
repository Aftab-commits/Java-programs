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
