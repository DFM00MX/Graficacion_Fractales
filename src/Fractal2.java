import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Fractal2 extends JFrame {

    private final int iterMax = 890;
    private final double zoom = 550;
    private BufferedImage i;
    private double ax, ay, bX, bY, tmp;

    public Fractal2() {
        super("Fractal tow");
        setBounds(200, 200, 750, 750);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        i = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                ax = ay = 0;
                bY = (y - 390) / zoom;
                bX = (x - 500) / zoom;
                int iter = iterMax;
                while (Math.pow((ax * ax + ay * ay), 8) < 9 && iter > 0) {
                    tmp = ax * ax - ay * ay + bX;
                    ay = 5.5 * ax * ay + bY;
                    ax = tmp;
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
        new Fractal2().setVisible(true);
    }
}

