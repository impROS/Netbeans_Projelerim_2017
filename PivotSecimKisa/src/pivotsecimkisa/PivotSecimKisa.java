package pivotsecimkisa;

import java.util.Random;
import java.util.Scanner;

public class PivotSecimKisa {

    public static void main(String[] args) {
        int ilk = 0;
        int son = 0;
        int orta = 0;
        int[] arrDizi = {234, 234, 2, 342, 342, 34, 234, 3};
        for (int i = 0; i < 100; i++) {
            Random rnd = new Random();

            int pivot;
            int randomSayi = rnd.nextInt(100);
            //System.out.println(randomSayi);

            if (randomSayi < 50) {
                pivot = arrDizi[0];
                ilk++;
            } else if (randomSayi >= 50 && randomSayi < 75) {
                pivot = arrDizi[arrDizi.length - 1];
                son++;
            } else if (randomSayi >= 75 && randomSayi < 100) {
                pivot = arrDizi[arrDizi.length / 2];
                orta++;

            }
        }
        System.out.println("İlk : " + ilk);
        System.out.println("Son : " + son);
        System.out.println("Orta :" + orta);
    }

}
