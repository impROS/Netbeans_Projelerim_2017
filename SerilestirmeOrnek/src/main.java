
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author impROS
 */
public class main {

    public static String strDataAdres = "E:\\denemeSeri\\impROS.ros";

    public static void main(String[] impROS) throws FileNotFoundException {
        Scanner giris = new Scanner(System.in);
        int secim = 0;
        while (secim != 0) {
            System.out.println("0.Cikis\n1.Kayit Ekle\n2.Kayit Oku");
            secim = giris.nextInt();
            switch (secim) {
                case 0:
                    System.exit(0);
                    break;

                case 1:
                    break;

                case 2:
                    break;
            }
        }
        Ogrenci o2 = new Ogrenci("cssc", "saa", 221);
        writeOgrenci(o2);
        readOgrenci(strDataAdres);

    }

    public static void hazirla() {

    }

    public static void writeOgrenci(Ogrenci o1) {
        ObjectOutputStream oos = null;
        try {
//eskileri yerine yaz

            FileInputStream fis = new FileInputStream(strDataAdres);
            ObjectInputStream ois = new ObjectInputStream(fis);
            FileOutputStream tmpFos = new FileOutputStream("E:\\denemeSeri\\tmpimpROS.ros");
            ObjectOutputStream tmpOos = new ObjectOutputStream(tmpFos);
            while (true) {

                Ogrenci tmpOgrenci = (Ogrenci) ois.readObject();
                tmpOos.writeObject(tmpOgrenci);
            }
        } catch (EOFException eof) {
            System.err.println("Bitti : " + eof.getMessage());

        } catch (IOException ex) {
            System.err.println("Hata : " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.err.println("Hata : " + ex.getMessage());
        } finally {
            try {
                FileInputStream tmpFis = new FileInputStream("E:\\denemeSeri\\tmpimpROS.ros");
                ObjectInputStream tmpOis = new ObjectInputStream(tmpFis);
                FileOutputStream fos = new FileOutputStream(strDataAdres);
                oos = new ObjectOutputStream(fos);
                while (true) {
                    Ogrenci tmpOgrenci1 = (Ogrenci) tmpOis.readObject();
                    oos.writeObject(tmpOgrenci1);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void readOgrenci(String strFile) {
        try {
            FileInputStream fis = new FileInputStream(strFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {

                Ogrenci tmpOgrenci = (Ogrenci) ois.readObject();
                System.out.println(tmpOgrenci.toString());
            }

        } catch (EOFException eof) {
            System.err.println("Bitti : " + eof.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("Hata : " + ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Hata : " + ex.getMessage());
        }

    }
}
