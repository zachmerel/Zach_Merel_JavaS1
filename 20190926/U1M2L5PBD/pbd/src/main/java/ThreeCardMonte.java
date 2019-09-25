import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        int randomCard;
        Random randomGenerator = new Random();
        randomCard = randomGenerator.nextInt(3) + 1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.");
        System.out.println(" ");
        System.out.println("Which one is the ace?");
        System.out.println(" ");
        System.out.println("##  ##  ##");
        System.out.println("##  ##  ##");
        System.out.println("1   2   3");

        int playerGuess = Integer.parseInt(scanner.nextLine());

        if(playerGuess == randomCard && randomCard ==1){
            System.out.println("AA  ##  ##");
            System.out.println("AA  ##  ##");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }else if(playerGuess == randomCard && randomCard ==2){
            System.out.println("##  AA  ##");
            System.out.println("##  AA  ##");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }else if(playerGuess == randomCard && randomCard ==3){
            System.out.println("##  ##  AA");
            System.out.println("##  ##  AA");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        }
        else if(playerGuess != randomCard && randomCard ==3){
            System.out.println("##  ##  AA");
            System.out.println("##  ##  AA");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.");
        }else if(playerGuess != randomCard && randomCard ==2){
            System.out.println("##  AA  ##");
            System.out.println("##  AA  ##");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 2.");
        }else if(playerGuess != randomCard && randomCard ==1){
            System.out.println("AA  ##  ##");
            System.out.println("AA  ##  ##");
            System.out.println("1   2   3");
            System.out.println(" ");
            System.out.println("Ha! Fast Eddie wins again! The ace was card number 1.");
        }
    }
}
