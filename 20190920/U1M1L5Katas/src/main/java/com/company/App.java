package com.company;

public class App {

    public static int subtract(int a, int b) {
        int subtractTwo = a - b;
        return subtractTwo;
    }

    public static int subtractOrZero(int a, int b) {
        int subtract = a - b;
        if (subtract > 0) {
            return subtract;
        } else {
            return 0;
        }
    }
    public static int max(int a, int b, int c){
        int max;

        if(a > b && a >c){
            max = a;
        }else if (b > c && b > a){
            max = b;
        }else{
            max = c;
        }
        return max;
    }

    public static int min(int a, int b, int c){
        int min;

        if(a < b && a <c){
            min = a;
        }else if (b < c && b < a){
            min = b;
        }else{
            min = c;
        }
        return min;
    }

    public static boolean isLarger (int a, int b){
        if(a > b){
            return true;
        }else{
            return false;
        }
    }

}




//    public static int addInts(int x, int y) {
//        int sum = x + y;
//        return sum;
//    }
