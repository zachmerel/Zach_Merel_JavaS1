import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        int side1;
        int side2;
        int side3;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three integers: ");
        System.out.print("Side 1: ");
        side1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Side 2: ");
        side2 = Integer.parseInt(scanner.nextLine());
        while(side1 > side2){
            System.out.println(side1 + " is smaller than " + side2 + ".  Try again.");
            System.out.print("Side 2: ");
            side2 = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Side 3: ");
        side3 = Integer.parseInt(scanner.nextLine());
        while(side2 > side3){
            System.out.println(side2 + " is smaller than " + side3 + ".  Try again.");
            System.out.print("Side 3: ");
            side3 = Integer.parseInt(scanner.nextLine());
        }


        double side1Squared = Math.pow(side1,2);
        double side2Squared = Math.pow(side2,2);
        double side3Squared = Math.pow(side3,2);

        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3 + ".");

        if(side1Squared+side2Squared != side3Squared) {
            System.out.println("NO!  These sides do not make a right triangle!");
        }else{
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        }

    }
}
