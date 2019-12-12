
package zombie_project;
//Coded by Michael Papka, Edited by Jeffrey Xiong, Zulkifl Mohammed, and Adam Maser
public class Human {

    private final String type;
    private int health;
    private int attack;
    private Weapon weapon;

    public Human(String type, int health, int attack, Weapon weapon) {
        this.type = type;
        this.health = health;
        this.attack = attack;
        this.weapon = weapon;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {return weapon;}
}