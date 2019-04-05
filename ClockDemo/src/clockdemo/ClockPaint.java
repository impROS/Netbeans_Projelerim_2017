/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockdemo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import javax.imageio.ImageIO;

public interface ClockPaint {

    public void paintClock(int width, int height, int seconds, Graphics2D g2);

    public default void paintClock(int width, int height, LocalTime time, Graphics2D g2) {
        paintClock(width, height, time.get(ChronoField.SECOND_OF_DAY), g2);
    }

    public default void paintClock(int width, int height, Graphics2D g2) {
        paintClock(width, height, LocalTime.now(), g2);
    }

    public default void saveClock(int width, int height, String fileName) throws IOException {
        saveClock(width, height, LocalTime.now(), fileName);
    }

    public default void saveClock(int width, int height, LocalTime time, String fileName) throws IOException {
        saveClock(width, height, time.get(ChronoField.SECOND_OF_DAY), fileName);
    }

    public default void saveClock(int width, int height, int seconds, String fileName) throws IOException {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        paintClock(width, height, seconds, (Graphics2D) image.getGraphics());
        String f = fileName.endsWith(".png") ? fileName : fileName + ".png";
        ImageIO.write(image, "png", new File(f));
    }
}