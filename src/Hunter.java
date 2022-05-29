import java.io.IOException;

public class Hunter extends Hero {
    public Hunter() {
        this.setLifePoints(5);
        this.setAttPoints(4);
        this.setArrows(100);
    }

    public boolean attack(Fighter enemy) {
        return enemy.receiveAttack(5);
    }

    protected int arrows;

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }
    public int getArrows(){
        return arrows;
    }
    public static boolean attack(int i) throws IOException, InterruptedException {
        Hunter hero = (Hunter) Game.heros.get(i);
        if (hero.getLifePoints() > 0) {
            if (hero.getArrows() > 0) {
                int k = Game.monsters.size() - 1;
                int att = hero.getAttPoints();
                Fighter monstre = Game.monsters.get(k);
                int life = monstre.getLifePoints();
                monstre.setLifePoints(life - att);
                System.out.println("attaque de Hunter");
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
                hero.setArrows(5);
                System.out.println(("des monstres, il en reste" + Game.monsters.size()));
            }
        return true;}else{
            return false;
        }
    }
    public static int manger(int i){
        Hunter hero = (Hunter) Game.heros.get(i);
        if(Game.lembas > 0){
            hero.setLifePoints(hero.getLifePoints() + 3);
            Game.lembas-=1;
            System.out.println("heal");
        }
        if(hero.getLifePoints()>7){
            hero.setLifePoints(7);
        }
        System.out.println("il reste " + Game.lembas + "lembas");
        return hero.getLifePoints();
    }
}

