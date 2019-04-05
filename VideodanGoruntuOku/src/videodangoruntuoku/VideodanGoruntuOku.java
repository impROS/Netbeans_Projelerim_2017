package videodangoruntuoku;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class VideodanGoruntuOku {

    static int indexYuz = 0;

    public static void main(String[] args) {
        boolean yuzBulunduMu = false;
        String xml = "C:\\Users\\impROS\\Desktop\\cars.xml";
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier yuzTespit = new CascadeClassifier(xml);
        System.out.println("Resim Okundu");
        MatOfRect yuzler = new MatOfRect();
        VideoCapture videoCap = new VideoCapture();
        Mat tmpImg = new Mat();
        videoCap.open("E:\\oto1.mp4");
        int sayac = 0;
        if (videoCap.isOpened()) {
            while (videoCap.read(tmpImg)) {
                if (sayac % 8 == 0) {

                    System.out.println("Resim Okundu");
                    yuzTespit.detectMultiScale(tmpImg, yuzler);
                    yuzBulunduMu = false;
                    for (Rect rect : yuzler.toArray()) {
                        Imgproc.rectangle(tmpImg,
                                new Point(rect.x, rect.y), new Point(
                                        rect.x + rect.width, rect.y
                                        + rect.height),
                                new Scalar(0, 255, 0), 2);

                        yuzBulunduMu = true;
                    }

                    if (yuzBulunduMu) {
                        Imgcodecs.imwrite("C:\\OpenCvDeneme\\Otoyol_Araba_Tanima_Projesi\\taninan_oto\\" + (++indexYuz) + ".jpg", tmpImg);
                    }
                }
                sayac++;
            }
        } else {
            System.err.println("Hata.Video Dosyasi Acilamadi.");

        }
    }

    private static void Kirp(Mat tmpImg, Rect rect) {
        tmpImg = new Mat(tmpImg, rect);
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\Otoyol_Araba_Tanima_Projesi\\taninan_oto\\" + (++indexYuz) + ".jpg", tmpImg);
    }

}
