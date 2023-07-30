# Heaps, Hash Tables, and Double Hashing

This repository contains Java code for implementing heaps, hash tables, and double hashing.

## Heaps

A heap is a specialized tree-based data structure that satisfies the heap property. In a max heap, the value of the parent node is greater than or equal to the values of its children. In a min heap, the value of the parent node is less than or equal to the values of its children.

The `Heap` class implements a min heap in Java. The `buildHeap` method builds a min heap from an unsorted array, and the `addToHeap` method adds a new value to the min heap.

The `MinHeap` class implements a min heap using an ArrayList. The `insert` method inserts a new value into the min heap, and the `removeMin` method removes the minimum value (root) from the min heap.

## Hash Tables

A hash table is a data structure that maps keys to values. The keys are hashed to a particular index in the hash table, and the values are stored at that index.

The `ChainingHashTable` class implements a hash table using chaining for collision resolution. The `insert` method inserts a key-value pair into the hash table, and the `get` method retrieves the value associated with a given key.

The `LinearProbingHashTable` class implements a hash table using linear probing for collision resolution. The `insert` method inserts a key-value pair into the hash table, and the `get` method retrieves the value associated with a given key.

## Double Hashing

Double hashing is a collision resolution technique for hash tables. It uses two hash functions to calculate the index for a key. If the first hash function results in a collision, the second hash function is used to increment the index until an empty slot is found.

The `DoubleHashing` class implements double hashing for collision resolution in a hash table. The `insert` method inserts a key-value pair into the hash table, and the `get` method retrieves the value associated with a given key.
