package com.luyaxige.solution.linkedlist;

public class LinkedList {

    public ListNode createReduplicatedNodeList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(3);
        ListNode fifth = new ListNode(2);
        ListNode sixth = new ListNode(1);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        fifth.next = sixth;
        return first;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode curNode = head;
        ListNode p;
        while (null != curNode) {
            p = curNode;
            while (null != p.next) {
                if (p.next.val == curNode.val) {
                    p.next = p.next.next;
                } else {
                    p = p.next;
                }
            }
            curNode = curNode.next;
        }
        return head;
    }

    public void removeDuplicateNodes(){
        ListNode head = createReduplicatedNodeList();
        ListNode result = removeDuplicateNodes(head);

        while(null != result) {
            System.out.print(result.val);
            result = result.next;
            System.out.print(", ");
        }
        System.out.println();
    }
}
