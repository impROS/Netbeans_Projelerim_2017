package deneme;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Deneme {

    public static void main(String[] args) {
        String str = "2.15";
        float f = Float.parseFloat(str);
        System.out.println(f);
        /*
        System.loadLibrary("opencv_java320");
        Mat im1 = Imgcodecs.imread("C:\\OpenCvDeneme\\3.jpg");
        Mat im2 = Imgcodecs.imread("C:\\OpenCvDeneme\\7.jpg");

        double[] arr1 = im1.get(5, 5);
        double[] arr2 = im2.get(5, 5);

        System.out.println(arr1.length);
        diziYaz(arr1);
        System.out.println(arr2.length);
        diziYaz(arr2);
         */
    }

    public static void diziYaz(double[] arrTmp) {
        for (double d : arrTmp) {
            System.out.println("Eleman : " + d);
        }
        System.out.println("-------------------------");
    }
}
