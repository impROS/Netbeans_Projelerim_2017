package ımage_comp;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Image_comp {

    public static void main(String[] args) throws IOException {

        BufferedImage im1 = toBufferedImage("C:\\OpenCvDeneme\\yuz\\3.jpg");

        for (int i = 1; i < 8; i++) {
            BufferedImage im2 = toBufferedImage("C:\\OpenCvDeneme\\yuz\\"+i+".jpg");

            double sonuc = CompareF.Compare(im1, im2);
            System.out.println(i+" ile Benzerlik : " + sonuc);
        }

    }

    public static BufferedImage toBufferedImage(String strPathImg) throws IOException {
        Image img;
        File fileImg = new File(strPathImg);
        img = ImageIO.read(fileImg);

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }
}
