package renkuzayi;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class RenkUzayi {

    public static void main(String[] args) {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat kaynakGoruntu = new Mat();
            kaynakGoruntu = Imgcodecs.imread("C:\\OpenCvDeneme\\yuz0.jpg");
            Mat hedefGoruntu = new Mat();
            //Okunanan RGB görüntüyü HSB renk uzayına çevirerek hedefGoruntu mat nesnesine atar
            for (int i = 0; i < 100; i++) {
                try {
                    Imgproc.cvtColor(kaynakGoruntu, hedefGoruntu, i);
                    Imgcodecs.imwrite("C:\\OpenCvDeneme\\renkDonusumleri\\2kizkulesiHSV" + i + ".jpg", hedefGoruntu);
                } catch (Exception e) {
                }

            }

        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage() + " ," + e.getCause());
        }

    }

}
