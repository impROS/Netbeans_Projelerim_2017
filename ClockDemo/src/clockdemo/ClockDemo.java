
package clockdemo;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class ClockDemo {
    public static void main(String[] args) {
        EventQueue.invokeLater(ClockDemo::runIt);
    }

    private static void runIt() {
        final JFrame j = new JFrame();
        j.setTitle("JClock");
        final JClock clock = new JClock(new CoolPaint());
        final JClock clock2 = new JClock(new CoolPaint());

        j.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                clock.stop();
                j.dispose();
            }
        });

        j.add(clock);
        j.add(clock2);
        j.setBounds(20, 20, 600, 500);
        j.setVisible(true);
        clock.start();
        clock2.start();
    }
}