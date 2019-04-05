package multilayer_xor;

import java.util.ArrayList;

public class MultiLayer_XOR {

    static ArrayList<String> arrInput = new ArrayList<>();
    static ArrayList<Integer> arrOutput = new ArrayList<>();
    static double alfa, beta, sonuc, sonucA, sonucB;

    static double weightA1 = .5, weightA2 = .5, weightB1 = .5, weightB3 = .5;
    static double thresholdA = .5, thresholdB = .75, thresholdSon = .25;

    public static void main(String[] args) {
        arrInput.add("0.0");
        arrInput.add("0.1");
        arrInput.add("1.0");
        arrInput.add("1.1");

        arrOutput.add(0);
        arrOutput.add(1);
        arrOutput.add(1);
        arrOutput.add(0);

        karsilastir();
    }

    public static void karsilastir() {
        for (int i = 0; i < arrInput.size(); i++) {
            String strInput = arrInput.get(i) + "";
            int noktaIndex = strInput.indexOf(".");
            int a = Integer.parseInt(strInput.substring(0, noktaIndex));
            int b = Integer.parseInt(strInput.substring(noktaIndex + 1, strInput.length()));
            System.out.println("A : " + a);
            System.out.println("B : " + b);
            sonucA = ((a * weightA1) + (b * weightA1)) >= thresholdA ? 1 : 0;
            sonucB = ((b * weightB1) + (a * weightB1)) >= thresholdB ? 1 : 0;
            System.out.println("SonucA : " + sonucA);
            System.out.println("SonucB : " + sonucB);

            sonuc = ((sonucA * .5) + (sonucB * -.5)) >= .25 ? 1 : 0;
            if (arrOutput.get(i) == sonuc) {
                System.out.println("Input =" + a + "," + b + " ==> Beklenen : " + arrOutput.get(i) + " ==> Output : " + (int) sonuc + " True");
            } else {
                System.out.println("Input =" + a + "," + b + " ==> Beklenen : " + arrOutput.get(i) + " ==> Output : " + (int) sonuc + " False");
            }

            System.out.println("----------------");

        }
    }

}
