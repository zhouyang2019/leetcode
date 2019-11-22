package com.zy.linkedlist;

import java.util.*;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

    public static void main(String[] args) {
//        ListNode<Integer> node = ListNode.buildByList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
//        System.out.println("#### node is: ");
//        ListNode.traverse(node);
//        System.out.println("#### reverse node is: ");
//        ListNode.traverse(reverse(node));
//        ListNode.traverse(reverse(node, null));
//        System.out.println("#### reverseKGroup node is: ");
//        ListNode.traverse(reverseKGroup(node, 3));

//        while (true) {
//            Scanner in = new Scanner(System.in);
//            System.out.println("Please enter a sentence: ");
//            String inputStr = in.nextLine();
//            List<String> inputList = new ArrayList<>();
//            for (char c : inputStr.toCharArray()) {
//                inputList.add(String.valueOf(c));
//            }
////            ListNode node = reverse(ListNode.buildByList(inputList));
//            ListNode node = reverseKGroup(ListNode.buildByList(inputList), 5);
//            ListNode.traverseVal(node);
//        }

        testCheckCircle();
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;
        int count = 0;
        while (end != null) {
            count++;
            // group
            if (count % k == 0) {
                // reverse linked list (start, end]
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }

    /**
     * reverse linked list from range (start, end), return last node.
     * for example:
     * 0->1->2->3->4->5->6->7->8
     * |           |
     * start       end
     *
     * After call start = reverse(start, end)
     *
     * 0->3->2->1->4->5->6->7->8
     *          |  |
     *       start end
     *       first
     *
     */
    public static ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode prev = start;
        ListNode first = curr;
        while (curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }

    /**
     * 单链表反转
     */
    public static <T> ListNode<T> reverse(ListNode<T> start) {
        ListNode<T> curr = start, prev = null;
        while (curr != null) {
            ListNode<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 检测环
     */
    public static <T> boolean checkCircle(ListNode<T> head) {
        if (head == null) {
            return false;
        }
        ListNode<T> fast = head.next;
        ListNode<T> slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("此处有环: " + fast.val);
                return true;
            }
        }
        return false;
    }

    /**
     * 检查链表代码正确性：
     * 1 链表为空
     * 2 链表只有一个节点
     * 3 链表只有两个节点
     * 4 代码逻辑，头节点尾节点是否正常工作
     */
    public static void testCheckCircle() {
        ListNode<Integer> node = new ListNode<>(0);
        ListNode<Integer> node1 = new ListNode<>(1);
        ListNode<Integer> node2 = new ListNode<>(2);
        ListNode<Integer> node3 = new ListNode<>(3);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        boolean hasCircle = checkCircle(node);
        System.out.println("rst is: " + hasCircle);

        //链表只有一个节点
        System.out.println("#### 链表只有一个节点 ####");
        ListNode la1 = new ListNode<>(0);
        System.out.println("rst is: " + checkCircle(la1));
        la1.next = la1;
        System.out.println("rst is: " + checkCircle(la1));

        //链表只有两个节点
        System.out.println("#### 链表只有两个节点 ####");
        ListNode lb1 = new ListNode<>(0);
        ListNode lb2 = new ListNode<>(1);
        lb1.next = lb2;
        System.out.println("rst is: " + checkCircle(lb1));
        lb2.next = lb1;
        System.out.println("rst is: " + checkCircle(lb1));


    }

    public static class ListNode<T> {
        public T val;
        public ListNode next;

        public ListNode(T val) {
            this.val = val;
        }

        public static <T> ListNode<T> buildByList(List<T> list) {
            if (list == null || list.size() < 1) {
                throw new IllegalArgumentException();
            }

            ListNode<T> headNode = new ListNode<>(list.get(0));
            ListNode<T> p = headNode;
            for (int i = 1; i < list.size(); i++) {
                ListNode<T> curr = new ListNode<>(list.get(i));
                p.next = curr;
                p = curr;
            }

            return headNode;
        }

        public static void traverse(ListNode node) {
            while (node != null) {
                System.out.println(node.val + ", " + (node.next == null ? "null" : node.next.val));
                node = node.next;
            }
        }

        public static <T> void traverseVal(ListNode<T> node) {
            List<T> list = new ArrayList<>();
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }

            String rst = "";
            for (T t : list) {
                rst += t.toString();
            }
            System.out.println(rst);
        }

    }


}
