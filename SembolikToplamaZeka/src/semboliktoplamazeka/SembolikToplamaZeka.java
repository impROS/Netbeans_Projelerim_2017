package semboliktoplamazeka;

import java.util.HashMap;
import java.util.Scanner;

public class SembolikToplamaZeka {

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        HashMap<String, Double> arrVeriler = new HashMap<>();
        String strVeri = "";

        strVeri = giris.next();

        while (!strVeri.equalsIgnoreCase("0")) {
            //2xMuz=30;
            // 2xKivi=20;
            //2xElma=8;
            //Muz+Elma+Kivi=?;

            int carpmaIndex = strVeri.indexOf("x");
            int esitIndex = strVeri.indexOf("=");

            double adet = Integer.parseInt(strVeri.substring(0, carpmaIndex));
            String veri = strVeri.substring(carpmaIndex + 1, esitIndex);
            double sonuc = Integer.parseInt(strVeri.substring(esitIndex + 1, strVeri.length()));

            double deger = sonuc / adet;
            System.out.println("Girdi : " + strVeri + ", Adet : " + adet + ", Veri : " + veri + ", Value : " + deger);
            arrVeriler.put(veri, deger);
            strVeri = giris.next();

        }

        System.out.println("Hesaplanacak Verileri giriniz");
        strVeri = "Muz+Elma+Kivi=?"; //giris.next();
        int esitIndex = strVeri.indexOf("=");
        strVeri = strVeri.substring(0, esitIndex);
        System.out.println("strVeri : " + strVeri);

        strVeri = strVeri.replace("+", "Toplam");
        String[] arrSoru = strVeri.split("Toplam");
        double cevap = 0;
        for (String string : arrSoru) {
            System.out.println(string + " :" + arrVeriler.get(string));
            cevap += arrVeriler.get(string);
        }
        System.out.println("Cevap : " + cevap);

    }

}
