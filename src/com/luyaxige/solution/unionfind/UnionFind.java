package com.luyaxige.solution.unionfind;

import java.util.Objects;

public class UnionFind {

    public String gcdOfStrings(String str1, String str2) {
        String ans = "";
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                ans = str1.substring(0, i);
                if (check(ans, str1) && check(ans, str2)) return ans;
            }
        }

        return "";
    }

    private boolean check(String t, String s) {
        int len = s.length() / t.length();
        String ans = "";
        for (int i = 1; i <= len; i++) {
            ans += t;
        }
        return Objects.equals(ans, s);
    }

    public void checkGcdOfString() {
        String A = "ABABAB";
        String B = "ABAB";
        System.out.println(gcdOfStrings(A, B));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean xOverlap = checkIsOverlap(rec1[0], rec1[2], rec2[0],rec2[2]);
        boolean yOverlap = checkIsOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
        return xOverlap && yOverlap;
    }

    private boolean checkIsOverlap(int start1, int end1, int start2, int end2) {
        return start1 < end2 && start2 < end1;
    }

    public void checkIsRectangleOverlap() {
        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};
        System.out.println(isRectangleOverlap(rec1, rec2));

        rec1 = new int[]{7, 8, 13, 15};
        rec2 = new int[]{10, 8, 12, 20};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }
}
