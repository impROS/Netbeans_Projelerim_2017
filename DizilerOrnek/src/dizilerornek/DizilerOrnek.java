package dizilerornek;

import java.util.Random;
import java.util.Scanner;
import dizilerornek.Personel;
public class DizilerOrnek {

    static int yas = 1;

    public static void main(String[] args) {
        Personel p1;
        p1.
        /*
        /*
//DegiskenTuru [] arrDeneme =new  DegiskenTuru[boyut];

//DegiskenTuru = int,String,double,Personel,Ogrenci
//        int[] arrYas = new int[4];
//        String[][] arrIsım = new String[1][2];
//        Personel[] arrPersonel = new Personel[10];
//
//        strDeneme();
//
//        // .lenght ==> Dizi uzunlugu
//        int diziUzunluk = arrPersonel.length;
//        System.out.println("Dizi uzunluk : " + diziUzunluk);
        int[] arrOyuncu = new int[3];
        for (int i = 0; i < arrOyuncu.length; i++) {
            Scanner giris = new Scanner(System.in);
            System.out.println("Oyuncunun id sini giriniz");
            int id = giris.nextInt();
            arrOyuncu[i] = id;
        }
        //Dizideki elemanları gösterme
        for (int i = 0; i < arrOyuncu.length; i++) {
            System.out.println("Oyuncunun id si = " + arrOyuncu[i]);
        }
        
         */
 /*
        String[][] arrAdSoyad = new String[2][2];
        for (int i = 0; i < arrAdSoyad.length; i++) {
            for (int j = 0; j < arrAdSoyad.length; j++) {
                Scanner giris = new Scanner(System.in);

                System.out.println("Adi giriniz");
                String ad = giris.next();

                System.out.println("Soyadi giriniz");
                String soyad = giris.next();
                arrAdSoyad[i][j] = ad + " " + soyad;
            }
        }
        //İki boyutlu dizide veri okuma
//        for (int i = 0; i < arrAdSoyad.length; i++) {//satir
//            for (int j = 0; j < arrAdSoyad.length; j++) {//sutun
//                arrCarpim[i][j] = arr1[i][j] * arr2[i][j];
//            }
//        }
//0,0 - 0,1 - 1,0 - 1,1
         */
        int[][] arr1 = new int[2][2];
//        int[0][0] = 1;
//        int[0][1] = 1;
//        int[1][0] = 3;
//        int[1][1] = 3;

        arr1 = diziDoldur(arr1);
        diziGoster(arr1);

        int[][] arr2 = new int[2][2];
        arr2 = diziDoldur(arr2);
        diziGoster(arr2);

        int[][] arrCarpim = new int[2][2];
        for (int i = 0; i < arrCarpim.length; i++) {
            for (int j = 0; j < arrCarpim.length; j++) {
                arrCarpim[i][j] = arr1[i][j] * arr2[i][j];
            }
        }
        diziGoster(arrCarpim);
    }

    public static void diziGoster(int[][] arrTmp) {
        System.out.print("Dizi elemanlari =");
        for (int i = 0; i < arrTmp.length; i++) {
            for (int j = 0; j < arrTmp.length; j++) {
                System.out.print(arrTmp[i][j] + " - ");
            }
        }
        System.out.println("");
    }

    public static int[][] diziDoldur(int[][] arrTmp) {
        Random rnd = new Random();
        for (int i = 0; i < arrTmp.length; i++) {
            for (int j = 0; j < arrTmp.length; j++) {
                arrTmp[i][j] = rnd.nextInt(5);
            }

        }
        return arrTmp;
    }

    public static void strDeneme() {
        System.out.println("");
    }
}
