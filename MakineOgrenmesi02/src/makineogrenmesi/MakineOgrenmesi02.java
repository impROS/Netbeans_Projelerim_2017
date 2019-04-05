package makineogrenmesi;

import java.util.ArrayList;

public class MakineOgrenmesi02 {

    public static void main(String[] args) {
        ArrayList<String> arrKordinat = new ArrayList<>();

        arrKordinat.add("A,1,3");
        arrKordinat.add("B,2,3");
        arrKordinat.add("C,1,2");
        arrKordinat.add("D,2,2");
        arrKordinat.add("E,2,1");

        arrKordinat.add("F,4,4");
        arrKordinat.add("G,5,5");
        arrKordinat.add("H,6,4");
        arrKordinat.add("L,5,3");

        arrKordinat.add("K,4,1");
        arrKordinat.add("M,5,1");
        arrKordinat.add("N,6,1");

        for (int i = 0; i < arrKordinat.size(); i++) {
            ArrayList<String> arrKomsuKumeler = new ArrayList<>();
            arrKomsuKumeler.add(arrKordinat.get(i));
            arrKordinat.remove(i);
            i--;
            for (int j = 0; j < arrKordinat.size(); j++) {
                for (int k = 0; k < arrKomsuKumeler.size(); k++) {
                    double distance = distance(arrKomsuKumeler.get(k), arrKordinat.get(j));

                    if (distance < 2) {
                        System.out.println("Küme Eklendi : " + arrKordinat.get(j) + ", Yakin Olan : " + arrKomsuKumeler.get(k) + ",Distance : " + distance);
                        arrKomsuKumeler.add(arrKordinat.get(j));
                        arrKordinat.remove(j);
                        j--;
                        break;
                    } else {
                        System.out.println("Yakın Degil : " + arrKordinat.get(j) + ", Karsilastirilan : " + arrKomsuKumeler.get(k) + ",Distance : " + distance);
                    }
                }

            }

            System.out.println("Komsular : ");
            int sumX = 0;
            int sumY = 0;

            for (int j = 0; j < arrKomsuKumeler.size(); j++) {
                String strA = arrKomsuKumeler.get(j);
                int Ax = Integer.parseInt(strA.substring(strA.indexOf(",") + 1, strA.lastIndexOf(",")));
                int Ay = Integer.parseInt(strA.substring(strA.lastIndexOf(",") + 1, strA.length()));

                sumX += Ax;
                sumY += Ay;
                System.out.println(j + "." + arrKomsuKumeler.get(j));

            }
            System.out.println("Merkez ==> X : " + (sumX / arrKomsuKumeler.size()) + ", Y : " + (sumY / arrKomsuKumeler.size()));
            System.out.println("-----------------");
            System.out.print("Elemanlar : ");
            for (int h = 0; h < arrKordinat.size(); h++) {
                System.out.print(arrKordinat.get(h) + " : ");
            }
        }

        //distance(arrKordinat.get(0), arrKordinat.get(1));
    }

    public static double distance(String strA, String strB) {
        int Ax = Integer.parseInt(strA.substring(strA.indexOf(",") + 1, strA.lastIndexOf(",")));
        int Ay = Integer.parseInt(strA.substring(strA.lastIndexOf(",") + 1, strA.length()));

//        System.out.println("Ax : " + Ax);
//        System.out.println("Ay : " + Ay);
        int Bx = Integer.parseInt(strB.substring(strB.indexOf(",") + 1, strB.lastIndexOf(",")));
        int By = Integer.parseInt(strB.substring(strB.lastIndexOf(",") + 1, strB.length()));

//        System.out.println("Bx : " + Bx);
//        System.out.println("By : " + By);
        double distance = Math.sqrt(Math.pow(Ax - Bx, 2) + Math.pow(Ay - By, 2));
        // System.out.println("Distance : " + distance);
        return distance;

    }

}
