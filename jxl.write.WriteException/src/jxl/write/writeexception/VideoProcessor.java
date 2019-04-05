/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxl.write.writeexception;

import org.opencv.core.Mat;

/**
 * Created by Krzysiek on 2016-07-23.
 */
public interface VideoProcessor {
    Mat process(Mat inputImage);

    void setImageThreshold(double imageThreshold);

    void setHistory(int history);

}
