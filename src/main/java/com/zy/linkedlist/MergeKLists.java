package com.zy.linkedlist;

import org.junit.Test;

import java.util.PriorityQueue;

public class MergeKLists {

    @Test
    public void test() {
        ListNode h1 = new ListNode(0);
        ListNode n11 = new ListNode(4);
        ListNode n12 = new ListNode(5);
        h1.next = n11;
        n11.next = n12;

        ListNode h2 = new ListNode(1);
        ListNode n21 = new ListNode(3);
        ListNode n22 = new ListNode(4);
        h2.next = n21;
        n21.next = n22;

        ListNode h3 = new ListNode(2);
        ListNode n31 = new ListNode(6);
        h3.next = n31;

        ListNode[] listNodes = new ListNode[]{h1, h2, h3};
        print(h1);
        print(h2);
        print(h3);
        print(mergeKLists(listNodes));

    }

    @Test
    public void test2() {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(2);
        ListNode[] listNodes = new ListNode[]{h1, null};
//        ListNode[] listNodes = new ListNode[]{h2, null};
        print(mergeKLists(listNodes));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            if (lists[0] == null) {
                return null;
            }
            if (lists[0].next == null) {
                return lists[0];
            }
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode head = new ListNode(0);
        ListNode pNode = head;
        while (queue.size() > 0) {
            ListNode curNode = queue.poll();
            if (curNode.next != null) {
                queue.add(curNode.next);
            }
            pNode.next = curNode;
            pNode = pNode.next;
        }

        return head.next;
    }

    public static void print(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }

    class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
