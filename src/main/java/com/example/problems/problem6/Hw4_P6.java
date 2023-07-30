package com.example.problems.problem6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Hw4_P6 {
    public static void main(String[] args) {
        // Generate two arrays with random integers
        int[] insertKeys = generateRandomIntegers(100000, 1, 1000000);
        int[] searchKeys = generateRandomIntegers(100000, 1, 2000000);

        // Variables to store total insertion times for each data structure
        long hashMapInsertTime = 0;
        long arrayListInsertTime = 0;
        long linkedListInsertTime = 0;

        // Create instances of data structures for testing
        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();

        // Repeat the insertion process 10 times to get average insertion time
        for (int i = 0; i < 10; i++) {

            // Measure insertion time for HashMap
            long startTime = System.currentTimeMillis();
            for (int insertKey : insertKeys) {
                myMap.put(insertKey, insertKey);
            }
            long endTime = System.currentTimeMillis();
            hashMapInsertTime += (endTime - startTime);

            // Measure insertion time for ArrayList
            startTime = System.currentTimeMillis();
            for (int insertKey : insertKeys) {
                myArrayList.add(insertKey);
            }
            endTime = System.currentTimeMillis();
            arrayListInsertTime += (endTime - startTime);

            // Measure insertion time for LinkedList
            startTime = System.currentTimeMillis();
            for (int insertKey : insertKeys) {
                myLinkedList.add(insertKey);
            }
            endTime = System.currentTimeMillis();
            linkedListInsertTime += (endTime - startTime);
        }

        // Variables to store total search times for each data structure
        long hashMapSearchTime = 0;
        long arrayListSearchTime = 0;
        long linkedListSearchTime = 0;

        // Repeat the search process 10 times to get average search time
        for (int i = 0; i < 10; i++) {
            // Measure search time for HashMap
            long startTime = System.currentTimeMillis();
            for (int searchKey : searchKeys) {
                myMap.containsKey(searchKey);
            }
            long endTime = System.currentTimeMillis();
            hashMapSearchTime += (endTime - startTime);

            // Measure search time for ArrayList
            startTime = System.currentTimeMillis();
            for (int searchKey : searchKeys) {
                myArrayList.contains(searchKey);
            }
            endTime = System.currentTimeMillis();
            arrayListSearchTime += (endTime - startTime);

            // Measure search time for LinkedList
            startTime = System.currentTimeMillis();
            for (int searchKey : searchKeys) {
                myLinkedList.contains(searchKey);
            }
            endTime = System.currentTimeMillis();
            linkedListSearchTime += (endTime - startTime);
        }

        // Print the results
        System.out.println("Number of keys = 100000");
        System.out.println("HashMap average total insert time = " + (hashMapInsertTime / 10));
        System.out.println("ArrayList average total insert time = " + (arrayListInsertTime / 10));
        System.out.println("LinkedList average total insert time = " + (linkedListInsertTime / 10));

        System.out.println("HashMap average total search time = " + (hashMapSearchTime / 10));
        System.out.println("ArrayList average total search time = " + (arrayListSearchTime / 10));
        System.out.println("LinkedList average total search time = " + (linkedListSearchTime / 10));
    }

    // Function to generate an array of random integers within a given range
    public static int[] generateRandomIntegers(int n, int min, int max) {
        Random r = new Random(System.currentTimeMillis());
        int[] randomIntegers = new int[n];
        for (int i = 0; i < n; i++) {
            randomIntegers[i] = r.nextInt(max - min + 1) + min;
        }
        return randomIntegers;
    }
}
