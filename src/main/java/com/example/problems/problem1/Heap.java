package com.example.problems.problem1;

import java.util.Arrays;

public class Heap {

    // Function to adjust the heap rooted at index i to maintain the min heap property
    public static void heapify(int[] arr, int n, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If the left child is smaller than the root, update the root index
        if (left < n && arr[left] < arr[root]) {
            root = left;
        }

        // If the right child is smaller than the current root, update the root index
        if (right < n && arr[right] < arr[root]) {
            root = right;
        }

        // If the root index has been updated, swap the root element with the smaller child
        if (root != i) {
            int temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;

            // Continue heapifying the affected subtree recursively
            heapify(arr, n, root);
        }
    }

    // Function to build a min heap from an unsorted array
    public static void buildHeap(int[] arr) {
        int n = arr.length;

        // Start heapifying from the last non-leaf node and move up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    // Function to add a new value to the min heap
    public static int[] addToHeap(int[] arr, int newValue) {
        int n = arr.length;
        int[] newArr = Arrays.copyOf(arr, n + 1);
        newArr[n] = newValue;

        int i = n;
        // Percolate the newly added value up the heap to maintain the min heap property
        while (i > 0 && newArr[(i - 1) / 2] > newArr[i]) {
            int temp = newArr[i];
            newArr[i] = newArr[(i - 1) / 2];
            newArr[(i - 1) / 2] = temp;
            i = (i - 1) / 2;
        }

        return newArr; // Return the new min heap array with the added value
    }

    public static void main(String[] args) {
        int[] minHeapArr = {42, 75, 56, 83, 77, 95};

        System.out.println("Original Min Heap: " + Arrays.toString(minHeapArr));

        // Build the min heap from the original array
        buildHeap(minHeapArr);

        System.out.println("Min Heap: " + Arrays.toString(minHeapArr));

        int newValue = 27;
        // Add a new value (27) to the min heap
        minHeapArr = addToHeap(minHeapArr, newValue);

        System.out.println("\nMin Heap after adding " + newValue + ": " + Arrays.toString(minHeapArr));
    }
}

