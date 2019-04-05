package opencv_gray;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class OpenCV_Gray {

    public static void main(String[] args) {
        //Gray  ==> 0.2989 * R + 0.5870 * G + 0.1140 * B

        int toplam = 0;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat im1 = new Mat();
        im1 = Imgcodecs.imread("C:\\OpenCvDeneme\\Ders_03\\3.jpg");
        int kanalSayisi = im1.channels();
        System.out.println("Kanal Sayisi : " + kanalSayisi);

        for (int i = 0; i < im1.rows(); i++) {
            for (int j = 0; j < im1.cols(); j++) {
                double[] arrRenkUzayi = im1.get(i, j);
//                arrRenkUzayi[0] = arrRenkUzayi[0] + 50;
//Gray 1
                 toplam = (int) (arrRenkUzayi[0] + arrRenkUzayi[1] + arrRenkUzayi[2]) / 3;
                 
                 //Gray 2
                //toplam = (int) (arrRenkUzayi[2] * 0.2989 + arrRenkUzayi[1] * 0.5870 + arrRenkUzayi[0] * 0.1140) ;
                arrRenkUzayi[0] = toplam;
                arrRenkUzayi[1] = toplam;
                arrRenkUzayi[2] = toplam;
                im1.put(i, j, arrRenkUzayi);

            }
        }
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\Ders_03\\3_outputGrayAyni.jpg", im1);
    }

}
