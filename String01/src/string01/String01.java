/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package string01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author impROS
 */
public class String01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("input : ");
        String strText = scn.nextLine();
        String[] arrLogic = strText.split(" ");
        System.out.println("Ayristirilan : ");
        for (String string : arrLogic) {
            System.out.print(" - "+string);
        }
        System.out.println("");
        if (arrLogic.length >= 3) {
            boolean sonuc;
            int sayac=0;
            for (int i = 0; i < arrLogic.length; i += 3) {
                boolean op1 = string2bool(arrLogic[sayac]);
                System.out.println("Op1 : " + op1);
                boolean op2 = string2bool(arrLogic[sayac + 2]);
                System.out.println("Op2 : " + op2);
                System.out.println("Op3 : "+arrLogic[sayac + 1]);
                sonuc = calcLogic(op1, op2, arrLogic[sayac + 1]);
                System.out.println("Sonuc : " + sonuc);
                sayac+=3;
            }
        }

    }

    public static boolean calcLogic(boolean p, boolean q, String strOp) {
        if (strOp.equalsIgnoreCase("and")) {
            return p && q;
        }
        System.exit(1);
        return false;
    }

    public static boolean string2bool(String strLogic) {
        if (strLogic.equalsIgnoreCase("true")) {
            return true;
        } else if (strLogic.equalsIgnoreCase("false")) {
            return false;
        }
        System.exit(1);
        return false;
    }
}
