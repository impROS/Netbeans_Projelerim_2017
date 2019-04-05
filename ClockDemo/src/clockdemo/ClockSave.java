/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clockdemo;


import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClockSave {
    public static void main(String[] args) {

        // Too much arguments.
        if (args.length < 3 || args.length > 4) {
            System.out.println("Bad usage: Should be java clock.ClockSave filename width height [HH:mm:ss]");
            return;
        }

        // Parse the image size.
        int h, w;
        try {
            w = Integer.parseInt(args[1]);
            h = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Bad usage: Should be java clock.ClockSave filename width height [HH:mm:ss]");
            return;
        }

        // Parse the intended time.
        LocalTime time;
        if (args.length == 4) {
            try {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
                time = LocalTime.parse(args[3], df);
            } catch (DateTimeParseException e) {
            System.out.println("Bad usage: Should be java clock.ClockSave filename width height [HH:mm:ss]");
            return;
            }
        } else {
            time = LocalTime.now();
        }

        // Save to an image.
        try {
            new CoolPaint().saveClock(w, h, time, args[0]);
        } catch (IOException e) {
            System.out.println("Error on image output: " + e.getMessage());
        }
    }
}