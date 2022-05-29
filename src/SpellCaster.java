import java.io.IOException;

public abstract class SpellCaster extends Hero {

    protected int manaPoints;

    public static boolean attack(int i) throws IOException, InterruptedException {
return false;
    }

    public void setManaPoints(int mana){
        this.manaPoints = mana;
    }
    public int getManaPoints(){
        return manaPoints;
    }

}
