/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.util.Enumeration;
import java.util.TooManyListenersException;

public class SerialTest implements SerialPortEventListener {

    SerialPort serialPort;

    private static final String arrPortAdlari[] = {
        "COM14", // Windows
    };

    private BufferedReader input;
    private static OutputStream output;

    private static final int bekleme_suresi = 2000;

    private static final int baud_rate = 9600;

    public void initialize() {

        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port as set in PORT_NAMES.
        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            for (String portName : arrPortAdlari) {
                if (currPortId.getName().equals(portName)) {
                    portId = currPortId;
                    break;
                }
            }
        }
        if (portId == null) {
            System.out.println("Belirlenen Port Numarasi Bulunamadi.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),
                    bekleme_suresi);

            // set port parameters
            serialPort.setSerialPortParams(baud_rate,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (PortInUseException | UnsupportedCommOperationException | IOException | TooManyListenersException e) {
            System.err.println("Hata : " + e.toString());
        }
    }

    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }

    }

    @Override
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                if (input.readLine() != null) {
                    String inputLine = input.readLine();
                    System.out.println(inputLine);
                }

            } catch (IOException e) {
                // hata(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SerialTest main = new SerialTest();
        main.initialize();
        Thread t = new Thread() {
            public void run() {

                try {

                    while (true) {
                        veriGonder("Javadan Arduinoya \nVeri");
                    
                        Thread.sleep(5000);
                    }

                } catch (InterruptedException e) {
                    System.out.println("Hata : " + e.getMessage());
                }
            }
        };
        t.start();

        // main.close();
        //  System.out.println("Baglanti Kapali");
    }

    public static void veriGonder(String strVeri) {
        System.out.println("Arduino yu tekrar baglayin");

        System.out.println("Baglanti Basarili");
        try {
            String command = strVeri;
            char[] char_array = command.toCharArray();
            Thread.sleep(100); // veri göndermeden önce bu thread gerekiyor.
            for (int i = 0; i < char_array.length; i++) {
                output.write(char_array[i]);
            }
            System.out.println("Veri Gonderildi");
            Thread.sleep(100); // connection kapatmadan önce bu thread gerekiyor.
        } catch (IOException | InterruptedException ioe) {
            hata(ioe);
        }
    }

    public static void hata(Exception e) {
        System.err.println("Hata : " + e.getMessage());
        try {
            for (int i = 0; i < e.getStackTrace().length; i++) {
                System.err.println("Satir : " + e.getStackTrace()[i]);
            }

        } catch (Exception e2) {
        }
    }
}
