
package javaapplication38;
import java.util.ArrayList;

public class javaapplication38 {

    static double alfa, threshold, delta, weight;
    static ArrayList<Integer> arrOutput;

    public static void main(String[] args) {

        alfa = 1;
        threshold = 5;
        weight = 1;

        ArrayList<String> arrInput = new ArrayList<>();
        arrInput.add("0.0");
        arrInput.add("0.1");
        arrInput.add("1.0");
        arrInput.add("1.1");

        arrOutput = new ArrayList<>();
        arrOutput.add(0);
        arrOutput.add(0);
        arrOutput.add(0);
        arrOutput.add(1);
        double lastWeight = output(arrInput);
        System.out.println("Son Weight : " + lastWeight);
    }

    public static double output(ArrayList arrInput) {
        String strTmp = "";
        for (int i = 0; i < arrInput.size(); i++) {
            String strInput = arrInput.get(i) + "";
            int noktaIndex = strInput.indexOf(".");
            //System.out.println("Nokta Index:" + noktaIndex);

            strTmp = strInput.substring(0, noktaIndex);
            int a = Integer.parseInt(strTmp);
            System.out.println("a : " + a);

            strTmp = strInput.substring(noktaIndex + 1, strInput.length());
            int b = Integer.parseInt(strTmp);
            System.out.println("b : " + b);

            double sonuc = (a * weight) + (b * weight) * alfa;
            int output;
            if (sonuc < threshold) {
                output = 0;
            } else {
                output = 1;
            }

            if (output != arrOutput.get(i)) {
                System.out.println("Cikti : " + output + ",Beklenen" + arrOutput.get(i) + " = FALSE");
                weight += (arrOutput.get(i) - output) * alfa;
                System.out.println("Agirlik Guncellendi: " + weight);
                return output(arrInput);
            } else {
                System.out.println("Cikti : " + output + ",Beklenen : " + arrOutput.get(i) + " = TRUE");
            }
        }
        return weight;
    }

}
