/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imshowjava;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;
import javax.imageio.*;
import java.io.*;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.*;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoWriter;

/**
 *
 * @author impROS
 */
public class ImShowJava {

    /**
     * @param args the command line arguments
     */
    static JFrame frame;
    static JLabel lbl;
    VideoWriter videoWriter1;
    videoWriter1  = new VideoWriter("", VideoWriter.fourcc('x', '2', '6', '4'),5, new Size(10, 40), true);
//fourcc ile codec olarak x264 kullanacağımızı belirttik
//Yazma işlemi için ise aşağıdaki metodu ekledik bu sayede parametre olarak verdiğimiz görüntüyü yazacak

    public void Write(Mat frame) {
        if (videoWriter1.isOpened() == false) {
            videoWriter1.release();
            throw new IllegalArgumentException("Video Writer Exception: VideoWriter açılamadı,"
                    + "parametreleri kontrol edin.");
        }
        //Yaz
        videoWriter1.write(frame);
    }

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture capture = new VideoCapture(0);
        Mat camImage = new Mat();
        if (capture.isOpened()) {
            while (true) {
                capture.read(camImage);

                Imgproc.rectangle(camImage, new Point(100, 200), new Point(150, 200), new Scalar(76, 255, 0));
                Imgcodecs.imwrite("C:\\OpenCvDeneme\\papatya_color_change.png", camImage);
                PushImage(ConvertMat2Image(camImage));
            }
        }

    }

    public static void PencereHazirla() {
        frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Resmi gösterecek label oluşturur
    public static void PushImage(Image img2) {
        // Pencere oluşturulmamış ise hazırlanır
        if (frame == null) {
            PencereHazirla();
        }
        // Daha önceden bir görüntü yüklenmiş ise yenisi için kaldırır
        if (lbl != null) {
            frame.remove(lbl);
        }
        ImageIcon icon = new ImageIcon(img2);
        lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        // Frame nesnesini yeniler
        frame.revalidate();
    }

    private static BufferedImage ConvertMat2Image(Mat kameraVerisi) {

        MatOfByte byteMatVerisi = new MatOfByte();
        // Ara belleðe verilen formatta görüntü kodlar
        Imgcodecs.imencode(".jpg", kameraVerisi, byteMatVerisi);
        // Mat nesnesinin toArray() metodu elemanlarý byte dizisine çevirir
        byte[] byteArray = byteMatVerisi.toArray();
        BufferedImage goruntu = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            goruntu = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return goruntu;
    }

}
