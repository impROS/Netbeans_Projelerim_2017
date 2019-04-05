package dosyanumarandir;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class DosyaNumarandir {

    public static void main(String[] args) {
        // isimUygunlastir("1-Ali");
        //boyutEsitle();
        dosyaNumaralandir("C:\\Users\\impROS\\Desktop\\Tubitak Resim\\Tubitak\\Ayiklanan_Resim\\Cizimler_ve_Alci");
        // boyutEsitle("C:\\Users\\impROS\\Desktop\\dasar_haartrain\\positive\\rawdata");
        //  klasorGrilestir("C:\\OpenCvDeneme\\Otoyol_Araba_Tanima_Projesi\\Oto1_Goruntuler\\Negatif");
        //  kirp();
        //  grilestir("C:\\OpenCvDeneme\\suleyman.jpg");
    }
 public static void dosyaNumaralandir(String strPath) {
        File tmpFile = new File(strPath);
        File[] arrFile = tmpFile.listFiles();

        for (int i = 0; i < arrFile.length; i++) {
            //  System.out.println(arrFile[AbsolutePath()i].getAbsolutePath());
            try {
                System.out.println(arrFile[i].getAbsolutePath());

                boolean isChange = arrFile[i].renameTo(new File(arrFile[i].getParent() + "\\cizimler_ve_alci_" + (i + 1) + ".jpg"));
                System.out.println(isChange);
            } catch (Exception e) {
                System.out.println("Hata : " + e.getMessage());
            }

        }
    }
    public static void boyutEsitle(String strPath) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File tmpFile = new File(strPath);
        File[] arrFile = tmpFile.listFiles();

        for (int i = 0; i < arrFile.length; i++) {
            //  System.out.println(arrFile[AbsolutePath()i].getAbsolutePath());
            if (arrFile[i].isFile()) {
                try {
                    System.out.println(arrFile[i].getAbsolutePath());
                    Mat tmpIm = Imgcodecs.imread(arrFile[i].getAbsolutePath());
                    Imgproc.resize(tmpIm, tmpIm, new Size(1000, 359));
                    Imgcodecs.imwrite(arrFile[i].getParent() + "\\" + (i + 1) + ".bmp", tmpIm);
                } catch (Exception e) {
                    System.out.println("Hata");
                }

            }

        }

    }

    public static void kirp() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File tmpFile = new File("C:\\OpenCvDeneme\\Otoyol_Araba_Tanima_Projesi\\Oto1_Goruntuler");
        File[] arrFile = tmpFile.listFiles();

        for (int i = 0; i < arrFile.length; i++) {
            //  System.out.println(arrFile[AbsolutePath()i].getAbsolutePath());
            if (arrFile[i].isFile()) {
                System.out.println(arrFile[i].getAbsolutePath());
                Mat tmpIm = Imgcodecs.imread(arrFile[i].getAbsolutePath());
                System.out.println(tmpIm.rows() + " - " + tmpIm.cols());
                Rect kirp = new Rect(new Point(0, 300), new Point(tmpIm.cols(), tmpIm.rows()));
                Mat tmp2 = new Mat(tmpIm, kirp);
                Imgcodecs.imwrite(arrFile[i].getAbsolutePath(), tmp2);

            }

        }
    }

    //  990-690
    public static void isimUygunlastir(String strIdIsım) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File tmpFile = new File("C:\\OpenCvDeneme\\yuz_ornekleri_db\\Karisik");
        File[] arrFile = tmpFile.listFiles();

        for (int i = 0; i < arrFile.length - 1; i++) {
            //  System.out.println(arrFile[AbsolutePath()i].getAbsolutePath());
            System.out.println(arrFile[i].getAbsolutePath());
            Mat tmpIm = Imgcodecs.imread(arrFile[i].getAbsolutePath());
            Imgproc.resize(tmpIm, tmpIm, new Size(250, 250));
            Imgcodecs.imwrite(arrFile[i].getParent() + "\\Output\\" + strIdIsım + "_" + (i + 1) + ".jpg", tmpIm);
        }
    }

   

    public static void klasorGrilestir(String strPath) {
        File klasor = new File(strPath);
        File[] arrKlasor = klasor.listFiles();
        for (File file : arrKlasor) {
            if (file.isDirectory()) {
                File tmpFile = new File(file.getAbsolutePath());
                File[] arrFile = tmpFile.listFiles();

                for (int i = 0; i < arrFile.length; i++) {
                    System.out.println(arrFile[i].getAbsolutePath());
                    // arrFile[i].renameTo(new File(file.getPath() + "\\" + i + ".jpg"));

                    grilestir(arrFile[i].getAbsolutePath());
                }
            } else {
                System.out.println(file.getAbsolutePath());
                grilestir(file.getAbsolutePath());

            }

        }
    }

    public static void grilestir(String strFile) {
        try {

            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            File input = new File(strFile);
            BufferedImage image = ImageIO.read(input);

            byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
            Mat mat = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC3);
            mat.put(0, 0, data);

            Mat mat1 = new Mat(image.getHeight(), image.getWidth(), CvType.CV_8UC1);
            Imgproc.cvtColor(mat, mat1, Imgproc.COLOR_RGB2GRAY);

            byte[] data1 = new byte[mat1.rows() * mat1.cols() * (int) (mat1.elemSize())];
            mat1.get(0, 0, data1);
            BufferedImage image1 = new BufferedImage(mat1.cols(), mat1.rows(), BufferedImage.TYPE_BYTE_GRAY);
            image1.getRaster().setDataElements(0, 0, mat1.cols(), mat1.rows(), data1);

            File ouptut = new File(strFile);
            ImageIO.write(image1, "jpg", ouptut);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
