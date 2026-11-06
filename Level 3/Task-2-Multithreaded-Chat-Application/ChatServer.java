import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Chat Server Started!");
            System.out.println("Waiting for clients...");

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("New client connected!");

                ClientHandler client =
                        new ClientHandler(socket, clients);

                clients.add(client);

                client.start();
            }

        } catch (IOException e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
}
