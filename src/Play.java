import java.awt.*;
import java.util.List;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Play {
    protected static Frame jfond = new Frame("fond du jeu");
    public static void play(List<Fighter> heros, List<Enemy> monsters) throws IOException {
        fondecran();
        //création et placement des personnages
        int a = heros.size();
        switch (a){
            case 4:
                player(heros, 1200, 500, 3);
            case 3:
                player(heros, 500, 500, 2);
            case 2:
                player(heros, 1300, 600, 1);
            case 1:
                player(heros, 400, 600, 0);
                break;
        }
        monster1(monsters);
    }
    public static void fondecran() throws IOException {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 1800, 2000);
        BufferedImage img = ImageIO.read(new File("src\\background.jpg"));
        JLabel pic = new JLabel(new ImageIcon(img));
        panel.add(pic);
        jfond.add(panel);
        jfond.setSize(1800, 2000);
        jfond.setLayout(null);
        jfond.setVisible(true);
        }
        public static void player(List<Fighter> heros, int x, int y, int i) throws IOException {
            Frame jfond = new Frame("joueur");
            JPanel panel = new JPanel();
            panel.setBounds(30, 35, 60, 70);
            BufferedImage img;
            switch (Game.typefighter[i]) {
                case 1:
                    img = ImageIO.read(new File("src\\magetete.png"));
                    JLabel pic = new JLabel(new ImageIcon(img));
                    panel.add(pic);
                    jfond.add(panel);
                    break;
                case 2:
                     img = ImageIO.read(new File("src\\healertete.png"));
                    JLabel pic1 = new JLabel(new ImageIcon(img));
                    panel.add(pic1);
                    jfond.add(panel);
                    break;
                case 3:
                    img = ImageIO.read(new File("src\\Guerrier archertete.png"));
                    JLabel pic2 = new JLabel(new ImageIcon(img));
                    panel.add(pic2);
                    jfond.add(panel);
                    break;
                case 4:
                    img = ImageIO.read(new File("src\\guerrierepeetete.png"));
                    JLabel pic3 = new JLabel(new ImageIcon(img));
                    panel.add(pic3);
                    jfond.add(panel);
                    break;
            }
            jfond.setSize(120, 140);
            jfond.setLocation(x,y);
            jfond.setLayout(null);
            jfond.setVisible(true);
        }
        public static void monster1(List<Enemy> momo) throws IOException {
            int a = momo.size();
            switch (a) {
                case 4:
                    monster(900, 550);
                case 3:
                    monster(700, 550);
                case 2:
                    monster(900, 400);
                case 1:
                    monster(700, 400);
                    break;
            }
        }
        public static void monster(int x, int y) throws IOException {
        Frame fmonster = new JFrame("monstre simplet");
        JPanel panel = new JPanel();
        panel.setBounds(30, 15, 60, 70);
        BufferedImage img= ImageIO.read(new File("src\\loup.png"));
        JLabel pic = new JLabel(new ImageIcon(img));
        panel.add(pic);
        fmonster.add(panel);

        fmonster.setSize(120, 140);
        fmonster.setLocation(x,y);
        fmonster.setLayout(null);
        fmonster.setVisible(true);

    }
}
