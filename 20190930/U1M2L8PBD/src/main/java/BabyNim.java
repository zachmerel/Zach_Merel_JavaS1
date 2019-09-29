import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        int pile1 = 3;
        int pile2 = 3;
        int pile3 = 3;

        Scanner scanner = new Scanner(System.in);



        while (pile1 > 0 || pile2 > 0 || pile3 > 0){
            System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);
            System.out.println(" ");
            System.out.print("Choose a pile:");
            String userPileAnswer = scanner.nextLine();
            System.out.print("How many to remove from pile " + userPileAnswer + ": ");
            int userNumberAnswer = Integer.parseInt(scanner.nextLine());

            if (userPileAnswer.equals("A")) {
                pile1 = pile1 - userNumberAnswer;

            } else if (userPileAnswer.equals("B")) {
                pile2 = pile2 - userNumberAnswer;

            } else if (userPileAnswer.equals("C")) {
                pile3 = pile3 - userNumberAnswer;

            }if(pile1<=0 && pile2 <= 0 && pile3 <= 0){
                System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3);
                System.out.println(" ");
                System.out.println("All piles are empty. Good job!");
            }

        }


    }

}
