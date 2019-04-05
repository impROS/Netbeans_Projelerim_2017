package tupper;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Tupper extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public static int xRes = 530, yRes = 85;
	
	public Tupper() {
		setTitle("Tupper's Self-Referential Formula");
		setSize(xRes + 25, yRes + 38);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Paint painted = new Paint();
		getContentPane().add(painted);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Tupper newTupper = new Tupper();
				newTupper.setVisible(true);
			}
		});
	}
	
}


