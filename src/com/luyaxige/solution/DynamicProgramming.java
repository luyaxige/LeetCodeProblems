package com.luyaxige.solution;

public class DynamicProgramming {

    public int massage(int[] nums) {
        int size = nums.length;
        if (size == 0) return 0;
        int dp0 = 0, dp1 = 0;
        for (int num : nums) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + num;
            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }

    public void checkMassage() {
        System.out.println(massage(new int[]{1, 2, 3, 1}));
        System.out.println(massage(new int[]{2, 7, 9, 3, 1}));
        System.out.println(massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
        System.out.println(massage(new int[]{
                226, 174, 214, 16, 218, 48, 153, 131, 128, 17, 157, 142, 88, 43, 37, 157, 43, 221, 191,
                68, 206, 23, 225, 82, 54, 118, 111, 46, 80, 49, 245, 63, 25, 194, 72, 80, 143, 55, 209,
                18, 55, 122, 65, 66, 177, 101, 63, 201, 172, 130, 103, 225, 142, 46, 86, 185, 62, 138,
                212, 192, 125, 77, 223, 188, 99, 228, 90, 25, 193, 211, 84, 239, 119, 234, 85, 83, 123,
                120, 131, 203, 219, 10, 82, 35, 120, 180, 249, 106, 37, 169, 225, 54, 103, 55, 166, 124
        }));
    }
}
