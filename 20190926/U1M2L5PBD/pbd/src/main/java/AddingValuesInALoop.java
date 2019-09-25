import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        int sum =0;
        int userNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me.");
        System.out.print("Number :");
        userNumber = Integer.parseInt(scanner.nextLine());

        while (userNumber !=0){

            sum += userNumber;
            System.out.println("The total so far is " + sum);
            System.out.print("Number :");
            userNumber = Integer.parseInt(scanner.nextLine());

        }
        System.out.println("The total is " + sum);

    }
}
