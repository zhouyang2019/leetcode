package com.zy.heap;

/**
 * 大顶堆
 */
public class Heap {

    public static void print(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]).append(", ");
        }
        System.out.println(sb.toString());
    }

    public static void buildHeap(int[] tree) {
        int last_node = tree.length - 1;
        int last_parent = (last_node - 1) / 2;
        for (int i = last_parent; i >= 0; i--) {
            heapify(tree, tree.length, i);
        }
    }

    public static void heapify(int[] tree, int n, int i) {
        if (i >= n) {
            return;
        }
        int max = i;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        if (c1 < n && tree[i] < tree[c1]) {
            max = c1;
        }
        if (c2 < n && tree[i] < tree[c2]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, i, max);
            heapify(tree, n, max);
        }
    }

    public static void swap(int[] tree, int a, int b) {
        int tmp = tree[a];
        tree[a] = tree[b];
        tree[b] = tmp;
    }

    private int[] table;
    private int capacity;
    private int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new int[capacity];
    }

    public int[] getTable() {
        return this.table;
    }

    public void add(int data) {
        if (size >= capacity) {
            return;
        }
        ++size;
        int last_node = size - 1;
        table[last_node] = data;
        int last_parent = (last_node - 1) / 2;
        while (last_parent >= 0 && table[last_node] > table[last_parent]) {
            swap(table, last_node, last_parent);
            last_node = last_parent;
            last_parent = (last_node - 1) / 2;
        }
    }

    /**
     * 删除堆顶的元素
     */
    public void remove() {
        if (size <= 1) {
            return;
        }
        int last_node = size - 1;
        swap(table, 0, last_node);
        table[last_node] = 0;
        heapify(table, size, 0);
    }
}
