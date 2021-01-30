package com.zy.linkedlist;

/**
 * 707. 设计链表
 * <p>
 * https://leetcode-cn.com/problems/design-linked-list/
 */

import org.junit.Test;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class MyLinkedList2 {

    private Node dummyHead;
    private Node tail;
    private int size;

    @Test
    public void test() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(1);
        System.out.println(list.get(0));
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
        list.addAtHead(2);
        list.addAtHead(3);
        list.addAtHead(4);
        System.out.println(list.get(1));
        list.addAtTail(1);
        System.out.println(list.get(0));
        System.out.println(list.get(3));
        list.addAtIndex(3, 99);
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        list.addAtIndex(5, 55);
        System.out.println(list.get(5));
    }

    @Test
    public void testAddAtTail() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(1);
        list.addAtIndex(1, 2);
        list.addAtTail(3);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

    @Test
    public void test2() {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        System.out.println(list.get(3));
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        this.dummyHead = new Node();
        this.tail = dummyHead;
        this.size = 0;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node pNode = dummyHead;
        for (int i = 0; i <= index; i++) {
            pNode = pNode.next;
        }
        return pNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node();
        newNode.val = val;
        newNode.next = dummyHead.next;
        if (dummyHead.next == null) {
            tail = newNode;
        } else {
            dummyHead.next.prev = newNode;
        }
        dummyHead.next = newNode;
        ++size;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node();
        newNode.val = val;
        tail.next = newNode;
        newNode.prev = tail;

        tail = tail.next;
        ++size;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        Node pNode = dummyHead;
        for (int i = 0; i < index; i++) {
            pNode = pNode.next;
        }
        Node newNode = new Node();
        newNode.val = val;
        if (pNode.next != null) {
            newNode.next = pNode.next;
            pNode.next.prev = newNode;
        } else {
            tail = newNode;
        }
        newNode.prev = pNode;
        pNode.next = newNode;
        ++size;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node pNode = dummyHead;
        for (int i = 0; i < index; i++) {
            pNode = pNode.next;
        }
        pNode.next = pNode.next.next;
        if (pNode.next != null) {
            pNode.next.prev = pNode;
        } else {
            tail = pNode;
        }
        --size;
    }

    class Node {
        public int val;
        public Node next;
        public Node prev;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }

    @Test
    public void testCreateNode() {
        int[] a = {1,2,3};
        Node node = createNode(a);
        printNode(node);
    }

    public Node createNode(int[] a) {
        Node[] nodes = new Node[a.length];
        for (int i = 0; i < a.length; i++) {
            nodes[i] = new Node(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
            }
            if (i < a.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }
        return nodes[0];
    }

    public void printNode(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(", ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }
}
