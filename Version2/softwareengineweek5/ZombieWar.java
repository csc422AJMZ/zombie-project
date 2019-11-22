package softwareengineweek5;

import java.util.ArrayList;
import java.util.Random;

class ZombieWar {
    public static void main(String[] args) {
        ZombieWar newWar = new ZombieWar();
        newWar.generateObjects();
        newWar.runWar();
    }
//----------------------------PROGRAM SETUP-------------------------------------
    ArrayList<Human> HumanList = new ArrayList<>();
    ArrayList<Zombie> ZombieList = new ArrayList<>();

    //Create separate lists for each type of human
    //This will be used to get the correct output (i.e. Soldier 0; Child 2)
    ArrayList<Child> ChildList = new ArrayList<>();
    ArrayList<Teacher> TeacherList = new ArrayList<>();
    ArrayList<Soldier> SoldierList = new ArrayList<>();
    ArrayList<CommonInfect> CommonInfectList = new ArrayList<>();
    ArrayList<Tank> TankList = new ArrayList<>();


    public void generateObjects() {
        Random random = new Random();

        int randomHumanNum = random.nextInt(20) + 1;
        int randomZombieNum = random.nextInt(20) + 1;

        for (int i = 0; i < randomHumanNum; i++) {
            int type = random.nextInt(3) + 1;

            if (type == 1) {
                Child myHuman = new Child("Child", 20, 2);
                HumanList.add(myHuman);
            } else if (type == 2) {
                Teacher myHuman = new Teacher("Teacher", 50, 5);
                HumanList.add(myHuman);
            } else if (type == 3) {
                Soldier myHuman = new Soldier("Soldier", 100, 10);
                HumanList.add(myHuman);
            }

        }

        for (int i = 0; i < randomZombieNum; i++) {
            int type = random.nextInt(2) + 1;

            if (type == 1) {
                CommonInfect myZombie = new CommonInfect("CommonInfect", 30, 5);
                ZombieList.add(myZombie);
            } else if (type == 2) {
                Tank myZombie = new Tank("Tank", 150, 20);
                ZombieList.add(myZombie);
            }

        }

        for (int i = 0; i < HumanList.size(); i++) {

            if (HumanList.get(i).getType().equals("Child")) {
                Child currentHuman = (Child) HumanList.get(i);
                ChildList.add(currentHuman);
            } else if (HumanList.get(i).getType().equals("Teacher")) {
                Teacher currentHuman = (Teacher) HumanList.get(i);
                TeacherList.add(currentHuman);
            } else if (HumanList.get(i).getType().equals("Soldier")) {
                Soldier currentHuman = (Soldier) HumanList.get(i);
                SoldierList.add(currentHuman);
            }
        }
        for (int i = 0; i < ZombieList.size(); i++) {

            if (ZombieList.get(i).getType().equals("CommonInfect")) {
                CommonInfect currentZombie = (CommonInfect) ZombieList.get(i);
                CommonInfectList.add(currentZombie);
            } else if (ZombieList.get(i).getType().equals("Tank")) {
                Tank currentZombie = (Tank) ZombieList.get(i);
                TankList.add(currentZombie);
            }
        }

        System.out.println("We have " + randomHumanNum + " survivors trying to make it to safety (" + ChildList.size() + " children, " + TeacherList.size() + " teachers, " + SoldierList.size() + " soldiers)");
        System.out.println("But there are " + randomZombieNum + " zombies waiting for them (" + CommonInfectList.size() + " common infected, " + TankList.size() + " tanks)");
    }

