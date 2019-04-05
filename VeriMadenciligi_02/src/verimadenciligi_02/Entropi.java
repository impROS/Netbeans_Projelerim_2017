/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verimadenciligi_02;

public class Entropi {

    public static void main(String[] impROS) {
        // log2(sayi);;
        for (int i = 0; i < 10; i++) {
            continue;
        }
    }

    static double log2(double sayi) {
        System.out.println("Log 2 Tabanında " + sayi + " = " + (Math.log(sayi) / Math.log(2)));
        return Math.log(sayi) / Math.log(2);
    }

    static double entropi(double[] arrData) {
        double entropi = 0;
        for (int i = 0; i < arrData.length; i++) {
            entropi += arrData[i] * log2(arrData[i]);
            System.out.println("Entropi " + (i + 1) + " : " + (arrData[i] * log2(arrData[i])));
        }
        System.out.println("Sonuc : ");
        System.out.println("Entropi : " + -1 * entropi);;
        return -1 * entropi;
    }

}
