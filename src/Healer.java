import java.io.IOException;

public class Healer extends SpellCaster {
    public Healer() {
        this.setLifePoints(4);
        this.setAttPoints(1);
        this.setManaPoints(100);
    }

    public boolean attack(Fighter enemy) {

        return enemy.receiveAttack(5);

    }
    public static boolean attack(int i) throws IOException, InterruptedException {
        Healer hero = (Healer) Game.heros.get(i);
        if(hero.getLifePoints()>0){
        if(hero.getManaPoints() >= 5 ){
            hero.setManaPoints(hero.getManaPoints()-5);
            int k = Game.monsters.size() - 1;
            int att = hero.getAttPoints();
            Fighter monstre = Game.monsters.get(k);
            int life = monstre.getLifePoints();
            monstre.setLifePoints(life - att);
            Fighter herodevant = Game.heros.get(Game.heros.size()-1);
            herodevant.setLifePoints(herodevant.getLifePoints() + 3);
            System.out.println("attaque de Healer");
            if (life - att <= 0) {
                Game.monsters.remove(k);
                System.out.println("il reste " + Game.monsters.size() + "monstres");
            } else {
                System.out.println(("des monstres, il en reste" + Game.monsters.size()));
            }if(Game.monsters.size()==0){
                Victory.victory();
            }
        }else{
            hero.setManaPoints(10);
            System.out.println(("des monstres, il en reste" + Game.monsters.size()));
        }return true;}else{
            return false;
        }
    }
    public static int manger(int i){
        Healer hero = (Healer) Game.heros.get(i);
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
