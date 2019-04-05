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
 * Implements a "velocimeter"-like component. Its primarily purpose is to
 * graphically display a value into a pre-defined range as a hand. Various
 * pluggable look and feels are supported : <code>Metal</code>,
 * <code>Aqua</code> and the default <code>Basic</code>.
 *
 * Source code <a href="Speedometer.java.html">here</a>.
 *
 * @see AquaSpeedometerUI
 * @see BasicSpeedometerUI
 * @see MetalSpeedometerUI
 * @author Jean-Baptiste Yunès
 * @date 03/2011
 */
public class Speedometer extends JComponent {

    private static final String packageName = "fr.upd.jby";
    private BoundedRangeModel model;

    /**
     * Creates a <code>Speedometer</code> with the following default values :
     * <code>value</code> is 0, <code>minimum</code> is 0, and
     * <code>maximum</code> is 100.
     */
    public Speedometer() {
        this(0, 0, 100);
    }

    /**
     * Creates a <code>Speedometer</code>.
     *
     * @param value the value of this <code>Speedometer</code>
     * @param minimum the minimum value this <code>Speedometer</code> can take
     * @param maximum the maximum value this <code>Speedometer</code> can take
     */
    public Speedometer(int value, int minimum, int maximum) {
        SpeedometerModel model = new SpeedometerModel(value, minimum, maximum);
        setModel(model);
        updateUI();
    }

    // Model
    private BoundedRangeModel getModel() {
        return model;
    }

    private void setModel(BoundedRangeModel m) {
        model = m;
    }

    // Model delegation services
    /**
     * Gets the current value of this <code>Speedometer</code>
     *
     * @return the current value of this <code>Speedometer</code>
     */
    public int getValue() {
        return model.getValue();
    }

    /**
     * Sets the current value of this <code>Speedometer</code>
     *
     * @param value the new value
     */
    public void setValue(int value) {
        model.setValue(value);
        repaint();
    }

    /**
     * Gets the minimum value this <code>Speedometer</code> can take.
     *
     * @return the minimum value
     */
    public int getMinimum() {
        return model.getMinimum();
    }

    /**
     * Gets the maximum value this <code>Speedometer</code> can take.
     *
     * @return the maximum value
     */
    public int getMaximum() {
        return model.getMaximum();
    }

    // UI delegation
    /**
     * Resets the UI property to a value from the current look and feel.
     *
     * @see JComponent#updateUI()
     */
    @Override
    public void updateUI() {
        String lafName = UIManager.getLookAndFeel().getID();
        if (UIManager.get(getUIClassID()) != null) {
            setUI((ComponentUI) UIManager.getUI(this));
        } else {
            String className = packageName + "." + lafName + getUIClassID();
            try {
                Class<?> c = Class.forName(className);
                Method m = c.getMethod("createUI", JComponent.class);
                ComponentUI newUI = (ComponentUI) m.invoke(null, this);
                setUI(newUI);
            } catch (Exception ex) {
                setUI(BasicSpeedometerUI.createUI(this));
            }
        }
    }

    /**
     * Returns the <code>UIDefaults</code> key used to look up the name of the
     * <code>swing.plaf.ComponentUI</code> class that defines the look and feel
     * for this component. Most applications will never need to call this
     * method.
     *
     * @return the <code>UIDefaults</code> key
     * @see UIDefaults#getUI(javax.swing.JComponent)
     */
    @Override
    public String getUIClassID() {
        return "SpeedometerUI";
    }
}
