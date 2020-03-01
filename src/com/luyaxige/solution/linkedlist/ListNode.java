package com.luyaxige.solution.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; }

    public void printAll(String msg) {
        if (null != msg) System.out.print(msg);
        System.out.print("[" + val);
        ListNode cur = next;
        while (null != cur) {
            System.out.print(", " + cur.val);
            cur = cur.next;
        }
        System.out.println("]");
    }
}
