package com.luyaxige.solution;

import com.luyaxige.solution.linkedlist.LinkedList;
import com.luyaxige.solution.linkedlist.ListNode;
import com.luyaxige.solution.linkedlist.MyStack;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class Solution {
    public static void main(String[] args) {

        /**
         * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/submissions/
         * */
        LinkedList linkedList = new LinkedList();
        ListNode head = linkedList.createReduplicatedNodeList();
        ListNode result = linkedList.removeDuplicateNodes(head);

        while(null != result) {
            System.out.print(result.val);
            result = result.next;
            System.out.print(", ");
        }
        System.out.println();

        /**
         * https://leetcode-cn.com/problems/implement-stack-using-queues/
         * */
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.printQueue();
        obj.pop();
        obj.top();
        obj.empty();
        obj.printQueue();
    }
}