    public void runWar() {
        boolean looper = true;
        while (looper) {
            if (HumanList.isEmpty() || ZombieList.isEmpty()) {
                looper = false;
            } else {
                for (int i = 0; i < HumanList.size(); i++) {

                    if (HumanList.get(i).getType().equals("Child")) {

                        Child currentHuman = (Child) HumanList.get(i);
                        int currentHumanAttack = currentHuman.getAttack();
                        for (int j = 0; j < ZombieList.size(); j++) {

                            if (ZombieList.get(j).getType().equals("CommonInfect")) {

                                CommonInfect currentZombie = (CommonInfect) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Child " + ChildList.indexOf(currentHuman) + " killed CommonInfect " + CommonInfectList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;
                                }
                            } else if (ZombieList.get(j).getType().equals("Tank")) {

                                Tank currentZombie = (Tank) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Child " + ChildList.indexOf(currentHuman) + " killed Tank " + TankList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;

                                }
                            }

                        }
                    } else if (HumanList.get(i).getType().equals("Teacher")) {

                        Teacher currentHuman = (Teacher) HumanList.get(i);
                        int currentHumanAttack = currentHuman.getAttack();

                        for (int j = 0; j < ZombieList.size(); j++) {

                            if (ZombieList.get(j).getType().equals("CommonInfect")) {

                                CommonInfect currentZombie = (CommonInfect) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Teacher " + TeacherList.indexOf(currentHuman) + " killed CommonInfect " + CommonInfectList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;
                                }
                            } else if (ZombieList.get(j).getType().equals("Tank")) {

                                Tank currentZombie = (Tank) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Teacher " + TeacherList.indexOf(currentHuman) + " killed Tank " + TankList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;
                                }
                            }

                        }
                    } else if (HumanList.get(i).getType().equals("Soldier")) {

                        Soldier currentHuman = (Soldier) HumanList.get(i);
                        int currentHumanAttack = currentHuman.getAttack();

                        for (int j = 0; j < ZombieList.size(); j++) {

                            if (ZombieList.get(j).getType().equals("CommonInfect")) {

                                CommonInfect currentZombie = (CommonInfect) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Soldier " + SoldierList.indexOf(currentHuman) + " killed CommonInfect " + CommonInfectList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;
                                }
                            } else if (ZombieList.get(j).getType().equals("Tank")) {

                                Tank currentZombie = (Tank) ZombieList.get(j);
                                int currentZombieHealth = currentZombie.getHealth();

                                currentZombieHealth = currentZombieHealth - currentHumanAttack;
                                currentZombie.setHealth(currentZombieHealth);

                                if (currentZombieHealth <= 0) {
                                    System.out.println("Soldier " + SoldierList.indexOf(currentHuman) + " killed Tank " + TankList.indexOf(currentZombie));
                                    ZombieList.remove(j);
                                    j = j - 1;
                                }
                            }

                        }
                    }

                }

                for (int i = 0; i < ZombieList.size(); i++) {

                    if (ZombieList.get(i).getType().equals("CommonInfect")) {

                        CommonInfect currentZombie = (CommonInfect) ZombieList.get(i);
                        int currentZombieAttack = currentZombie.getAttack();
                        for (int j = 0; j < HumanList.size(); j++) {

                            if (HumanList.get(j).getType().equals("Child")) {

                                Child currentHuman = (Child) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("CommonInfect " + CommonInfectList.indexOf(currentZombie) + " killed Child " + ChildList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            } else if (HumanList.get(j).getType().equals("Teacher")) {

                                Teacher currentHuman = (Teacher) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("CommonInfect " + CommonInfectList.indexOf(currentZombie) + " killed Teacher " + TeacherList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            } else if (HumanList.get(j).getType().equals("Soldier")) {

                                Soldier currentHuman = (Soldier) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("CommonInfect " + CommonInfectList.indexOf(currentZombie) + " killed Soldier " + SoldierList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            }

                        }
                    } else if (ZombieList.get(i).getType().equals("Tank")) {

                        Tank currentZombie = (Tank) ZombieList.get(i);
                        int currentZombieAttack = currentZombie.getAttack();

                        for (int j = 0; j < HumanList.size(); j++) {

                            if (HumanList.get(j).getType().equals("Child")) {

                                Child currentHuman = (Child) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("Tank " + TankList.indexOf(currentZombie) + " killed Child " + ChildList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            } else if (HumanList.get(j).getType().equals("Teacher")) {

                                Teacher currentHuman = (Teacher) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("Tank " + TankList.indexOf(currentZombie) + " killed Teacher " + TeacherList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            } else if (HumanList.get(j).getType().equals("Soldier")) {

                                Soldier currentHuman = (Soldier) HumanList.get(j);
                                int currentHumanHealth = currentHuman.getHealth();

                                currentHumanHealth = currentHumanHealth - currentZombieAttack;
                                currentHuman.setHealth(currentHumanHealth);

                                if (currentHumanHealth <= 0) {
                                    System.out.println("Tank " + TankList.indexOf(currentZombie) + " killed Soldier " + SoldierList.indexOf(currentHuman));
                                    HumanList.remove(j);
                                    j = j - 1;
                                }
                            }

                        }
                    }

                }
            }
        }

        if (HumanList.isEmpty()) {
            System.out.println("None of the survivors made it.");
        } else {
            System.out.println("It seems " + HumanList.size() + " made it to safety.");
        }
    }

} //End of ZombieGame
