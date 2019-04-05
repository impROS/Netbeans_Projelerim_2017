/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siralama;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author impROS
 */
public class Siralama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ogrenci o1 = new Ogrenci();
        o1.yas = 33;

        Ogrenci o2 = new Ogrenci();
        o2.yas = 44;

        Ogrenci o3 = new Ogrenci();
        o3.yas = 444;

        ArrayList<Ogrenci> arrOgrenci = new ArrayList<>();
        arrOgrenci.add(o1);
        arrOgrenci.add(o2);
        arrOgrenci.add(o3);

        for (int i = 0; i < arrOgrenci.size(); i++) {
            
            System.out.println(arrOgrenci.get(i).yas);
        }
    }
}
