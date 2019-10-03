import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LocatingTheLargestValueInAnArrayList {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> largestNumberList = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            largestNumberList.add(random.nextInt(100) + 1);
        }

        System.out.println(largestNumberList);
        int indexNumber = 0;
        int largeNum = 0;
        for (Integer x : largestNumberList) {
            if (x > largeNum) {
                largeNum = x;
            }
        }

        for (Integer x : largestNumberList) {
            if (x == largeNum) {
                indexNumber = largestNumberList.lastIndexOf(x);
            }
        }
        System.out.println(largeNum + " is in slot " + indexNumber);
//            System.out.println("The largest value is " + largeNum);
    }
}

