/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yildiz;

/**
 *
 * @author impROS
 */
public class Yildiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 3; i > 0; i--) {
            
            for (int j = 3; j < i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
