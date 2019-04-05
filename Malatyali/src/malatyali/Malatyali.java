/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malatyali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author impROS
 */
public class Malatyali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> arrTmp = new ArrayList<Integer>();
        ArrayList<Integer> arrTmp2 = new ArrayList<>(arrTmp);

        arrTmp.add(1);
        arrTmp.add(3);
        arrTmp2.add(2);
        System.out.print("ArrTmp1");
        for (Integer integer : arrTmp) {
            System.out.print(integer + " -");
        }
        System.out.println("");
        System.out.print("ArrTmp2");
        for (Integer integer : arrTmp2) {
            System.out.print(integer + " -");
        }
        System.out.println("");
        String[][] A1 = new String[2][2];
        A1[0][0] = 1 + "";

        String[][] A2 = diziKopyala(A1);
        A2[0][0] = 2 + "";
        System.out.println("1.Dizi " + A1[0][0]);
        System.out.println("2.Dizi " + A2[0][0]);
    }

    public static String[][] diziKopyala(String[][] arrTmp) {
        String[][] A2 = arrTmp.clone();
        for (int i = 0; i < A2.length; i++) {
            A2[i] = A2[i].clone();
        }
        return A2;
    }

}
