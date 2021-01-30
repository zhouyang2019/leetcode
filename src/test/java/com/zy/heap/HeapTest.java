package com.zy.heap;

import org.junit.Test;

import static com.zy.heap.Heap.print;

public class HeapTest {

    @Test
    public void testBuildHeap() {
        int[] tree = {14, 10, 3, 5, 1, 9, 2};
        Heap.buildHeap(tree); // 14, 10, 9, 5, 1, 3, 2
        print(tree);
    }

    @Test
    public void testAdd() {
        Heap heap = new Heap(4);
        heap.add(3);
        print(heap.getTable());
        heap.add(5);
        print(heap.getTable());
        heap.add(2);
        print(heap.getTable());
        heap.add(10);
        print(heap.getTable());

        heap.remove();
        print(heap.getTable());
    }

    @Test
    public void testRemove() {

    }

}