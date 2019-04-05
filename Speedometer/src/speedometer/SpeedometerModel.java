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
import java.lang.reflect.*;

/**
 * Defines the model used by <code>Speedometer</code>s components. It's a
 * specialized <code>BoundedRangeModel</code> for which <code>extent</code>
 * property is always set to 0.
 *
 * Source code <a href="SpeedometerModel.java.html">here</a>.
 *
 * @author Jean-Baptiste Yunès
 * @date 03/2011
 */
public class SpeedometerModel extends DefaultBoundedRangeModel {

    /**
     * Initializes value, minimum and maximum. The following constraint must be
     * satisfied :<br/><code>minimum <= value <= maximum</code>
     */
    public SpeedometerModel(int value, int minimum, int maximum) {
        super(value, 0, minimum, maximum);
    }
}
