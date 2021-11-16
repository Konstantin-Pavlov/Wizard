import java.util.Random;

class Wizard {
    String name;
    String house;
    int hp;
    int mp;
    int luck;

    Wizard(String name, String house, int hp, int mp, int luck) {
        this.name = name;
        this.house = house;
        this.hp = hp;
        this.mp = mp;
        this.luck = luck;
    }

    // Complete the method body below. It should not include a call to printStatus()
    //Harry Potter casts incendio and Voldemort takes 70 damage!
    //Harry Potter couldn't cast sectumsempra! Not enough MP.
    void attack(Wizard opponent, String spell, int mpCost, int attackPower) {
        if(mpCost > this.mp){
            System.out.println(this.name + " couldn't cast " + spell + "! Not enough MP.");
        }
        else{
            this.mp -= mpCost;
            if(opponent.evades()){
                System.out.println(opponent.name + " dodges " + this.name + "!");
            }
            else{
                opponent.hp -= attackPower;
                System.out.println(this.name + " casts " + spell + " and " +
                        opponent.name + " takes " + attackPower + " damage!");
            }
        }
    }

    /* Generates a random number based on the Wizard's luck and returns true
   if it's sufficiently large */
    boolean evades() {
        Random rand = new Random(); //instance of random class
        int upperbound = 15;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
//        System.out.println(int_random);
        return this.luck * int_random > 100;
    }

    void printStatus() {
        System.out.println("Character: " + this.name);
        System.out.println("HP: " + this.hp + ", MP: " + this.mp);
        System.out.println("=================================================");
    }
}