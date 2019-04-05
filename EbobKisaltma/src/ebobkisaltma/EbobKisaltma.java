package ebobkisaltma;

import java.util.ArrayList;
public class EbobKisaltma {

    public static void main(String[] args) {
        int sayi1 = 162;
        int sayi2 = 72;
        int enKucukSayi = sayi1 < sayi2 ? sayi1 : sayi2;
        ArrayList<Integer> arrBolenler = new ArrayList<>();

        for (int i = 2; i <= enKucukSayi; i++) {
            if (sayi1 % i == 0 && sayi2 % i == 0) {
                arrBolenler.add(i);
            }
        }
        System.out.println("Ebob(" + sayi1 + "," + sayi2 + ")=" + arrBolenler.get(arrBolenler.size() - 1));
        arrBolenler.contains(1);
    }
    
}
