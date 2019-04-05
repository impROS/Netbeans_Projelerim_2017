package labchatclient;

import java.net.*;
import java.io.*;

public class LabChatClient {

    public static void main(String[] args) throws IOException {

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket("localhost", 4747);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Sunucu bulunamadı");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Hata : " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Sunucuya baglanildi.");

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        while (!(userInput = stdIn.readLine()).equals("Kapan")) {
            out.println(userInput);
            System.out.println("Sunucu: " + in.readLine());
        }
        System.out.println("Baglanti kesiliyor...");

        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
