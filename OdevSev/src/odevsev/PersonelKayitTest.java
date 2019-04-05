package odevsev;

import java.util.Arrays;
import java.util.Scanner;

public class PersonelKayitTest {

    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);
        final int maksMevcut = 40;
        int mevcut;
        Personel dizi[];
        System.out.println("Personel sayısını giriniz:");
        do {
            mevcut = klavye.nextInt();

            if (mevcut < 1 || mevcut > 40) {
                System.out.println("Yanlış mevcut,yeniden deneyiniz:");
            }
        } while (mevcut < 1 || mevcut > 40);
        dizi = new Personel[mevcut];
        for (int i = 0; i < mevcut; i++) {
            Personel tmpPersonel = new Personel();
            tmpPersonel.bilgiOku();
            tmpPersonel.bilgiYaz();
            dizi[i] = tmpPersonel;

        }
        Personel temp;

        System.out.println("----------");
        int[] maas = new int[dizi.length];
        for (int i = 0; i < dizi.length; i++) {
            dizi[i].bilgiYaz();
            maas[i]=dizi[i].
        }
        System.out.println("----------");
        for (int i = 1; i > dizi.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (dizi[j].getMaasHesapla() > dizi[j - 1].getMaasHesapla()) {
                    Personel tmp = dizi[j];
                    dizi[j] = dizi[j - 1];
                    dizi[j - 1] = tmp;
                }
            }

        }
        //artik dizi maas sirasina gore siralandi.Bunlari ekrana yazsin
        Arrays.sort(dizi);
    }
}
