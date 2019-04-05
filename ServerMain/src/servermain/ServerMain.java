/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermain;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by prog on 12.03.15.
 */
public class ServerMain {


    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
         String strVeri;
        try {
            Clients clients = new Clients();

            ServerSocket serverSocket = new ServerSocket(8097);
            while (true) {
                System.out.println("Wait client");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                Client client = new Client(socket, clients);
                clients.addClient(client);
//                System.out.println("Veri giriniz : ");
//                strVeri = giris.next();
//                client.sendToClient(strVeri);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
