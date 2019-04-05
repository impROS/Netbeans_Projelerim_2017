package telemetritest;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class TelemetriTest {

    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //addTo();
        for (double i = 0;  i < 1; i+=0.1) {
               ekle(i);
        }
     
    }

    public static void ekle(double aci) throws IOException {
        File path = new File("C:\\OpenCvDeneme\\Telemetri");

// load source images
        BufferedImage image = ImageIO.read(new File(path, "sayac.png"));
        BufferedImage overlay = ImageIO.read(new File(path, "gosterge2.png"));

        AffineTransform transform = new AffineTransform();
        transform.rotate(aci, overlay.getWidth(), overlay.getHeight() );
        AffineTransformOp op = new AffineTransformOp(transform, AffineTransformOp.TYPE_BILINEAR);
        overlay = op.filter(overlay, null);
// create the new image, canvas size is the max. of both image sizes
        int w = Math.max(image.getWidth(), overlay.getWidth());
        int h = Math.max(image.getHeight(), overlay.getHeight());
        BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

// paint both images, preserving the alpha channels
        Graphics2D g = combined.getGraphics();
        g.drawImage(image, 0, 0, null);
     
        int x = ((image.getWidth()-overlay.getWidth()-100)/2);
        int y = (image.getHeight()/2);
           g.drawLine(h, h, h, h);
        System.out.println("x : " + x + ",y : " + y);
        //125 66
        g.drawImage(overlay, x, y, null);

// Save as new image
        ImageIO.write(combined, "PNG", new File(path, "\\Sonuclar\\"+aci+"combined.png"));
    }

    public static Mat addTo() {
        Mat im1 = new Mat();
        Mat im2 = new Mat();
        Mat dst = new Mat();

        im1 = Imgcodecs.imread("C:\\OpenCvDeneme\\Telemetri\\sayac2.png");
        im2 = Imgcodecs.imread("C:\\OpenCvDeneme\\Telemetri\\sayac.png");

        List<Mat> src = Arrays.asList(im1, im2);
        Core.vconcat(src, dst);
        Imgcodecs.imwrite("C:\\OpenCvDeneme\\Telemetri\\output.png", dst);
        return dst;
    }
}
