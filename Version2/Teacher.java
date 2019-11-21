//Coded by Michael Papka, Editied by Jeffrey Xiong, Zulkifl Mohammed


class Teacher extends Human {

    private int health;
    private int attack;

    public Teacher(String type, int health, int attack) {
        super(type);
        this.health = 50;
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
