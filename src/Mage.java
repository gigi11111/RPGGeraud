import java.io.IOException;

public class Mage extends SpellCaster {
    public Mage() {
        this.setLifePoints(3);
        this.setAttPoints(7);
        this.setManaPoints(50);
    }
    public static boolean attack(int i) throws IOException, InterruptedException {
        Mage hero = (Mage) Game.heros.get(i);
        if (hero.getLifePoints()>0) {
            if (hero.getManaPoints() > 0) {
                hero.setManaPoints(hero.getManaPoints()-1);
                int k = Game.monsters.size() - 1;
                int att = hero.getAttPoints();
                Fighter monstre = Game.monsters.get(k);
                int life = monstre.getLifePoints();
                monstre.setLifePoints(life - att);
                System.out.println("attaque de Mage");
                if (life - att <= 0) {
                    Game.monsters.remove(k);
                    System.out.println("il reste " + Game.monsters.size() + "monstres");
                } else {
                    System.out.println(("des monstres, il en reste" + Game.monsters.size()));
                }
                if (Game.monsters.size() == 0) {
                    Victory.victory();
                }
            } else {
                hero.setManaPoints(5);
                System.out.println(("des monstres, il en reste" + Game.monsters.size()));
            }
        return true;}else{return false;}
    }
    public static int manger(int i){
        Mage hero = (Mage) Game.heros.get(i);
        System.out.println("il y a "+ Game.lembas + "lembas");
        if(Game.lembas > 0){
            hero.setLifePoints(hero.getLifePoints() + 3);
            Game.lembas-=1;
            System.out.println("heal");
        }
        if(hero.getLifePoints()>5){
            hero.setLifePoints(5);
        }
        System.out.println("il reste " + Game.lembas + "lembas");
        return hero.getLifePoints();
    }
}
