package eratostenelegi;

public class EratostenElegi {

    public static void main(String[] args) {
        int aralik = 100;
        int[] arrSayilar = new int[aralik];
        for (int i = 0; i < aralik; i++) {
            arrSayilar[i] = i;
        }
        arrSayilar[0] = 0;
        arrSayilar[1] = 0;
        int sinir = (int) Math.ceil(Math.sqrt(aralik));
        
        for (int i = 2; i <= sinir; i++) {
            int asalDegil = i * i;
            for (int j = asalDegil; j < aralik; j += i) {
                if (arrSayilar[j] != 0) {
                    System.out.println(arrSayilar[j] + " Asal Degil,isaretlendi.j=" + j);
                    arrSayilar[j] = 0;
                }
            }
        }

        for (int i = 0; i < arrSayilar.length; i++) {
            if (arrSayilar[i] != 0) {
                System.out.println("Asal : " + arrSayilar[i]);
            }
        }
    }

}
