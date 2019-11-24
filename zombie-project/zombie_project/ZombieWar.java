package zombie_project;

import java.util.ArrayList;
import java.util.Random;

class ZombieWar {
    public static void main(String[] args) {
        ZombieWar newWar = new ZombieWar();
        newWar.generateObjects();
        newWar.runWar();
    }
//----------------------------PROGRAM SETUP-------------------------------------
    //create superclass arrays
    private ArrayList<Human> HumanList = new ArrayList<>();
    private ArrayList<Zombie> ZombieList = new ArrayList<>();

    //Create separate lists for each type of human
    //This will be used to get the correct output (i.e. Soldier 0; Child 2)
    private ArrayList<Child> ChildList = new ArrayList<>();
    private ArrayList<Teacher> TeacherList = new ArrayList<>();
    private ArrayList<Soldier> SoldierList = new ArrayList<>();

    //Create separate lists for each type of soldier
    private ArrayList<CommonInfect> CommonInfectList = new ArrayList<>();
    private ArrayList<Tank> TankList = new ArrayList<>();


    private void generateObjects() {
        Random random = new Random();

        //generate size of Human and Zombie Lists (1-20)
        int randomHumanNum = random.nextInt(20) + 1;
        int randomZombieNum = random.nextInt(20) + 1;

        //generate types of humans and add to human list and respective subclass list
        //also, the size of the subclass list is passed as a param to keep track of
        //the order of subclass objects. Basically hard-coding the order of subclasses
        //(since the arrays are never modified again)
        for (int i = 0; i < randomHumanNum; i++) {
            int type = random.nextInt(3) + 1;

            if (type == 1) {
                Child newChild = new Child(ChildList.size());
                HumanList.add(newChild);
                ChildList.add(newChild);
            } else if (type == 2) {
                Teacher newTeacher = new Teacher(TeacherList.size());
                HumanList.add(newTeacher);
                TeacherList.add(newTeacher);
            } else if (type == 3) {
                Soldier newSoldier = new Soldier(SoldierList.size());
                HumanList.add(newSoldier);
                SoldierList.add(newSoldier);
            }
        }

        //generate types of zombies and add to zombie list and respective subclass list
        //size of subclasses passed as parameters (see above)
        for (int i = 0; i < randomZombieNum; i++) {
            int type = random.nextInt(2) + 1;
            if (type == 1) {
                CommonInfect newCommonInfect = new CommonInfect(CommonInfectList.size());
                ZombieList.add(newCommonInfect);
                CommonInfectList.add(newCommonInfect);
            } else if (type == 2) {
                Tank newTank = new Tank(TankList.size());
                ZombieList.add(newTank);
                TankList.add(newTank);
            }
        }

        //output character descriptions
        System.out.println("We have " + randomHumanNum + " survivors trying to make it to safety (" + ChildList.size() + " children, " + TeacherList.size() + " teachers, " + SoldierList.size() + " soldiers)");
        System.out.println("But there are " + randomZombieNum + " zombies waiting for them (" + CommonInfectList.size() + " common infected, " + TankList.size() + " tanks)");
    }

    //controls war logic flow
    //calls to attack***() methods to execute attacks
    private void runWar() {
        while(!HumanList.isEmpty() && !ZombieList.isEmpty()) {

            //humans attack
            for (Human currentHuman : HumanList) {
                //attack each zombie
                for (int i = 0; i < ZombieList.size(); i++) {
                    //get current zombie
                    Zombie currentZombie = ZombieList.get(i);
                    //attack and handle whether zombie is alive or dead
                    if (!attackZombie(currentHuman, currentZombie)) {
                        //System.out.println(currentHuman.getType() + " killed " + currentZombie.getType());
                        ZombieList.remove(currentZombie);
                    }
                }
            }

            //zombies attack
            for (Zombie currentZombie : ZombieList) {
                //attack each human
                for (int i = 0; i < HumanList.size(); i++) {
                    //get current human
                    Human currentHuman = HumanList.get(i);
                    //attack and handle whether zombie is alive or dead
                    if (!attackHuman(currentZombie, currentHuman)) {
                        //System.out.println(currentZombie.getType() + " killed " + currentHuman.getType());
                        HumanList.remove(currentHuman);
                    }
                }
            }
        }
        //output results of war
        if (HumanList.isEmpty()) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("It seems " + HumanList.size() + " made it to safety.");
        }
    }

    //returns true if zombie is alive, false if dead
    private boolean attackZombie(Human human, Zombie zombie) {
        //do attack
        zombie.setHealth(zombie.getHealth()-human.getAttack());
        //get and test result of attack
        return zombie.getHealth() > 0;
    }

    //returns true if human is alive, false if dead
    private boolean attackHuman(Zombie zombie, Human human) {
        //do attack
        human.setHealth(human.getHealth()-zombie.getAttack());
        //get and test result of attack
        return human.getHealth() > 0;
    }
} //end of ZombieWar