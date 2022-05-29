import org.junit.jupiter.api.Test ;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Gametest {
    @Test
    void testVieHunter() throws IOException, InterruptedException {
        Hunter hero = new Hunter();
        Game.heros.add(hero);
        hero.setLifePoints(-1);
        assertFalse(Hunter.attack(1));
    }
    @Test
    void testVieWarrior() throws IOException, InterruptedException {
        Warrior hero = new Warrior();
        Game.heros.add(hero);
        hero.setLifePoints(-1);
        assertFalse(Warrior.attack(1));
    }
    @Test
    void testVieMage() throws IOException, InterruptedException {
        Mage hero = new Mage();
        Game.heros.add(hero);
        hero.setLifePoints(-1);
        assertFalse(Mage.attack(1));
    }
    @Test
    void testVieHealer() throws IOException, InterruptedException {
        Healer hero = new Healer();
        Game.heros.add(hero);
        hero.setLifePoints(-1);
        assertFalse(Healer.attack(1));
    }
    @Test
    void testPvMage(){
        //tout héros peux attendre 7 pv. aucun ne doit pouvoir les dépasser
        Mage hero = new Mage();
        Game.heros.add(hero);
        hero.setLifePoints(8);
        Mage.manger(1);
        assertFalse(hero.getLifePoints()>5);
    }
    @Test
    void testPvHealer(){
        //tout héros peux attendre 7 pv. aucun ne doit pouvoir les dépasser
        Healer hero = new Healer();
        Game.heros.add(hero);
        hero.setLifePoints(8);
        Healer.manger(1);
        assertFalse(hero.getLifePoints()>7);
    }
    @Test
    void testPvHunter(){
        //tout héros peux attendre 7 pv. aucun ne doit pouvoir les dépasser
        Hunter hero = new Hunter();
        Game.heros.add(hero);
        hero.setLifePoints(8);
        Hunter.manger(1);
        assertFalse(hero.getLifePoints()>7);
    }
    @Test
    void testPvWarrior(){
        Warrior hero = new Warrior();
        Game.heros.add(hero);
        hero.setLifePoints(20);
        Warrior.manger(1);
        assertFalse(hero.getLifePoints()>15);
    }
}
