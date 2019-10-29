import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class DogNamerTest {

    DogNamer dogNamer;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldGenereateName() {
        //arrange
        List<String> nameList1 = new ArrayList<>();
        nameList1.add("Rover");
        nameList1.add("Winston");
        nameList1.add("Spike");
        nameList1.add("Spot");
        nameList1.add("Speck");
        nameList1.add("Diogi");
        nameList1.add("Max");

        //act
        String nameIExpect = "Rover Winston Smith";
        String nameIGot = dogNamer.generateName(nameList1, 0, 1, "Smith");


        //assert
        assertEquals(nameIExpect, nameIGot);
    }
}