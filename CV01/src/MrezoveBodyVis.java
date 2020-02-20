import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MrezoveBodyVis extends JFrame {

    int marg = 10;
    int matrixSize = 10;
    int cellSize = 50;
    int pointSize = 3;
    int canvasSize = 2*marg + matrixSize * cellSize;
    int posCentre = marg + (matrixSize/2) * cellSize;

    public void drawGrid(Graphics g) {
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                g.drawRect(marg + cellSize *i, marg + cellSize *j, cellSize, cellSize);
            }
        }
    }

    public void drawCircle(Graphics g, double sx, double sy, double r) {
        g.drawOval(marg + (int) (sx*cellSize - r*cellSize), marg + (int) (sy*cellSize - r*cellSize),
                (int) (2*r*cellSize), (int) (2*r*cellSize));
        g.setColor(Color.blue);
        g.fillOval(marg + (int)(sx*cellSize) - pointSize, marg + (int)(sy*cellSize) - pointSize,
                2*pointSize, 2*pointSize);
    }

    public void drawGridMarkersInCircle(Graphics g, double sx, double sy, double r) {
        g.setColor(Color.red);
        for (long i = Math.round(sx - r); i <= Math.round(sx + r); i++) {
            for (long j = Math.round(sy - r); j <= Math.round(sy + r); j++) {
                if (((i - sx)*(i - sx) + (j - sy)*(j - sy)) <= r*r) {
                    int x = (int) i;
                    int y = (int) j;
                    g.fillOval(marg + x*cellSize - pointSize,
                            marg +  y*cellSize - pointSize,
                            2*pointSize,
                            2*pointSize);
                }
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, canvasSize, canvasSize);
        g.setColor(Color.black);
        drawGrid(g);
//        drawCircle(g, matrixSize/2, matrixSize/2, 2);
//        drawGridMarkersInCircle(g, matrixSize/2, matrixSize/2, 2);
//        drawCircle(g, 6.3, 5.2, 3);
//        drawGridMarkersInCircle(g, 6.3, 5.2, 3);
        drawCircle(g, 3.5,3.5,3);
        drawGridMarkersInCircle(g, 3.5,3.5,3);

    }

    public void display() {
        this.setSize(canvasSize,canvasSize);
        this.setVisible(true);
    }

    public void saveImage(String path) {
        BufferedImage image = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        this.paint(graphics2D);
        try {
            File newfile = new File(path);
            if(!newfile.exists())
                newfile.createNewFile();
            ImageIO.write(image, "png", newfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MrezoveBodyVis vis = new MrezoveBodyVis();
        vis.display();
        vis.saveImage("mrezovnik2.png");
    }

}
