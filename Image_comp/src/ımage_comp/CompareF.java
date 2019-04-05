
package ımage_comp;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class CompareF
{

  public static double Compare(BufferedImage a, BufferedImage b)
  {
      for (int i = 0; i < 10; i++) {
          
      }
    //Set the width and height for each image.
    int wa = a.getWidth();
    int wb = b.getWidth();
    int ha = a.getHeight();
    int hb = b.getHeight();

    //Compare the width and height, if not the same, it will resize the image.
    if((wa != wb) || (ha != hb))
    {
      int type = b.getType();
      BufferedImage resizedImage = new BufferedImage(wa, ha, type);
      Graphics2D g = resizedImage.createGraphics();
      g.drawImage(b, 0, 0, wa, ha, null);
      g.dispose();
      b = resizedImage;
    }

    //A Similarity counter, counts when there is a similar pixel
    int counter = 0;

    //A forloop to check every pixel
    for (int i = 0; i < ha; i++) {
      for (int j = 0; j < wa; j++) {

        //Difference between each pixel
        long dif = 0;

        //Get RGB from two images
        int rgbofa= a.getRGB(i, j);
        int rgbofb = b.getRGB(i, j);

        int reda = (rgbofa >> 16) & 0xff;
        int grea = (rgbofa >>  8) & 0xff;
        int blua = (rgbofa      ) & 0xff;
        int redb = (rgbofb >> 16) & 0xff;
        int greb = (rgbofb >>  8) & 0xff;
        int blub = (rgbofb      ) & 0xff;

        //Calculate the difference
        dif += Math.abs(reda - redb);
        dif += Math.abs(grea - greb);
        dif += Math.abs(blua - blub);

        //Well I used 200 for the number to check for a similar color. You can change it if you want.
        if (dif < 250)
        {
          counter++;
        }

      }
    }

    double numberofPixels = wa * ha;
    double percentage = counter / numberofPixels;
    return percentage;
  }

}