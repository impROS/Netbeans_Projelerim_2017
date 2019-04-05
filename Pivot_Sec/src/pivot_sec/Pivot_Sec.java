package pivot_sec;

import java.util.Arrays;

public class Pivot_Sec {

    public static void main(String[] args) {
        int[] arrTmp = {1, 23, 5};
        double oran = Math.random();
        int sayi = Integer.parseInt((oran + "").substring(2, 4));

        if (sayi >= 0 && sayi < 25) {
            System.out.println("Pivot Eleman : " + arrTmp[arrTmp.length - 1]);
        } else if (sayi >= 25 && sayi < 50) {
            System.out.println("Pivot Eleman : " + arrTmp[(arrTmp.length - 1) / 2]);
        } else if (sayi >= 50 && sayi < 100) {
            System.out.println("Pivot Eleman : " + arrTmp[0]);
        }
        oranlariGor();
    }

    public static void oranlariGor() {
        int[] oranlar = {0, 0, 0};
        for (int i = 0; i < 100; i++) {
            double oran = Math.random();
            int sayi = Integer.parseInt((oran + "").substring(2, 4));

            if (sayi >= 0 && sayi < 25) {
                oranlar[0]++;
            } else if (sayi >= 25 && sayi < 50) {
                oranlar[1]++;
            } else if (sayi >= 50 && sayi < 100) {
                oranlar[2]++;
            }

        }
        System.out.println(Arrays.toString(oranlar));
    }

}
