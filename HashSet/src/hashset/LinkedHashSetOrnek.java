package hashset;

import java.util.LinkedHashSet;

public class LinkedHashSetOrnek {

    public static void main(String[] args) {
        LinkedHashSet<String> kume = new LinkedHashSet<String>();
        kume.add("Ridvan");
        kume.add("Orhan");
        kume.add("Seyhmus");

        System.out.println("Küme Elemanlari : ");
        for (String string : kume) {
            System.out.println(string);
        }

    }

}
