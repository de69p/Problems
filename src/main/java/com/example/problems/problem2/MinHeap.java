package com.example.problems.problem2;

import java.util.NoSuchElementException;

import java.util.*;

public class MinHeap {
    private final List<Integer> heap;

    // Constructor to initialize an empty heap (represented by an ArrayList)
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Helper function to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Helper function to perform the re-heapify operation (fix the heap property from the given index downwards)
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        // Find the smallest element among the current node and its children
        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        // If the smallest element is not the current node, swap it with the smallest child and continue heapifyDown
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Remove the minimum element (root) from the heap
    public void removeMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        // Replace the root with the last element and then perform heapifyDown to maintain the min heap property
        int lastElement = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
    }

    // Insert an element into the heap
    public void insert(int element) {
        heap.add(element);
        int current = heap.size() - 1;
        int parent = (current - 1) / 2;

        // Perform heapifyUp to maintain the min heap property
        while (current > 0 && heap.get(current) < heap.get(parent)) {
            swap(current, parent);
            current = parent;
            parent = (current - 1) / 2;
        }
    }

    // Print the elements in the heap
    public void printHeap() {
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(22);
        minHeap.insert(15);
        minHeap.insert(34);
        minHeap.insert(27);
        minHeap.insert(28);
        minHeap.insert(37);
        minHeap.insert(49);
        minHeap.insert(56);
        minHeap.insert(66);
        minHeap.insert(30);
        minHeap.insert(41);
        minHeap.insert(34);

        System.out.println("Original Heap:");
        minHeap.printHeap();

        System.out.println("\nRemoving minimum element:");
        minHeap.removeMin();

        System.out.println("Heap after removal:");
        minHeap.printHeap();
    }
}




