//package softwareengineweek5;
//Coded by Michael Papka, Editied by Jeffrey Xiong, Zulkifl Mohammed

package softwareengineweek5;

class CommonInfect extends Zombie {

    private int health;
    private int attack;

    public CommonInfect(String type, int health, int attack) {
        super(type);
        this.health = 30;
        this.attack = 5;
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