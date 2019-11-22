package softwareengineweek5;
//Coded by Michael Papka, Editied by Jeffrey Xiong, Zulkifl Mohammed

public class Zombie {

    private String type;
    private int health;
    private int attack;

    public Zombie(String type, int health, int attack) {
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
