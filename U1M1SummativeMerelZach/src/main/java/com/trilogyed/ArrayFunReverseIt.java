package com.trilogyed;

import java.util.Arrays;

public class ArrayFunReverseIt {
    public static void main(String[] args) {

        int[] forwardArray = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(forwardArray));

        for(int i = 0; i < forwardArray.length / 2; i++)
        {
            int elementHolder = forwardArray[i];
            forwardArray[i] = forwardArray[forwardArray.length - i - 1];
            forwardArray[forwardArray.length - i - 1] = elementHolder;
        }
        int[] backwardsArray = forwardArray;

        System.out.println(Arrays.toString(backwardsArray));
    }
}
