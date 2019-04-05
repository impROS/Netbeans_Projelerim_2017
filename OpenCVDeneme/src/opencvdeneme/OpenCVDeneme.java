package opencvdeneme;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class OpenCVDeneme {

    public static void main(String[] args) {
        //sistem kütüphanesini yükleme
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //görüntüyü barındıracak nesne
        Mat imageArray;
        //görüntü dosyasını oku
        imageArray = Imgcodecs.imread("C:\\OpenCvDeneme\\papatya_color.png");
        //mat nesnesinin satır ve sutun sayısı
        System.out.println(imageArray.rows());
        System.out.println(imageArray.cols());
        System.out.println(imageArray.channels());
        System.out.println(imageArray.diag());
        System.out.println(imageArray.isContinuous());
        System.out.println(imageArray.rowRange(4, 12));
    }
}
