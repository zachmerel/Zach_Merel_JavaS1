import java.util.*;

public class City {
    private String name;
    private int population;


    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population &&
                Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population);
    }

    public static void main(String[] args) {

        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMonies = new City("Des Monies", 217521);
        City atlanta = new City("Atlanta", 486213);


        Map<String, City> stateCityMap = new HashMap<>();
        stateCityMap.put("New York", newYork);
        stateCityMap.put("California", losAngeles );
        stateCityMap.put("Illinois", chicago );
        stateCityMap.put("Colorado",denver );
        stateCityMap.put("Iowa", desMonies);
        stateCityMap.put("Georgia", atlanta);

        Set<Map.Entry<String, City>> myEntrySet1 = stateCityMap.entrySet();
        for(Map.Entry<String, City> entry : myEntrySet1) {
            System.out.println(entry.getValue().name + ", " + entry.getKey() + " Population: " + entry.getValue().population);


        }

        filterByPopulation(stateCityMap, 0);

    }

    public static Map<String, City> filterByPopulation(Map<String,City> stateCityMap, int population){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a population you would like to test.");
         population = Integer.parseInt(scanner.nextLine());

        Set<Map.Entry<String, City>> myEntrySet = stateCityMap.entrySet();
        for (Map.Entry<String, City> entry : myEntrySet) {
            if(entry.getValue().getPopulation() > population)
            System.out.println(entry.getValue().name+ " Population: " + entry.getValue().getPopulation());
//            System.out.println(entry.getKey());
        }
        return null;
        }

    }
