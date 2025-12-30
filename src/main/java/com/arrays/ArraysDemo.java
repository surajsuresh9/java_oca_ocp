package com.arrays;

import java.util.Arrays;

public class ArraysDemo {
    public static void main(String[] args) {
        // valid declarations

        // int[] nums;
        // int [] nums;
        // int []nums;
        // int nums[];
        // int nums [];

        // int myNumbers[], a;

        // arrays don;t implement equals method
        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{1, 2, 3};
        System.out.println(num1.equals(num2)); // equivalent to ==
        int[] nums = new int[]{3, -1, 17};
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));

        // length is a PROPERTY, not method

    }
}
