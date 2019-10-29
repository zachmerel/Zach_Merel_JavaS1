import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WRITE TESTS IN A SEPARATE TEST CLASS, AND IMPLEMENT THE METHOD
 * generateName
 * BELOW
 *
 *
 * The DogNamer class has a method that will generate a dog name for you.
 * Given a list of names, two numbers, and a surname, the generateName method will
 * give you a full dog name (first and middle) with a surname
 * The only rule is that no two names in the result can start with the same letter.
 * So,
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 0 and 1
 * and the surname Smith
 *
 * the generateName method will give the name
 * Rover Winston Smith
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 1 and 2
 * and the surname Smith
 * the generateName method will give the name
 * Winston Smith
 *
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 2 and 3
 * and the surname Smith
 * the generateName method will give the name
 * Smith
 *
 * given the list
 * Rover, Winston, Spike, Spot, Speck, Diogi, Max
 * and the numbers 2 and 5
 * and the surname Smith
 * the generateName method will give the name
 * Diogi Smith
 */


public class DogNamer {
    public static void main(String[] args) {


        DogNamer dogNamer = new DogNamer();

        List<String> nameList1 = new ArrayList<>();
        nameList1.add("Rover");
        nameList1.add("Winston");
        nameList1.add("Spike");
        nameList1.add("Spot");
        nameList1.add("Speck");
        nameList1.add("Diogi");
        nameList1.add("Max");
        System.out.println(dogNamer.generateName(nameList1, 2, 5, "Smith"));
    }

    public String generateName(List<String> nameList1, int a, int b, String surname) {
        // your code goes here
        String name;
        String firstNameFirstLetter = nameList1.get(a).substring(0,1);
        String middleNameFirstLetter = nameList1.get(b).substring(0,1);
        String lastNameFirstLetter = surname.substring(0,1);

        String first_name = nameList1.get(a);
        String middle_name = nameList1.get(b);
        String last_name = surname;

        if(firstNameFirstLetter.equals(lastNameFirstLetter) && middleNameFirstLetter.equals(lastNameFirstLetter) ){
            name = surname;
        }else if(firstNameFirstLetter.equals(lastNameFirstLetter)){
            name = middle_name + " " + last_name;
        }else if(middleNameFirstLetter.equals(lastNameFirstLetter)){
            name = first_name + " " + last_name;
        }else{
            name = first_name + " " + middle_name + " " + last_name;
        }



        return name;
    }
}
