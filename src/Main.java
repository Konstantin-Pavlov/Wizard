public class Main {
    public static void main(String[] args) {
        // https://stepik.org/lesson/313241/step/2?unit=295758
        Wizard harryPotter = new Wizard("Harry Potter", "Gryffindor", 400, 200, 30);
        Wizard voldemort = new Wizard("Voldemort", "Slytherin", 800, 500, 10);
        Wizard albusDumbledore = new Wizard("Albus Dumbledore", "Gryffindor", 1000, 900, 34);
        Wizard gellertGrindelwald = new Wizard("Gellert Grindelwald", "Durmstrang", 900, 800, 23);
        Wizard dracoMalfoy = new Wizard("Draco Malfoy", "Slytherin", 500, 150, 28);
        Wizard mcgonagall = new Wizard("Minerva McGonagall", "Gryffindor", 820, 670, 33);
        Wizard cedricDiggory = new Wizard("Cedric Diggory", "Hufflepuff", 550, 20, 9);
        Wizard hermioneGranger = new Wizard("Hermione Granger", "Gryffindor", 350, 600, 37);
        Wizard severusSnape = new Wizard("Severus Snape", "Slytherin", 790, 710, 31);
        Wizard nevilleLongbottom = new Wizard("Neville Longbottom", "Gryffindor", 200, 80, 4);


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
                harryPotter.incendio(voldemort);
            }
            else{
                voldemort.sectumsempra(harryPotter);
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
