package asalfibo;

import java.util.ArrayList;

public class AsalFibonacci {

    public static void main(String[] args) {
        ArrayList<Integer> arrAsallar = asalSayilar(100);
        ArrayList<Integer> arrFibonacci = fibonachiSayilar(100);
        for (int i = 0; i < arrFibonacci.size(); i++) {
            if (arrAsallar.contains(arrFibonacci.get(i))) {
                System.out.println("Hem Asal,Hem Fibonacci : " + arrFibonacci.get(i));
            }
        }
    }

    public static ArrayList<Integer> fibonachiSayilar(int sayiSinir) {
        ArrayList<Integer> arrFibonacci = new ArrayList<>();
        int sayi = 1;
        int oncekiSayi = 1;
        int sonrakiSayi = sayi + oncekiSayi;
        while (sayi <= sayiSinir) {
            arrFibonacci.add(sayi);
            oncekiSayi = sayi;
            sayi = sonrakiSayi;
            sonrakiSayi = oncekiSayi + sayi;
        }
        return arrFibonacci;
    }

    public static ArrayList<Integer> asalSayilar(int sayiSinir) {
        boolean AsalMi = true;
        ArrayList<Integer> arrAsallar = new ArrayList<>();
        for (int i = 2; i <= sayiSinir; i++) {
            AsalMi = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    AsalMi = false;
                    break;
                }
            }
            if (AsalMi) {
                arrAsallar.add(i);
            }
        }
        return arrAsallar;
    }
}
