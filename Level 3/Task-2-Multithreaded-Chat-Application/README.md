# Multithreaded Chat Application

## Codveda Java Development Internship – Level 3, Task 2

### Project Description
This project is a Multithreaded Chat Application developed using Java Socket Programming.

It allows multiple clients to connect to a single server and exchange messages. The server uses threads to handle multiple client connections simultaneously and broadcasts messages to all connected clients.

### Technologies Used
- Java
- Java Socket Programming
- Multithreading
- VS Code
- PowerShell

### Project Structure


Task-2-Multithreaded-Chat-Application/
│
├── ChatServer.java
├── ClientHandler.java
├── ChatClient.java
├── README.md
└── screenshots/


### Main Features
1. Start a chat server on port 5000.
2. Connect multiple clients to the server.
3. Send and receive messages.
4. Broadcast messages to all connected clients.
5. Handle clients using separate threads.
6. Disconnect from the chat by typing `exit`.

### How to Run

**1. Compile the Java files**

powershell
javac *.java


**2. Start the server**

powershell
java ChatServer


**3. Open another terminal and start a client**

powershell
java ChatClient


**4. Connect additional clients**

Open more terminals and run:

powershell
java ChatClient


**5. Exit the chat**

Type:

exit


### Learning Outcomes
- Understanding Java Socket Programming.
- Understanding client-server communication.
- Learning how to create and use threads.
- Handling multiple client connections.
- Implementing message broadcasting.

### Conclusion
The Multithreaded Chat Application was successfully developed and tested. Multiple clients were able to connect to the server and exchange messages through the broadcasting system.
