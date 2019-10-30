import java.util.*;

public class ListWithinRange {
    /**
     * Write tests for a method, and then write the method to satisfy the following:
     * <p>
     * Given two lists of integers, check that all the elements of one list are completely within the range of the other
     * list.
     * <p>
     * So, given the lists (5, 2, 1, 3) and the list (4, 3), the method would return true because both 4
     * and 3 are between the min and max of the first list (1 and 5)
     * <p>
     * Also, given the lists (4, 3) and (1, 7), the method would again return true
     * because the whole first list is within the range of the second list
     * <p>
     * Given the lists (4, 1) and (3, 7), the method would return false because 7 is not between 1 and 4
     * and 1 is not between 3 and 7.
     * <p>
     * If either list is empty or null, the result is true.
     * <p>
     * Given these arguments, the method would return true:
     * (14, 355, 121, 66) and (39, 55, 355, 18, 26, 321, 1)
     * (4922, 4922, 4922, 4922, 4922) and (4922, 4922, 4922)
     * () and (-83)
     * <p>
     * Given these arguments, the method would return false:
     * (0, 2) and (1, 3)
     * (3) and (4)
     * (94, 22, 161, 18, 55, 230) and (56, 47, 206, 102, 12)
     */

    public static void main(String[] args) {
        ListWithinRange listWithinRange = new ListWithinRange();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);

        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);

        boolean returnA = listWithinRange.isListWithinRange(linkedList, stack);

        System.out.println("According to the instructions, this should be true: " + returnA);

        System.out.println("According to the instructions, this should be false: " + listWithinRange.isListWithinRange(Arrays.asList(4, 3), Arrays.asList(1, 7)));

    }

    public boolean isListWithinRange(List<Integer> a, List<Integer> b) {
        // Your code goes here
        int listAMin;
        int listAMax;
        int listBMin;
        int listBMax;

        Collections.sort(a);
        listAMin = a.get(0);
        listAMax = a.get(a.size() - 1);

        Collections.sort(b);
        listBMin = b.get(0);
        listBMax = b.get(b.size() - 1);

        if (listAMin > listBMin && listAMax < listBMax) {
            return true;
        }else if(listBMin > listAMin && listBMax < listAMax){
            return true;
        }else{
            return false;
        }


    }

}
