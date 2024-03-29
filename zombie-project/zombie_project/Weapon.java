package zombie_project;
import java.util.Random;

public class Weapon {
    private int damage;
    private int accuracy; //higher is better -- use int between 2 and 5
    private String name;

    public Weapon(int damage, int accuracy, String name) {
        this.damage = damage;
        this.accuracy = accuracy;
        this.name = name;
    }

    //attack method
    public boolean attack(Zombie zombie) {
        Random getNum = new Random();
        int randNum = getNum.nextInt(11);
        // DEBUG -- System.out.println("Number being used: " + randNum);
        if (randNum % accuracy == 0) {
            //DEBUG -- System.out.println("result of mod: " + randNum % accuracy);
            return false;
        } else {
            //DEBUG -- System.out.println("Weapon being used: " + this.getName());
            zombie.setHealth(zombie.getHealth() - this.damage);
            return true;
        }
    }

    public String getName() {return name;}
}
