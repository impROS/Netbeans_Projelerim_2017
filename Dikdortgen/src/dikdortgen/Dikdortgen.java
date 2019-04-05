
package dikdortgen;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.*;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Dikdortgen {

	public static void main(String[] args) {

	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	Mat goruntuDizisi=new Mat();
	goruntuDizisi=Imgcodecs.imread("C:\\OpenCvDeneme\\papatya_color.png");	
	/* rectangle metodu paramatetre olarak, üzerinde çizim yapılacak bir mat nesnesi
	 * dikdörtgen çizimi için gerekli olan 4 köşenin koordinatı [(x1,y1),(x2,y2)] ve rengini almaktadır.
	 * */
	Imgproc.rectangle(goruntuDizisi, new Point(10,100), new Point(100,200),new Scalar(76,255,0));
	Imgcodecs.imwrite("C:\\OpenCvDeneme\\papatya_color_change.png", goruntuDizisi);
	System.out.println("Düzenlenen görüntü dosya sistemine yazıldı.");
	}
}
