package com.luyaxige.solution.array;

public class Array {
    public boolean canThreePartsEqualSum(int[] A) {
        int size = A.length;
        int totalSum = sum(A, 0, size);
        if (0 != totalSum % 3) return false;
        int sum1=0, sum2=0, sum3=0;
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
}
