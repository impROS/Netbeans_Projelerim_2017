package arkaplantemizleme;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ArkaplanTemizleme {

    public static void main(String[] args) {
//        for (int i = 0; i < 200; i++) {
//            try {
//                threshold(i);
//                System.out.println("Threshold uygulandi : " + i);
//            } catch (Exception e) {
//                System.out.println("");
//            }
//        }
arkaplanTemizle();
    }

    public static void arkaplanTemizle() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        threshold(0);
        Mat kaynakMatris = Imgcodecs.imread("C:\\OpenCvDeneme\\goruntu_karsilastir\\at1.jpg");
        Mat kaynakMatrisGray = new Mat();
// Rgb renk uzayından gri renk uzayına çevirme  
        Imgproc.cvtColor(kaynakMatris, kaynakMatrisGray, Imgproc.COLOR_RGB2BGR);

        Mat hedefMatris = Imgcodecs.imread("C:\\OpenCvDeneme\\goruntu_karsilastir\\at2.jpg");
        Mat hedefMatrisGray = new Mat();
// Rgb renk uzayından gri renk uzayına çevirme  
        Imgproc.cvtColor(hedefMatris, hedefMatrisGray, Imgproc.COLOR_RGB2BGR);
// Arka plan temi ̇zlendi ̇kten sonraki ̇ veri ̇ 
        Mat islemSonucu = new Mat();
        Core.absdiff(hedefMatrisGray, kaynakMatrisGray, islemSonucu);
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\goruntu_karsilastir\\atfark.jpg", islemSonucu);
    }

    public static void threshold(int i) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat kaynakGoruntu = new Mat();
        kaynakGoruntu = Imgcodecs.imread("C:\\OpenCvDeneme\\3.jpg");
        Mat hedefGoruntu = new Mat();
        int thresh = 150;
        int maxDeger = 255;
        Imgproc.threshold(kaynakGoruntu, hedefGoruntu, thresh, maxDeger, i);
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\threshold\\" + i + "_out.jpg", hedefGoruntu);
        System.out.println("Thresholding uygulandı.");
    }
}
