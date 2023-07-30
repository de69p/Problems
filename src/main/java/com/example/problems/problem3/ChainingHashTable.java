package com.example.problems.problem3;

import java.util.LinkedList;

public class ChainingHashTable {

    private final LinkedList<Integer>[] table;

    // Constructor to create a ChainingHashTable with a given size (number of buckets)
    public ChainingHashTable(int size) {
        this.table = new LinkedList[size];
    }

    // Function to insert a key into the hash table
    public void insert(int key) {
        int index = key % table.length; // Calculate the index (bucket) based on the key using modulo operator
        LinkedList<Integer> list = table[index]; // Get the linked list (chain) at the calculated index

        if (list == null) {
            // If the linked list is empty (no collision), create a new list and add the key
            list = new LinkedList<>();
            list.add(key);
            table[index] = list; // Store the list at the calculated index in the table
        } else {
            // If the linked list is not empty (collision occurred), simply add the key to the list
            list.add(key);
        }
    }

    public static void main(String[] args) {
        ChainingHashTable hashTable = new ChainingHashTable(11);
        int[] keys = {5, 8, 44, 23, 12, 20, 35, 32, 14, 16};

        // Insert keys into the hash table
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Print the elements in each bucket of the hash table (non-empty buckets)
        System.out.println("Elements in each bucket of the hash table:");
        for (int i = 0; i < hashTable.table.length; i++) {
            if (hashTable.table[i] != null) {
                System.out.println("Bucket " + i + ": " + hashTable.table[i]);
            }
        }
    }
}

