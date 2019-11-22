package softwareengineweek5;//package softwareengineweek5;
//Coded by Michael Papka, Editied by Jeffrey Xiong, Zulkifl Mohammed


class Soldier extends Human {

    private int health;
    private int attack;

    public Soldier(String type, int health, int attack) {
        super(type);
        this.health = 100;
        this.attack = 10;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @param attack the attack to set
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

}
