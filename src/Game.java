import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game {
    private static int k = 0; //variable utile pour mes différentes boucles while
    public static int nbdejoueur = 0;
    public static int cas =0;
    public static List<Fighter> heros = new ArrayList<>();
    public static List<Enemy> monsters = new ArrayList<Enemy>();
    public static int[] typefighter = new int[4];
    static JFrame f = new JFrame("Choix des presonnages");//utiliser pour afficher les personnages lors du choix par l'utilisateur
    static boolean boucle = true;
    public static int lembas;
    public static int potions;
    public static int p=0;


    public static void playGame() throws InterruptedException, IOException {
        nombredejoueur();
        do{
            Thread.sleep(100);
        }while(nbdejoueur==0);
        lembas = 2*nbdejoueur;
        potions = 1*nbdejoueur;
        System.out.println(typefighter);
        afficherpersonnages();
        listdejoueur();

        do{
            Thread.sleep(100);
        }while(nbdejoueur>0);
        f.setVisible(false);
        System.out.println(heros);//les héros demandés int bien été créé
        // création d'un combat
        enemyinit();
        while(heros.size()>0 && monsters.size()>0){
            affichejeu();
            combat();}
    }
    public static void nombredejoueur(){
        JFrame frame = new JFrame("frame");
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Choisissez le nombre d'avanturiers");
        //Ajouter l'étiquette au frame
        frame.add(label);

        String[] items = { "Jeune avanturier seul et solitaire", "couple et duo, simple et basique", "3, ah, tu porte la chandelle?", "4, un plan qui m'en demande trop la" };
        JComboBox cb = new JComboBox(items);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Valeur: " + cb.getSelectedItem().toString());
                switch (cb.getSelectedItem().toString()){
                    case "Jeune avanturier seul et solitaire":
                        cas = 1;
                        break;
                    case "couple et duo, simple et basique" :
                        cas = 2;
                        break;
                    case "3, ah, tu porte la chandelle?" :
                        cas = 3;
                        break;
                    case "4, un plan qui m'en demande trop la" :
                        cas = 4;
                        break;
                }
            }
        });
        frame.add(cb);
        JButton btn = new JButton("Cliquer pour envoyer votre choix!");
        frame.add(btn);
        btn.addActionListener(e -> {
            frame.dispose();
            nbdejoueur = cas;
            if (nbdejoueur == 0){
                nombredejoueur();
            }
            System.out.println(nbdejoueur);
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2500, 2500);
        frame.setVisible(true);
    }
    public static void afficherpersonnages(){
        f.getContentPane().add(new DrawMyImgs());
        f.setSize(800, 400);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void listdejoueur(){
        cas = 0;
        JFrame frame = new JFrame("frame");
        frame.setLayout(new FlowLayout());
        JLabel label = new JLabel("Choisissez le type d'aventurier que vous etes, joueur : " + nbdejoueur);
        //Ajouter l'étiquette au frame
        frame.add(label);

        String[] items = { "mage, pour les degats", "healer, pour plus de surete", "geurrier archer, pour le soutien", "guerrier epee, trop de reflechir" };
        JComboBox cb = new JComboBox(items);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Valeur: " + cb.getSelectedItem().toString());
                switch (cb.getSelectedItem().toString()){
                    case "mage, pour les degats":
                        cas = 1;
                        break;
                    case "healer, pour plus de surete" :
                        cas = 2;
                        break;
                    case "geurrier archer, pour le soutien" :
                        cas = 3;
                        break;
                    case "guerrier epee, trop de reflechir" :
                        cas = 4;
                        break;
                }
            }
        });
        frame.add(cb);
        JButton btn = new JButton("Cliquer pour confimer votre choix!");
        frame.add(btn);
        btn.addActionListener(e -> {
            frame.dispose();
            if (cas == 0){
                listdejoueur();
            }else {
                System.out.println(nbdejoueur);
                nbdejoueur-=1;
                player(cas);
                if (nbdejoueur> 0){
                    listdejoueur();
                }
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocation(0,399);
        frame.setVisible(true);
    }
    public static void player(int cas){
        //appel la fonction pour créer les héros
        switch (cas){
            case 1:
                Mage mage = new Mage();
                heros.add(mage);
                break;
            case 2:
                Healer healer = new Healer();
                heros.add(healer);
                break;
            case 3:
                Hunter hunter = new Hunter();
                heros.add(hunter);
                break;
            case 4:
                Warrior warrior = new Warrior();
                heros.add(warrior);
                break;
        }
        typefighter[p]= cas;
        p+=1;
        System.out.println(typefighter[nbdejoueur]);
    }
    public static void enemyinit(){
        int a = heros.size();
        for (int k = 1; k<= a; k++) {
            BasicEnemy enemy = new BasicEnemy();
            monsters.add(enemy);
        }
        System.out.println(monsters);
    }
    public static void play(List<Fighter> heros, List<Enemy> monsters) throws IOException {
        Play.play(heros, monsters);//on renvoit la requête sur une nouvelle fenêtre pour soulager cette première
        // cette fonction permet l'affichage des joueurs et des enemis
    }
    public static void combat() throws InterruptedException, IOException {
        for (int i = 0;i < heros.size() ;i++){
            play(heros,monsters);
            Combat.choix(i);            do{
              Thread.sleep(100);
            }while(boucle);
            Combat.enemy();
            do{
                Thread.sleep(100);
            }while(boucle);
        }
    }
    public static void affichejeu() throws InterruptedException {
        Frame jfond = new Frame("stat");
        jfond.add(new DrawMyImgs2());

        jfond.setSize(1800, 2000);
        jfond.setVisible(true);
        Thread.sleep(5000);
        jfond.setVisible(false);
    }
}


