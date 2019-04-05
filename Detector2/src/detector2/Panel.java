/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detector2;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import org.opencv.core.Mat;

//Kameradan alınan ve işlenen görüntüler jpanel üzerinde görüntülenecek
class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	private BufferedImage image;
 
	public Panel() {
		super();
	}
	private BufferedImage getimage() {
		return image;
	}
	public void setimage(BufferedImage newimage) {
		image = newimage;
		return;
	}
 
	public void setimagewithMat(Mat newimage) {
		image = this.ConvertImage(newimage);
		return;
	}
 
	/* Mat nesnesini frame içerisinde göstermek için BufferedImage tipine
	çeviriyoruz*/
	public BufferedImage ConvertImage(Mat matrix) {
		// Mat nesnesinin sütun, satır ve boyutunu BufferedImage nesnesi içintutuyoruz
		int cols = matrix.cols();
		int rows = matrix.rows();
		int elemSize = (int) matrix.elemSize();
		byte[] data = new byte[cols * rows * elemSize];
		int type;
		matrix.get(0, 0, data);
		// Mat nesnesinin kaç kanallı, hangi renk uzayında olduğunu tespit ediyoruz.
		switch (matrix.channels()) {
		// Tek kanallı gri renk uzayına sahip matris
		case 1:
			type = BufferedImage.TYPE_BYTE_GRAY;
			break;
		// Üç kanallı BGR renk uzayına sahip matris
		case 3:
			type = BufferedImage.TYPE_3BYTE_BGR;
	/*
	 * Opencv rgb renk uzayını bgr olarak tuttuğu için görüntülemede
	 * düzgün bir görüntü elde etmek amacıyla rgb uzayına çeviriyoruz
	 */
			byte b;
			for (int i = 0; i<data.length; i = i + 3) {
				b = data[i];
				data[i] = data[i + 2];
				data[i + 2] = b;
			}
			break;
		default:
			return null;
		}
		BufferedImage image2 = new BufferedImage(cols, rows, type);
		image2.getRaster().setDataElements(0, 0, cols, rows, data);
		return image2;
	}
 
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
 
		BufferedImage temp = getimage();
 
		if (temp != null)
			g.drawImage(temp, 10, 10, temp.getWidth(), temp.getHeight(), this);
	}
}