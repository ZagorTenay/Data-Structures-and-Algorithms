# Data-Structures-and-Algorithms
This repository contains two assignments and some laboratory tasks of the Data Structures and Algorithms course.

### Assignment 1 Sorting Algorithm

Design and code a recursive sorting algorithm which sorts positive integers (32 bit unsigned integers) in increasing order according to the following approach using Java:

Here is an example of 8-bit integers: </br>
Think about the integers 132, 14, 2 and 9. </br>
The binary representations of these integers are: </br>
>132 = 10000100  </br>
>14 = 00001100  </br>
>2 = 00000010  </br>
>9 = 00001001  </br></br>

|                | 7.bit          | 6.bit          | 5.bit          | 4.bit          | 3.bit          | 2.bit          | 1.bit          | 0.bit          |
|     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |
| 132            | 1              | 0              | 0              | 0              | 0              | 1              | 0              | 0              |
| 14             | 0              | 0              | 0              | 0              | 1              | 1              | 1              | 0              |
| 2              | 0              | 0              | 0              | 0              | 0              | 0              | 1              | 0              |
|9               | 0              | 0              | 0              | 0              | 1              | 0              | 0              | 1              |       

</br>In each call, the algorithm replaces the integers in the region specified by parameters “p” and “q” and depending on bit values indicated by the parameter “digit”. At that point, the algorithm places the integers whose current bit values are 0 to the left part of the region specified by “p” and “q”; places the integers whose current bit values are 1 to the right part. For that purpose, in a loop, the algorithm compares bit values of two integers in the p th and q th positions of the array. If necessary, these two numbers are shifted mutually and “p” and/or “q” are updated accordingly. If not necessary, updating “p” and/or “q” is sufficient. In the comparison of two bits, there are four possibilities: 0-0, 0-1, 1-0, 1-1. Updating “p” and/or “q” is performed depending on these four cases. An example is shown in the following table. Here, starting from the most significant bit (7. bit), the algorithm changes the positions of the integers as shown in the following table. The bold lines in the table indicates the regions processed by recursive calls. </br> </br>

|                | 132            | 14             | 2              | 9              |
|     :---:      |     :---:      |     :---:      |     :---:      |     :---:      |
|  Start:       | 10000100 (132)         | 00001110 (14)         | 00000010 (2)  | 00001001 (9)    |
| After 7.bit placement|**0**0001001 (9)    | **0**0001110 (14)    | **0**0000010 (2)  | 10000100 (132)  |
| After 6.bit placement  |0**0**001001 (9) |0**0**001110 (14) |0**0**000010 (2) |10000100 (132)|
|  After 5.bit placement  | 00**0**01001 (9)   | 00**0**01110 (14) | 00**0**00010 (2) |10000100 (132) |
| After 4.bit placement | 000**0**1001 (9) | 000**0**1110 (14) | 000**0**0010 (2) | 10000100 (132) |
| After 3.bit placement | 0000**0**010 (2) | 0000**1**110 (14) | 0000**1**001 (9) | 10000100 (132) |
| After 2.bit placement | 00000**0**10 (2) | 00001**0**01 (9) | 00001**1**10 (14) | 10000100 (132) |
| After 1.bit placement | 00000010 (2) | 00001001 (9) | 00001110 (14) | 10000100 (132) |
| After 0.bit placement | 00000010 (2) | 00001001 (9) | 00001110 (14) | 10000100 (132) | 
| Resulting array: | 2 | 9 | 14 | 132 |

</br>

>public void Our_sort(UInt32[] array, int p, int q, int digit)

</br>Here;
array = the array which will be sorted by Our_sort function. </br>
p = starting index </br>
q = last index </br>
Initially, you should run the algorithm as Our_sort (array, 0, array.Length-1, 32).

### Assignment 2 Augmented AVL Tree

Description: You are expected to implement a balanced binary search tree (specifically an AVL-Tree)
which performs operations and queries displayed below. Then you are required to improve it by
augmenting the tree structure to make some queries faster. Finally, compare them according to the
computing time of queries. Project will be coded in Java.

##### Task - 1

Design and code AVL-Tree data structure with the following capabilities:
-INSERT: insert an input item with a given key (an integer number)
-GETSUMSMALLER: get summation of items smaller than a given input key
-GETMAX: get maximum of all items
-GETMIN: get minimum of all items
-GETSUM: get summation of all items in tree
-PRINT: display all items of the tree by applying in-order tree walk.

##### Task - 2

The program should run the methods in the following order for testing.
-Insert all elements
-Print the time elapsed for the insertion of all items
-Print the result of GETSUMSMALLER for the item with value 1000
-Print the maximum value
-Print the minimum value
-Print the summation of all items (GETSUM)
-Print the time elapsed during GETSUM

##### Task - 3

Improve the AVL-Tree class by augmenting the structure so that each node holds an additional field:
the sum of all items (keys) that are smaller than the current node item. Note that you need to update
this value on each insert operation.
The standard output of your program should appear as follows:

>------ AVL-Tree ------  </br>
>All items were inserted.  </br>
>The time elapsed for the insertion of all items is 2,47563383 nanoseconds  </br>
>The result of GETSUMSMALLER for the item with value 1000 is 23442  </br>
>The maximum value of all items is 1987  </br>
>The minimum value of all items is 2  </br>
>The summation of all items is 221327  </br>
>The time elapsed for GETSUM is 0,01563383 nanoseconds  </br>

>------ Augmented AVL-Tree ------  </br>
>All items were inserted.  </br>
>The time elapsed for the insertion of all items is 3,15623873 nanoseconds  </br>
>The result of GETSUMSMALLER for the item with value 1000 is 23442  </br>
>The maximum value of all items is 1987  </br>
>The minimum value of all items is 2  </br>
>The summation of all items is 221327  </br> 
>The time elapsed for GETSUM is 0,00062383 nanoseconds  </br>

##### Task - 4

Compare the running times (in nanoseconds) of the INSERT and GETSUM methods for AVL-Tree and
Augmented AVL-Tree with sizes of 1000, 10000, 100000 items; fill Table 1 accordingly. Use
System.nanoTime() to calculate the time elapsed. You need to generate the items randomly
(Generate random numbers between 0 and 2000). You should use the same input for testing both
AVL-Tree and Augmented AVL-Tree for each size (i.e., 1000, 10000, 100000). If you get memory
errors while inserting large amount of numbers (e.g., size of 100000), you can rescale input sizes e.g.,
500, 5000, 50000.

