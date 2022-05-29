import java.io.IOException;

public abstract class Fighter {

    private int lifePoints;
    private int attPoints;
    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }

    //    public abstract boolean attack(Fighter fighter);
    public static boolean attack(int i) throws IOException, InterruptedException {return false; }

    public boolean receiveAttack(int lifePoints) {
        this.lifePoints -= lifePoints;
        return this.lifePoints <= 0; // Vrai si le combattant est mort
    }

    public void setAttPoints(int attPoints) {
        this.attPoints = attPoints;
    }

    public int getAttPoints() {
        return attPoints;
    }

}
