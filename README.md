# 🏨 EasyStay - Hotel Reservation System

A modern **Java Swing desktop application** for managing hotel reservations, rooms, customers, and user authentication. Built with a clean Material Design UI, MySQL backend, and JasperReports for professional reporting.

![Java](https://img.shields.io/badge/Java-100%25-blue)
![Maven](https://img.shields.io/badge/Maven-Project-orange)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1)

## ✨ Features

- **🔐 Secure Authentication** – Login system with validation
- **🏠 Room Management** – View, add, and manage hotel rooms
- **👥 Customer Management** – Register and manage customers
- **📅 Reservations** – Create and track bookings
- **📊 Reporting** – Generate reports using JasperReports
- **🎨 Modern UI** – Powered by FlatLaf + Material Themes for a sleek desktop experience
- **🗄️ Database Integration** – MySQL connector for persistent storage

## 🛠️ Tech Stack

- **Language**: Java (JDK 25+)
- **UI Framework**: Java Swing + FlatLaf + Material UI
- **Build Tool**: Maven
- **Database**: MySQL

- **Components**:
  - LGoodDatePicker (date selection)
  - Ikonli (icons)
  - Material Themes

## 📁 Project Structure
``` EasyStay/
├── src/main/java/
│   ├── Main.java                 # Entry point
│   ├── model/                    # Data models (Room, Customer, Reservation, User)
│   ├── view/                     # Swing UI forms (Login, Dashboard, Rooms, etc.)
│   ├── controller/               # Business logic
│   ├── dao/                      # Data Access Objects
│   ├── service/                  # Service layer
│   └── util/                     # Utilities
├── pom.xml                       # Maven dependencies
└── out/artifacts/                # Compiled JAR

```
## 🚀 Getting Started
### Prerequisites

- Java 25 or higher
- MySQL Server
- Maven (recommended)

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Isanka-maduwantha/EasyStay.git
   cd EasyStay

Database Setup
- Create a MySQL database (e.g., easystay)
- Update database connection details in your DAO/utility classes
- Run any provided SQL scripts to create tables

#### Build the projectBash
```mvn clean package```
#### Run the application
```java -jar out/artifacts/EasyStay_jar/EasyStay.jarOr run directly from your IDE: Main.java ```
