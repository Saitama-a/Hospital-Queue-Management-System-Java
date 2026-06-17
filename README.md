# Hospital Queue Management System

## Student Information

**Student Name:** Muhammad Waleed
**Roll Number:** L1F23BSSE0339
**Course:** Software Construction & Development
**Semester Project - Phase 2**

---

## Project Description

The Hospital Queue Management System is a Java Swing desktop application developed to automate patient queue handling in hospitals and clinics. The system allows administrators to manage patient records, assign queue tokens, search patient information, update records, delete records, and serve patients in a First-In-First-Out (FIFO) order.

This project demonstrates the practical implementation of Object-Oriented Programming (OOP) concepts, Data Structures & Algorithms (DSA), Java Swing GUI development, file handling, input validation, and exception handling.

---

## Features

### Authentication

* Admin Login System
* Multiple Admin Accounts Support
* Credential Validation

### Patient Management

* Add Patient
* Update Patient Information
* Delete Patient
* Search Patient by Name or Token
* View Patient Records

### Queue Management

* Automatic Token Generation
* FIFO Queue Processing
* Serve Next Patient
* Queue Status Tracking

### Data Management

* Save Patient Records to File
* Load Patient Records from File
* Persistent Data Storage

### Additional Features

* Statistics Dashboard
* Patient Status Tracking (Waiting / Served)
* Input Validation
* Exception Handling
* User-Friendly Swing Interface

---

## OOP Concepts Used

### Encapsulation

Private fields with getters and setters in Patient and Admin classes.

### Inheritance

Patient class inherits from the abstract Person class.

### Abstraction

Abstract Person class defines common behavior.

### Polymorphism

Method overriding using the getDetails() method.

### Constructors

Parameterized constructors used throughout the project.

### Method Overloading

Search functionality implemented using different search methods.

---

## DSA Concepts Used

* Queue (FIFO)
* ArrayList
* Linear Search
* Bubble Sort

---

## Technologies Used

* Java
* Java Swing
* File Handling
* Object-Oriented Programming (OOP)
* Data Structures & Algorithms (DSA)

---

## Installation Steps

### Prerequisites

* Java JDK 8 or higher
* IntelliJ IDEA / Eclipse

### Steps

1. Clone the repository

git clone https://github.com/yourusername/HospitalQueueManagementSystem.git

2. Open the project in your IDE.

3. Compile all Java files.

4. Run the application.

HospitalQueueSystem.java


5. Login using:

Username:

admin

Password:

admin123

or you can sign up.
---

## Project Structure


HospitalQueueManagementSystem/
│
├── src/
│   └── gms/
│       ├── Admin.java
│       ├── Patient.java
│       ├── Person.java
│       ├── FileManager.java
│       ├── LoginSystem.java
│       └── HospitalQueueSystem.java
│
├── screenshots/
│
├── docs/
│   └── Project_Report.docx
│
├── README.md
│
├── admins.txt
└── patients.txt


---

## Screenshots

### Login Screen

<img width="440" height="314" alt="image" src="https://github.com/user-attachments/assets/ba425598-4899-4bc3-96d9-cdecc862c513" />


### Dashboard

<img width="1088" height="689" alt="image" src="https://github.com/user-attachments/assets/e4989914-7b81-42ee-931e-b6520e5996fa" />


### Add Patient

<img width="1079" height="504" alt="image" src="https://github.com/user-attachments/assets/2b382ef0-0a8c-4301-92fc-557ef6db51a4" />


### Search Patient

<img width="781" height="499" alt="image" src="https://github.com/user-attachments/assets/465580e0-2611-4df0-8cf5-5c093521bb32" />

---

## Testing

The following functionalities were tested successfully:

* Login Validation
* Add Patient
* Update Patient
* Delete Patient
* Search Patient
* Save Data
* Load Data
* Sorting Patients
* Input Validation
* Exception Handling

---

## Future Enhancements

* MySQL Database Integration
* Doctor Management Module
* Appointment Scheduling System
* Multi-User Support
* Patient History Records
* Report Generation
* Email Notifications
* Role-Based Access Control
* Advanced Search and Filtering
* Cloud Data Storage

---

## Conclusion

The Hospital Queue Management System successfully automates patient queue management using Java Swing and core Java concepts. The project demonstrates practical implementation of OOP principles, DSA concepts, GUI development, file handling, and software engineering practices while providing an efficient solution for hospital queue management.

---

### Developed By

**Muhammad Waleed**
**Reg Number: L1F23BSSE0339**
