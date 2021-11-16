import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // https://stepik.org/lesson/313241/step/2?unit=295758
        Wizard harryPotter = new Wizard("Harry Potter", "Gryffindor", 400, 200, 45);
        Wizard voldemort = new Wizard("Voldemort", "Slytherin", 800, 500, 10);

        harryPotter.attack(voldemort, "incendio", 20, 70);

        harryPotter.printStatus();
        voldemort.printStatus();



    }

}
