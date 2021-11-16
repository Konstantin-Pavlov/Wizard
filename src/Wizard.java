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

    //checking if the wizard is able to attack
    boolean cantAttack(int mpCost){
        return this.mp <= mpCost;
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

    /* Casts the spell, incendio, at opponent. Details:
     * name: incendio
     * MP cost: 20
     * Attack power: 70
     */
    void incendio(Wizard opponent) {
        // calling the attack method with the proper arguments for this spell.
        attack(opponent, "incendio", 20, 70);


    }

    /* Casts the spell, sectumsempra, at opponent. Details:
     * name: sectumsempra
     * MP cost: 100
     * Attack power: 200
     */
    void sectumsempra(Wizard opponent) {
        // calling the attack method with the proper arguments for this spell.

        attack(opponent, "sectumsempra", 100, 200);
    }

    /* Complete the three method bodies below */

    /* Casts the spell, reparo, to restore HP.
     * Restores 100 HP for this Wizard
     * MP cost: 50
     */
    void reparo() {
        int hpIncrease = 100;
        int mpCost = 50;
        String name = "reparo";

        /* TODO: if this Wizard has enough MP, then:
         *       - increase this Wizard's hp by 100
         *       - decrease this Wizard's mp by 50
         *       - print message
         *       if not:
         *       - print other message (see sample output)
         */
        if(this.mp > mpCost){
            this.hp += hpIncrease;
            this.mp -= mpCost;
            System.out.println(this.name + " takes a moment to heal their wounds!");
        }
        else{
            System.out.println(this.name + " couldn't cast reparo! Not enough MP.");
        }


    }

    /* Casts the spell, accio, to summon more MP.
     * Restores 150 MP for this Wizard
     * MP Cost: 0
     */
    void accioMP() {
        String name = "accio mp";
        int mpIncrease = 150;
        this.mp += mpIncrease;
        /* TODO: - increase this Wizard's mp by 150 and print message */
        System.out.println(this.name + " gathers some more magic!");

    }

    /* Casts the spell, felix felices, to restore HP and increase luckiness.
     * Restores 100 HP for this Wizard and increases luck by 1
     * MP Cost: 170
     */
    void felixFelices() {
        int hpIncrease = 100;
        int luckIncrease = 1;
        int mpCost = 170;
        String name = "felix felices";


        /* TODO: if this Wizard has enough MP, then:
         *       - increase this Wizard's hp by 100
         *       - increase this Wizard's luck by 1
         *       - decrease this Wizard's mp by 170
         *       - print message
         *       if not:
         *       - print other message (see sample output)
         */

        if(this.mp > mpCost){
            this.hp += hpIncrease;
            this.luck += luckIncrease;
            this.mp -= mpCost;
            System.out.println(this.name + " restores HP and increases luck!");
        }
        else{
            System.out.println(this.name + " couldn't cast felix felices! Not enough MP.");
        }

    }

    /* Generates a random number based on the Wizard's luck and returns true
   if it's sufficiently large */
    /*
    The authors of the course did not provide an implementation of the method So I came up with my own
    * */
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