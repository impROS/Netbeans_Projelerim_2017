/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedometer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * Source code <a href="SpeedometerExample.java.html">here</a>.
 * @author Jean-Baptiste Yunès
 * @date 03/2011
 */
public class SpeedometerExample implements Runnable {
    private int l;
    private Vector<String> lafs;
    public void run() {
	lafs = new Vector<String>();
	UIManager.LookAndFeelInfo [] lafi = UIManager.getInstalledLookAndFeels();
	for (UIManager.LookAndFeelInfo info : lafi) {
	    lafs.add(info.getClassName());
	}
	final JFrame f = new JFrame("Du vent dans les cheveux...");
	final Speedometer s = new Speedometer(50,0,100);
	f.getContentPane().setLayout(new BorderLayout());
	f.getContentPane().add(s,BorderLayout.CENTER);
	JButton b = new JButton("Next layout");
	f.getContentPane().add(b,BorderLayout.NORTH);
	JButton b2 = new JButton("Change the value");
	f.getContentPane().add(b2,BorderLayout.SOUTH);
	f.pack();
	f.setVisible(true);
	final Random r = new Random();
	l = 0;
	b.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			System.out.println(lafs.elementAt(l));
			UIManager.setLookAndFeel(lafs.elementAt(l));
			SwingUtilities.updateComponentTreeUI(f);
			f.pack();
			l = (l+1)%lafs.size();
		    } catch(Exception ex) {
			ex.printStackTrace();
		    }
		}
	    });
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int saut = r.nextInt()%10;
		    if (saut==0) saut = 30;
		    else saut = 5;
		    int v = r.nextInt()%saut;
		    s.setValue(s.getValue()+v);
		}
	    });
    }
    public static void main(String [] args) {
	SwingUtilities.invokeLater(new SpeedometerExample());
    }
}
