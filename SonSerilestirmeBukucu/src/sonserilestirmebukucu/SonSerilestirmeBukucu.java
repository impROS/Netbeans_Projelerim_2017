package sonserilestirmebukucu;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SonSerilestirmeBukucu {

    static String strFileName = "E:\\denemeSeri\\impROS.ros";
    static String strTmpFileName = "E:\\denemeSeri\\tmpimpROS.ros";

    public static void main(String[] args) {
        Random rnd = new Random();
        String strWords = "abcdefghijklmnoprstuvyz";
        String strTmpName = strWords.charAt(rnd.nextInt(strWords.length() - 1)) + "";
        Ogrenci o = new Ogrenci(strTmpName, "Soyad", 1);
       int[] arrTmp = {3,23,4};
        for (int i = 0; i < arrTmp.length; i++) {
           strTmpName.length();
        }
        writeOgrenci(o);
        readOgrenci();
    }

    public static void writeOgrenci(Ogrenci ogrenci) {
        File fileData = new File(strFileName);

        if (fileData.exists()) {
            ObjectOutputStream tmpOos = null;
            try {
                FileInputStream fis = new FileInputStream(strFileName);
                ObjectInputStream ois = new ObjectInputStream(fis);

                FileOutputStream tmpFos = new FileOutputStream(strTmpFileName);
                tmpOos = new ObjectOutputStream(tmpFos);

                while (true) {
                    Ogrenci tmpOgrenci = (Ogrenci) ois.readObject();
                    tmpOgrenci.toString();
                    tmpOos.writeObject(tmpOgrenci);
                }
            } catch (EOFException ex) {
                try {
                    tmpOos.writeObject(ogrenci);//Hersey tmpOos a yazildi.
                    //Simdi asil oos a yazacagiz
                    FileInputStream fis = new FileInputStream(strTmpFileName);
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    FileOutputStream fos = new FileOutputStream(strFileName);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    boolean a = true;
                    int sayac = 0;
                    while (a) {
                        sayac++;
                        try {
                            if (ois.available() >0) {
                                System.out.println("Null");
                            } else {
                                System.out.println("no Null");
                            }
                            Ogrenci tmpOgrenci = (Ogrenci) ois.readObject();

                            oos.writeObject(tmpOgrenci);
                        } catch (EOFException ex2) {
                            System.out.println("Sayac : " + sayac);
                            a = false;
                        } catch (ClassNotFoundException ex1) {

                        }
                    }

                } catch (IOException ex1) {
                    Logger.getLogger(SonSerilestirmeBukucu.class.getName()).log(Level.SEVERE, null, ex1);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(SonSerilestirmeBukucu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SonSerilestirmeBukucu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SonSerilestirmeBukucu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                FileOutputStream fos = new FileOutputStream(strFileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ogrenci);
            } catch (IOException ex) {
                Logger.getLogger(SonSerilestirmeBukucu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void readOgrenci() {
        try {
            FileInputStream fis = new FileInputStream(strFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Ogrenci tmpOgrenci = (Ogrenci) ois.readObject();
                tmpOgrenci.toString();

            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {

        }
    }
}
