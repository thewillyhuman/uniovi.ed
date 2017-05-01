# Data Structures Subject from prof. Martin Gonzalez at Universidad de Oviedo (Uniovi)

## Description 
This repository contains all the necessary code to understand correctly the subject. As you know it's forbiden to copy your code in this subject and given that this is a public repository and teachers know its existance I strongly recommend you not to copy this code. Otherwise if you do it I have to be mention in the JavaDoc tag @author.
To give some structure to the course it's given as an API called willyOS with the following internal architecture:
```php
 - willyOS
   - SDK
     - Foundation
       - AVLTree
       - ...
     - MathsKit
       - AKS
       - ...
```
# Foundation
The Foundation package includes all the types and structures that represent the core of the API. Example of that are the AVLTrees, the HashTables, Graphs and the Priority Queues.
   
## AVL Tree
###  Overview
In computer science, an AVL tree is a self-balancing binary search tree. It was the first such data structure to be invented.In an AVL tree, the heights of the two child subtrees of any node differ by at most one; if at any time they differ by more than one, rebalancing is done to restore this property. Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases, where n is the number of nodes in the tree prior to the operation. Insertions and deletions may require the tree to be rebalanced by one or more tree rotations. --From Wikipedia.
You can create new AVL Trees as following:
```JAVA
  // AVL Tree that stores integer objects.
  AVLTree<Integer> intTree = new AVLTree<Integer>();

  // AVL Tree that stores string objects.
  AVLTree<String> stringTree = new AVLTree<String>();
```
As a result you have to know that the AVLTree constitutes a generic type, so can be instansiated with any type.
```JAVA
  // AVL Tree that stores integer objects.
  AVLTree<T> genericTree = new AVLTree<T>();
```
    
###  Adding and Removing values
Imagine that you want to add some values to an AVL tree. For that you have to call to the ```add(T value)```. An example of that could be:
```JAVA
  // Adding some values to the tree.
  intTree.add(5);
  intTree.add(3);
  intTree.add(7);
  intTree.add(6);
  intTree.add(9);

  // Will create a tree like this.
      6
     / \
    5   7
   /     \
  3       9
```

To remove values from the item just call the ```remove(T value)```. For example:
```JAVA
  // Adding some values to the tree.
  intTree.remove(3);
  intTree.add(5);

  // Will create a tree like this.
      7
     / \
    6   9
```
