package com.luyaxige.solution;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Strings {
    public String compressString(String s) {
        StringBuilder result = new StringBuilder();
        if (s==null) return "";
        int count = 0;
        char c = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) count++;
            else {
                result.append(c);
                result.append(count);
                c = s.charAt(i);
                count = 1;
            }
        }
        result.append(c);
        result.append(count);
        if (result.length() >= s.length())
            result = new StringBuilder(s);
        return result.toString();
    }

    public void checkCompressString() {
        String s = "aabcccccaa";
        System.out.println(compressString(s));

        s = "bb";
        System.out.println(compressString(s));
    }
}
