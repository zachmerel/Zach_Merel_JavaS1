import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
        public static void main(String[] args) {
            Random random = new Random();
            List<Integer> listOfInts = new ArrayList<>();

            for (int i = 0; i <= 10 ; i++) {
                listOfInts.add(random.nextInt(100) +1);
            }

            List<Integer> listOfCopiedInts = new ArrayList<>();
            for(Integer x: listOfInts){
                listOfCopiedInts.add(x);
            }

            listOfInts.set(10, -7);


            System.out.println(listOfInts);
            System.out.println(listOfCopiedInts);
        }
}
