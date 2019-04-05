package sezarsifreleme;

import java.util.Arrays;
import java.util.Scanner;

public class SezarSifreleme {

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in,"windows-1254");
        int secim = -1, shift;
        String strText, strCipherText;
        String strHarfler = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ.";
        strHarfler = strHarfler.toLowerCase();
        //System.out.println("Uzunluk : " + strHarfler.length());
        String[] arrHarfler = toArray(strHarfler);
        // System.out.println(Arrays.toString(arrHarfler));

        while (secim != 0) {
            System.out.println("Lutfen bir secim yapiniz.\n0.Cikis.\n1.Sifrele\n2.Coz");
            secim = giris.nextInt();
            giris.reset();
            switch (secim) {
                case 0:
                    System.out.println("Program Kapatiliyor..");
                    System.exit(0);
                    break;
                case 1:
                    giris.nextLine();
                    System.out.println("Sifrelenecek Veriyi Giriniz : ");
                    strText = giris.nextLine();
                   
                    
                    System.out.println("Kaydirme Sayisini Giriniz : ");
                    shift = giris.nextInt();
                
                    strCipherText = sifrele(strText, shift, arrHarfler);
                    System.out.println("Sifrelenmis Veri : " + strCipherText);

                    break;
                case 2:
                    giris.nextLine();
                    System.out.println("Cozumlenecek Veriyi Giriniz : ");
                    strCipherText = giris.nextLine();
                

                    System.out.println("Kaydirme Sayisini Giriniz : ");
                    shift = giris.nextInt();
                    

                    strText = coz(strCipherText, shift, arrHarfler);
                    System.out.println("Cozulmus Veri : " + strText);
                    break;
            }

        }

    }

    static String coz(String strText, int shift, String[] arrAlfabe) {
        strText = strText.toLowerCase();
        String strCrypt = "";
        char harf;
        int index;
        for (int i = 0; i < strText.length(); i++) {
            harf = strText.charAt(i);
            index = findIndex(harf, arrAlfabe);
            if (index <= shift) {
                index += arrAlfabe.length;
            }
            index = (index - shift) % arrAlfabe.length;
            strCrypt += arrAlfabe[index];
        }
        return strCrypt;
    }

    static String sifrele(String strText, int shift, String[] arrAlfabe) {
        strText = strText.toLowerCase();
        String strCrypt = "";
        char harf;
        int index;
        for (int i = 0; i < strText.length(); i++) {
            harf = strText.charAt(i);
            index = findIndex(harf, arrAlfabe);
            index = (index + shift) % arrAlfabe.length;
            strCrypt += arrAlfabe[index];
        }
        return strCrypt;
    }

    static String[] toArray(String strTmp) {
        String[] arrHarfler = new String[strTmp.length()];
        for (int i = 0; i < strTmp.length(); i++) {
            arrHarfler[i] = strTmp.charAt(i) + "";
        }
        return arrHarfler;
    }

    static int findIndex(char harf, String[] strAlfabe) {
        String strHarf = harf + "";
        for (int i = 0; i < strAlfabe.length; i++) {
            if (strAlfabe[i].equals(strHarf)) {
                return i;
            }
        }
        return -1;
    }
}
