import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
public class DrawMyImgs extends JPanel {
    public void paint(Graphics g) {
        Image img1 = Toolkit.getDefaultToolkit().getImage("src\\mage.jpg");
        g.drawImage(img1, 0, 0, this);
        g.drawString("mage",50,250);
        Image img2 = Toolkit.getDefaultToolkit().getImage("src\\healer.png");
        g.drawImage(img2, 200, 0, this);
        g.drawString("healer",250,250);
        Image img3 = Toolkit.getDefaultToolkit().getImage("src\\Guerrier archer.jpg");
        g.drawImage(img3, 400, 0, this);
        g.drawString("Guerrier archer",430,250);
        Image img4 = Toolkit.getDefaultToolkit().getImage("src\\guerrierepee.jpg");
        g.drawImage(img4, 600, 0, this);
        g.drawString("guerrier épée", 630, 250);
    }
}