package com.zy.linkedlist;

/**
 * 707. 设计链表
 * <p>
 * https://leetcode-cn.com/problems/design-linked-list/
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class MyLinkedList {

    private Node dummyHead;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        this.dummyHead = new Node();
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
        dummyHead.next = newNode;
        ++size;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node pNode = dummyHead;
        while (pNode.next != null) {
            pNode = pNode.next;
        }
        Node newNode = new Node();
        newNode.val = val;
        pNode.next = newNode;
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
        newNode.next = pNode.next;
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
        --size;
    }

    class Node {
        public int val;
        public Node next;
    }
}
