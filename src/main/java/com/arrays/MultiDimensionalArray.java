package com.arrays;

public class MultiDimensionalArray {
    // this is an array of arrays
    public static void main(String[] args) {
        int[][] a = {
                {-1, 17},
                {3},
                {5, 103, 11},
                {4, 9, -6, 8},
        };

        // traditional for loop
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println("a(%d,%d) = %d".formatted(i, j, a[i][j]));
            }
        }

        // for-each loop
        for (int[] arr : a) {
            System.out.print("[");
            for (int el : arr) {
                System.out.print(el + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
