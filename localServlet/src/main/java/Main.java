import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8089;

        try(ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = server.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("Новое подключение. Порт: " + clientSocket.getPort());

                    final String name = in.readLine();
                    out.println(String.format("Привет, " + name + ", номер твоего порта: " + clientSocket.getPort()));
                }

                }
            }
        }
    }
