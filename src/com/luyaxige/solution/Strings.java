package com.luyaxige.solution;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    public String compressString(String s) {
        StringBuilder result = new StringBuilder();
        if (s == null) return "";
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

    public int countCharacters(String[] words, String chars) {
        int len = 0;
        if (words.length == 0) return len;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
        }
        for (String word : words) {
            len += checkFormer(word, new HashMap<>(map));
        }
        return len;
    }

    private int checkFormer(String word, Map<Character, Integer> map) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c) && map.get(c) > 0) map.put(c, map.get(c) - 1);
            else return 0;
        }
        return word.length();
    }

    public void checkCountCharacters() {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
}
