
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {

    Socket socket;
    Vector<ClientHandler> clients;
    BufferedReader input;
    PrintWriter output;

    public ClientHandler(Socket socket, Vector<ClientHandler> clients) {

        this.socket = socket;
        this.clients = clients;

        try {
            input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            output = new PrintWriter(
                    socket.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Client connection error!");
        }
    }

    public void run() {

        try {
            String message;

            while ((message = input.readLine()) != null) {

                System.out.println("Message: " + message);

                for (ClientHandler client : clients) {
                    client.output.println(message);
                }
            }

        } catch (IOException e) {
            System.out.println("Client disconnected!");
        } finally {
            clients.remove(this);

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Socket closing error!");
            }
        }
    }
}
