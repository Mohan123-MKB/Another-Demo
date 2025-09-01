
import java.util.*;
// Interface (contract for all playable characters)
interface Playable {
    void attack();
}
// Abstract Class (base for all characters)
abstract class GameCharacter implements Playable {
    private String name;
    private int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    // Encapsulation (private fields with getters/setters)
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    // Common method for all
    public void displayInfo() {
        System.out.println(getName() + " has " + getHealth() + " HP");
    }
}
// Subclass 1: Warrior
class Warrior extends GameCharacter {
    public Warrior(String name, int health) {
        super(name, health);
    }

    // Polymorphism (different attack)
    @Override
    public void attack() {
        System.out.println(getName() + " swings a sword ⚔️!");
    }
}
// Subclass 2: Mage
class Mage extends GameCharacter {
    public Mage(String name, int health) {
        super(name, health);
    }

    // Polymorphism (different attack)
    @Override
    public void attack() {
        System.out.println(getName() + " casts a fireball 🔥!");
    }
}
// Main Game Application
public class GameApp {
    public static void main(String[] args) {
        // Using Collections to store characters
        List<GameCharacter> players = new ArrayList<>();
        players.add(new Warrior("Arjun", 100));
        players.add(new Mage("Merlin", 80));

        // Gameplay simulation
        for (GameCharacter player : players) {
            player.displayInfo();
            player.attack();
            System.out.println("------------");
        }
    }
}
//Output
Arjun has 100 HP
Arjun swings a sword ⚔️!
------------
Merlin has 80 HP
Merlin casts a fireball 🔥!
------------


// Encapsulation → name, health are private
// Inheritance → Warrior and Mage extend GameCharacter
// Polymorphism → Different attack() methods
// Abstraction → GameCharacter is abstract
// Interface → Playable contract
// Collections → List<GameCharacter> to manage players
