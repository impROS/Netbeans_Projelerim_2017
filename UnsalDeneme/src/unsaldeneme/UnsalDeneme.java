/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsaldeneme;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

public class UnsalDeneme {

    public static void main(String[] args) {
        String strPath = "deneme.txt";

        try {
            int index = 0;
            String[] arrVeriler = new String[5];
            File file = new File(strPath);
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String strTmp = "";
            while (strTmp != null) {
                strTmp = bf.readLine();
                arrVeriler = strTmp.split(",");
                System.out.println("Okunan : " + strTmp);

                String strAd = arrVeriler[0];
                String strSoyad = arrVeriler[1];
                String strNick = arrVeriler[2];
                String strYas = arrVeriler[3];
                String strId = arrVeriler[4];
                
                System.out.println("strAd : "+strAd);
                System.out.println("strSoyad : "+strSoyad);
                System.out.println("strNick: "+strNick);
                System.out.println("strYas: "+strYas);
                System.out.println("strID: "+strId);
                System.out.println("---------------");
            }
        } catch (Exception ex) {
            System.err.println("Hata : " + ex.getCause());
        }

    }
}
