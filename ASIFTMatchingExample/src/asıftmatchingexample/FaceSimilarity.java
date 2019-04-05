/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asıftmatchingexample;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import org.opencv.core.Core;

import org.openimaj.feature.FloatFV;
import org.openimaj.feature.FloatFVComparison;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.FaceDetector;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;
import org.openimaj.image.processing.face.detection.keypoints.FKEFaceDetector;
import org.openimaj.image.processing.face.detection.keypoints.KEDetectedFace;
import org.openimaj.image.processing.face.feature.FacePatchFeature;
import org.openimaj.image.processing.face.feature.FacePatchFeature.Extractor;
import org.openimaj.image.processing.face.feature.comparison.FaceFVComparator;
import org.openimaj.image.processing.face.similarity.FaceSimilarityEngine;
import org.openimaj.math.geometry.shape.Rectangle;
import org.openimaj.video.capture.VideoCapture;

/**
 * Example showing how to use the {@link FaceSimilarityEngine} class to compare
 * faces detected in two images.
 *
 * @author Jonathon Hare (jsh2@ecs.soton.ac.uk)
 *
 */
public class FaceSimilarity {

    /**
     * Main method for the example.
     *
     * @param args Ignored.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture vc = new VideoCapture(320, 240);
        VideoDisplay<MBFImage> vd = VideoDisplay.createVideoDisplay(vc);
        vd.addVideoListener(
                new VideoDisplayListener<MBFImage>() {
            public void beforeUpdate(MBFImage frame) {
            }

            public void afterUpdate(VideoDisplay<MBFImage> display) {
            }
        });
        FaceDetector<DetectedFace,FImage> fd = new HaarCascadeDetector(40);
    }
}
