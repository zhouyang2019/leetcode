package com.geektime.list;

public class ListNode<T> {

    private ListNode pre;

    private T val;

    private ListNode next;

    public ListNode getPre() {
        return pre;
    }

    public ListNode<T> setPre(ListNode pre) {
        this.pre = pre;
        return this;
    }

    public T getVal() {
        return val;
    }

    public ListNode<T> setVal(T val) {
        this.val = val;
        return this;
    }

    public ListNode getNext() {
        return next;
    }

    public ListNode<T> setNext(ListNode next) {
        this.next = next;
        return this;
    }
}
