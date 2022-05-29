import java.awt.*;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
public class DrawMyImgs2 extends JPanel {
    public void paint(Graphics g) {
        for (int k = 1; k <= Game.heros.size(); k++) {
            Fighter hero = Game.heros.get(k - 1);
            int pv = hero.getLifePoints();
            int type = Game.typefighter[k - 1];
            dessin(pv, type, k, g);
        }
        for (int k = 1; k <= Game.monsters.size(); k++) {
            Fighter monstre = Game.monsters.get(k - 1);
            int pv = monstre.getLifePoints();
            dessinmonstre(pv, k, g);
        }
        Image img1 = Toolkit.getDefaultToolkit().getImage("src\\lembas2.jpg");
        g.drawImage(img1, 750, 0, this);
        Image img2 = Toolkit.getDefaultToolkit().getImage("src\\potions.jpg");
        g.drawImage(img2, 1000, 0, this);
        g.drawString("nombre de lembas restants = " + Game.lembas, 750, 250);
        g.drawString("nombre de potions restants = " + Game.potions, 1000, 250);}

    public void dessin(int pv, int type, int k, Graphics g) {
        int x = 0;
        int y = 0;
        switch (k) {
            case 1:
                x = 0;
                y = 0;
                break;
            case 2:
                x = 200;
                y = 0;
                break;
            case 3:
                x = 400;
                y = 0;
                break;
            case 4:
                x = 600;
                y = 0;
                break;
        }
        switch (type) {
            case 1:
                Image img1 = Toolkit.getDefaultToolkit().getImage("src\\mage.jpg");
                g.drawImage(img1, x, y, this);
                g.drawString("pv = " + pv, x, 250);
                break;
            case 2:
                Image img2 = Toolkit.getDefaultToolkit().getImage("src\\healer.png");
                g.drawImage(img2, x, y, this);
                g.drawString("pv = " + pv, x, 250);
                break;
            case 3:
                Image img3 = Toolkit.getDefaultToolkit().getImage("src\\Guerrier archer.jpg");
                g.drawImage(img3, x, y, this);
                g.drawString("pv = " + pv, x, 250);
                break;
            case 4:
                Image img4 = Toolkit.getDefaultToolkit().getImage("src\\guerrierepee.jpg");
                g.drawImage(img4, x, y, this);
                g.drawString("pv = " + pv, x, 250);
                break;
        }
    }

    public void dessinmonstre(int pv, int k, Graphics g) {
        int x = 0;
        int y = 0;
        switch (k) {
            case 1:
                x = 0;
                y = 400;
                break;
            case 2:
                x = 200;
                y = 400;
                break;
            case 3:
                x = 400;
                y = 400;
                break;
            case 4:
                x = 600;
                y = 400;
                break;
        }
        Image img1 = Toolkit.getDefaultToolkit().getImage("src\\loup.png");
        g.drawImage(img1, x, y, this);
        g.drawString("pv = " + pv, x, 600);
    }
}