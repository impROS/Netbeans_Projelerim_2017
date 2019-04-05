/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkaplantemizlemeyeni;

/**
 *
 * @author impROS
 */
import java.util.Arrays;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;

public class ArkaplanTemizlemeYeni {

    public static void main(String[] args) {
        double[] arrBeyaz = new double[3];
        arrBeyaz[0] = 255;
        arrBeyaz[1] = 255;
        arrBeyaz[2] = 255;

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat im1 = Imgcodecs.imread("C:\\OpenCvDeneme\\arkaplan_temizle\\s1.png");
        Mat im2 = Imgcodecs.imread("C:\\OpenCvDeneme\\arkaplan_temizle\\s2.png");
        Mat im3 = Imgcodecs.imread("C:\\OpenCvDeneme\\arkaplan_temizle\\s2.png");

//        Imgproc.cvtColor(im1, im1, Imgproc.COLOR_RGB2GRAY);
//        Imgproc.cvtColor(im2, im2, Imgproc.COLOR_RGB2GRAY);

        for (int i = 0; i < im1.rows(); i++) {
            for (int j = 0; j < im1.cols(); j++) {
                double[] arr1 = im1.get(i, j);
                double[] arr2 = im2.get(i, j);
                if (compImg(arr1, arr2)) {
                    im3.put(i, j, arrBeyaz);
                }
            }
        }
        Imgproc.blur(im2, im2, new Size(7, 7));
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\arkaplan_temizle\\fark.jpg", im3);
    }

    public static boolean compImg(double[] arr1, double[] arr2) {
        int threshold = 150;
        for (int i = 0; i < arr1.length; i++) {
            if ((arr1[i] > arr2[i] + threshold) || (arr1[i] < arr2[i] - threshold)) {
                return false;
            }
        }
        return true;
    }
}
