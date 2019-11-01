import com.trilogyed.MostFrequentString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMostFrequestString {

    private MostFrequentString mostFrequentString = new MostFrequentString();

    @Test
    public void shouldTestToSeeIfListIsEmpty() {
        //arrange
        List<String> stringListIExpect = new ArrayList<>();
        //assert
        assertTrue(mostFrequentString.findMostFrequent(stringListIExpect).isEmpty());
    }

    @Test
    public void shouldTestThatEqualCountOfElementsInListAreBothReturned() {

    }

    @Test
    public void shouldTestThatMostFrequentElementInTestIsReturned() {
        //arrange
        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("1");
        stringList.add("2");

        List<String> stringListIExpectBack = new ArrayList<>();
        stringListIExpectBack.add("1");
        //act
        List<String> stringListIgotBack = mostFrequentString.findMostFrequent(stringList);

        assertEquals(stringListIExpectBack, stringListIgotBack);
    }
}
