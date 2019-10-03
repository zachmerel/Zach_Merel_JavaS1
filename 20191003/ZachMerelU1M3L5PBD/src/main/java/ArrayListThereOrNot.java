import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> findTheInt = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            findTheInt.add(random.nextInt(50) + 1);
        }

        System.out.println(findTheInt);

        System.out.print("Value to find: ");
        int userNumber = Integer.parseInt(scanner.nextLine());


        if (findTheInt.contains(userNumber)) {

            for (Integer x : findTheInt) {
                if (x == userNumber) {
                    System.out.println(userNumber + " is in the Array");
                }
            }

        }else{
            System.out.println(userNumber + " is not in the Array");
        }
    }
}
