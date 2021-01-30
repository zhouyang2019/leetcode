package com.geektime.list;

import org.junit.Test;

/**
 * 单向链表
 * 双向链表
 * 环形链表
 */
public class List06 {

    /**
     * 链表代码边界条件：
     * <p>
     * 链表为空
     * 链表只有一个结点
     * 链表只有两个结点
     * 处理头结点
     * 处理尾结点
     */

    @Test
    public void testSingleList1() {
        BaseList list = new SingleList();
        fillData(list);
        list.print();
        list.delete("str2");
        list.print();
        list.delete("str3"); // 删除尾节点
        list.print();
        list.delete("str1"); // 删除头节点
        list.print();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSingleList2() {
        BaseList list = new SingleList();
        list.delete("str");
    }

    @Test
    public void testDequeList1() {
        BaseList list = new DequeList();
        fillData(list);
        list.print();
        list.delete("str2");
        list.print();
        list.delete("str3"); // 删除尾节点
        list.print();
        list.delete("str1"); // 删除头节点
        list.print();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDequeList2() {
        BaseList list = new DequeList();
        list.delete("str");
    }

    @Test
    public void testCircleList1() {
        BaseList list = new CircleList();
        fillData(list);
        list.print();
        list.delete("str2");
        list.print();
        list.delete("str3"); // 删除尾节点
        list.print();
        list.delete("str1"); // 删除头节点
        list.print();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCircleList2() {
        BaseList list = new CircleList();
        list.delete("str");
    }

    private void fillData(BaseList list) {
        list.add("str1");
        list.add("str2");
        list.add("str3");
    }

    public static abstract class BaseList {
        ListNode<String> head;
        ListNode<String> tail;
        int size = 0;

        public abstract void add(String nodeVal);

        public abstract void delete(String nodeVal);

        public abstract void print();
    }

    public static class SingleList extends BaseList {

        @Override
        public void add(String nodeVal) {
            // 插入头节点
            if (head == null) {
                head = new ListNode<>();
                head.setVal(nodeVal);
                tail = new ListNode<>();
                head.setNext(tail);
            } else {
                tail.setVal(nodeVal);
                ListNode newNode = new ListNode();
                tail.setNext(newNode);
                tail = newNode;
            }
            size++;
        }

        @Override
        public void delete(String val) {
            if (val == null) {
                throw new IllegalArgumentException("val is null");
            }
            if (head == null) {
                throw new IllegalArgumentException("val 不存在");
            }
            // 删除头节点
            if (val.equals(head.getVal())) {
                head = head.getNext();
                return;
            }
            ListNode cur = head;
            while (cur.getNext() != null) {
                if (val.equals(cur.getNext().getVal())) {
                    cur.setNext(cur.getNext().getNext());
                    size--;
                    return;
                }
                cur = cur.getNext();
            }

            throw new IllegalArgumentException("val 不存在");
        }

        @Override
        public void print() {
            if (head == null || head.getNext() == null) {
                System.out.println("empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            ListNode cur = head;
            while (cur.getNext() != null) {
                sb.append(cur.getVal()).append("\r\n");
                cur = cur.getNext();
            }
            System.out.println(sb.toString());
        }
    }

    public static class DequeList extends BaseList {

        @Override
        public void add(String val) {
            if (head == null) {
                head = new ListNode<>();
                tail = new ListNode<>();
                head.setVal(val);
                head.setNext(tail);
                tail.setPre(head);
            } else {
                tail.setVal(val);
                ListNode newNode = new ListNode();
                tail.setNext(newNode);
                newNode.setPre(tail);
                tail = newNode;
            }
            size++;
        }

        @Override
        public void delete(String val) {
            if (val == null) {
                throw new IllegalArgumentException("val is null");
            }
            if (head == null) {
                throw new IllegalArgumentException("val 不存在");
            }
            // 删除头节点
            if (val.equals(head.getVal())) {
                head = head.getNext();
                return;
            }
            ListNode cur = head;
            while (cur.getNext() != null) {
                if (val.equals(cur.getNext().getVal())) {
                    cur.getNext().getNext().setPre(cur);
                    cur.setNext(cur.getNext().getNext());
                    size--;
                    return;
                } else {
                    cur = cur.getNext();
                }
            }

            throw new IllegalArgumentException("val 不存在");
        }

        @Override
        public void print() {
            print1();
            print2();
        }

        private void print1() {
            if (head == null || head.getNext() == null) {
                System.out.println("empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            ListNode cur = head;
            while (cur.getNext() != null) {
                sb.append(cur.getVal()).append("\r\n");
                cur = cur.getNext();
            }
            System.out.println(sb.toString());
        }

        private void print2() {
            if (head == null || head.getNext() == null) {
                System.out.println("empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            ListNode cur = tail;
            while ((cur = cur.getPre()) != null) {
                sb.append(cur.getVal()).append("\r\n");
            }
            System.out.println(sb.toString());
        }

    }

    public static class CircleList extends BaseList {

        @Override
        public void add(String val) {
            if (size == 0) {
                ListNode node = new ListNode();
                node.setVal(val);
                node.setNext(node);
                node.setPre(node);
                tail = head = node;
            } else {
                ListNode newNode = new ListNode();
                newNode.setVal(val);
                tail.setNext(newNode);
                newNode.setPre(tail);
                newNode.setNext(head);
                tail = newNode;
                head.setPre(tail);
            }
            size++;
        }

        @Override
        public void delete(String val) {
            if (val == null) {
                throw new IllegalArgumentException("val is null");
            }
            if (head == null) {
                throw new IllegalArgumentException("val 不存在");
            }
            ListNode cur = head;
            if (val.equals(head.getVal())) {
                tail.setNext(head.getNext());
                head.getNext().setPre(tail);
                if (size == 1) {
                    tail = head = null;
                } else {
                    head = head.getNext();
                }
                size--;
                return;
            }
            if (size == 1) {
                throw new IllegalArgumentException("val 不存在");
            }

            while (true) {
                if (val.equals(cur.getNext().getVal())) {
                    cur.getNext().getNext().setPre(cur);
                    cur.setNext(cur.getNext().getNext());
                    size--;
                    return;
                } else {
                    cur = cur.getNext();
                }
                if (cur == head) {
                    throw new IllegalArgumentException("val 不存在");
                }
            }

        }

        @Override
        public void print() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = head;
            if (cur == null) {
                System.out.println("empty");
                return;
            }
            while (cur.getNext() != head) {
                sb.append(cur.getVal()).append("\r\n");
                cur = cur.getNext();
            }
            sb.append(cur.getVal()).append("\r\n");
            System.out.println(sb.toString());
        }

    }

}
