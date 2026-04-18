**********  Delivery System  **********

A Java OOP Project
Package: Delivery   |   Language: Java
Project Overview
The Delivery System is a Java-based simulation of a food delivery platform — inspired by services like Foodpanda. It models real-world entities such as restaurants, menu items, and customer orders using core Object-Oriented Programming principles. The project is entirely console-driven and focuses on clean class design rather than a graphical interface.

The system allows a central delivery platform to manage multiple restaurants across different cities, each with their own menus. Customers can place orders, have them copied, and view itemized bills — all while the underlying code rigorously enforces data integrity through encapsulation and deep copying.

Key OOP & Java Concepts Demonstrated

Composition vs. Aggregation
One of the most intentional design decisions in this project is the clear separation between composition (ownership) and aggregation (reference).

    • Composition — Restaurant owns its menu (ArrayList<MenuItem>). If a restaurant is destroyed, its menu items go with it. Deep copies are made in the copy constructor to ensure full independence.
    • Composition — Order owns its items (ArrayList<MenuItem>). Each order holds its own copies of menu items, not shared references.
    • Aggregation — DeliverySystem references an array of Restaurant objects (Restaurant[]). It does not own them; restaurants exist independently.

Deep Copy & Copy Constructors
Every class that holds mutable objects implements a copy constructor that performs a deep copy, preventing external mutation of internal state.

MenuItem(MenuItem m) { this.name = m.name; this.price = m.price; this.category = m.category; }
Restaurant(Restaurant r) { for (MenuItem a : r.menu) { this.menu.add(new MenuItem(a)); } }
Order(Order a) { for (MenuItem n : a.item) { item.add(new MenuItem(n)); } }

This pattern ensures that copying an Order or Restaurant yields a fully independent object — modifying the copy will never affect the original.

Encapsulation & Defensive Copying
Fields are kept private throughout. Getters that return mutable collections (like getMenu()) return a new deep-copied ArrayList rather than the internal reference, so callers cannot accidentally corrupt restaurant data.

public ArrayList<MenuItem> getMenu() {
    ArrayList<MenuItem> newMenu = new ArrayList<>();
    for (MenuItem m : menu) { newMenu.add(new MenuItem(m)); }
    return newMenu;
}

ArrayList
ArrayList is used extensively throughout the project as the primary dynamic data structure. Unlike arrays, it grows automatically and provides convenient add/remove operations.

    • Restaurant.menu — dynamically holds all menu items; items can be added or removed at runtime.
    • Order.item — holds the deep-copied items for a given order.
    • DeliverySystem.find() — returns a filtered ArrayList<Restaurant> of all restaurants in a given city.
    • Tester — uses ArrayList<MenuItem> to build item lists before placing an order.

StringBuilder
All toString() methods and display methods use StringBuilder instead of String concatenation. This is a deliberate performance and style choice — StringBuilder is mutable and avoids creating unnecessary intermediate String objects inside loops.

StringBuilder sb = new StringBuilder();
sb.append("================================\n");
for (MenuItem m : menu) { sb.append(m.getName() + "...\n"); }
return sb.toString();

This pattern appears in Restaurant.toString(), Order.toString(), DeliverySystem.displayMenu(), and DeliverySystem.displayByCity() — making all output consistently formatted and efficient.

Static Fields & Auto-Incrementing IDs
The Order class uses a static counter field to assign a unique, auto-incrementing Order ID to every new order — including copies. This means each Order object, whether original or cloned, receives its own distinct ID.

private static int counter = 1;
this.orderId = counter;
counter++;

Method Overriding — equals() & toString()
Both MenuItem and all major classes override Object methods:

    • toString() — overridden in MenuItem, Restaurant, Order, and DeliverySystem to produce formatted, readable console output using StringBuilder.
    • equals() — overridden in MenuItem to compare by name and price (not reference), enabling correct behavior for ArrayList.remove() in Restaurant.

@Override
public boolean equals(Object obj) {
    MenuItem other = (MenuItem) obj;
    return this.name.equals(other.name) && this.price == other.price;
}

final Fields & Immutability
Fields that should never change after construction are marked final:

    • Order.orderId — cannot be reassigned after the order is placed.
    • Order.name — the customer name is fixed for the lifetime of the order.
    • DeliverySystem.r — the restaurant array reference is fixed (no add/remove methods exist for it).

Class Overview

Class
Role
Notable Concepts
MenuItem
Represents a single dish with name, price, and category
equals(), copy constructor, defensive getters
Restaurant
Owns a menu; supports add/remove/filter operations
Composition, deep copy, ArrayList, getMenuByCategory()
Order
A placed order with customer name and item list
Composition, static ID counter, copy constructor, getTotalPrice()
DeliverySystem
Central hub referencing all restaurants
Aggregation, find(), displayByCity(), StringBuilder
Tester
Demonstrates all features via a main() method
Integration testing, deep copy verification

Project Structure

Delivery/
├── MenuItem.java        // Leaf entity — name, price, category
├── Restaurant.java      // Composes ArrayList<MenuItem>
├── Order.java           // Composes ArrayList<MenuItem> with auto-ID
├── DeliverySystem.java  // Aggregates Restaurant[]
└── Tester.java          // Entry point & demonstration

How to Run

1. Ensure all five .java files are in a folder named Delivery (matching the package declaration).
2. From the parent directory, compile all files:

javac Delivery/*.java

3. Run the Tester class:

java Delivery.Tester

The console will display the full delivery system, sample orders, deep copy verification, menu filtering, city-based restaurant search, and formatted display output.

Delivery System — Java OOP Project
