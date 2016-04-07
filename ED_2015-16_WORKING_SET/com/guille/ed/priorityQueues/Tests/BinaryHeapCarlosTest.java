package com.guille.ed.priorityQueues.Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.guille.ed.priorityQueues.BinaryHeap;

public class BinaryHeapCarlosTest {

    @Test
    public void test_sort_order_A() {

	Integer[] input = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	BinaryHeap<Integer> heap = new BinaryHeap<Integer>(input);

	String result = "";

	// print elements in sorted order
	while (!heap.isEmpty()) {
	    int x = heap.getMin();
	    result += x;
	}

	assertEquals(result, "12345678910");
    }

    @Test
    public void test_sort_order_B() {

	BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
	heap.add(2);
	heap.add(5);
	heap.add(1);

	String result = "";

	// print elements in sorted order
	while (!heap.isEmpty()) {
	    int x = heap.getMin();
	    result += x;
	}

	assertEquals(result, "125");
    }

}
