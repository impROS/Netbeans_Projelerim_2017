package haritaboya;

import java.util.ArrayList;
import java.util.Objects;

public class HaritaBoya {

    static ArrayList<Integer> arrRenkler = new ArrayList<Integer>();
    static ArrayList<Integer> arrSehirler = new ArrayList<Integer>();
    static ArrayList<String> arrKomsuluk = new ArrayList<String>();
    static ArrayList<String> arrEslesme = new ArrayList<String>();

    static ArrayList<String> arrRenkAdleri = new ArrayList<String>();
    static ArrayList<String> arrSehirAdlari = new ArrayList<String>();

    public static void main(String[] args) {
        sehirAdiDoldur();
        renkAdiDoldur();

        int renkSinir = 5;

        for (int i = 1; i <= renkSinir; i++) {
            arrRenkler.add(i);
        }
        int sehirSinir = 6;
        for (int i = 1; i <= sehirSinir; i++) {
            arrSehirler.add(i);
        }
        arrKomsuluk.add("1.2");
        arrKomsuluk.add("1.3");
        arrKomsuluk.add("1.4");
        arrKomsuluk.add("2.3");
        arrKomsuluk.add("2.5");
        arrKomsuluk.add("3.5");
        arrKomsuluk.add("4.5");
        arrKomsuluk.add("4.6");
     
     


        System.out.println("");
        for (int i = 1; i <= arrSehirler.size(); i++) {
            ArrayList<Integer> arrKomsular = komsulariGetir(i);
            diziGoster(arrKomsular, i + " nin Komsuları : ");
        }

        while (arrSehirler.size() > 0) {
            int sehir = arrSehirler.get(0);
            ArrayList<Integer> arrKomsular = komsulariGetir(sehir);
            int renk = arrRenkler.get(0);
            arrEslesme.add(sehir + "." + renk);

            System.out.println("Eslesme = Sehir: " + sehir + ", Renk : " + renk);
            arrSehirler.remove(0);
            int sehirBoyut = arrSehirler.size();
            for (int i = 0; i < sehirBoyut; i++) {
                boolean komsuMu = false;
                for (int j = 0; j < arrKomsular.size(); j++) {
                    System.out.println("Karsilastirilan : " + arrSehirler.get(i) + "," + arrKomsular.get(j));
                    if (Objects.equals(arrSehirler.get(i), arrKomsular.get(j))) {
                        komsuMu = true;
                        System.out.println("Komsusu var,Atlaniyor..");
                        break;
                    }

                }

                if (!komsuMu) {
                    System.out.println("İc Eslesme = Sehir: " + arrSehirler.get(i) + ", Renk : " + renk);
                    arrEslesme.add(arrSehirler.get(i) + "." + renk);
                    ArrayList<Integer> arrKomsularTmp = komsulariGetir(arrSehirler.get(i));
                    arrSehirler.remove(i);
                    sehirBoyut--;
                    i--;
                    for (Integer integer : arrKomsularTmp) {
                        arrKomsular.add(integer);
                    }
                }

            }

            arrRenkler.remove(0);
            System.out.println("---------------");
        }
        
        diziGoster(arrEslesme, "Cozum : ");
        
        System.out.println("Sembolik Cozum :");
        for (int i = 0; i < arrEslesme.size(); i++) {
            int noktaIndex = arrEslesme.get(i).indexOf(".");
            int sehirIndex = Integer.parseInt(arrEslesme.get(i).substring(0, noktaIndex));
            int renkIndex = Integer.parseInt(arrEslesme.get(i).substring(noktaIndex+1, arrEslesme.get(i).length()));
           // System.out.println("SehirIndex: " + --sehirIndex + ",renkIndex: " + --renkIndex);
            System.out.println(arrSehirAdlari.get(--sehirIndex) + " - " + arrRenkAdleri.get(--renkIndex));
        }
    }

    public static void diziGoster(ArrayList<?> arrTmp, String strDiziBasligi) {
        System.out.print(strDiziBasligi);
        for (Object object : arrTmp) {
            System.out.print(object + "  ");
        }
        System.out.println("");
    }

    public static ArrayList<Integer> komsulariGetir(int sehir) {
        ArrayList<Integer> arrKomsularTmp = new ArrayList<Integer>();
        for (String komsu : arrKomsuluk) {
            int noktaIndex = komsu.indexOf(".");

            int sehir1 = Integer.parseInt(komsu.substring(0, noktaIndex));
            int sehir2 = Integer.parseInt(komsu.substring(noktaIndex + 1, komsu.length()));

            if (sehir1 == sehir) {
                arrKomsularTmp.add(sehir2);
            } else if (sehir2 == sehir) {
                arrKomsularTmp.add(sehir1);
            }
        }
        return arrKomsularTmp;
    }

    public static void sehirAdiDoldur() {
        arrSehirAdlari.add("Adana");
        arrSehirAdlari.add("Tunceli");
        arrSehirAdlari.add("Mardin");
        arrSehirAdlari.add("İstanbul");
        arrSehirAdlari.add("Mersin");
        arrSehirAdlari.add("Konya");
        arrSehirAdlari.add("Izmir");
        arrSehirAdlari.add("Isparta");
        arrSehirAdlari.add("Kocaeli");
        arrSehirAdlari.add("Antalya");
    }

    public static void renkAdiDoldur() {
        arrRenkAdleri.add("Mavi");
        arrRenkAdleri.add("Kırmızı");
        arrRenkAdleri.add("Sarı");
        arrRenkAdleri.add("Yesil");
        arrRenkAdleri.add("Beyaz");
        arrRenkAdleri.add("Mor");
        arrRenkAdleri.add("Kahverengi");
        arrRenkAdleri.add("Gri");

    }
}
