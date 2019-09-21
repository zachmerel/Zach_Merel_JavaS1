package com.trilogyed;

public class SomeMath {

    public static int total5(int a, int b, int c, int d, int e) {

        int sum = a + b + c + d + e;
        System.out.println(sum);

        return sum ;
    }
    public static double average5(int a, int b, int c, int d, int e){
        int avg = (a + b + c + d + e)/5;

        System.out.println(avg);

        return avg;
    }
    public static double largest5(double a, double b, double c, double d, double e) {
        double max = a;
        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }
        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {

        total5(1,2,3,4,5);
        average5(1,3,5,7,9);
        largest5(42.0, 35.1, 2.3, 40.2, 15.6);
    }
}
