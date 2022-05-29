import java.io.IOException;

public class Warrior extends Hero {
    public Warrior() {
        this.setLifePoints(9);
        this.setAttPoints(1);
    }

    public static boolean attack(int i) throws IOException, InterruptedException {
        int k = Game.monsters.size() - 1;
        Warrior hero = (Warrior) Game.heros.get(i);
        if (hero.getLifePoints() > 0) {
            int att = hero.getAttPoints();
            Fighter monstre = Game.monsters.get(k);
            int life = monstre.getLifePoints();
            monstre.setLifePoints(life - att);
            System.out.println("attaque de warrior");
            if (life - att <= 0) {
                Game.monsters.remove(k);
                System.out.println("il reste " + Game.monsters.size() + "monstres");
            } else {
                System.out.println(("des monstres, il en reste" + Game.monsters.size()));
            }
            if (Game.monsters.size() == 0) {
                Victory.victory();
            }
            return true;
        }else {
            return false;
        }
    }
    public static int manger(int i){
        Warrior hero = (Warrior) Game.heros.get(i);
        if(Game.lembas > 0){
            hero.setLifePoints(hero.getLifePoints() + 3);
            Game.lembas-=1;
            System.out.println("heal");
        }
        if(hero.getLifePoints()>15){
            hero.setLifePoints(15);
        }
        System.out.println("il reste " + Game.lembas + "lembas");
        return hero.getLifePoints();
    }
}

