package com.example.problems.problem4;

import java.util.Arrays;

public class LinearProbingHashTable {

    private final int[] table;

    // Constructor to create a LinearProbingHashTable with a given size (number of slots)
    public LinearProbingHashTable(int size) {
        this.table = new int[size];
    }

    // Function to insert a key into the hash table using linear probing for collision resolution
    public void insert(int key) {
        int index = key % table.length; // Calculate the index (slot) based on the key using modulo operator

        // Keep probing (linearly incrementing the index) until an empty slot is found
        while (table[index] != 0) {
            index = (index + 1) % table.length;
        }

        table[index] = key; // Insert the key into the found empty slot
        System.out.println("Inserted " + key + " at index " + index);
        System.out.println("Hash Table: " + Arrays.toString(table));
    }

    public static void main(String[] args) {
        LinearProbingHashTable hashTable = new LinearProbingHashTable(11);
        int[] keys = {5, 8, 44, 23, 12, 20, 35, 32, 14, 16};

        // Insert keys into the hash table using linear probing for collision resolution
        for (int key : keys) {
            hashTable.insert(key);
        }

        System.out.println("Final Hash Table: " + Arrays.toString(hashTable.table));
    }
}





