package tupper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.math.BigInteger;

import javax.swing.JPanel;

public class Paint extends JPanel {

    private static final long serialVersionUID = 1L;

    public static BigInteger K = new BigInteger(
            "96093937991895888497167296212785275471500433966012930665150551927170"
            + "28023952664246896428421743507181212671537827706233559932372808741443"
            + "07891325963941337723487857735749823926629715517173716995165232890538"
            + "22161240323885586618401323558513604882869333790249145422928866708109"
            + "61844960917051834540678277315517054053816273809676025656250169814820"
            + "83418783163849115590225610003652351370343874461848378737238198224849"
            + "86346503315941005497470059313833922649724946175154572836670236974546"
            + "1014655997933798537483143786841806593422227898388722980000748404719");

    public static boolean set_buffer(float xAxis, float yAxis) {
        BigInteger y = new BigInteger("" + (int) yAxis);
        y = y.add(K);
        BigInteger x = new BigInteger("" + (int) xAxis);

        //meat of the actual formula
        if (0.5 < y.divideAndRemainder(BigInteger.valueOf(17))[0].divideAndRemainder(BigInteger.valueOf(2).pow(BigInteger.valueOf(17).multiply(x).add(y.mod(BigInteger.valueOf(17))).intValue()))[0].mod(BigInteger.valueOf(2)).doubleValue()) {
            return true;
        } else {
            return false;
        }
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        int _j;
        for (int i = 0; i < Tupper.yRes; i++) {
            for (int j = 0; j < Tupper.xRes; j++) {
                if (set_buffer(((float) j) / 5L, ((float) i) / 5L)) //first argument prevents image from appearing reversed
                {
                    g2.drawLine((_j = Tupper.xRes - j), i, _j, i);
                }
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

}
