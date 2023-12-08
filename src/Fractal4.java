import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractal4 extends JFrame {

    private final int iterMax = 570;
    private final double zoom = 200;
    private BufferedImage i;
    private double ax, ay, bX, bY;

    public Fractal4() {
        super("Mandelbrot Set");
        setBounds(100, 100, 550, 550);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        i = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                ax = ay = 0;
                bX = (x - 350) / zoom;
                bY = (y - 300) / zoom;
                int iter = iterMax;
                while (iter > 0) {

                    double r = Math.pow(ax * ax + ay * ay, 2.5);
                    double theta = 5 * Math.atan2(ay, ax);
                    ax = r * Math.cos(theta) + bX;
                    ay = r * Math.sin(theta) + bY;
                    if (ax * ax + ay * ay > 4) break;
                    iter--;
                }
                i.setRGB(x, y, iter | (iter << 8));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(i, 0, 0, this);
    }

    public static void main(String[] args) {
        new Fractal4().setVisible(true);
    }
}