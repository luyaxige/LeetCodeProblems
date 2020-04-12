package com.luyaxige.solution.sort;

import java.util.Arrays;

public class Test {

    private TestData testData = new TestData();

    public void sortRun() {
        checkSort("Insertion Sort", Sort.insertionSort);
        checkSort("Shell Sort", Sort.shellSort);
        checkSort("Selection Sort", Sort.selectionSort);
        checkSort("Heap Sort", Sort.heapSort);
        checkSort("Bubble Sort", Sort.bubbleSort);
        checkSort("Quick Sort", Sort.quickSort);
        checkSort("Merge Sort Recurse", Sort.mergeSort);
        checkSort("Merge Sort Loop", Sort.loopMergeSort);
    }

    private void checkSort(String s, Sort.SortInterface<int[]> sortInterface) {
        System.out.println("--------- " +  s + " ---------");
        System.out.println(Arrays.toString(testData.ascending));
        System.out.println(Arrays.toString(sortInterface.sort(testData.ascending)));
        System.out.println("*******************************************************");
        System.out.println(Arrays.toString(testData.descending));
        System.out.println(Arrays.toString(sortInterface.sort(testData.descending)));
        System.out.println("*******************************************************");
        System.out.println(Arrays.toString(testData.duplicate));
        System.out.println(Arrays.toString(sortInterface.sort(testData.duplicate)));
        System.out.println("*******************************************************");
        System.out.println(Arrays.toString(testData.random));
        System.out.println(Arrays.toString(sortInterface.sort(testData.random)));
        System.out.println("*******************************************************");
        System.out.println(Arrays.toString(testData.random2));
        System.out.println(Arrays.toString(sortInterface.sort(testData.random2)));
        System.out.println("*******************************************************");
        System.out.println();
    }
}
