package com.luyaxige.solution.sort;

public class TestData {
    private static TestData instance;
    public TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] descending = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    int[] duplicate = {9, 8, 7, 6, 5, 4, 3, 2, 1, 2, 5, 7, 2, 3, 8, 9};
    int[] random = {8, 3, 2, 6, 7, 1, 5, 4};
    int[] random2 = {49, 38, 65, 97, 76, 13, 27};
}
