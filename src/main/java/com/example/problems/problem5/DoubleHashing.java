package com.example.problems.problem5;

import java.util.Arrays;

public class DoubleHashing {

    private static final int TABLE_SIZE = 13;

    // First hash function to calculate the initial index (slot) for the key
    private static int hash(int k) {
        return k % TABLE_SIZE;
    }

    // Second hash function (hashPrime) for double hashing
    private static int hashPrime(int k) {
        return 1 + (k % 11);
    }

    // Function to insert a key into the hash table using double hashing for collision resolution
    private static void insert(int k, int[] table) {
        int i = hash(k); // Calculate the initial index (slot) for the key

        // Keep probing using double hashing until an empty slot is found
        while (table[i] != 0) {
            i = (i + hashPrime(k)) % TABLE_SIZE; // Increment the index using the second hash function
        }

        table[i] = k; // Insert the key into the found empty slot
    }

    public static void main(String[] args) {
        int[] table = new int[TABLE_SIZE];
        Arrays.fill(table, 0);

        // Insert keys into the hash table using double hashing for collision resolution
        insert(2, table);
        insert(29, table);
        insert(18, table);
        insert(21, table);
        insert(48, table);
        insert(15, table);

        System.out.println("Table before insert 16: " + Arrays.toString(table));

        // Insert key 16 into the hash table using double hashing for collision resolution
        insert(16, table);

        System.out.println("Table after insert 16: " + Arrays.toString(table));
    }

}

