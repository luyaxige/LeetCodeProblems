package com.luyaxige.solution.linkedlist;

public class LinkedList {

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

    public void checkRemoveDuplicateNodes() {
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
        first.printAll("Before Delete ");
        ListNode result = removeDuplicateNodes(first);
        result.printAll("After Delete ");
    }

    public void deleteNodeInLinkedList(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public void checkDeleteNodeInLinkedList() {
        ListNode first = new ListNode(4);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(1);
        ListNode forth = new ListNode(9);
        first.next = second;
        second.next = third;
        third.next = forth;
        first.printAll("Before Delete: ");
        deleteNodeInLinkedList(second);
        first.printAll("After Delete: ");
    }
}
