/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verimadenciligi_01;

/**
 *
 * @author impROS
 */
public class VeriMadenciligi_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // double[] arrData = {10, 40, 5, 50, 30, 70};
        double[] arrData = {20, 35, 40, 80, 10, 65, 50};
        double[] arrDataNormal = minMaxNormal(arrData);

        for (int i = 0; i < arrData.length; i++) {
            System.out.println("Veri : " + arrData[i] + ", Islenen Veri : " + arrDataNormal[i]);
        }

    }

    public static double[] minMaxNormal(double[] arrTmp) {
        double min = getMin(arrTmp);
        double max = getMax(arrTmp);
        double[] arrTmp2 = new double[arrTmp.length];
        //System.arraycopy(arrTmp, 0, arrTmp2, 0, arrTmp.length);
        for (int i = 0; i < arrTmp.length; i++) {
            arrTmp2[i] = (arrTmp[i] - min) / (max - min);
        }
        return arrTmp2;

    }

    public static double getMin(double[] arrTmp) {
        double min = arrTmp[0];
        for (int i = 1; i < arrTmp.length; i++) {
            if (arrTmp[i] < min) {
                min = arrTmp[i];
            }
        }
        System.out.println("Min : " + min);
        return min;
    }

    public static double getMax(double[] arrTmp) {
        double max = arrTmp[0];
        for (int i = 1; i < arrTmp.length; i++) {
            if (arrTmp[i] > max) {
                max = arrTmp[i];
            }
        }
        System.out.println("Max : " + max);
        return max;
    }

}
