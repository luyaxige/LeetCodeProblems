package com.luyaxige.solution.sort;

import java.util.Arrays;

public class Sort {

    @FunctionalInterface
    public interface SortInterface<R> {
        int[] sort(R r);
    }

    static SortInterface<int[]> insertionSort = l -> {
        int size = l.length;
        int[] _l = Arrays.copyOf(l, size);
        for (int i = 0; i < size; i++) {
            int j = i;
            int current = _l[j];
            while(j - 1 >= 0  && _l[j - 1] >= current) {
                _l[j] = _l[j - 1];
                j--;
            }
            _l[j] = current;
        }
        return _l;
    };

    static SortInterface<int[]> shellSort = l -> {
        int size = l.length;
        int[] _l = Arrays.copyOf(l, size);
        int gap = size / 2;
        while (gap > 0) {
            for (int i = gap; i < size; i++) {
                int j = i;
                int current = _l[j];
                while(j - gap >= 0 && _l[j - gap] > current) {
                    _l[j] = _l[j - gap];
                    j -= gap;
                }
                _l[j] = current;
            }
            gap /= 2;
        }
        return _l;
    };

    static SortInterface<int[]> selectionSort = l -> {
        int[] _l = Arrays.copyOf(l, l.length);
        int size = l.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (_l[j] < _l[min]) min = j;
            }
            swap(i, min, _l);
        }
        return _l;
    };

    static SortInterface<int[]> heapSort = new SortInterface<int[]>() {
        @Override
        public int[] sort(int[] l) {
            int size = l.length;
            int[] _l = Arrays.copyOf(l, size);
            for (int i = 0; i < size; i++) {
                for (int j = size - i - 1; j > 0; j--) {
                    if(_l[j] > _l[(j-1)/2]) swap(j, (j-1)/2, _l);
                }
                swap(0, size - i - 1, _l);
            }
            return _l;
        }


    };

    static SortInterface<int[]> bubbleSort = l -> {
        int[] _l = Arrays.copyOf(l, l.length);
        for (int i = 0; i < _l.length; i++) {
            for (int j = 1; j < _l.length - i; j++) {
                if (_l[j-1] > _l[j]) swap(j-1, j, _l);
            }
        }
        return _l;
    };

    static SortInterface<int[]> quickSort = new SortInterface<int[]>() {
        @Override
        public int[] sort(int[] l) {
            int size = l.length;
            int[] _l = Arrays.copyOf(l, size);
            quickSort(0, size - 1, _l);
            return _l;
        }

        private void quickSort(int start, int end, int[] l) {
            if (start < end) {
                int index = start + 1;
                for (int i = start + 1; i <= end; i++) {
                    if (l[i] <= l[start]) {
                        swap(i, index++, l);
                    }
                }
                swap(start, index - 1, l);
                int partitionIndex = index - 1;
                quickSort(start, partitionIndex - 1, l);
                quickSort(partitionIndex + 1, end, l);
            }
        }
    };

    static SortInterface<int[]> mergeSort = new SortInterface<int[]>() {
        @Override
        public int[] sort(int[] l) {
            if (l.length <= 1) return l;
            int size = l.length;
            int mid = size / 2;
            int[] left = sort(Arrays.copyOfRange(l, 0, mid));
            int[] right = sort(Arrays.copyOfRange(l, mid, size));
            return merge(left, right);
        }

        private int[] merge(int[] l1, int[] l2) {
            int[] l = new int[l1.length + l2.length];
            int index = 0, i = 0, j = 0;
            while (index < l.length) {
                if(i >= l1.length) l[index++] = l2[j++];
                else if (j >= l2.length) l[index++] = l1[i++];
                else if (l1[i] < l2[j]) l[index++] = l1[i++];
                else if(l1[i] >= l2[j]) l[index++] = l2[j++];
            }
            return l;
        }
    };

    static SortInterface<int[]> loopMergeSort = new SortInterface<int[]>() {
        @Override
        public int[] sort(int[] l) {
            int N = 2;
            int[] _l = Arrays.copyOf(l, l.length);

            while(N < l.length) {
                int j = 0;
                for (; j < l.length; j+=N) {
                    int end = Math.min(j+N, l.length);
                    int mid = (j + end - 1) / 2 + 1;
                    merge(_l, j, mid, end);
                }
                N *= 2;
            }
            merge(_l, 0, N / 2 , l.length);
            return _l;
        }

        private void merge(int[] l, int s, int mid, int e) {
            int i = s, j = mid;
            int[] _l = Arrays.copyOf(l, l.length);
            int k = s;
            while(i < mid && j < e) {
                if (_l[i]<_l[j])
                    l[k++] = _l[i++];
                else if (_l[i]>=_l[j])
                    l[k++] = _l[j++];
            }
            while (i < mid)
                l[k++] = _l[i++];
            while(j < e)
                l[k++] = _l[j++];
        }
    };

    private static void swap(int a, int b, int[] L) {
        if (a == b) return;
        int tmp = L[a];
        L[a] = L[b];
        L[b] = tmp;
    }
}
