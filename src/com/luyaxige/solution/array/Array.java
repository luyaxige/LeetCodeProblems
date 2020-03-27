package com.luyaxige.solution.array;

import java.util.*;

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
            length--;
            width--;
            w++;
            l++;
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

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(Collections.emptyMap());
        for (int num : nums) {
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (null == majorityEntry || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        assert majorityEntry != null;
        return majorityEntry.getKey();
    }

    public void checkMajorityElement() {
        int[] nums = {3, 2, 3};
        System.out.println(majorityElement(nums));
    }

    int[][] flag;

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if (grid.length == 0) return maxArea;
        int width = grid.length;
        int length = grid[0].length;
        flag = new int[width][length];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (flag[i][j] == 1 || grid[i][j] == 0) continue;
                int area = countArea(grid, i, j);
                if (maxArea < area) maxArea = area;
            }
        }
        return maxArea;
    }

    private int countArea(int[][] grid, int x, int y) {
        if (!(x<grid.length && x >=0) || !(y<grid[0].length && y>=0) || flag[x][y] == 1 || grid[x][y]==0) return 0;
        flag[x][y] = 1;
        int area = grid[x][y];
        area += countArea(grid, x, y + 1) + countArea(grid, x + 1, y) + countArea(grid, x, y - 1) + countArea(grid, x - 1, y);
        return area;
    }

    public void checkMaxAreaOfIsland() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(maxAreaOfIsland(grid));

        grid = new int[][]{{1,1,0,1,1},
                           {1,0,0,0,0},
                           {0,0,0,0,1},
                           {1,1,0,1,1}};
        System.out.println(maxAreaOfIsland(grid));

        grid = new int[][]{{0,1},
                           {1,0}};
        System.out.println(maxAreaOfIsland(grid));

        grid = new int[][]{{0,1},
                           {1,1}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public int minIncrementForUnique(int[] A) {
        int size = A.length;
        Arrays.sort(A);
        int[] l = A;
        int last = l[0];
        int step = 0;
        for (int i = 1; i < size; i++) {
            if (l[i] == last) {
                l[i] = last + 1;
                step += 1;
            }
            if (l[i] < last) {
                step += last - l[i] + 1;
                l[i] = last + 1;
            }
            last = l[i];
        }
        return step;
    }

    public void checkMinIncrementForUnique() {
        int[] array = {2,2,2,2,0};
        System.out.println(minIncrementForUnique(array));
    }

    public boolean hasGroupSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: deck) {
            map.put(num, map.get(num) == null ? 1 : map.get(num) + 1);
        }
        int X = -1;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (-1 == X) X = value;
            X = gcd(X, value);
        }
        return X >= 2;
    }

    public void checkHasGroupSizeX() {
        int[] deck = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(hasGroupSizeX(deck));
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
