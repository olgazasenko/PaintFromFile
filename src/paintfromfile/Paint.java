/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paintfromfile;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import org.math.plot.Plot2DPanel;

/**
 *
 * @author Olga
 */
public class Paint extends Applet {

    Graphics2D g2;
    ArrayList<Long[]> points;
    Plot2DPanel plot;

    Paint(ArrayList<Long[]> points) {
        this.points = points;
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(700, 700);
        plot = new Plot2DPanel();
        plot.setAxisLabel(0, "n");
        plot.setAxisLabel(1, "Floating-point operations");
        plot.setFixedBounds(0, 0, 2000000);
        plot.setFixedBounds(1, 0, 2000000);
        frame.setContentPane(plot);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void paint() {
        paintPoints();

    }

    private void paintPoints() {

        int totalSize = points.size();
        double[][] dataPlot = new double[totalSize][2];
        for (int i = 0; i < totalSize; i++) {
                dataPlot[i][0] = points.get(i)[0];
                dataPlot[i][1] = points.get(i)[1];
            }
        plot.addScatterPlot("plot", Color.GREEN, dataPlot);
    }
}
