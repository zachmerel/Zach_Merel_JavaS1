import java.util.Random;

public class DiceDoubles {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        System.out.println("HERE COMES THE DICE!");
        int firstDie;
        int secondDie;
        int rollValue;

        firstDie = randomGenerator.nextInt(6) + 1;
        secondDie = randomGenerator.nextInt(6) + 1;
        rollValue = firstDie + secondDie;

        while(firstDie != secondDie) {
            System.out.println("Roll #1: " + firstDie);
            System.out.println("Roll #2: " + secondDie);
            System.out.println("The total is " + rollValue + "!");
            firstDie = randomGenerator.nextInt(6) + 1;
            secondDie = randomGenerator.nextInt(6) + 1;
            rollValue = firstDie + secondDie;

        }
        System.out.println("Roll #1: " + firstDie);
        System.out.println("Roll #2: " + secondDie);
        System.out.println("The total is " + rollValue + "!");
    }
}
