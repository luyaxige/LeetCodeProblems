package com.luyaxige.solution.linkedlist;

import java.util.List;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode pre = dummyHead;
        int carryValue = 0;
        while (null != l1 || null != l2 || 0 != carryValue) {
            if (null != l1) {
                carryValue += l1.val;
                l1 = l1.next;
            }
            if (null != l2) {
                carryValue += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(carryValue % 10);
            carryValue /= 10;
            pre = pre.next;
        }
        return dummyHead.next;
    }

    public void checkAddTwoNumbers() {
        ListNode node1_1 = new ListNode(2);
        ListNode node1_2 = new ListNode(4);
        ListNode node1_3 = new ListNode(3);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node1_1.printAll("Node List One: ");

        ListNode node2_1 = new ListNode(5);
        ListNode node2_2 = new ListNode(6);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2;
        node2_2.next = node2_3;
        node2_1.printAll("Node List Two: ");

        ListNode result = addTwoNumbers(node1_1, node2_1);
        result.printAll("Result Node List: ");

        ListNode node3_1 = new ListNode(5);
        node3_1.printAll("Node List Three: ");
        ListNode node4_1 = new ListNode(5);
        node4_1.printAll("Node List Four: ");
        result = addTwoNumbers(node3_1, node4_1);
        result.printAll("Result Node List: ");

        ListNode node5_1 = new ListNode(0);
        node5_1.printAll("Node List Three: ");
        ListNode node6_1 = new ListNode(7);
        ListNode node6_2 = new ListNode(3);
        node6_1.next = node6_2;
        node6_1.printAll("Node List Four: ");
        result = addTwoNumbers(node5_1, node6_1);
        result.printAll("Result Node List: ");
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curNode, nextNode, nextNextNode;
        curNode = dummyHead;
        while (null != curNode.next && null != curNode.next.next) {
            nextNode = curNode.next;
            nextNextNode = curNode.next.next;

            curNode.next = nextNextNode;
            nextNode.next = nextNextNode.next;
            nextNextNode.next = nextNode;

            curNode = nextNextNode.next;
        }
        return dummyHead.next;
    }

    public ListNode swapPairsRecursion(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode next = head.next;
        ListNode nextNext = next.next;
        next.next = head;
        head.next = swapPairsRecursion(nextNext);
        return next;
    }

    public void checkSwapPairs() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n1.printAll("Before Swap: ");
        ListNode swap = swapPairs(n1);
        swap.printAll("After Swap: ");

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n1.printAll("Before Recursion Swap: ");
        ListNode recursionSwap = swapPairsRecursion(n1);
        recursionSwap.printAll("After Recursion Swap: ");

    }
}
