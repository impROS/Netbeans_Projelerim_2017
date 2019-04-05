package goruntukopyalama;

import java.util.ArrayList;
import java.util.Random;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class GoruntuKopyalama {

    public static void main(String[] args) {
        for (int rr = 0; rr < 1; rr++) {
            ArrayList arrSatir = new ArrayList();
            ArrayList arrSutun = new ArrayList();

            Random rnd = new Random();
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat arrImage = new Mat();
            VideoCapture videoDevice = new VideoCapture();
            videoDevice.open(0);
            if (videoDevice.isOpened()) {
                videoDevice.read(arrImage);
                videoDevice.release();
            } else {
                System.out.println("Video aygitina baglanilamadi");
            }
            Mat arrHedefImage = new Mat();
            arrHedefImage.create(arrImage.rows(), arrImage.cols(), CvType.CV_8UC1);
            int r = 0;
            int g = 0;
            int b = 0;
            int index = 50;

            arrSatir.add(0);

            arrSatir.add(arrImage.rows() - 1);

//            System.out.println("Row : " + arrHedefImage.rows());
//            System.out.println("Cols: " + arrHedefImage.cols());
            for (int i = 0; i < arrHedefImage.rows(); i++) {
                for (int j = 0; j < arrHedefImage.cols(); j++) {

                    //System.out.println("Yeni Double Dizisi : ");
                    //   System.out.println("Uzunluk : " + tmpImage.length);
                    // System.out.println(rnd.nextInt(255));
                    double[] tmpImage = arrImage.get(i, j);
                    if (j == 0 || j == arrImage.cols() - 1 || arrSatir.contains(i)) {

                        tmpImage[0] = 0;
                        tmpImage[1] = 0;
                        tmpImage[2] = 0;

                    } else {
                        tmpImage[0] = 255;
                        tmpImage[1] = 255;
                        tmpImage[2] = 255;
                    }

                    arrHedefImage.put(i, j, tmpImage);

                }
            }
            for (int i = 0; i < arrHedefImage.cols(); i += 29) {
                Imgproc.arrowedLine(arrHedefImage, new Point(i, i), new Point(i + 20, i + 20), new Scalar(0, 0, 0));
                Imgproc.arrowedLine(arrHedefImage, new Point(i + 20, i + 20), new Point(i, i), new Scalar(0, 0, 0));
                Imgproc.circle(arrHedefImage, new Point(i + 24.4, i + 24.4), 6, new Scalar(10, 50, 70));
                Imgproc.putText(arrHedefImage, "1", new Point(i + 22, i + 26), 1, 0.5, new Scalar(0, 0, 0));
            }
            for (int i = arrHedefImage.cols(); i < 0; i -= 50) {
                Imgproc.arrowedLine(arrHedefImage, new Point(i, i), new Point(i - 20, i - 20), new Scalar(0, 0, 0));
            }
            Imgcodecs.imwrite("C:\\OpenCvDeneme\\goruntu\\denemexxx" + rr + ".jpg", arrHedefImage);
            
            System.out.println(
                    "Dosya Yazildi");
        }
        Kirp();

    }

    public static void Kirp() {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat goruntuDizisi = new Mat();
        goruntuDizisi = Imgcodecs.imread("C:\\OpenCvDeneme\\papatya_color_change.png");
        //Dikdörtgen olluşturuyoruz ve koordinatlarını belirliyoruz
        Rect dikdortgen = new Rect(new Point(10, 100), new Point(100, 200));
        //Yeni bir mat nesnesi oluşturuyoruz ve okunan görüntüye dikdörtgen ebatlarında kırpma işlemi uyguluyoruz
        Mat yeniGoruntu = new Mat(goruntuDizisi, dikdortgen);
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\papatya_color_chang3333e.png", yeniGoruntu);

    }

}
