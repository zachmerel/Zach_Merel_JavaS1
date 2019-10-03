import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValueInAnArrayList {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> largestNumberList = new ArrayList<>();

        for (int i = 0; i <= 20 ; i++) {
            largestNumberList.add(random.nextInt(100) +1);
        }

        System.out.println(largestNumberList);

        int largeNum = 0;
        for(Integer x : largestNumberList){
            if(x > largeNum){
                largeNum = x;
            }
        }
        System.out.println("The largest value is " + largeNum);
    }
}
