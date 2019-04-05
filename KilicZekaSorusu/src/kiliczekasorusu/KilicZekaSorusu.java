package kiliczekasorusu;

import java.util.ArrayList;

public class KilicZekaSorusu {

    public static void main(String[] args) {
        ArrayList<Integer> arrMahkumlar = new ArrayList<>();

        int mahkumSayisi = 1_000;
        for (int i = 1; i <= mahkumSayisi; i++) {
            arrMahkumlar.add(i);
        }
        int kilicliMahkum = 0;

        while (arrMahkumlar.size() > 1) {
            int olumIndex = kilicliMahkum + 1;
            if (olumIndex == arrMahkumlar.size()) {
                olumIndex = 0;
                kilicliMahkum = -1;
            } else if (olumIndex > arrMahkumlar.size()) {
                olumIndex = 1;
                kilicliMahkum = 0;
            }
            arrMahkumlar.remove(olumIndex);
            kilicliMahkum++;
        }
        System.out.println("Hayatta Kalan Mahkum : " + arrMahkumlar.get(0));

    }

}
