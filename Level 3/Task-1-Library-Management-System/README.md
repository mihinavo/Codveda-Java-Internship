# Library Management System with JDBC

## Internship
**Organization:** Codveda Technology  
**Domain:** Java Development Internship  
**Level:** Level 3 – Advanced  
**Task:** Task 1 – Library Management System with JDBC

## 1. Project Description

The Library Management System is a Java console-based application developed using Java, JDBC, and MySQL.

The application allows users to manage library books and registered members. It also supports borrowing and returning books while maintaining transaction records in a MySQL database.

## 2. Technologies Used

- Java
- MySQL
- JDBC (Java Database Connectivity)
- MySQL Connector/J
- Visual Studio Code
- MySQL Workbench

## 3. Project Structure


Task-1-Library-Management-System/
│
├── lib/
│   └── mysql-connector-j.jar
│
├── screenshots/
│
├── Book.java
├── User.java
├── DBConnection.java
├── LibraryManagement.java
├── Main.java
└── README.md


## 4. Database Structure

Database name: `LibraryDB`

The database contains three tables:

### Books
Stores book information:
- book_id
- title
- author
- isbn
- total_copies
- available_copies

### Users
Stores registered user information:
- user_id
- name
- email

### Transactions
Stores borrowing and returning records:
- transaction_id
- book_id
- user_id
- borrow_date
- return_date
- status

## 5. Main Features

1. Add new books.
2. View all books.
3. Update book details.
4. Delete books.
5. Register library users.
6. View registered users.
7. Borrow books.
8. Return borrowed books.

## 6. JDBC and SQL Operations

JDBC connects the Java application to the MySQL database.

SQL operations used include:

- INSERT – Add books and users.
- SELECT – Retrieve books and users.
- UPDATE – Modify book information and availability.
- DELETE – Remove book records.
- COMMIT – Save borrowing and returning transactions.
- ROLLBACK – Cancel unsuccessful transactions.

## 7. How to Run the Project

### Step 1: Create the Database

Open MySQL Workbench and execute the SQL script to create `LibraryDB` and its tables.

### Step 2: Configure Database Connection

Open `DBConnection.java` and configure the MySQL connection URL, username, and password.

### Step 3: Compile the Project

Open the terminal in the project directory and execute:

powershell
javac -cp ".;lib\*" *.java


### Step 4: Run the Application

powershell
java -cp ".;lib\*" Main


### Step 5: Use the Application

Select an option from the console menu to manage books, users, borrowing, and returning operations.

## 8. Screenshots

The screenshots folder contains evidence of:

- Database and table creation.
- Java project structure.
- Database connection.
- Adding and viewing books.
- Updating and deleting books.
- Registering and viewing users.
- Borrowing and returning books.
- Database transaction verification.

## 9. Learning Outcomes

Through this project, I gained practical experience in:

- Java object-oriented programming.
- Connecting Java applications with MySQL using JDBC.
- Executing SQL queries using PreparedStatement.
- Implementing CRUD operations.
- Managing database transactions using commit and rollback.
- Developing console-based applications.

## 10. Conclusion

This project demonstrates the development of a Library Management System using Java and MySQL. It provides practical experience in database connectivity, SQL operations, and transaction management through JDBC.

**Developed as part of the Codveda Technology Java Development Internship.**