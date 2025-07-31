import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to the chat server.");

        new ReadThread(socket).start();
        new WriteThread(socket).start();
    }

    static class ReadThread extends Thread {
        private BufferedReader reader;

        public ReadThread(Socket socket) {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println("Disconnected from server.");
            }
        }
    }

    static class WriteThread extends Thread {
        private PrintWriter writer;

        public WriteThread(Socket socket) {
            try {
                writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    String input = console.readLine();
                    writer.println(input);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}