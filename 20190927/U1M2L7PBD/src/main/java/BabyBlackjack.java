import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        System.out.println("Baby Blackjack!");
        int playerCard1;
        int playerCard2;
        int playerTotal;
        int dealerCard1;
        int dealerCard2;
        int dealerTotal;

        playerCard1 = randomGenerator.nextInt(10) + 1;
        playerCard2 = randomGenerator.nextInt(10) + 1;
        playerTotal = playerCard1 + playerCard2;

        dealerCard1 = randomGenerator.nextInt(10) + 1;
        dealerCard2 = randomGenerator.nextInt(10) + 1;
        dealerTotal = dealerCard1 + dealerCard2;

        System.out.println("You drew " + playerCard1 + " and " + playerCard2 + ".");
        System.out.println("Your total is " + playerTotal);
        System.out.println(" ");
        System.out.println("The dealer has " + dealerCard1 + " and " + dealerCard2);
        System.out.println("Dealer's total is " + dealerTotal);

        if(dealerTotal < playerTotal){
            System.out.println("YOU WIN!");
        }else{
            System.out.println("YOU LOSE!");
        }

    }
}
