import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class CityTest {

    private Object City;
//    private static HashMap<String, City> ;
//    private static City

    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void shouldReturnCitiesWithPopulationGreaterThanInputValue(){

        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMonies = new City("Des Monies", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> expected = new HashMap<>();
        Set<Map.Entry<String, City>> myEntrySet = expected.entrySet();
        expected.put("New York", newYork);
        expected.put("California", losAngeles );
        expected.put("Illinois", chicago );
        expected.put("Colorado",denver );
        expected.put("Iowa", desMonies);
        expected.put("Georgia", atlanta);

        Map<String, City> expected1 = new HashMap<>();
        expected1.put("New York", newYork);
        expected1.put("California", losAngeles );
        expected1.put("Illinois", chicago );

        Map<String, City> expected2 = new HashMap<>();
        expected1.put("New York", newYork);
        //if user input is 0 I would expect to have the entire map return
        assertEquals(expected,0);
        assertEquals(expected1,1000000);
        assertEquals(expected2, 5000000);
    }
}