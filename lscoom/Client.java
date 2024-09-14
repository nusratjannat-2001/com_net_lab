import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 7777);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("ls");
            String file;
            while ((file = in.readLine()) != null) {
                System.out.println(file);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}