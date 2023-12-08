import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractal3 extends JFrame {

    private final int MAX_ITER = 770;
    private final double ZOOM = 200;
    private BufferedImage I;
    private double ax, ay, bX, bY;

    public Fractal3() {
        super("Mandelbrot Set");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                ax = ay = 0;
                bX = (x - 400) / ZOOM;
                bY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (iter > 0) {

                    double r = Math.pow(ax * ax + ay * ay, 2.2);
                    double theta = 3.9 * Math.atan2(ay, ax);
                    ax = r * Math.cos(theta) + bX;
                    ay = r * Math.sin(theta) + bY;
                    if (ax * ax + ay * ay > 6.2) break;
                    iter--;
                }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }

    public static void main(String[] args) {
        new Fractal3().setVisible(true);
    }
}