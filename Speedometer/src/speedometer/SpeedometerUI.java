/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedometer;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.accessibility.*;

/**
 * Source code <a href="SpeedometerUI.java.html">here</a>.

 * @author Jean-Baptiste Yunès
 * @date 03/2011
 */
public abstract class SpeedometerUI extends ComponentUI {
    protected Color arrowColor;
    public SpeedometerUI() {
	arrowColor = Color.RED;
    }
    public boolean contains(JComponent c,int x, int y) {
	Dimension d = c.getSize();
	double w = d.getWidth();
	double h = d.getHeight();
	double r = 0;
	if (w>2*h) r = h;
	else r = w/2;
	if ((x-w/2)*(x-w/2)+(y-h)*(y-h) > r*r) return true;
	return false;
    }
    public Accessible getAccessible(JComponent c,int i) {
	return null;
    }
    public int getAccessibleChildrenCount(JComponent c) {
	return 0;
    }
    public int getBaseline(JComponent c,int w,int h) {
	return -1;
    }
    public java.awt.Component.BaselineResizeBehavior getBaselineResizeBehavior(JComponent c) {
	return Component.BaselineResizeBehavior.OTHER;
    }
    public Dimension getMinimumSize(JComponent c) {
	return new Dimension(100,50);
    }
    public Dimension getPreferredSize(JComponent c) {
	return new Dimension(200,100);
    }
    public Dimension getMaximumSize(JComponent c) {
	return new Dimension(400,200);
    }
    public void paint(Graphics og,JComponent co) {
	Graphics2D g = (Graphics2D)og;
	Speedometer c = (Speedometer)co;
	Color b = c.getBackground();
	Color f = c.getForeground();
	Dimension d = c.getSize();
	double w = d.getWidth();
	double h = d.getHeight();
	double r = 0;
	if (w>2*h) r = h;
	else r = w/2;
	g.setStroke(new BasicStroke(3));
	g.setColor(f);
	g.drawArc((int)(w/2-r),(int)(h-r),(int)(2*r),(int)(2*r),0,180);
	g.setColor(Color.BLUE);
	g.fillArc((int)(w/2-10),(int)(h-10),(int)(2*10),(int)(2*10),0,180);
	int v = c.getValue();
	int m = c.getMinimum();
	int M = c.getMaximum();
	double fv = 1.0-(double)(v-m)/(double)(M-m);
	double a = fv*Math.PI;
	double x = r*Math.cos(a);
	double y = r*Math.sin(a);
	g.setStroke(new BasicStroke(5));
	g.setColor(arrowColor);
	g.drawLine((int)(w/2),(int)h,(int)(w/2+x),(int)(h-y));
	g.setColor(Color.BLACK);
	g.drawString(""+v,(int)(w/2)-20,(int)h-20);
    }
}
