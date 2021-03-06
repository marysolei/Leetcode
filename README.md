
Solutions to problems on Leetcode, using Golang and JAVA.

Feel free to make a pull request, if you are interested in helping or you have solutions in different programming languages.


# Data Structures

 ## Arrays & Strings
 
 - The array has a fixed size in Java.
 - ArrayLists have dynamic resizing feature. When the Array is full, it doubles the size.
 - Copying a string is an expensive operation, an alternative can be using String Builder.
 - String Builder is a resizable array of Strings. String Builder can be converted to a String when it is needed.
 
 ## Hash Table
 
 - It is a map of keys to values.
 - How it can be implemented?  Using an array of linked lists and a hash function.
 - How does it work? 
    - The hashcode of the key is computed using a hash function.
    - The result will be mapped to an index in the array. e.g. (key % ArrayLength).
    - The key and value will be stored in that index.
    
    ### Collision Handling:
    
    - Since there are infinite values and finite possible hashcode or indexes in an array collision may occur. How to handle the collision?
        - Chaining with Linked List: it is the most common way in which we make a hashtable of items with having an array that maps to a linked list. The keys and values are stored in Linked Lists. The time complexity of access is O(n) in the worst case.
        - Chaining with Binary Search Tree: The collisions are stored in a binary search tree. The method is not that common but provides time complexity of O(logn).
        - Open Addressing with Linear Probing: while saving the key value in the hash map, if a collision occurs, increment the index and move to the next index till we find the next open spot. If the number of collisions is low, this method can be very fast and space efficient.
        - Quadratic Probing: Like the approach above but instead of linear search for next open spot, do a quadratic search for the next open spot. Another possible approach is to do a double hash function as well.
        
   ## Linked Lists
     - No constant time Access (unlike arrays).
     - Add or remove to the beginning of the Linked List is constant. 
     
     
     
     ```
     Class Node {
     int data; 
     Node next; 
     public Node (int data) {
     this.data= data;
      }
     }
     ```
        
    ## Stack
    
     - The order in stack is LIFO (Last in First out).
     - The adds and removes can be done in constant time.
     - No constant time access.
     - 4 available functions: pop(), push(), peek() and isEmpty();
     - Stacks can be implemented by linked lists.
     
     
     
     ```
     public class stackNode <int> {
      
      int data; 
      stackNode next; 
      public stackNode (int d) {
       this.data= d; 
       }
     }
     ```
   ## Queue
   
     - The order in Queue is FIFO (First in First out).
     - The adds and removes can be done in constant time.
     - It is used in Breadth First Search.
     - 4 available functions:  add(), remove(), peek() and isEmpty();
     - Queues can be implemented by linked lists.
   
   
   
   ```
   public class MyQueue {
    
    public class QueueNode {
     
     int data;
     QueueNode next; 
     public QueueNode (int d) {
      this.data=d;
       }
     }
    }
   ```
   
   ## Trees
   
   - Tree is a type of connected graph with no cycle.
   - Tree has a root node.
   
   ```
   class TreeNode{
    int data; 
    TreeNode[] children;
    }
   ```
   ### Different Types of Trees:
   
   - Binary Tree: A tree that has up to 2 children.
   - Binary Search Tree: A binary tree with the condition: Value of all left descendants <= Value of root < Value of all right descendants.
   - Balanced Tree: insertion and find time complexity: O(logn) where n is the number of nodes in the tree.
   - Complete Binary Tree: A binary tree in which every level of the tree is fully filled except the last level.
   - Full Binary Tree: A binary tree in which every node has either zero or two children.
   - Perfect Binary Tree: A tree that is full and complete. The number of nodes in the level of K in a perfect binary tree is 2^K-1 nodes.
   
   
   ## Graphs
   
   - Graphs can be directed or undirected.
   - Connected Graph: if we have a path between every pair of vertices.
   - Acyclic Graph: a graph without a cycle.
   
   There are two ways of representing a graph a) Adjacency List b) Adjacency Matrix
   
   ```
   //Representing a graph in the form of an adjacency list
   
   class Node {
     int data;
     Node[] children;
   }
   
   class Graph {
     public Node[] nodes;
   }
   ```
   
   ### Graph Search
   
 There are two types of graph searches: **a)** Breadth Frist Search (BFS) **b)** Depth First Search (DFS).
  
  **DFS:** In this search, we start at the root and explore each branch completely before moving to the next branch. So we go deep and then we go wide. 
  
   **BFS:** We start at the root and explore each neighbor and then we go to the next step. So we go wide and then we go deep.
    
 **Bidirectional Search:** In this type of graph search we run two BFSs from the source node to the destination node. When these two searches collide then there is a path.
    The bidirectional search is faster than a single BFS, why? 
    Imagine we start at node S and the destination is node D. The distance between these two nodes is t nodes, and each node has at most k neighbors. Using a BFS, for each step we have k nodes if we have t steps we have k^t nodes. Using a bidirectional search the distance from each node will be t/2 so the total steps will be 2*(k^(t/2)), so the time complexity is O(k^(t/2) which is faster than the BFS method with a complexity of O(k^t).
    

## Heap 


Heap is a special case of a balanced binary tree data structure where the root-node key is compared with its children and arranged accordingly. If a has a child node b then key(a)>= key(b).

**MinHeap** where the value of the root node is less than or equal to either of its children.

**MaxHeap** where the value of the root node is greater than or equal to either of its children.

**How to add a node to the heap:**

**Step1:** Create a new node at the end of the heap.

**Step2:** Assign the new value to the node.

**Step3:** Compare the value of this child node with its parent.

**Step4:** If the value of the parent is less than the child then swap them.

**Step5:** Repeat steps 3 & 4 until heap property holds.


## Sorting 

### Bubble Sort:
Repeatedly swap adjacent elements.

**Time Complexity:** O(n^2).

**Space Complexity:** O(1) in place.

### Selection Sort:
Repeatedly finding the min value from the unsorted part and put it at the beginning.

**Time Complexity:** O(n^2).

**Space Complexity:** O(1) in place.

### Insertion Sort:
It is like when we sort the cards

**Time Complexity:** O(n^2).

**Space Complexity:** O(1) in place.

### Merge Sort:
Dividing the array into two halves and call the function for each half. In the end, merge two halves.

**Time Complexity:** O(nlogn).

**Space Complexity:** depends

### Quick Sort: 
Pick an element as pivot and partition array around the pivot.


**Time Complexity:** O(nlogn) in the average case and O(n^2) in the worst case. 

**Space Complexity:** depends.

### Radix Sort: 
Sorting digit by digit starting from the least significant digit. 

**Time Complexity:** O(nk) where n is the total numbers in the array to be sorted and k is the max digits in the number.
