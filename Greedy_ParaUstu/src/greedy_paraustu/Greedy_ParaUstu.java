package greedy_paraustu;

public class Greedy_ParaUstu {

//Para birimlerimizi kurus cinsinden tanimliyoruz
    static int[] arrParaBirimleri = {1, 5, 10, 25, 50, 100, 500};

    //Daha guzel gozuksun diye para birimleriyle ayni indexte Turkce karsiliklarini yaziyoruz
    static String[] arrParaTurkceKarsilik = {" 1 Kuruş", "5 Kuruş", "10 Kuruş", "25 Kuruş", "50 Kuruş", "1 TL", "5 Tl"};

    public static void main(String[] args) {
        paraUstu(365);//Kurus cinsinden parayi aliyoruz
    }

    public static void paraUstu(int paraUstu) {
        //En buyuk para biriminden en kucuk para birimine kadar dolas
        for (int i = arrParaBirimleri.length - 1; i >= 0; i--) {
            //i. Paradan kac tane verildigini saymak icin sayac tuttuk
            int sayac = 0;
            //Verecegimiz para,para ustunden buyuk oldugu surece calis
            while (paraUstu >= arrParaBirimleri[i]) {
                //her para ustu verdiginde sayaci bir artir
                sayac++;
                //Verilen parayi,para ustunden cikar
                paraUstu = paraUstu - arrParaBirimleri[i];
            }
            //eger para birimi kullanilmissa,kac tane kullanildigini ekrana yaz
            if (sayac > 0) {
                System.out.println(sayac + " Tane " + arrParaTurkceKarsilik[i]);
            }
        }
    }
}
