

import java.util.Collection;
import java.util.Random;
import java.util.Set;

public class PropertiesFile {

    public static void a(){
        Data data = new Data("E:\\denemeSeri\\config.ros");

        Random rnd = new Random();
        String strWords = "abcdefghijklmnoprstuvyz";
        String strTmpName = strWords.charAt(rnd.nextInt(strWords.length() - 1)) + "";
        String strTmpSurname = strWords.charAt(rnd.nextInt(strWords.length() - 1)) + "";
        int age = rnd.nextInt(70);

      //  Kisi o = new Kisi(strTmpName, strTmpSurname, age);
     //   data.add(o.getInfo());

        data.listAll();
        /*
        System.out.println(data.get(1));
        Ogrenci tmpOgrenci = new Ogrenci();
        System.out.println(tmpOgrenci.getInfo());
        tmpOgrenci.putInfo(data.get( 1));
        System.out.println(tmpOgrenci.toString());
         */
    }
}
