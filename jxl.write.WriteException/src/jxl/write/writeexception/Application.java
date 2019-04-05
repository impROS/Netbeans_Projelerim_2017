/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jxl.write.writeexception;

import org.opencv.core.Core;
import tw.edu.sju.ee.commons.nativeutils.NativeUtils;

import java.io.IOException;
import jxl.write.WriteException;

/**
 * Created by Krzysiek on 2016-07-23.
 */
public class Application {
    static {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // used for tests. This library in classpath only
        } catch (UnsatisfiedLinkError e) {
            try {
                NativeUtils.loadLibraryFromJar("opencv_java320"); // during runtime. .DLL within .JAR
            } catch (IOException e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    public static void main(String[] args) throws IOException, WriteException, InterruptedException {
        GUI gui = new GUI();
        gui.init();
    }
}
