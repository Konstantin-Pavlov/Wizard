public class Main {
    public static void main(String[] args) {
        // https://stepik.org/lesson/313241/step/2?unit=295758
        Wizard harryPotter = new Wizard("Harry Potter", "Gryffindor", 400, 200, 38);
        Wizard voldemort = new Wizard("Voldemort", "Slytherin", 800, 500, 10);
        Wizard albusDumbledore = new Wizard("Albus Dumbledore", "Gryffindor", 1000, 900, 34);
        Wizard gellertGrindelwald = new Wizard("Gellert Grindelwald", "Durmstrang", 900, 800, 23);
        Wizard dracoMalfoy = new Wizard("Draco Malfoy", "Slytherin", 500, 150, 28);
        Wizard mcgonagall = new Wizard("Minerva McGonagall", "Gryffindor", 820, 670, 33);
        Wizard cedricDiggory = new Wizard("Cedric Diggory", "Hufflepuff", 550, 20, 9);
        Wizard hermioneGranger = new Wizard("Hermione Granger", "Gryffindor", 350, 600, 37);
        Wizard severusSnape = new Wizard("Severus Snape", "Slytherin", 790, 710, 31);
        Wizard nevilleLongbottom = new Wizard("Neville Longbottom", "Gryffindor", 200, 80, 4);

        /* Incendio: - deals 70 damage to opponent's HP
         *           - costs 20 MP
         *           - does not restore HP of caster
         *           - does not restore MP of the caster
         *           - does not increase the caster's luck
         */
        Spell incendio = new Spell("incendio", true, 20, 0, 0, 0, 0);

        /* Felix felices:   - deals 0 damage to opponent's HP
         *                  - costs 170 MP
         *                  - restores 100 HP of caster
         *                  - does not restore MP of the caster
         *                  - increases the caster's luck by 1
         */
        Spell felixFelices = new Spell("felix felices", false, 170, 100, 0, 1, 0);

        /*
        we could "teach" Harry how to cast incendio by creating a Wizard object
        for Harry and a Spell object for indendio, then adding the Spell to his spells array:
        * */
        harryPotter.spells[0] = incendio;    // "teaching" Harry the spell, incendio

//        harryPotter.attack(voldemort, "incendio", 20, 70); // outdated

        // battle simulation
        // until one wizard defeats the other.
        /*
        We can simulate this with a while loop,
        keeping track of whose turn it is in battle (
        alternating between the two wizards dueling),
        and continuing to battle
        until either character's HP becomes less than or equal to 0.
        * */
        boolean isHarrysTurn = true;
        boolean harryRunOutOfmp = false;
        boolean voldemortRunOutOfmp = false;
        int incendioCost = 20;
        int sectumsempraCost = 100;
        int t = 20;
        while (harryPotter.hp > 0 && voldemort.hp > 0) {

            if(harryPotter.cantAttack(incendioCost)){
                harryRunOutOfmp = true;

            }

            if(voldemort.cantAttack(sectumsempraCost)){
                voldemortRunOutOfmp = true;

            }

            if(harryRunOutOfmp && voldemortRunOutOfmp){
                break;
            }

            if(isHarrysTurn){
//                harryPotter.incendio(voldemort);// outdated
                harryPotter.takeTurn(voldemort);
            }
            else{
//                voldemort.sectumsempra(harryPotter);// outdated
                voldemort.takeTurn(harryPotter);
            }

            harryPotter.printStatus();
            voldemort.printStatus();


            isHarrysTurn = !isHarrysTurn;    // flips whether or not is Harry's turn
        }

        if(harryRunOutOfmp){
            System.out.println("Harry is run out of magic points!");
        }

        if(voldemortRunOutOfmp){
            System.out.println("Voldemort is run out of magic points!");
        }


        if (harryPotter.hp > voldemort.hp ) {
            System.out.println("But Harry has saved Hogwarts!");
        }

        else {
            System.out.println("But The Dark Lord has vanquished the Boy Who Lived!");
        }




        /*
        harryPotter.incendio(voldemort);
        voldemort.sectumsempra(harryPotter);
        harryPotter.printStatus();
        voldemort.printStatus();
        */

        /*
        System.out.println();

        harryPotter.sectumsempra(dracoMalfoy);
        harryPotter.printStatus();
        dracoMalfoy.printStatus();*/



        /*
        cedricDiggory.reparo(); //Cedric Diggory couldn't cast reparo! Not enough MP.
        hermioneGranger.accioMP(); // Hermione Granger gathers some more magic!
        severusSnape.felixFelices(); //Severus Snape restores HP and increases luck!
        harryPotter.felixFelices(); // Harry Potter restores HP and increases luck!
        nevilleLongbottom.felixFelices(); // Neville Longbottom couldn't cast felix felices! Not enough MP.
        */


    }

}
