package detector2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

public class Detector {

    public static void main(String arg[]) {
        System.loadLibrary("opencv_java320");

        // Anlıkolarakyakalanankameragörüntülerinigöstereceğimiz frame ve panel
        JFrame cameraFrame = new JFrame("Anlık kamera görüntüsü");
        cameraFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cameraFrame.setSize(640, 480);
        cameraFrame.setBounds(0, 0, cameraFrame.getWidth(), cameraFrame.getHeight());
        Panel panelCamera = new Panel();
        cameraFrame.setContentPane(panelCamera);
        cameraFrame.setVisible(true);

        // İşlenecekgörüntünün threshold uygulandıktan sonraki halini
        // göstereceğimiz frame ve panel
        JFrame thresholdFrame = new JFrame("Threshold görüntü");
        thresholdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thresholdFrame.setSize(640, 480);
        thresholdFrame.setBounds(0, 0, cameraFrame.getWidth(), cameraFrame.getHeight());
        Panel panelThreshold = new Panel();
        thresholdFrame.setContentPane(panelThreshold);
        thresholdFrame.setVisible(true);

        // Video akışıiçin, 0 ilevarsayılankamerayıbaşlatacağız
        VideoCapture capture = new VideoCapture(1);
        // Parametreleri atıyoruz
        /*capture.set(3, 1366);
		capture.set(4, 768);
		capture.set(15, -2);*/
        // Saf kameragörünrüsü
        Mat webcam_image = new Mat();
        // Hsv renk uzayında görüntüsü
        Mat hsv_image = new Mat();
        // 1. ve 2. threshold
        Mat thresholded = new Mat();
        Mat thresholded2 = new Mat();
        // Kameradan görüntü oku
        capture.read(webcam_image);
        // Kameradan alınan görüntüleri gösterecek olduğumuz frame boyutları
        // kameradan okunang örüntüye göre ayarlanıyor.

        cameraFrame.setSize(webcam_image.width() + 50, webcam_image.height() + 50);
        thresholdFrame.setSize(webcam_image.width() + 50, webcam_image.height() + 50);

        Mat array255 = new Mat(webcam_image.height(), webcam_image.width(), CvType.CV_8UC1);
        array255.setTo(new Scalar(255));
        Mat distance = new Mat(webcam_image.height(), webcam_image.width(), CvType.CV_8UC1);

        List<Mat> lhsv = new ArrayList<Mat>(3);
        Mat circles = new Mat();
        // Renktespitiburadabelirttiğimizminve max değerleregöreyapılacak
        // hsvuzayındaverdiğimizrenktonlarıarasındaki her renktespitedilecektir.
        // Renkaralıklarıiçinhsvrenktablolarınagözatabilirsiniz.

        Scalar minColor = new Scalar(101, 53, 196, 0);
        Scalar maxColor = new Scalar(101, 53, 196, 0);
        // Kamera aygıtı çalışıyor ise
        if (capture.isOpened()) {
            while (true) {
                capture.read(webcam_image);
                // Bir görüntü okunmuş ve boşdeğilse
                if (!webcam_image.empty()) {
                    // Kameradan okunan görüntü hsv renk uzayına dönüştürülür
                    Imgproc.cvtColor(webcam_image, hsv_image, Imgproc.COLOR_BGR2HSV);
                    Core.inRange(hsv_image, minColor, maxColor, thresholded);

                    // Erode ve dilate işlemi uygulanır yapısal element ölçüleri
                    // iki işlemdede aynıdır
                    Imgproc.erode(thresholded, thresholded,
                            Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(8, 8)));
                    Imgproc.dilate(thresholded, thresholded,
                            Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(8, 8)));
                    /*
					 * Split metodu
					 * ilegörüntüüzerindekihistogramlarıparçalıyoruz. Matrisin
					 * her boyutu ayrı ayrı nesnelere atanıyor.
                     */
                    Core.split(hsv_image, lhsv);
                    Mat S = lhsv.get(1);
                    Mat V = lhsv.get(2);
                    // dizilerarası element farklarıhesaplıyoruz
                    Core.subtract(array255, S, S);
                    Core.subtract(array255, V, V);
                    S.convertTo(S, CvType.CV_32F);
                    V.convertTo(V, CvType.CV_32F);
                    // 2 boyutluvektörlerimizinbüyüklüğünühesaplıyoruz
                    Core.magnitude(S, V, distance);
                    /*
					 * Verilendeğerlerarasında thresholding uyguluyor.
					 * pikselindeğeriverilendeğerlerarasındaise o
					 * piksel,beyazdeğilsesiyahyapılıyor.
                     */
                    Core.inRange(distance, new Scalar(0.0), new Scalar(200.0), thresholded2);
                    Core.bitwise_and(thresholded, thresholded2, thresholded);
                    // thresholded içingaussian blur filtresiuyguluyoruz
                    Imgproc.GaussianBlur(thresholded, thresholded, new Size(9, 9), 0, 0);
                    // Şeklindışhatları
                    List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
                    Imgproc.HoughCircles(thresholded, circles, Imgproc.CV_HOUGH_GRADIENT, 2, thresholded.height() / 8,
                            200, 100, 0, 0);
                    // thresholding sonrasınesnenin binary
                    // haliüzerindebağlınoktalarıtesiğediyoruz
                    Imgproc.findContours(thresholded, contours, thresholded2, Imgproc.RETR_LIST,
                            Imgproc.CHAIN_APPROX_SIMPLE);
                    // Nesneninkonumunaaşağıdakirenkileçiziyoruz
                    Imgproc.drawContours(webcam_image, contours, -2, new Scalar(10, 0, 0), 4);

                    /*
					 * Panellerüzerinegörünrüleriatayıp frame'lerin
					 * tekrardançizilmesinisağlıyoruz
                     */
                    panelCamera.setimagewithMat(webcam_image);
                    panelThreshold.setimagewithMat(thresholded);
                    cameraFrame.repaint();
                    thresholdFrame.repaint();

                } else {
                    JOptionPane.showMessageDialog(null, "Kamera aygıtına bağlanılamadı!");
                    break;
                }
            }
        }

    }

}
