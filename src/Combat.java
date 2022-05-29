import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Combat {
    static Frame choixframe;
    static int k;
    static int a;//type du joueur qui attaque

    public static void choix(int i) { //i est le i_eme élément de la liste qui attaque; du dernier au premier joueur
        System.out.println(Game.heros);
    for (int j = 0; j<4;j++){
        System.out.print(Game.typefighter[j]);
    }
    choixframe = new Frame("fait ton choix d'action");

        k=0; Game.boucle = true;
        choixframe.setLayout(new FlowLayout());
        JLabel label = new JLabel("Choisissez l'action que vous souhaiter faire : " + Game.heros.get(i));
        //Ajouter l'étiquette au frame
        choixframe.add(label);

        String[] items = { "attaquer", "manger", "boire" };
        JComboBox cb = new JComboBox(items);
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Valeur: " + cb.getSelectedItem().toString());
                a = Game.typefighter[i];
                switch (cb.getSelectedItem().toString()){
                    case "attaquer":
                        k=0;
                        choixframe.setVisible(false);
                        a = Game.typefighter[i];
                        try {
                            attaque(a,i);
                        } catch (IOException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        System.out.println("att");
                        break;
                    case "manger" :
                        k=1;
                        choixframe.setVisible(false);
                        manger(a,i);
                        System.out.println("manger");
                        break;
                    case "boire" :
                        k=2;
                        choixframe.setVisible(false);
                        boire(i);
                        System.out.println("boire");
                        break;
                }
                Game.boucle=false;
            }
        });
        choixframe.add(cb);
        JButton btn = new JButton("faite votre choix");
        choixframe.add(btn);
        btn.addActionListener(e -> {
            choixframe.dispose();
            choixframe.setVisible(false);
            Game.boucle = false;
        });
        choixframe.setSize(2000, 200);
        choixframe.setVisible(true);
    }
    public static void enemy(){
        Game.boucle = true;
        JFrame frame = new JFrame();
        JButton btn = new JButton("l'adversaire attaque, cliquer pour passer");
        frame.setContentPane(btn);
        btn.addActionListener(e -> {
            frame.dispose();
            attaquemonstre();
            if(Game.heros.size()==0){
                defaite();
            }
            Game.boucle = false;
            frame.setVisible(false);
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(2000, 200));
        frame.pack();
        frame.setVisible(true);
    }
    public static void attaque(int a, int i) throws IOException, InterruptedException {
        switch (a){
            case 1 :
                Mage.attack(i);
                break;
            case 2 :
                Healer.attack(i);
                break;
            case 3 :
                Hunter.attack(i);
                break;
            case 4 :
                Warrior.attack(i);
                break;
        }
    }
    public static void attaquemonstre(){
        Fighter hero = Game.heros.get(Game.heros.size()-1);
        int life = hero.getLifePoints();
        Fighter monster = Game.monsters.get(0);
        hero.setLifePoints(life - monster.getAttPoints());
        if (hero.getLifePoints()<=0){
            Game.heros.remove(Game.heros.size() - 1);
            System.out.println("il reste "+ Game.heros.size()+ "héros");
        }else{
            System.out.println("il reste " + Game.heros.size() + "heros");
        }
    }
    public static void manger(int a, int i){
        switch (a){
            case 1 :
                Mage.manger(i);
                System.out.println("heal réussi mage");
                break;
            case 2 :
                Healer.manger(i);
                System.out.println("heal réussi healer");
                break;
            case 3 :
                Hunter.manger(i);
                System.out.println("heal réussi hunter");
                break;
            case 4 :
                Warrior.manger(i);
                System.out.println("heal warrior");
                break;
        }
    }
    public static void boire(int i){
        Fighter hero = Game.heros.get(i);
        if(Game.potions > 0){
            hero.setLifePoints(hero.getLifePoints() + 4);
            Game.potions-=1;}
        System.out.println("il reste " + Game.potions + "potions");
    }
    public static void defaite(){
        System.out.println("bien essayer, retente ta chance");
        Main.fin();
    }
}
