
package zombie_project;
//Coded by Michael Papka, Edited by Jeffrey Xiong, Zulkifl Mohammed, and Adam Maser
public class Human {

    private final String type;
    private int health;
    private int attack;

    public Human(String type, int health, int attack) {
        this.type = type;
        this.health = health;
        this.attack = attack;
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

    public int getAttack() {
        return attack;
    }
}