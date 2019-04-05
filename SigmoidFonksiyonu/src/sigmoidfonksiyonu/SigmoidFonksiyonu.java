/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigmoidfonksiyonu;

import static java.lang.Math.exp;
import java.util.Scanner;

/**
 *
 * @author impROS
 */
public class SigmoidFonksiyonu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Sayi Giriniz");
        double sayi = scn.nextDouble();
        double sonuc = (Math.pow(Math.E, sayi)) / ((Math.pow(Math.E, sayi) + 1));
        System.out.println("Sonuc1 : " + sonuc);
        
        
        double temp = Math.exp(-sayi);
        sonuc = (1 - temp) / (1 + temp);
        System.out.println("Sonuc2 : " + sonuc);
        System.out.println("------------------------------------");
        main(null);
    }

}
