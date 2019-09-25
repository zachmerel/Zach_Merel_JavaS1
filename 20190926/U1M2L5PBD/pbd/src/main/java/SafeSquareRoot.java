import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        int userNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        userNumber = Integer.parseInt(scanner.nextLine());

        while(userNumber <= 0){
            System.out.println("You can't take the square root of a negative number, silly.");
            userNumber = Integer.parseInt(scanner.nextLine());
        }

        double squareRootOfUserNumber = Math.sqrt(userNumber);

        System.out.println("The square root of " + userNumber +  " is " + squareRootOfUserNumber);

    }
}
