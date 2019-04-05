
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author impROS
 */
public class NewClass {

    public static void main(String[] args) {
        HashSet<String> arrDeneme = new HashSet<String>();

//        arrDeneme.add("a");
//        arrDeneme.add("a");
//        arrDeneme.add("c");
//        arrDeneme.add("b");
// 
//        for (String string : arrDeneme) {
//            System.out.println(string);
//        }
////////////////
//        double sayi = 4.0;
//        NumberFormat nf = new DecimalFormat("#0.00");
//        System.out.println(nf.format(sayi));
        String str = "orta";
        String[] arrTmp = str.split(",");
        for (String string : arrTmp) {
            System.out.println("Veri : " + string);
        }
    }
}
