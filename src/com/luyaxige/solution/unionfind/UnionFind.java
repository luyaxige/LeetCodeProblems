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
}
