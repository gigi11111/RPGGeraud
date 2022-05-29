public class BasicEnemy extends Enemy {
    public BasicEnemy() {
        this.setLifePoints(15);
        this.setAttPoints(2);
    }
    public boolean attack(Fighter hero) {
        return hero.receiveAttack(1);
    }
}
