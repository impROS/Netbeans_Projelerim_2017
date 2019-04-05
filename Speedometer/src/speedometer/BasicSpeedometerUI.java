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
 * Source code <a href="BasicSpeedometerUI.java.html">here</a>.
 * @author Jean-Baptiste Yunès
 * @date 03/2011
 */
public class BasicSpeedometerUI extends SpeedometerUI {
    private static SpeedometerUI speedometerUI;
    public static ComponentUI createUI(JComponent c) {
	System.out.println("BasicSpeedometerUI");
	if (speedometerUI==null) speedometerUI = new BasicSpeedometerUI();
	return speedometerUI;
    }
}
