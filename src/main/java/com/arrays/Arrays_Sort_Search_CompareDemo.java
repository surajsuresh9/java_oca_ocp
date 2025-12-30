package com.arrays;

import java.util.Arrays;

public class Arrays_Sort_Search_CompareDemo {
    public static void main(String[] args) {
        // Arrays.sort()
        int[] nums = new int[]{3, -1, 17};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        // arrays are mutable, sort() changes the original array

        /* Arrays.binarySearch()
            - works only on sorted arrays
            - if array is not sorted, the result is unpredictable
           Takes array and array element as args
            - if element is found the index of the element is returned
            - if not found, the negative number is returned
                -   -(index_where_it_would_belong + 1)
                - nth place with '-' in front
        */
        System.out.println("Arrays.binarySearch(nums, -1): " + Arrays.binarySearch(nums, -1));
        System.out.println("Arrays.binarySearch(nums, 17): " + Arrays.binarySearch(nums, 17));
        System.out.println("Arrays.binarySearch(nums, 0): " + Arrays.binarySearch(nums, 0));
        int[] myNums = new int[]{3, -1, 17};
        System.out.println("Arrays.binarySearch(myNums, 0): " + Arrays.binarySearch(myNums, -1)); // unpredictable

        /* Arrays.compare()
            - determines which array is 'smaller' and returns
                - -ve num if first is smaller than second
                - 0 if arrays are equal in content
                - +ve num if first is larger than second

            - what is 'smaller'?
                - if 1 array has lesser elements, it's smaller
                - if arrays have equal number of elements
                    - smaller is the one whose 1st number is smaller
                - null is smaller than any other values
                - strings
                    - one is smaller if it's a prefix of another
                    - numbers are smaller than letters
                    - uppercase is smaller than lowercase
                    - alphabetical order is applied

        */


        System.out.println(Arrays.compare(new int[]{3, 7}, new int[]{3})); // +ve num
        System.out.println(Arrays.compare(new int[]{3, 7}, new int[]{3, 7})); // 0
        System.out.println(Arrays.compare(new String[]{"ab", "John Wayne"}, new String[]{"abc", "Hey!"})); // -ve
        System.out.println(Arrays.compare(new String[]{"xy", "John Wayne"}, new String[]{"abc", "Hey!"})); // +ve
        System.out.println(Arrays.compare(new String[]{"John", "Wayne"}, new String[]{"john", "Wayne"})); // -ve

        // Arrays.mismatch()
        // return -1 if arrays are equal, otherwise the first index where they differ
        System.out.println(Arrays.mismatch(new String[]{"John", "Wayne"}, new String[]{"John", "Doe"})); // 1
        System.out.println(Arrays.mismatch(new String[]{"John", "Wayne"}, new String[]{"John", "Wayne", "The Duke"})); // 2
        System.out.println(Arrays.mismatch(new String[]{"John", "Wayne"}, new String[]{"John", "Wayne"})); // -1 equal
        System.out.println(Arrays.mismatch(new int[]{3, -2, 7}, new int[]{3, -2, 7})); // -1 equal

    }
}
