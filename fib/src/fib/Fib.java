/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fib;

/**
 *
 * @author impROS
 */
public class Fib {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int a =0;
    int b =1;
        for (int i = 0; i < 27; i++) {
            System.out.print(a+"  ");
            a=a+b;
            b=a-b;
        }
    }
    
}
