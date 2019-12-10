package zombie_project;
//Coded by Michael Papka, Edited by Jeffrey Xiong, Zulkifl Mohammed


class Soldier extends Human {

    public Soldier(int rank, Weapon weapon) {
        super(("Soldier " + rank), 100, 10, weapon);
    }
}
