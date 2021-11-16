import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // https://stepik.org/lesson/313241/step/2?unit=295758
        Wizard harryPotter = new Wizard("Harry Potter", "Gryffindor", 400, 200, 45);
        Wizard voldemort = new Wizard("Voldemort", "Slytherin", 800, 500, 10);
        Wizard albusDumbledore = new Wizard("Albus Dumbledore", "Gryffindor", 1000, 900, 34);
        Wizard gellertGrindelwald = new Wizard("Gellert Grindelwald", "Durmstrang", 900, 800, 23);
        Wizard dracoMalfoy = new Wizard("Draco Malfoy", "Slytherin", 500, 150, 28);


//        harryPotter.attack(voldemort, "incendio", 20, 70); // outdated

        harryPotter.incendio(voldemort);
        harryPotter.printStatus();
        voldemort.printStatus();

        System.out.println();

        harryPotter.sectumsempra(dracoMalfoy);
        harryPotter.printStatus();
        dracoMalfoy.printStatus();


    }

}
