package tiktak;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TikTak {

    static String[][] arrOyunDizisi;
    static boolean hamle = false;
    static boolean kazananVarMı = false;
    static boolean kazananVarMı2 = false;
    static ArrayList<String> arrKalanHamleler;
    static ArrayList<String> arrYedekHamleler = new ArrayList<>();
    static ArrayList<Integer> arrKazancDizisi = new ArrayList<>();
    static ArrayList<Integer> arrOynanHamleler = new ArrayList<>();

    static ArrayList<String> arrTumKazanclar = new ArrayList<>();
    static ArrayList<String> arrTumKayiplar = new ArrayList<>();
    static ArrayList<String> arrTumBeraberlikler = new ArrayList<>();
    static int hamleSayisi = 0;
    static int donguSayac = 0;

    public static void main(String[] args) {
        arrOyunDizisi = new String[3][3];
        // BilgisayarVSInsan();
        ikiKisilikOyna();
    }
    static int index = 0;

    public static void BilgisayarVSInsan() {
        Scanner giris = new Scanner(System.in);
        olasiHamleler();
        int satir, sutun;
//System.out.println(arrMatris.length);
        basla();
        yazdir();
        for (int i = 0; i < 9; i++) {
            kazananVarMı = kazananVarMı();
            if (!kazananVarMı) {

                System.out.println("Hamle Girin:");
                String koordinat = giris.nextLine();
                System.out.println(koordinat);
                satir = Integer.parseInt("" + koordinat.charAt(0));
                sutun = Integer.parseInt("" + koordinat.charAt(2));
                System.out.println(satir + "," + sutun);
                arrKalanHamleler.remove(arrKalanHamleler.indexOf(koordinat));

                ///
                //    diziGoster(arrKalanHamleler);
                oyna(!hamle, satir, sutun);

                yazdir();

                arrOynanHamleler.add(arrYedekHamleler.indexOf(koordinat));

                ArrayList<String> arrKalanTmp = new ArrayList<>(arrKalanHamleler);
                String[][] arrOyunDizisiTmp = diziKopyala(arrOyunDizisi);
                boolean hamleYedek = hamle;
                donguSayac = 0;
                boolean tmpKazananVarMı = kazananVarMı;
                //Kritik Nokta
                ArrayList<Integer> arrTmp = kazancDizisi();
                arrKalanHamleler = new ArrayList<>(arrKalanTmp);
                arrOyunDizisi = diziKopyala(arrOyunDizisiTmp);
                hamle = hamleYedek;
                kazananVarMı = tmpKazananVarMı;
                /*
                System.out.println("Dizi");
                for (Integer integer : arrTmp) {
                    System.out.print(integer);
                }
                 */
                //    System.out.println("");
                index++;
                int bilgisayarHamle = arrTmp.get(index);
                //  System.out.println("İndex:" + index);

                //System.out.println("Bilgisayar:" + bilgisayarHamle + "ArrKalan");
                System.out.println("");

                koordinat = arrYedekHamleler.get(bilgisayarHamle);
                System.out.println("Bilgisayar Hamle :" + koordinat);
                satir = Integer.parseInt("" + koordinat.charAt(0));
                sutun = Integer.parseInt("" + koordinat.charAt(2));
                System.out.println(satir + "," + sutun);

                // System.out.println("İNDEX :" + arrYedekHamleler.indexOf(koordinat));
                // arrKalanHamleler.remove(arrKalanHamleler.indexOf(koordinat));
                oyna(!hamle, satir, sutun);
                yazdir();
                hamleSayisi++;
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                } else {
                    kazanan = "x";
                }

                System.out.println("Oyun Bitti.Kazanan " + kazanan);
                return;
            }

        }
        System.out.println("Oyun Bitti.Oyun Berabere.");
    }

    /**
     *
     * @param arrTmp
     */
    public static void diziGoster(ArrayList<?> arrTmp) {
        System.out.print("Dizi Elemanlari");
        for (Object object : arrTmp) {
            System.out.print(object + " * ");
        }
        System.out.println("");
    }

    public static String[][] diziKopyala(String[][] arrTmp) {
        String[][] A2 = arrTmp.clone();
        for (int i = 0; i < A2.length; i++) {
            A2[i] = A2[i].clone();
        }
        return A2;
    }

    public static ArrayList<Integer> kazancDizisi() {
        int kazancVarMi = 0;
        String strKazanDizisi = "";
        donguSayac++;
        arrKazancDizisi = new ArrayList<>();
        ArrayList<Integer> arrOynananTmp = new ArrayList<>(arrOynanHamleler);
        ArrayList<String> arrKalanTmp = new ArrayList<>(arrKalanHamleler);
        Random rnd = new Random();
        basla();

        for (int i = 0; i < 9 - arrOynanHamleler.size(); i++) {
            //   System.out.println("ArrUzunluk =" + (9 - arrOynanHamleler.size()));
            kazananVarMı = kazananVarMı();
            if (!kazananVarMı) {
                String koordinat;
                int randomHamle;
                if (arrOynananTmp.size() > 0) {
                    //  System.out.println("Girildi : " + arrOynananTmp.size());

                    int oynananHamle = arrOynananTmp.get(0);

                    // System.out.println("oynanan:" + oynananHamle);
                    koordinat = arrYedekHamleler.get(oynananHamle);

                    arrKazancDizisi.add(arrYedekHamleler.indexOf(koordinat));
                    //  System.out.println("Koordinat = " + koordinat);
                    // diziGoster(arrKalanTmp);

                    // arrKalanTmp.remove(arrKalanTmp.indexOf(koordinat));
                    arrOynananTmp.remove(0);

                } else {
                    randomHamle = rnd.nextInt(arrKalanTmp.size());
                    koordinat = arrKalanTmp.get(randomHamle);
                    arrKazancDizisi.add(arrYedekHamleler.indexOf(koordinat));
                    arrKalanTmp.remove(randomHamle);
                }

                // System.out.println(koordinat);
                int satir = Integer.parseInt("" + koordinat.charAt(0));
                int sutun = Integer.parseInt("" + koordinat.charAt(2));
                oyna(!hamle, satir, sutun);
                //  yazdir();
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                    //System.out.println("Oyun Bitti.Kazanan " + kazanan);
                    // System.out.println("Tekrar Araniyor..");

                    strKazanDizisi = arrToString(arrKazancDizisi);
                    arrTumKayiplar.add(strKazanDizisi);
                    kazancVarMi = -1;
                    System.out.println("Kayıp");
                    //  return kazancDizisi();
                } else {
                    kazanan = "x";
                    // System.out.println("Oyun Bitti.Kazanan " + kazanan);

                    strKazanDizisi = arrToString(arrKazancDizisi);
                    arrTumKazanclar.add(strKazanDizisi);
                    kazancVarMi = 1;
                    System.out.println("Kazanc");

                    //   return arrKazancDizisi;
                }

            }
            // System.out.println("");
        }
        if (kazancVarMi == 0) {
            strKazanDizisi = arrToString(arrKazancDizisi);
            arrTumBeraberlikler.add(strKazanDizisi);
        }
        if (donguSayac < 300) {
            return kazancDizisi();
        } else {
            System.out.println("Girildi");
            int enKisaKazanan = enKisaUzunluguAl(arrTumKazanclar);
            int enKisaKaybeden = enKisaUzunluguAl(arrTumKayiplar);
            int enKisaBeraberlik = enKisaUzunluguAl(arrTumBeraberlikler);

            int enCokKazanan = enCokHamle(arrTumKazanclar, enKisaKazanan);
            int enCokKaybeden = enCokHamle(arrTumKayiplar, enKisaKaybeden);
            int enCokBeraberlik = enCokHamle(arrTumBeraberlikler, enKisaBeraberlik);
            System.out.println("En Kisa Kazanan" + enKisaKazanan);
            System.out.println("En Kisa Kaybeden" + enKisaKaybeden);
            System.out.println("En Kisa Beraberlik" + enKisaBeraberlik);

            //if (enKisaKaybeden < enKisaKazanan || enKisaKaybeden == hamleSayisi) {
            if (true) {

                //    System.out.println("Girildi enKisaKaybeden");
                //      System.out.println("EnCokKaybeden = " + enCokKaybeden);
                for (String string : arrTumKayiplar) {
                    if (string.length() <= enKisaKaybeden && Integer.parseInt(string.charAt(hamleSayisi + 1) + "") == enCokKaybeden) {
                        // System.out.println("Girildi enKisaKaybeden2");
                        arrKazancDizisi = new ArrayList<>();
                        for (char c : string.toCharArray()) {
                            arrKazancDizisi.add(Integer.parseInt(c + ""));

                            //     System.out.println("kazanc Dondu" + string);
                        }
                    }
                }
            } else if (enKisaKazanan <= enKisaKaybeden) {
                //   System.out.println("enCokKazanan = " + enCokKazanan);
                // System.out.println("Girildi enKisaKazanan");
                for (String string : arrTumKazanclar) {
                    if (string.length() <= enKisaKazanan && Integer.parseInt(string.charAt(hamleSayisi) + "") == enCokKazanan) {
                        //     System.out.println("Girildi enKisaKazanan2");
                        arrKazancDizisi = new ArrayList<>();
                        for (char c : string.toCharArray()) {
                            arrKazancDizisi.add(Integer.parseInt(c + ""));
                            System.out.println("Beraberlik Dondu" + string);
                        }
                    }
                }
            } else {
                //   System.out.println("Girildi enKisaBeraberlik");
                System.out.println("enKisaBeraberlik = " + enKisaBeraberlik);
                for (String string : arrTumBeraberlikler) {
                    if (string.length() <= enKisaBeraberlik && Integer.parseInt(string.charAt(hamleSayisi) + "") == enCokBeraberlik) {
                        //   System.out.println("Girildi enKisaBeraberlik2");
                        arrKazancDizisi = new ArrayList<>();
                        for (char c : string.toCharArray()) {
                            arrKazancDizisi.add(Integer.parseInt(c + ""));
                            diziGoster(arrKazancDizisi);
                            // System.out.println("Beraberlik Dondu" + string);
                        }
                    }
                }
            }

            return arrKazancDizisi;

            // return arrKazancDizisi;
        }
    }

    public static int enCokHamle(ArrayList<String> arrTmp, int enKisa) {
        int[] arrSayiYogunlugu = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (String string : arrTmp) {
            if (string.length() == enKisa) {
                if (Integer.parseInt(string.charAt(hamleSayisi) + "") == 1) {
                    int sayi = Integer.parseInt(string.charAt(hamleSayisi) + "");
                    arrSayiYogunlugu[sayi]++;
                }

            }
        }
        int enCok = arrSayiYogunlugu[0];
        int enCokIndexSayi = 0;
        for (int i = 0; i < arrSayiYogunlugu.length; i++) {
            if (arrSayiYogunlugu[i] > enCok) {
                enCok = arrSayiYogunlugu[i];
                enCokIndexSayi = i;
            }
        }
        return enCokIndexSayi;
    }

    public static int enKisaUzunluguAl(ArrayList<String> arrTmp) {
        if (arrTmp.size() < 0) {
            return 0;
        } else {
            int enKisa = arrTmp.get(0).length();
            for (String string : arrTmp) {
                if (string.length() < enKisa) {
                    enKisa = string.length();
                }
            }
            return enKisa;
        }

    }

    public static String arrToString(ArrayList<Integer> arrTmp) {
        String strTmp = "";
        for (Integer integer : arrTmp) {
            strTmp += integer;
        }
        return strTmp;
    }

    public static void bilgisayarBilgisayarOyna() {
        Random rnd = new Random();
        basla();
        olasiHamleler();
        for (int i = 0; i < 9; i++) {
            kazananVarMı = kazananVarMı();
            if (!kazananVarMı) {
                int randomHamle = rnd.nextInt(arrKalanHamleler.size());
                String koordinat = arrKalanHamleler.get(randomHamle);
                arrKalanHamleler.remove(randomHamle);

                System.out.println(koordinat);
                int satir = Integer.parseInt("" + koordinat.charAt(0));
                int sutun = Integer.parseInt("" + koordinat.charAt(2));
                oyna(!hamle, satir, sutun);
                yazdir();
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                } else {
                    kazanan = "x";
                }
                System.out.println("Oyun Bitti.Kazanan " + kazanan);
                return;
            }
            System.out.println("");
        }
        System.out.println("Oyun Bitti.Oyun Berabere.");
    }

    public static void ikiKisilikOyna() {

        Scanner giris = new Scanner(System.in);
//System.out.println(arrMatris.length);
        basla();
        yazdir();
        for (int i = 0; i < 9; i++) {
            kazananVarMı = kazananVarMı();
            if (!kazananVarMı) {
                System.out.println("Hamle Girin:");
                String koordinat = giris.nextLine();
                System.out.println(koordinat);
                int satir = Integer.parseInt("" + koordinat.charAt(0));
                int sutun = Integer.parseInt("" + koordinat.charAt(2));
                System.out.println(satir + "," + sutun);
                oyna(!hamle, satir, sutun);
                yazdir();
            } else {
                String kazanan;
                if (hamle) {
                    kazanan = "o";
                } else {
                    kazanan = "x";
                }
                System.out.println("Oyun Bitti.Kazanan " + kazanan);
                return;
            }

        }
        System.out.println("Oyun Bitti.Oyun Berabere.");
    }

    public static void olasiHamleler() {
        arrKalanHamleler = new ArrayList<>();
        arrYedekHamleler = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                String strHamle = i + " " + j;
                arrKalanHamleler.add(strHamle);
// System.out.println(strHamle);
            }
        }
        for (String strKlan : arrKalanHamleler) {
            arrYedekHamleler.add(strKlan);
        }
    }

    public static void yazdir() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrOyunDizisi[i][j]);
            }
            System.out.println("");
        }
    }

    public static void basla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrOyunDizisi[i][j] = "- ";
            }
        }
    }

    public static void oyna(boolean x, int i, int j) {
        if (arrOyunDizisi[i - 1][j - 1].equalsIgnoreCase("- ")) {
            if (x) {
                arrOyunDizisi[i - 1][j - 1] = "o ";
            } else {
                arrOyunDizisi[i - 1][j - 1] = "x ";
            }
            hamle = !hamle;
        } else {
            System.out.println("Buraya Hamle Yapamazsınız");
        }
    }

    public static boolean kazananVarMı() {
        String harf = arrOyunDizisi[1][1];
        if (!harf.equalsIgnoreCase("- ")) {
            if (arrOyunDizisi[1][0].equals(harf) && arrOyunDizisi[1][2].equals(harf)) {
                //  System.out.println("orta yatay");
                return true;
            } else if (arrOyunDizisi[2][0].equals(harf) && arrOyunDizisi[0][2].equals(harf)) {
                // System.out.println("sag ustten,sol alta capraz");
                return true;
            } else if (arrOyunDizisi[0][0].equals(harf) && arrOyunDizisi[2][2].equals(harf)) {
                // System.out.println("sol ustten,sag alta capraz");
                return true;
            } else if (arrOyunDizisi[0][1].equals(harf) && arrOyunDizisi[2][1].equals(harf)) {
                // System.out.println("orda dikey");
                return true;
            }
        }

        harf = arrOyunDizisi[0][0];
        if (!harf.equalsIgnoreCase("- ")) {
            if (arrOyunDizisi[0][1].equals(harf) && arrOyunDizisi[0][2].equals(harf)) {
                // System.out.println("ust yatay");
                return true;
            } else if (arrOyunDizisi[1][0].equals(harf) && arrOyunDizisi[2][0].equals(harf)) {
                // System.out.println("ust dikey");
                return true;
            }
        }

        harf = arrOyunDizisi[2][0];
        if (!harf.equalsIgnoreCase("- ")) {

            if (arrOyunDizisi[2][1].equals(harf) && arrOyunDizisi[2][2].equals(harf)) {
                //System.out.println("alt yatay");
                return true;
            }
        }

        harf = arrOyunDizisi[0][2];
        if (!harf.equalsIgnoreCase("- ")) {
            if (arrOyunDizisi[1][2].equals(harf) && arrOyunDizisi[2][2].equals(harf)) {
                // System.out.println("son dikey");
                return true;
            }
        }

        return false;
    }

}
