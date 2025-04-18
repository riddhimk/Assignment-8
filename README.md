# Assignment-8: Student Operations using Custom Exceptions

## Overview  
This Java program implements a **Student Management System** using **OOP principles** and **custom exception handling**. It allows adding, updating, deleting, displaying, and searching student records with proper validations.

## Features  
- **Create, Update, Delete, Display** student records  
- **Search by PRN, Name, and Position in List**  
- Custom Exception Handling:  
  - `DuplicatePRNException`  
  - `InvalidCGPAException`  
  - `EmptyStudentListException`  
  - `StudentNotFoundException`  
  - `InvalidPositionException`  

## Class Structure  

### `Student.java`  
- Represents a student entity with attributes:  
  - `name`, `prn`, `dept`, `batch`, `cgpa`  
- Methods:  
  - Getters and setters for all attributes  
  - `display()`: Prints student details  

### `StudentOperations.java`  
- Contains an **ArrayList** of `Student` objects  
- Operations include:  
  - `addStudent(Student)`  
  - `displayStudents()`  
  - `searchByPRN(long)`  
  - `searchByName(String)`  
  - `searchByPosition(int)`  
  - `updateStudent(long, String, String, String, double)`  
  - `deleteStudent(long)`  
- Uses custom exceptions for validation and error handling  

### `Main.java`  
- User interface for interacting with the system  
- Pre-populates 5 sample student records  
- Provides a **menu-driven CLI** for user operations  

## Custom Exceptions  
| Exception Class           | Trigger Condition                                  |
|---------------------------|----------------------------------------------------|
| `DuplicatePRNException`   | When a student with the same PRN already exists    |
| `InvalidCGPAException`    | When CGPA is out of valid range (0.0 to 10.0)      |
| `EmptyStudentListException`| When trying to display/search/delete from an empty list |
| `StudentNotFoundException`| When a student with given PRN/Name is not found   |
| `InvalidPositionException`| When position index is out of bounds               |

## Sample Student Attributes  
| Name           | PRN           | Department | Batch | CGPA |
|----------------|---------------|------------|-------|------|
| Rohit Sharma   | 23070126101   | CSE        | A1    | 9.1  |
| Virat Kohli    | 23070126102   | ENTC       | B3    | 8.5  |
| Riddhim Kawdia | 23070126103   | AIML       | B2    | 7.8  |
| David Warner   | 23070126104   | CIVIL      | A2    | 8.2  |
| Chris Gayle    | 23070126105   | CSE        | B1    | 9.0  |
