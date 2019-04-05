/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinoseri;

import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class ArduinoSeri {

    public static void main(String[] args) {

        SerialPort ports[] = SerialPort.getCommPorts();
        System.out.println("Bir port seçimi yapınız:"+ports.length );
        int i = 0;
        for (SerialPort port : ports) {
            System.out.println(i++ + " " + port.getSystemPortName());
        }
        Scanner scan = new Scanner(System.in);
        int selectPort = scan.nextInt();
        SerialPort port = ports[selectPort];
        port.setBaudRate(9600);
        if (port.openPort()) {
            System.out.println("Bağlantı Başarılı");
        } else {
            System.out.println("Bağlantı Başarısız");
            return;
        }
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, Integer.MAX_VALUE, 0);
        Scanner data = new Scanner(port.getInputStream());
        while (data.hasNextLine()) {
            System.out.println(data.nextLine());
        }

    }

}
