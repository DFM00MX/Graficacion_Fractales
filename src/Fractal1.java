import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractal1 extends JFrame {

    private final int IterMax = 520;
    private final double Zoom = 250;
    private BufferedImage I;
    private double ax, ay, bX, bY;

    public Fractal1() {
        super("Fractal one");
        setBounds(150, 150, 750, 750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                ax = ay = 0;
                bX = (x - 400) / Zoom;
                bY = (y - 300) / Zoom;
                int iter = IterMax;
                while (ax * ax + ay * ay < 15 && iter > 0) {
                    double zx1 = ax*ax*ax-2.5*ax*ay*ay;
                    double zy1 = 3*ax*ax*ay-ay*ay*ay;
                    ax = zx1 + bX;
                    ay = zy1 + bY;
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
        new Fractal1().setVisible(true);
    }
}