import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number between 1 and 12.");
        int userMonthConverterInput = Integer.parseInt(scanner.nextLine());

        //returns month using switch statement
        System.out.println(ConverterSwitch.monthCoverter(userMonthConverterInput));
        //returns month using if/else if/ else statement
        System.out.println(ConverterIf.monthConverter(userMonthConverterInput));


        System.out.println("Please enter a number between 1 and 7");
        int userDayConverterInput = Integer.parseInt(scanner.nextLine());

        //returns day using switch statement
        System.out.println(ConverterSwitch.dayConverter(userDayConverterInput));
        //returns day using if/else if/ else statement
        System.out.println(ConverterIf.dayConverter(userDayConverterInput));
    }
}
