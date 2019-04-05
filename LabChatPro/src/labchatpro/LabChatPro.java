/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labchatpro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author impROS
 */
public class LabChatPro {

    public static void main(String[] args) throws IOException {
        Scanner giris = new Scanner(System.in);
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4747);
        } catch (IOException e) {
            System.err.println("Hata : "+e.getMessage());
            System.exit(1);
        }
        System.out.println("Sunucu baslatildi. Baglanti bekleniyor...");
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept(); 
        } catch (IOException e) {
            System.err.println("Hata : "+e.getMessage());
            System.exit(1);
        }

        System.out.println(clientSocket.getLocalAddress() + " baglandi.");

   
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        String inputLine, outputLine;
        System.out.println("bekleniyor...");
        while ((inputLine = in.readLine()) != null) {
      
            System.out.println("Client:" + inputLine);
            outputLine = giris.nextLine();        
            out.println(outputLine); 
     
            if (outputLine.equals("Kapan")) 
            {
                break;
            }
        }
        System.out.println(clientSocket.getLocalSocketAddress()
                + " baglantisi kesildi.");
     
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
