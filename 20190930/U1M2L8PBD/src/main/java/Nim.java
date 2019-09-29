import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        int pile1 = 3;
        int pile2 = 3;
        int pile3 = 3;
        int pileSum = pile1 + pile2 + pile3;
        int userTurnCount = 0;
        String userName1;
        String userName2;
        String currentPlayer = "";


        Scanner scanner = new Scanner(System.in);


        //gets the names of the players
        System.out.print("Player 1, enter your name: ");
        userName1 = scanner.nextLine();
        System.out.print("Player 2, enter your name: ");
        userName2 = scanner.nextLine();
        System.out.println(" ");



        while (pileSum > 1) {
            System.out.println(" ");

            //determines who is player one and player two
            if (userTurnCount % 2 == 0) {
                currentPlayer = userName1;
            } else if (userTurnCount % 2 > 0) {
                currentPlayer = userName2;
            }
            System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);
            System.out.println(" ");
            System.out.print(currentPlayer + ", Choose a pile:");
            String userPileAnswer = scanner.nextLine().toUpperCase();


            //makes sure that user is choosing a valid pile.
            while(!userPileAnswer.equals("A") && !userPileAnswer.equals("B") && !userPileAnswer.equals("C")){
                System.out.print(currentPlayer + ", Choose a valid pile:");
                 userPileAnswer = scanner.nextLine();
            }

            while (userPileAnswer.equals("A") && pile1 <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                userPileAnswer = scanner.nextLine();
            }
            while (userPileAnswer.equals("B") && pile2 <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                userPileAnswer = scanner.nextLine();
            }
            while (userPileAnswer.equals("C") && pile3 <= 0) {
                System.out.print("Nice try, " + currentPlayer + ". That pile is empty. Choose again:");
                userPileAnswer = scanner.nextLine();
            }

            System.out.print("How many to remove from pile " + userPileAnswer + ": ");
            int userNumberAnswer = Integer.parseInt(scanner.nextLine());
            while(userNumberAnswer < 1){
                System.out.print("You must choose at least 1. How many? ");
                userNumberAnswer = Integer.parseInt(scanner.nextLine());
            }


            if (userPileAnswer.equals("A")) {
                while (userNumberAnswer > pile1) {
                    System.out.print("Pile " + userPileAnswer + " doesn't have that many. Try again:");
                    userNumberAnswer = Integer.parseInt(scanner.nextLine());
                }
                pile1 = pile1 - userNumberAnswer;
                pileSum = pileSum - userNumberAnswer;

            } else if (userPileAnswer.equals("B")) {
                while (userNumberAnswer > pile2) {
                    System.out.print("Pile " + userPileAnswer + " doesn't have that many. Try again:");
                    userNumberAnswer = Integer.parseInt(scanner.nextLine());
                }
                pile2 = pile2 - userNumberAnswer;
                pileSum = pileSum - userNumberAnswer;

            } else if (userPileAnswer.equals("C")) {
                while (userNumberAnswer > pile3) {
                    System.out.print("Pile " + userPileAnswer + " doesn't have that many. Try again:");
                    userNumberAnswer = Integer.parseInt(scanner.nextLine());
                }
                pile3 = pile3 - userNumberAnswer;
                pileSum = pileSum - userNumberAnswer;

            }
            userTurnCount++;

            if (pileSum == 1) {
                System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);
                System.out.println(" ");
                if (userTurnCount % 2 == 0) {
                    System.out.println( userName1 + ", you must take the last remaining counter, so\n" +
                            "you lose." + currentPlayer + " wins!");
                } else if (userTurnCount % 2 > 0) {
                    System.out.println( userName2 + ", you must take the last remaining counter, so\n" +
                            "you lose." + currentPlayer + " wins!");
                }
            }

        }
    }
}
