
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            System.out.println("Connected to Chat Server!");
            System.out.println("Type your messages below:");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            Thread receiveThread = new Thread(() -> {

                try {
                    String message;

                    while ((message = input.readLine()) != null) {
                        System.out.println(message);
                    }

                } catch (IOException e) {
                    System.out.println("Disconnected from server!");
                }
            });

            receiveThread.start();

            while (true) {

                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }

                output.println(message);
            }

            socket.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
