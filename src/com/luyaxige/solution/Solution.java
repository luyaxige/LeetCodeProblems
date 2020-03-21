package com.luyaxige.solution;

import com.luyaxige.solution.array.Array;
import com.luyaxige.solution.linkedlist.LinkedList;
import com.luyaxige.solution.linkedlist.MyStack;

public class Solution {
    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Array array = new Array();

        /**
         * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/submissions/
         * */
        System.out.println("删除重复节点");
        linkedList.checkRemoveDuplicateNodes();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/delete-middle-node-lcci/
         * */
        System.out.println("删除链表中的节点");
        linkedList.checkDeleteNodeInLinkedList();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/implement-stack-using-queues/
         * */
        System.out.println("队列实现堆栈");
        MyStack obj = new MyStack();
        obj.checkMyStack();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/add-two-numbers/
         * */
        System.out.println("#2 Add Two Numbers");
        linkedList.checkAddTwoNumbers();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
         * */
        System.out.println("#24 Swap Nodes in Pairs");
        linkedList.checkSwapPairs();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
         * */
        System.out.println("#1013 Partition Array Into Three Parts With Equal Sum");
        array.checkCanThreePartsEqualSum();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/spiral-matrix/
         * */
        System.out.println("#54 Spiral Matrix");
        array.checkSpiralOrder();
        System.out.println("**********************");


        UnionFind uf = new UnionFind();
        /**
         * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/submissions/
         * */
        System.out.println("#54 Spiral Matrix");
        uf.checkGcdOfString();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/majority-element/
         * */
        System.out.println("#169 Majority Element");
        array.checkMajorityElement();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/majority-element/
         * */
        System.out.println("#695 Max Area Of Island");
        array.checkMaxAreaOfIsland();
        System.out.println("**********************");

        Strings strings = new Strings();

        /**
         * https://leetcode-cn.com/problems/compress-string-lcci/
         * */
        System.out.println("#面试题01.06 Compress String LCCI");
        strings.checkCompressString();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/submissions/
         * */
        System.out.println("#1160 Find Words That Can Be Formed by Characters");
        strings.checkCountCharacters();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/rectangle-overlap/
         * */
        System.out.println("#836 Rectangle Overlap");
        uf.checkIsRectangleOverlap();
        System.out.println("**********************");

        /**
         * https://leetcode-cn.com/problems/rectangle-overlap/
         * */
        System.out.println("#409 Longest Palindrome");
        strings.checkLongestPalindrome();
        System.out.println("**********************");

        Graph graph = new Graph();

        /**
         * https://leetcode-cn.com/problems/water-and-jug-problem/
         * */
        System.out.println("@365 Water and Jug Problem");
        graph.checkCanMeasureWater();
        System.out.println("**********************");
    }
}
