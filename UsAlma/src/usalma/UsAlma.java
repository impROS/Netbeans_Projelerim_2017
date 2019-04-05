package usalma;

import java.util.Scanner;

public class BasamakUsAlma {

    public static void main(String[] args) {
        try {
            int sayi;
            System.out.print("Sayıyı giriniz : ");
            Scanner scn = new Scanner(System.in);
            sayi = scn.nextInt();
            System.out.println("Sonuç : " + hesapla(sayi, 1));
        } catch (Exception ex) {
            System.out.println("Yanlış işlem yaptınız!");
            main(null);
        }
    }

    public static int hesapla(int sayi, int basIndex) {
        if (sayi <= 0) {
            return 0;
        } else {
            return us(sayi % 10, basIndex++) + hesapla(sayi / 10, basIndex);
        }
    }

    public static int us(int taban, int us) {
        if (us >= 1) {
            return taban * us(taban, us - 1);
        }
        return 1;
    }

}
