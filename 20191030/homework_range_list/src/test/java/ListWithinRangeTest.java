import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListWithinRangeTest {
    ListWithinRange listWithinRange = new ListWithinRange();
    @Test
    public void shouldCheckToSeeIfOneListIsInRangeOfTheOtherList() {
        //arrange
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(3);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);

        //act
        int list1MinIExpect = 1;
        int list1MaxIExpect = 5;
        int list2MinIExpect = 3;
        int list2MaxIExpect = 4;


        //assert


    }
}
