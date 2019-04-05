package personelkayit;

import java.util.Scanner;

public class PersonelKayitTest {

    public static void main(String[] args) {
        Scanner giris = new Scanner(System.in);
        int persay;
        Personel[] arrPersonel;

        System.out.println("Lutfen Personel Sayisini Giriniz");
        persay = giris.nextInt();

        arrPersonel = new Personel[persay];

        for (int i = 0; i < arrPersonel.length; i++) {
            Personel tmpPersonel = new Personel();

            System.out.println("Personel Adini Giriniz");
            String ad = giris.next();
            tmpPersonel.setAd(ad);

            System.out.println("Brut Maasi Giriniz");
            double brutMaas = giris.nextDouble();
            tmpPersonel.setBrutMaas(brutMaas);

            System.out.println("Kesinti Miktarini Girisniz");
            double kesintiMiktari = giris.nextDouble();
            tmpPersonel.setKesintiMiktari(kesintiMiktari);

            arrPersonel[i] = tmpPersonel;

        }
        for (int i = 0; i < arrPersonel.length; i++) {
            for (int j = 0; j < arrPersonel.length; j++) {
                if (arrPersonel[i].netMaasHesapla() > arrPersonel[j].netMaasHesapla()) {
                    Personel tmpPersonel = new Personel();
                    tmpPersonel = arrPersonel[i];
                    arrPersonel[i] = arrPersonel[j];
                    arrPersonel[j] = tmpPersonel;
                }
            }
        }
        /*
        for (int i = 0; i < arrPersonel.length; i++) {
            System.out.println(arrPersonel[i].getAd() + ", " + arrPersonel[i].netMaasHesapla());
        }
         */
        for (Personel personel : arrPersonel) {
            System.out.println(personel.getAd() + ", " + personel.netMaasHesapla());
        }
    }

}
