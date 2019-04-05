/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brainstorm;

import java.util.ArrayList;

/**
 *
 * @author impROS
 */
public class BrainStorm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> arrName = new ArrayList<String>();
        ArrayList<String> arrSuffix = new ArrayList<String>();
        arrName.add("munzur");
        arrName.add("cyber");
        arrName.add("siber");
       // arrName.add("security");
        //arrName.add("guvenlik");
        //arrName.add("bilisim");

        arrSuffix.add("com");
       // arrSuffix.add("org");
       // arrSuffix.add("net");
        String strDomain;
        for (int i = 0; i < arrSuffix.size(); i++) {
            for (int j = 0; j < arrName.size(); j++) {
                for (int k = 0; k < arrName.size(); k++) {
                    strDomain = "wwww." + arrName.get(j) + arrName.get(k) + "." + arrSuffix.get(i);
                    System.out.println(strDomain);
                }
            }
        }
    }

}
