package opencvfacerecognizer;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;

import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import static org.bytedeco.javacpp.opencv_core.CV_8UC1;
import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createEigenFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createLBPHFaceRecognizer;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.opencv_face.FaceRecognizer;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_face;
import static org.bytedeco.javacpp.opencv_highgui.cvWaitKey;
import static org.bytedeco.javacpp.opencv_highgui.imshow;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import org.opencv.core.Core;

public class OpenCVFaceRecognizer {
    
    public static void main(String[] args) {        
        
//Eğitim için kullanacağım veri setinin dizini      
        String trainingDir = "C:\\OpenCvDeneme\\yuz_ornekleri_db\\Karisik\\Output";         //Eşleştirme için kullanacağım diğer yüz    
        Mat testImage = imread("C:\\OpenCvDeneme\\yuz_ornekleri_db\\Karisik\\3.jpg", CV_LOAD_IMAGE_GRAYSCALE);
        
        File root = new File(trainingDir);
        
        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
            }
        };
        
        File[] imageFiles = root.listFiles(imgFilter);
        
        MatVector images = new MatVector(imageFiles.length);
        
        Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
        IntBuffer labelsBuf = labels.createBuffer();
        
        int counter = 0;
        
        for (File image : imageFiles) {
            Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
            System.out.println(image.getName().split("\\-")[0]);
            int label = Integer.parseInt(image.getName().split("\\-")[0]);
            System.out.println("Eğitilen Yüz: " + label);
            images.put(counter, img);
            labelsBuf.put(counter, label);
            counter++;
        }
        FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
        //FaceRecognizer faceRecognizer = createFisherFaceRecognizer();            
        //FaceRecognizer faceRecognizer = createLBPHFaceRecognizer(); 

        faceRecognizer.train(images, labels);
        
        int predictedLabel = faceRecognizer.predict(testImage);
       
      int benzerlik  =  faceRecognizer.predict(testImage);
      
        System.out.println("Benzerlik : "+benzerlik);
        System.out.println("Bulunan Yüz ID: " + predictedLabel);
        cvWaitKey(0);
    }
}
