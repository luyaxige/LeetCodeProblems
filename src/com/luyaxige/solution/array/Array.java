package com.luyaxige.solution.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    public boolean canThreePartsEqualSum(int[] A) {
        int size = A.length;
        int totalSum = sum(A, 0, size);
        if (0 != totalSum % 3) return false;
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = 0; i < size - 2; i++) {
            sum1 += A[i];
            if (sum1 == totalSum / 3) {
                for (int j = i + 1; j < size - 1; j++) {
                    sum2 += A[j];
                    if (sum2 == sum1) return true;
                }
                return false;
            }
        }
        return false;
    }

    private int sum(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public void checkCanThreePartsEqualSum() {
        int[] array = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(array));

        array = new int[]{18, 12, -18, 18, -19, -1, 10, 10};
        System.out.println(canThreePartsEqualSum(array));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int width = matrix.length;
        int length = matrix[0].length;
        int w = 0, l = 0;
        while (w < width && l < length) {
            for (int i = l; i < length; i++) list.add(matrix[w][i]);
            for (int i = w + 1; i < width; i++) list.add(matrix[i][length - 1]);
            if (w < width - 1 && l < length - 1) {
                for (int i = length - 2; i >= l; i--) list.add(matrix[width - 1][i]);
                for (int i = width - 2; i > w; i--) list.add(matrix[i][l]);
            }
            length--;width--;w++;l++;
        }
        return list;
    }

    public void checkSpiralOrder() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(array));

        array = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(array));

        array = new int[][]{{3}, {2}};
        System.out.println(spiralOrder(array));

        array = new int[][]{{6, 9, 7}};
        System.out.println(spiralOrder(array));

        array = new int[][]{{2, 5, 8}, {4, 0, -1}};
        System.out.println(spiralOrder(array));
    }
}
