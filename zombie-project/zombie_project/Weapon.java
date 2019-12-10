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

    public void attack(Human human) {
        Random getNum = new Random();
        int randNum = getNum.nextInt(11);
        if (randNum % accuracy == 0) {
            System.out.println("The " + this.name + " missed!");
        } else {
            human.setHealth(human.getHealth() - this.damage);
        }
    }
    public void attack(Zombie zombie) {
        Random getNum = new Random();
        int randNum = getNum.nextInt(11);
        //DEBUG
        //System.out.println(randNum);
        if (randNum % accuracy == 0) {
            System.out.println("The " + this.name + " missed!");
        } else {
            zombie.setHealth(zombie.getHealth() - this.damage);
        }
    }

    public String getName() {return name;}
}
