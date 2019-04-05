/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication108;

/**
 *
 * @author impROS
 */
public class JavaApplication108 {

    /**
     * @param args the command line arguments
     */
    static double[] data1 = {1.2, 2.3, 3.4, 5.1, 7.8};
    static double[] data2 = {5.3, 7.9, 2.1, 6.4, 9.2};

    public static void main(String[] args) {
        sumArray();
    }

    public static double[] sumArray() {
        double[] data3 = new double[data1.length];
        for (int i = 0; i < data1.length; i++) {
            data3[i] = data1[i] + data2[i];
            System.out.println("Toplanan Data : "+data3[i]);
        }
        return data3;
    }

}
