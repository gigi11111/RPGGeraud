import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Victory {
    protected static Frame jond = new Frame("un air de victoire ??? BIEN JOUE JOUEUR");
    public static void victory() throws IOException, InterruptedException {
            System.out.println("tous les monstres ont ete tues");
            Main.fin();
    }
}
