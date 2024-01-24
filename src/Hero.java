import java.util.*;
public class Hero {
    // Properties
    private String name;
    private int hitPoints;

    // Constructors
    public Hero(String name) {
        this.name = name;
        hitPoints = 100;
    }

    // Methods
    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent) {
        Random random = new Random();
        double num = random.nextDouble();

        if (num >= 0.5) {
            this.hitPoints -= 10;
        }
        else {
            opponent.hitPoints -= 10;
        }
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        this.fightUntilTheDeathHelper(opponent);
        return (this.getName() + ": " + this.getHitPoints() + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int heroWin = 0;
        int oppWin = 0;

        for (int i = 0; i < n; i++) {
            this.fightUntilTheDeathHelper(opponent);
            if (this.getHitPoints() == 0) {
                oppWin += 1;
            }
            else {
                heroWin += 1;
            }
            this.senzuBean();
            opponent.senzuBean();
        }
        int[] array = {heroWin, oppWin};
        return array;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] array = nFightsToTheDeathHelper(opponent, n);

        if (array[0] > array[1]) {
            return (this.getName() + ": " + array[0] + " wins\n" + opponent.getName() + ": " + array[1] + " wins\n" + this.getName() + " wins!");
        }
        else if (array[1] > array[0]) {
            return (this.getName() + ": " + array[0] + " wins\n" + opponent.getName() + ": " + array[1] + " wins\n" + opponent.getName() + " wins!");
        }
        else {
            return (this.getName() + ": " + array[0] + " wins\n" + opponent.getName() + ": " + array[1] + " wins\nOMG! It was actually a draw!");
        }
    }

    public void dramaticFightToTheDeath(Hero opponent) {
        while (this.hitPoints > 0 && opponent.hitPoints > 0) {
            this.attack(opponent);
            System.out.println(this.getName() + ": " + this.getHitPoints() + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
        }
    }
}
