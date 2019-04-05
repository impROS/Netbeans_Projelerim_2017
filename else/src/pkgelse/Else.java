/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgelse;

/**
 *
 * @author impROS
 */
public class Else {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1 den mi buyuk,2 den mi buyuk 3 ten mi buyuk
        int a = 1;
        if (a > 10) {
            System.out.println("Sayi 10 den buyuk");
        } else if (a > 5) {
            System.out.println("Sayi 5 den buyuk");
        } else if (a > 1) {
            System.out.println("Sayi 1 den buyuk");
        } else {
            System.out.println("Sayi araligi bulunmadi ");
        }
        switch (a) {
            case 1 :    System.out.println("Sayi 10");break;
            case 2 :    System.out.println("Sayi 5 den buyuk");
            case 3 :    System.out.println("Sayi 1 den buyuk");
        }
    }

}
