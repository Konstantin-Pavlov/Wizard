import java.util.Arrays;
import java.util.Random;

class Wizard {
    String name;
    String house;
    int hp;
    int mp;
    int luck;
    Spell[] spells;    // represents the list of spells that a Wizard has learned to cast

    /* All wizards have a starting maximum of 3 Spells they can know(length of spells must be 3)
     * At first, a Wizard knows no Spells (all elements of spells are null)    */
    Wizard(String name, String house, int hp, int mp, int luck) {
        this.name = name;
        this.house = house;
        this.hp = hp;
        this.mp = mp;
        this.luck = luck;
        this.spells = new Spell[3];  // elements start as {null, null, null}
    }


    /* If you find a null element in this.spells, then assign toLearn
     * to that element. If there are multiple null elements in it, toLearn
     * should be assigned to the first (lowest) index encountered.
     *
     * For example, if all three elements are null, then calling
     * learn should assign toLearn to the lowest index, 0. If
     * index 0 and index 2 are null, then learn should  assign
     * toLearn to index 1 (the lowest index that is null).

     *  In either case, print out a message that matches the format in
     *  the Sample Output.
     */
    void learn(Spell toLearn) {
        boolean hasLearned = false;
        for(int i = 0; i < spells.length; i++){
            if(spells[i] == null){
                spells[i] = toLearn;
                hasLearned = true;
                break;
            }
        }
        if(hasLearned) System.out.println(name + " learned how to cast " + toLearn.name + "!");
        else System.out.println(name + " can't learn any more spells!");
    }

    /* Implements a Wizard "forgetting" all spells that they know
     * All elements in this.spells should be set to null
     */
    void obliviate() {
        /*
        for(int i = 0; i < spells.length; i++){
            spells[i] = null;
        }
        */
        // another way
        Arrays.fill(spells, null);
        System.out.println("All spells are forgotten!");
    }

    /* Implements a Wizard "forgetting" any spell with the name toUnlearn
     * All elements in this.spells whose name is equal to unLearn should
     * be set to null.
     */
    void obliviateByName(String toUnlearn) {
        boolean found = false;
        for(int i = 0; i < spells.length; i++){
            if(spells[i] != null && spells[i].name.equals(toUnlearn)){
                spells[i] = null;
                // not using break because there are could be similar spells in the spells array
                found = true;
            }
        }
        if (found) {
            System.out.println(toUnlearn + " has been forgotten!");
        }
        else {
            System.out.println("There wasn't spell like that!");
        }

    }

    //  method for printing this wizard's known spells
    void printKnownSpells(){
        //Known spells' names: {incendio, felix felices, null}
        System.out.print("Known spells' names: {");
        for (int i = 0; i < spells.length; i++) {
            if(spells[i] != null) System.out.print(i == spells.length - 1 ? spells[i].name + "}\n" : spells[i].name + ", ");
            else System.out.print(i == spells.length - 1 ? spells[i] + "}\n" : spells[i] + ", ");
        }
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

    void takeTurn(Wizard opponent) {
/*

    if: if this Wizard's mp is less than 50, this casts accioMP to restore MP
    else if: otherwise, if this's hp is less than 100, this casts reparo to restore HP
    else: otherwise, there is a 50% chance that this will cast incendio at opponent and a 50% chance that this will     cast sectumsempra at opponent

*/
        if(mp < 50) {
            accioMP();
        }
        else if (hp < 100) {
            reparo();
        }
        else {
            // the next line gets a random number between 0.0 and 1.0
        /*
        If num is less than or equal to 0.5, this should cast incendio and if not,
        this should cast sectumsempra at opponent
        */
            double num = getRandomDouble();
            if (num <= 0.5) {
                incendio(opponent);
            }
            else {
                sectumsempra(opponent);
            }
        }
    }

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

    // getting random number between 0 and 1
    private static double getRandomDouble() {
        Random r = new Random();
        return r.nextDouble();
    }

    void printStatus() {
        System.out.println("Character: " + this.name);
        System.out.println("HP: " + this.hp + ", MP: " + this.mp);
        System.out.println("=================================================");
    }
}