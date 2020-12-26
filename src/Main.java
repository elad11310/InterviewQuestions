import javafx.util.Pair;
import org.omg.PortableInterceptor.INACTIVE;
import sun.nio.cs.ext.MacThai;

import java.util.*;
import java.util.LinkedList;

public class Main {

    /**
     * this class represents some interview questions.
     * 1)printAllPermutations - recursively prints all arr permutations.
     * 2)RandInO_I - this function gets an array in length of N and prints i random numbers without any memory use to save numbers we already print
     * and in complexity - O(I) - whats means if i==4 we print 4 different numbers from the arr in a loop that runs 4 times at all.
     * 3)swap - swap 2 int variables in arr without a temp variable
     * 4) by given an arr with numbers 1-100 , if we take out 1 variable, whats the value we took out?(we are allowed to iterate once on the arr)
     * if we take out 2 variables , what the value of them? (we are allowed to iterate once on the arr)
     * for the first answer  - we know that sum of arithmetic sequence from 1-100 is 5050,so we will count the sum of the arr and do 5050 - sum and that's the value we took
     * for the second answer - for the first iteration we will do as same as the first question. now we have a number that is the sum of 2 numbers we took out.
     * we will make it's average (dividing by two), because zero is out of the game so we know that 1 number is greater then the average and 1 is lower.
     * for example if the sum was 100, so we know 1 num is less then 50 and the other is greater then 50.
     * so in the second iteration we will count the numbers that are lower/greater then 50 (we can choose), and then we will make an arithmetic sequence between 1-50,
     * and substract the sum from it. and that's will be the first of two numbers, the second we can find by subtracting the num from 100. ( no implementation for this ex)
     * 5) N Queens problem recursively - by using backtrack recursion we will check if we can place N queens on N*N board size.
     * <p>
     * 6) Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example :
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * Time complexity : O(n)O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1)O(1) time.
     * <p>
     * Space complexity : O(n)O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
     * <p>
     * 7) You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * <p>
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * <p>
     * Example:
     * <p>
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     * Time complexity : O(\max(m, n))O(max(m,n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively, the algorithm above iterates at most \max(m, n)max(m,n) times.
     * <p>
     * Space complexity : O(\max(m, n))O(max(m,n)). The length of the new list is at most \max(m,n) + 1max(m,n)+1.
     * <p>
     * 8) by given an arr of find the maximum profit from selling snf buying. for example
     * arr = {7,1,5,3,6,4} - maximum profit is 7 - we buy 1 then sell in 5,then we buy in 3 sell in 6.
     * the algorithm is to find sub sorted arr and takes the last index of it minus the first index of if as this "transaction' max profit.
     * <p>
     * 9) There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * <p>
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * You may assume nums1 and nums2 cannot be both empty.
     * <p>
     * 10) Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * <p>
     * 11) Given an arr in size of n and another number k , checks if there is a number in the arr that repeats exactly k times - the algorithm shout run in O(N).
     * <p>
     * ARRAY ROTATIONS:
     * <p>
     * 12) Given an arr ,n(length of arr), d(how many elements to rotate) , rotate the arr d times.
     * Instead of moving one by one, divide the array in different sets
     * where number of sets is equal to GCD of n and d and move the elements within sets.
     * If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only,
     * we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
     * time complexity O(n) - worst case - arr = {1,2,3,4} and d=4. it wont rotate 4 times , it wont do anything , each arr[i] will be equal to temp,
     * temp in that case will be the same value arr[i] already has because if d>=n so we do d=d%n -> d=0.
     * <p>
     * another algorithm is the reverse algorithm also in O(n) :
     * Let AB are the two parts of the input array where A = arr[0..d-1] and B = arr[d..n-1]. The idea of the algorithm is :
     * arr = {1,2,3,4,5,6,7}
     * Reverse A to get ArB, where Ar is reverse of A. arr ={2,1,3,4,5,6,7}
     * Reverse B to get ArBr, where Br is reverse of B. arr = {2,1,7,6,5,4,3}
     * Reverse all to get (ArBr) r = BA. arr = {3,4,5,6,7,1,2}
     * <p>
     * 13) cyclically rotate an array by one - example : arr = {1,2,3,4,5} -> arr = {5,1,2,3,4} O(n)
     * <p>
     * 14) An element in a sorted array can be found in O(log n) time via binary search. But suppose we rotate an ascending order sorted array at some pivot
     * unknown to you beforehand.
     * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
     * <p>
     * The idea is to find the pivot point, divide the array in two sub-arrays and perform binary search.
     * The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array,
     * pivot element is the only element for which next element to it is smaller than it.
     * <p>
     * 14) given sorted arr or rotated arr or just random numbers arr , and another number x and determine if there are 2 numbers which has a sum equal to the given number x.
     * 1) if its sorted arr we will use the 2 pointer technique which means 1 pointer at the beginning,another at the end,
     * then sum them , if the sum is greater then the given number we  decrease the pointer at the end , other wise we increase the pointer at the beginning.
     * 2) if its rotated arr , first we find the pivot using adaptable binary search , then we use the 2 pointer technique again.
     * 3) if its random numbers arr we will use hash map. all algorithms should be O(n)
     * <p>
     * 15) Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed.
     * The idea is to calculate next rotation value from previous rotation.
     * <p>
     * 1) Compute sum of all array elements. Let this sum be 'arrSum'.
     * <p>
     * 2) Compute R0 by doing i*arr[i] for given array.
     * Let this value be currVal.
     * <p>
     * 3) Initialize result: maxVal = currVal // maxVal is result.
     * <p>
     * // This loop computes Rj from  Rj-1
     * 4) Do following for j = 1 to n-1
     * ......a) currVal = currVal + arrSum-n*arr[n-j];
     * ......b) If (currVal > maxVal)
     * maxVal = currVal
     * <p>
     * 5) Return maxVal
     * <p>
     * 16) An array consisting of N integers is given. There are several Right Circular Rotations of range[L..R] that we perform.
     * After performing these rotations, we need to find element at a given index.
     * <p>
     * ARRANGEMENT , REARRANGEMENT:
     * 17) Given an array (or string), the task is to reverse the array/string.
     * 18) Rearrange positive and negative numbers in O(n) time and O(1) extra space
     * An array contains both positive and negative numbers in random order. Rearrange the array elements so that positive and negative numbers
     * are placed alternatively. Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of
     * the array.
     * If there are more negative numbers, they too appear in the end of the array.
     * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
     * <p>
     * 19) given arr -  Push all the zero’s of a given array to the end of the array.
     * The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
     * <p>
     * 20) Given an array of n positive integers and a number k. Find the minimum number of swaps required to bring all the numbers less than or equal to k together.
     * <p>
     * 21) Rearrange array such that odd positioned are greater than even
     * the algorithm : traverse the array from the second element and swap the element with the previous one if the condition is not satisfied
     * <p>
     * 22) Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..
     * can be also done by time complexity O(log n) , space complexity O(n) using new arr helper
     * <p>
     * 23) Replace every array element by multiplication of previous and next , time complexity O(n) , space complexity O(1)
     * 24) Shuffle a given array , assuming the rand operation is O(1)
     * 25) K’th Smallest/Largest Element in Unsorted Array.
     * first approach : Build a Min Heap tree in O(n),
     * Use Extract Min k times to get k minimum elements from the Max Heap O(klogn)
     * Time complexity: O(n + klogn)
     * <p>
     * second approach : A simple solution is to sort the given array using a O(N log N) sorting algorithm like Merge Sort, Heap Sort, etc
     * and return the element at index k-1 in the sorted array.
     * Time Complexity of this solution is O(N Log N)
     * <p>
     * 26)Find the largest three elements in an array
     * first approach is O(N) in time complexity and O(1) in space complexity
     * <p>
     * 27) Find all elements in array which have at-least two greater elements
     * first approach : sort the arr then return all elements but the two last elements(they dont have 2 or more greater elements).
     * time complexity : O(nlogn) , space complexity : O(1)
     * <p>
     * second approach : we will find second maximum in the arr , then we will print all the numbers which are smaller. O(N)
     * 2 algos in - findTwoElemetnsOrMore
     * <p>
     * 28) Find Second largest element in an array in one traversal of the array
     * <p>
     * 29) Find k numbers with most occurrences in the given array
     * algorithm :
     * Create a Hashmap hm, to store key-value pair, i.e. element-frequency pair.
     * Traverse the array from start to end.
     * For every element in the array update hm[array[i]]++
     * Store the element-frequency pair in a vector and sort the vector in decreasing order of frequency.
     * Print the first k elements of sorted array.
     * <p>
     * Time Complexity: O(d log d), where d is the count of distinct elements in the array. To sort the array O(d log d) time is needed.
     * Auxiliary Space: O(d), where d is the count of distinct elements in the array. To store the elements in HashMap O(d) space complexity is needed.
     * <p>
     * 30) Maximum profit by buying and selling a share at most twice
     * 31) Find minimum difference between any two elements
     * sort in n*logn , then check differences between each two adjacent variables.
     * <p>
     * 32) Find the subarray with least average in O(n)
     * example :
     * Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
     * Output: Subarray between indexes 3 and 5
     * The subarray {20, 10, 50} has the least average
     * among all subarrays of size 3.
     * <p>
     * 33) find the minimum distance between given 2 numbers .
     * example: {2, 5, 3, 5, 4, 4, 2, 3},
     * x = 3, y = 2
     * Output: Minimum distance between 3
     * and 2 is 1.
     * Explanation:3 is at index 7 and 2 is at
     * index 6, so the distance is 1
     * 34) Write an efficient program to find the sum of contiguous subarray within a one-dimensional array
     * 35) rotate matrix
     * 36) multiply matrices.
     * 37) Given a two dimensional array, Write a program to print lower triangular matrix and upper triangular matrix.
     * 38) Given a n x n matrix. The problem is to find all the distinct elements common to all rows of the matrix. The elements can be printed in any order.
     * i will use hash map and then Time complexity :O(N**2) - traverse on matrix , space complexity: O(N)
     * <p>
     * 39) Given a 2D array, print it in spiral form. See the following examples.
     * 40) Given a square matrix, swap the element of major and minor diagonals.
     * <p>
     * /// all implementions in MyLinkedList class//////
     * <p>
     * 41) Given a linked list, check if the linked list has loop or not.
     * the idea : Traverse linked list using two pointers.
     * Move one pointer(slow_p) by one and another pointer(fast_p) by two.
     * If these pointers meet at the same node then there is a loop. If pointers do not meet then linked list doesn’t have a loop.
     * 42) Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
     * 43) Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted
     * 44)Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links
     * 45) Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
     * The new list should be made with its own memory — the original lists should not be changed.
     * 46) There are two singly linked lists in a system. By some programming error, the end node of one of the linked list got linked to the second list,
     * forming an inverted Y shaped list. Write a program to get the point where two linked list merge.(this function is in Node class).
     * 47) Segregate even and odd nodes in a Linked List.
     * <p>
     * 48) copy arbitrary list - an arbitray list is a DLL which next pointer is normal but previous could point to any node in the list.
     * the idea is to copy first each node (i) and put it between i , i+1 , then we have the option to copy the arbitrary pointers also.
     * 49) Given a sorted doubly linked list of positive distinct elements,
     * the task is to find pairs in doubly linked list whose sum is equal to given value x, without using any extra space ?
     * 50) Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x.
     * Count triplets in the list that sum up to a given value x.
     * <p>
     * 51) Given an unsorted doubly linked list containing n nodes. The problem is to remove duplicate nodes from the given list.
     * <p>
     * STACK:
     * <p>
     * 52) implementing Queue using 2 stacks
     * 53) SpecialStack is a class that supports getMin in O(1) :
     * first implementation is with extra Stack which keeps the minimum that's takes O(n) space Complexity,
     * second approach is in O(1) space Complexity algorithm described in class
     * <p>
     * 54) Prefix to Infix Conversion
     * Infix : An expression is called the Infix expression if the operator appears in between the operands in the expression.
     * Simply of the form (operand1 operator operand2).
     * Example : (A+B) * (C-D)
     * <p>
     * Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands.
     * Simply of the form (operator operand1 operand2).
     * Example : *+AB-CD (Infix : (A+B) * (C-D) )
     * <p>
     * Given a Prefix expression, convert it into a Infix expression.
     * <p>
     * 55) Prefix to Postfix Conversion
     * <p>
     * Postfix: An expression is called the postfix expression if the operator appears in the expression after the operands.
     * Simply of the form (operand1 operand2 operator).
     * Example : AB+CD-* (Infix : (A+B * (C-D) )
     * Given a Prefix expression, convert it into a Postfix expression
     * <p>
     * 56)Postfix to Prefix Conversion
     * 57) Check for Balanced Brackets in an expression (well-formedness) using Stack
     * Input: exp = “[()]{}{[()()]()}”
     * Output: Balanced
     * <p>
     * Input: exp = “[(])”
     * Output: Not Balanced
     * <p>
     * 58) Next Greater Element
     * Given an array, print the Next Greater Element (NGE) for every element.
     * The Next greater Element for an element x is the first greater element on the right side of x in array.
     * Elements for which no greater element exist, consider next greater element as -1.
     * <p>
     * Examples:
     * <p>
     * For any array, rightmost element always has next greater element as -1.
     * For an array which is sorted in decreasing order, all elements have next greater element as -1.
     * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
     * <p>
     * 59) reverse stack using recursion
     * Given a stack, reverse it using recursion. Use of any loop constructs like while, for..etc is not allowed.
     * We can only use the following ADT functions on Stack S: push,pop,top,isEmpty O(N**2)
     * 60) sort stack using recursion :
     * Given a stack, sort it using recursion. Use of any loop constructs like while, for..etc is not allowed.
     * We can only use the following ADT functions on Stack S: push,pop,top,isEmpty O(N**2)
     * <p>
     * 61) Sort a stack using a temporary stack
     * 62) Delete middle element of a stack - Given a stack with push(), pop(), empty() operations, delete middle of it without using any additional data structure.
     * <p>
     * 63) Delete array elements which are smaller than next or become smaller
     * Given an array arr[] and a number k. The task is to delete k elements which are smaller than next element (i.e., we delete arr[i] if arr[i] < arr[i+1]) or become smaller than next because next element is deleted.
     * <p>
     * QUEUE:
     * <p>
     * 64) Reversing a queue using Stack O(N) Complexity , O(N) extra space
     * 65) Reversing queue using recursion O(N)
     * 66) sorting a  queue.
     */

    static int N = 4;
    static Stack<Integer> stack;
    static Queue<Integer> queue;

    public static void main(String[] args) {

        //   int arr[] = {1,464,123,435,664,2};
        // int board[][] = new int[N][N];


        //    QueensProblem queensProblem = new QueensProblem(board, N);


        //System.out.println(addTwoNumbers(l1, l2));

        //int arr[] = {7, 6, 5, 4, 3, 2, 1};
        //System.out.println(maxProfit(arr));
        int arr[] = {1, 2, 3};
        //  printAllPermutations(arr,"",0);
        // int a[] = {1, 3};
        //int b[] = {2};
        //System.out.println(findMedianSortedArrays(a, b));

        // System.out.println(longestPalindrome("ac"));

        //int arr2[] = {4, 5, 6, 5, 4, 56, 5, 2, 3, 4, 5, 5, 6, 2};
        //System.out.println(isRepeatsKtimes(arr2, 5));

        //int arr3[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        // rotateArrayReverse(arr3, 13);
        //System.out.println(Arrays.toString(arr3));

        //int arr4[] = {1, 2, 3, 4, 5};
        //  cyclicallyRotate(arr4);
        //System.out.println(Arrays.toString(arr4));


        //int arr5[] = {10, 20, 30, 40, 44, 45, 48, 49, 52, 5, 6, 7, 8, 9};
        // System.out.println(searchElementRoatedArr(arr5, 92));
        //int arr6[] = {21, 24, 25, 27, 34, 35, 37, 10, 13, 15, 16};
        //  System.out.println(isThereASum(arr6, 31, 3));

        //int arr7[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //  System.out.println(findMaxSum(arr7));

        //int arr8[] = {1, 2, 3, 4, 5};

        // Ranges according to 0-based indexing
        //int ranges[][] = {{0, 2}, {0, 3}};

        // System.out.println(findElement(arr8, ranges, 1));

        //int arr9[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        //rearrangeArray(arr9);
        //System.out.println(Arrays.toString(arr9));

        //int arr10[] = {1, 2, 3, 4, 5, 6};
        //reverseArrayRecursivly(arr10, 0, arr10.length - 1);
        //System.out.println(Arrays.toString(arr10));

        //int arr11[] = {-1, 2, -3, 4, 5, -6, -7, 8, -9};
        //  reArrangePosAndNeg(arr11);
        // System.out.println(Arrays.toString(arr11));

        // int arr12[] = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        // moveZeroToEnd(arr12);
        // System.out.println(Arrays.toString(arr12));
        //int arr13[] = {5, 2, 6, 8, 21, 9, 22, 11, 15, 14, 17, 1, 2, 8, 4};
        // System.out.println(numOfMinSwapsRequire(arr13, 5));

        // int arr14[] = {2, 7, 9, 5, 8, 7, 4};
        //rearrangeArray2(arr14);
        //System.out.println(Arrays.toString(arr14));

        //int arr15[] = {5, 8, 1, 4, 2, 3, 7, 6};
        //rearrangeArray3(arr15);

        //int arr16[] = {2, 3, 4, 5, 6};
        //repalceMultipictaion(arr16);
        // System.out.println(Arrays.toString(arr16));

//        shuffuleArray(arr16);
//        System.out.println(Arrays.toString(arr16));


//        int arr1[] = {7, 10, 4, 3, 20, 15};
//        System.out.println(Kth_Smallest(arr1, 4));

//        int arr1[] = {1,35,64,23,120,53,5,24,124,34,464};
//        threeLargestElements(arr1);

//        int arr1[] = {7, -2, 3, 4, 9, -1};
//        findTwoElemetnsOrMore(arr1);

//        int arr1[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
//        findKOccurrences(arr1, 4);

//        int arr1[] = {10, 22, 35, 75, 65, 80};
//        maxProfit1(arr1, arr1.length);

//        int arr1[] = {3, 7, 5, 20, -10, 0, 12};
//        leastAvg(arr1, 2);

//
//        int arr1[] = {2, 5, 3, 5, 4, 4, 2, 3};
//        System.out.println("the minimum between X and Y is " + findMinDisBetweenTwoNumbers(arr1, 3, 2));

//        int arr1[] = {-2, -3, 4, -1, -2, 1, 5, -3};
//        System.out.println(best(arr1));
//
//        int mat[][] = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        upperLowerTriangular(mat);

//        int mat[][] = {{12, 1, 14, 3, 16},
//                {14, 2, 1, 3, 35},
//                {14, 1, 14, 3, 11},
//                {14, 25, 3, 2, 1},
//                {1, 18, 3, 21, 14}};
//
//        distinctElementsCommonToAllRows(mat);
//        MyLinkedList linkedList = new MyLinkedList();
//        MyCircularLinkedList l = new MyCircularLinkedList();
//        l.append(5);
//        l.append(6);
//        l.append(10);
//        l.append(22);
//        System.out.println(l);
//        l.delete(6);
//        System.out.println(l);


//        MyCircularQueue queue = new MyCircularQueue();
//        queue.enQueue(15);
//        queue.enQueue(54);
//        queue.enQueue(125);
//        queue.enQueue(545);
//        queue.enQueue(5);
//        queue.enQueue(511);
//        System.out.println(queue);
//        MyCircularQueue.Node res = queue.deQueue();
//        System.out.println(queue);
//        int a=queue.getRear();
//        System.out.println(a);
//        System.out.println(queue);
//        System.out.println(queue.size());
//        queue.deQueue();
//        System.out.println(queue);
//        System.out.println(queue.size());

        myDLL m = new myDLL();
//        myDLL.Node t1 = new myDLL.Node(1);
//        myDLL.Node t2 = new myDLL.Node(2);
//        myDLL.Node t3 = new myDLL.Node(3);
//        myDLL.Node t4 = new myDLL.Node(4);
//        myDLL.Node t5 = new myDLL.Node(5);
//        t1.next=t2;
//        t1.prev=t3;
//        t2.next=t3;
//        t2.prev=t1;
//        t3.next=t4;
//        t3.prev=t5;
//        t4.next=t5;
//        t4.prev=t3;
//        t5.next=null;
//        t5.prev=t2;
//        t1= m.copyArbitrayList(t1);
//        m.printlist(t1);
//        m.append(4);
//        m.append(4);
//        m.append(4);
//        m.append(6);
//        m.append(8);
//        m.append(8);
//        m.append(11);
//        m.append(10);
//        m.append(12);
//        m.append(11);
//        m.printlist(m.getHead());
//        m.removeDuplicate();
//        m.printlist(m.getHead());
//
//        QueueUsingStacks q = new QueueUsingStacks();
//        q.Enqueue(6);
//        q.Enqueue(16);
//        q.Enqueue(64);
//        q.Enqueue(26);
//        q.Enqueue(65);
//        q.Enqueue(12);
//        q.Enqueue(24);
//
//        System.out.println(q.Dequeue());
//        System.out.println(q.Dequeue());
//        System.out.println(q.Dequeue());

//        SpecialStack s = new SpecialStack();
//        s.push(3);
//        s.push(5);
//        s.push(2);
//        s.push(1);
//        s.push(1);
//        s.push(-1);
//
//        for (int i=0;i<6;i++){
//
//            System.out.println(s.getMin());
//            System.out.println(s.pop());
//        }


//        int arr2 [] = {13,7,6,12,20};
//        NextGreaterElement(arr2);

        // Input: number of disks
        int num_of_disks = 3;

        ToH_Iterative ob = new ToH_Iterative();
        ToH_Iterative.Stack src, dest, aux;

        // Create three stacks of size 'num_of_disks'
        // to hold the disks
        src = ob.createStack(num_of_disks);
        dest = ob.createStack(num_of_disks);
        aux = ob.createStack(num_of_disks);

        ob.tohIterative(num_of_disks, src, aux, dest);
        stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        deleteMidElement(stack,stack.size(),0);
//
//        System.out.println(stack);
//        System.out.println(stack.peek());

        // int[] arr23 = {3, 100, 1};
        // deleteElements(arr23, 1);

        queue = new LinkedList<>();
        queue.add(11);
        queue.add(5);
        queue.add(4);
        queue.add(21);
        //queue.add(5);
        System.out.println(queue);
        sortQueue();
        System.out.println(queue);


    }

    private static void printAllPermutations(int[] arr, String ans, int count) {
        for (int i = 0; i < arr.length; i++) {
            // checking if this number already exists in the string or not,if not add it.
            if (!contains(ans, String.valueOf(arr[i]))) {
                ans += arr[i] + " ";
                count++;
                if (count == arr.length) {
                    System.out.println(ans);
                    return;
                }


                //recursively calling the function again.
                printAllPermutations(arr, ans, count);
                ans = subString(ans);
                count--;
                if (count == 0) {
                    ans = "";
                }

            }


        }

    }

    private static boolean contains(String ans, String c) {
        String[] temp = ans.split(" ");
        for (int i = 0; i < temp.length; i++) {
            if (c.equals(temp[i])) {
                return true;
            }
        }
        return false;
    }

    private static String subString(String ans) {
        int i = ans.length() - 2;
        if (i > 0) {
            while (ans.charAt(i) != ' ') {
                i--;
                if (i < 0) {
                    break;
                }
            }
            ans = ans.substring(0, i + 1);
            return ans;
        } else {
            return "";
        }

    }

    private static void RandInO_I(int arr[], int i) {
        int numberToRand = arr.length, ind = 0;
        for (int k = 0; k < i; k++) {
            ind = (int) (Math.random() * numberToRand);
            System.out.print("num of index " + ind + " , ");
            System.out.print(arr[ind] + " ");

            swap(arr, ind, numberToRand - 1);
            numberToRand--;

        }
    }

    private static void swap(int[] arr, int ind, int indToSwitch) {
        // this function makes a swap between 2 arr variables without using temp variable.
        if (ind == indToSwitch) {
            return;
        }
        arr[ind] = arr[ind] + arr[indToSwitch];
        arr[indToSwitch] = arr[ind] - arr[indToSwitch];
        arr[ind] = arr[ind] - arr[indToSwitch];
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");


    }

    public static LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        boolean remainder = false;
        while (i >= 0 && j >= 0) {

            int sum = l1.get(i) + l2.get(j);
            if (remainder) {
                sum++;
                remainder = false;
            }
            if (sum >= 10) {
                remainder = true;
                res.add(sum % 10);
            } else {
                res.add(sum);
            }

            i--;
            j--;
        }

        while (i >= 0) {
            res.add(l1.get(i));
            i--;
        }
        while (j >= 0) {
            res.add(l2.get(j));
            j--;
        }
        return res;

    }

    public static int maxProfit(int[] arr) {
        int totalProfit = 0;
        int buy, sell;

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i + 1] > arr[i]) {
                buy = arr[i];
                while (i + 1 < arr.length && arr[i + 1] > arr[i]) {
                    i++;
                }
                sell = arr[i];
                totalProfit += sell - buy;
            }
        }
        return totalProfit;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        int k = arr.length - 1;
        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int count = 0;

        while (i >= 0 && j >= 0 && count != arr.length / 2 + 1) {
            if (nums1[i] >= nums2[j]) {
                arr[k--] = nums1[i--];
            } else {
                arr[k--] = nums2[j--];
            }
            count++;
        }


        while (count != arr.length / 2 + 1 && i >= 0) {
            arr[k--] = nums1[i--];
            count++;
        }
        while (count != arr.length / 2 + 1 && j >= 0) {
            arr[k--] = nums2[j--];
            count++;
        }

        if (arr.length % 2 == 1) {
            return arr[++k];
        } else {
            double twoMedian = arr[++k] + arr[++k];
            return twoMedian / 2;
        }


    }

    public static String longestPalindrome(String s) {
        String res = "";
        int i = 0, j = s.length() - 1;
        if (s.length() % 2 == 1) {
            while (i != j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (res.length() != 0) {
                        int index = res.length() / 2;
                        String marble = s.charAt(i) + "" + s.charAt(j);
                        String bagBegin = res.substring(0, index);
                        String bagEnd = res.substring(index);
                        return bagBegin + marble + bagEnd;


                    } else {
                        res = s.charAt(i) + "" + s.charAt(j);
                        //res+=s.charAt(i);
                        //  res+=s.charAt(j);
                    }
                }
                i++;
                j--;
            }
        } else {
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (res.length() != 0) {
                        int index = res.length() / 2;
                        String marble = s.charAt(i) + "" + s.charAt(j);
                        String bagBegin = res.substring(0, index);
                        String bagEnd = res.substring(index);
                        return bagBegin + marble + bagEnd;


                    } else {
                        res = s.charAt(i) + "" + s.charAt(j);
                        //res+=s.charAt(i);
                        //  res+=s.charAt(j);
                    }
                }

                i++;
                j--;
            }
        }
        if (s.length() % 2 == 1) {
            int index = res.length() / 2;
            String marble = s.charAt(i) + "";
            String bagBegin = res.substring(0, index);
            String bagEnd = res.substring(index);
            res = bagBegin + marble + bagEnd;
        }
        if (res == "") {
            res += s.charAt(0);
        }
        if (res.equals("") && !s.equals("")) {
            res = s.charAt(0) + "";
        }
        return res;
    }

    public static boolean isRepeatsKtimes(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if this num doesnt exist in the map
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            }
            // if this num does exists , increment its appearance.
            else {
                int times = map.get(arr[i]);
                times++;
                map.put(arr[i], times);
                if (times == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void rotateArray(int[] arr, int d, int n) {

        /* To handle if d >= n */
        d = d % n;
        int i, j, k, temp;
        int g_c_d = GCD(d, n);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    private static int GCD(int a, int b) {
        if (a == 0)
            return b;
        else
            return GCD(b % a, a);
    }

    public static void rotateArrayReverse(int[] arr, int d) {
        if (d == 0)
            return;

        int n = arr.length;
        // in case the rotating factor is
        // greater than array length
        d = d % n;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }


    }

    private static void cyclicallyRotate(int arr[]) {
        int n = arr.length;
        // save last element
        int temp = arr[arr.length - 1];
        // push all variables 1 step forward
        int x = arr[n - 1], i;
        for (i = n - 1; i > 0; i--)
            arr[i] = arr[i - 1];
        // putting at the first index the last value from last index we saved.
        arr[0] = x;
    }

    private static int searchElementRoatedArr(int arr[], int key) {
        int n = arr.length;
        int pivot = searchPivot(arr, 0, n - 1);

        if (pivot == -1) // means the arr is not rotated at all , only sorted
            return searchBinary(arr, 0, n - 1, key);

        if (arr[pivot] == key) { // if the index of the pivot is also the requested key
            return pivot;
        }
        if (key > arr[0]) { // we know we need to search in the left side of the arr
            return searchBinary(arr, 0, pivot - 1, key);
        }
        // else we know to search in the right side of the arr
        return searchBinary(arr, pivot + 1, n - 1, key);
    }

    private static int searchBinary(int[] arr, int low, int high, int key) {


        if (high < low) {
            return -1;
        }
        int mid = (high + low) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[mid] < key) {
            return searchBinary(arr, mid + 1, high, key);

        }

        return searchBinary(arr, low, mid - 1, key);


    }

    private static int searchPivot(int[] arr, int low, int high) {


        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }

        int mid = (high + low) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }

        if (arr[low] >= arr[mid]) {
            return searchPivot(arr, low, mid - 1);
        }
        return searchPivot(arr, mid + 1, high);


    }

    private static boolean isThereASum(int arr[], int x, int type) {

        if (type == 1) { // sorted arr
            int i = 0;
            int j = arr.length - 1;

            while (i != j) {
                int sum = arr[i] + arr[j];
                if (sum == x) {
                    return true;
                } else if (sum > x) {
                    j--;
                } else
                    i++;
            }
            return false;
        } else if (type == 2) { // rotated arr

            int pivot = searchPivot(arr, 0, arr.length - 1); // pivot is also the largest number in the arr
            int j = pivot;
            int i = pivot + 1;

            while (j >= 0 && i < arr.length) {
                int sum = arr[i] + arr[j];

                if (sum == x) {
                    return true;
                } else if (sum > x) {
                    j--;
                } else
                    i++;
            }

            return false;
        } else { // type 3 means a regular array with random numbers.
            //  int count=0;
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                if (!map.isEmpty()) {
                    if (map.containsKey(x - arr[i])) {
                        Pair<Integer, Integer> p = new Pair<>(map.get(x - arr[i]), i);
                        System.out.println(p);
                        // count++;
                        return true;
                    }
                    map.put(arr[i], i);
                } else
                    map.put(arr[i], i);
            }
            // System.out.println(count);

        }
        return false;
    }

    private static int findMaxSum(int arr[]) {
        int sumArr = 0;
        int currMax = 0;
        int max;
        int n = arr.length;
        // first find sum of the arr + sum i*arr[i]
//        for (int i : arr) {
//            sumArr += i;
//
//        }
        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
            currMax += i * arr[i];
        }
        max = currMax;

        for (int j = 1; j < arr.length; j++) {
            currMax = currMax + sumArr - n * arr[n - j];
            if (currMax > max) {
                max = currMax;
            }
        }

        return max;
    }

    private static int findElement(int[] arr, int[][] ranges,
                                   int index) {
        int rotations = ranges.length;
        for (int i = rotations - 1; i >= 0; i--) {
            int right = ranges[i][1]; // in the example should be here in the first iteration 2
            int left = ranges[i][0]; // and here 0 {0,2}

            if (left <= index && right >= index) {
                if (index == left) {
                    index = right;
                } else
                    index--;
            }
        }
        return arr[index];

    }

    private static void rearrangeArray(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        // first iterate on the arr and insert all values to hashSet

        for (int i : arr) {
            hashSet.add(i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashSet.contains(i)) {
                arr[i] = i;
            } else
                arr[i] = -1;
        }

        // another approach
        for (int i = 0; i < arr.length; ) {
            if (arr[i] >= 0 && arr[i] != i) {
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            } else {
                i++;
            }
        }
    }

    private static void reverseArray(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j && i != j) {
            arr[j] += arr[i];
            arr[i] = arr[j] - arr[i];
            arr[j] -= arr[i];
            i++;
            j--;
        }


    }

    private static void reverseArrayRecursivly(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        arr[start] += arr[end];
        arr[end] = arr[start] - arr[end];
        arr[start] -= arr[end];

        reverseArrayRecursivly(arr, start + 1, end - 1);


    }

    private static void reArrangePosAndNeg(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = arr.length - 1;
        // first rearrange all negative numbers at the start, all positive at the end
        while (i <= j) {
            if (arr[i] > 0 && arr[j] < 0) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (arr[i] < 0) {
                i++;
            } else if (arr[j] > 0) {
                j--;
            }
        }

        // now we start taking positive from the end and maintain on positive and after it negative.


        // Now all positive numbers are at end and negative numbers at
        // the beginning of array. Initialize indexes for starting point
        // of positive and negative numbers to be swapped
        int pos = i + 1, neg = 0;
        int temp;
        // Increment the negative index by 2 and positive index by 1, i.e.,
        // swap every alternate negative number with next positive number
        while (pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
    }

    private static void moveZeroToEnd(int arr[]) {
        int i = 0;
        int indexToReplace = 0;
        boolean toReplace = false;

        while (i < arr.length) {
            if (arr[i] == 0 && !toReplace) {
                indexToReplace = i;
                toReplace = true;
            } else if (arr[i] != 0 && toReplace) { // now we replace
                swap(arr, indexToReplace, i);
                i = indexToReplace;
                toReplace = false;
            }
            i++;
        }
    }

    private static int numOfMinSwapsRequire(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        int countA = 0, countB = 0;
        int j = n - 1, i;
        boolean isFirstSide = false;
        // the algorithm is to "split" the arr into two equal parts and to check in which side the most numbers that less or equal to k are located,
        // and afterwords just to use two pointers technique

        // first iteration on arr
        for (i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                if (i <= n / 2) { // means first side
                    countA++;
                } else {
                    countB++; // second side
                }
            }
        }
        if (countA > countB) { // if the most of the numbers are on the first side
            isFirstSide = true;
        }
        // second iteration with two pointers according to the side with most numbers close to k
        i = 0;
        while (i < j) {
            if (arr[i] >= k && arr[j] <= k) {
                if (isFirstSide) {
                    count++; // a swap is nedded
                    i++;
                    j--;
                } else {
                    j--;
                }
            } else if (arr[i] <= k && arr[j] >= k) {
                {
                    if (!isFirstSide) {
                        count++;
                        i++;
                        j--;
                    } else {
                        i++;
                    }
                }

            } else if (arr[i] >= k) { // we know that arr[j] now is >k
                if (isFirstSide)
                    j--;
                else
                    i++;
            } else if (arr[i] <= k) { // we know that arr[j] now is <k
                if (isFirstSide) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        return count;
    }

    private static void rearrangeArray2(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                if (arr[i] < arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            } else if (i % 2 == 0) {
                if (arr[i] > arr[i - 1]) {
                    swap(arr, i, i - 1);
                }
            }
        }
    }

    private static void rearrangeArray3(int arr[]) {
        int n = arr.length - 1;
        // first we sort the arr
        Arrays.sort(arr);
        int tempArr[] = new int[n + 1];
        int arrIndex = 0;
        int i, j;
        for (i = 0, j = n; i <= n / 2 || j > n / 2; i++, j--) {

            if (arrIndex < n) {
                tempArr[arrIndex++] = arr[i];
            }
            if (arrIndex < n) {
                tempArr[arrIndex++] = arr[j];
            }
        }
        tempArr[arrIndex] = arr[++j];

        System.out.println(Arrays.toString(tempArr));
    }

    private static void repalceMultipictaion(int[] arr) {
        int temp = 0, temp2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                temp = arr[i];
                arr[i] = arr[i] * arr[i + 1];
            } else if (i == arr.length - 1) {
                arr[i] = temp * arr[i];
            } else {
                temp2 = arr[i];
                arr[i] = temp * arr[i + 1];
                temp = temp2;
            }
        }

    }

    private static void shuffuleArray(int arr[]) {

        int numberToRand = arr.length; // random between 0 - arr.length-1
        for (int k = 0; k < arr.length; k++) {
            int ind = (int) (Math.random() * numberToRand); // assuming its O(1)
            numberToRand--;
            swap(arr, ind, numberToRand);

        }


    }

    static class sortByFreq implements Comparator<Integer> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }

    static class sortByPair implements Comparator<Pair<Integer, Integer>> {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Pair a, Pair b) {
            return (int) b.getValue() - (int) a.getValue();
        }
    }

    private static int Kth_Smallest(int arr[], int k) {
        int temp = 0;
        // making minHeap using sortByFreq comparator that i made.
        // O(n)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length, new sortByFreq());


        // Adding items to the pQueue using add()
        for (Integer i : arr) {
            priorityQueue.add(i);
        }

        // extract min is O(logn) -> so O(k*logn)
        for (int i = 0; i < k; i++) {
            temp = priorityQueue.poll();
        }

        // total complexity is O(n+klogn).
        return temp;

    }

    private static void threeLargestElements(int arr[]) {

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                third = second;
                second = arr[i];
            } else { // arr[i]>third
                third = arr[i];
            }
        }

        System.out.println("First = " + first + " Second = " + second + " Third = " + third);
    }

    private static void findTwoElemetnsOrMore(int arr[]) {

        // first method sort and then print all numbers besides the 2 last
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length-2; i++) {
//            System.out.println(arr[i]+" ");
//
//
//        }

        // second method - find second minimum and then print all numbers which are less then it.

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }

        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < second) {
                System.out.print(arr[i] + " ");
            }

        }

    }

    private static void findSecondLargest(int arr[]) {
        int first, second;
        first = second = Integer.MIN_VALUE;


        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }

        System.out.println("The second largest element in the arr is :" + second);
    }

    // here 3 ways to iterate on hash map.
    private static void findKOccurrences(int arr[], int k) {

        // first create hash map to store key ,value
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {

            // Get the count for the element if already
            // present in the Map or get the default value
            // which is 0.
            //map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }

        }
        // Create a list of pairs from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Sort the list , using lambda expression(descending order,from big to small)
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())

                return o2.getKey() - o1.getKey();
            else
                return o2.getValue() - o1.getValue();
        });

//        // Getting an iterator for the map - first way to iterate through the map
//        Iterator hmIterator = map.entrySet().iterator();
//
//        // Iterate through the hashmap
//
//        while (hmIterator.hasNext()) {
//            Map.Entry mapElement = (Map.Entry) hmIterator.next();
//            int marks = ((int) mapElement.getValue() + 10);
//            System.out.println(mapElement.getKey() + " : " + marks);
//        }

//        // second approach to iterate map  - for each
//        for (Map.Entry mapElement : map.entrySet()) {
//            int key = (int) mapElement.getKey();
//
//            // Add some bonus marks
//            // to all the students and print it
//            int value = ((int) mapElement.getValue());
//
//
//        }


        // third approach
        // Using Hashmap.forEach()
//        map.forEach((key, val) -> System.out.println(key + " : " + val));


        for (int i = 0; i < k; i++) {
            System.out.print(list.get(i).getKey() + " ");
        }


    }

    private static void maxProfit1(int price[], int n) {

        {
            // Create profit array and initialize it as 0
            int profit[] = new int[n];
            for (int i = 0; i < n; i++)
                profit[i] = 0;

        /* Get the maximum profit with only one transaction
           allowed. After this loop, profit[i] contains maximum
           profit from price[i..n-1] using at most one trans. */
            int max_price = price[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                // max_price has maximum of price[i..n-1]
                if (price[i] > max_price)
                    max_price = price[i];

                // we can get profit[i] by taking maximum of:
                // a) previous maximum, i.e., profit[i+1]
                // b) profit by buying at price[i] and selling at
                //    max_price
                profit[i] = Math.max(profit[i + 1], max_price - price[i]);
            }

        /* Get the maximum profit with two transactions allowed
           After this loop, profit[n-1] contains the result */
            int min_price = price[0];
            for (int i = 1; i < n; i++) {
                // min_price is minimum price in price[0..i]
                if (price[i] < min_price)
                    min_price = price[i];

                // Maximum profit is maximum of:
                // a) previous maximum, i.e., profit[i-1]
                // b) (Buy, Sell) at (min_price, price[i]) and add
                //    profit of other trans. stored in profit[i]
                profit[i] = Math.max(profit[i - 1], profit[i] +
                        (price[i] - min_price));
            }

            int result = profit[n - 1];
            System.out.println(result);
        }
    }

    private static void leastAvg(int arr[], int k) {
        // the idea is to compute first k elements avg , then removing the first element (of k's elements) pointed and adding the next element pointed.(iteration on arr).
        // we will use 2 pointers technique.
        boolean isFirst = true; // summing the first k elements
        int j = 0;
        int sum = 0;
        double currentAvg = 0;
        int ind1 = 0, ind2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && i % k == 0 && isFirst) {
                isFirst = false;
                currentAvg = sum / k;
                ind1 = j;
                ind2 = i - 1;
            }
            if (isFirst) {
                sum += arr[i];
            } else {
                sum -= arr[j];
                sum += arr[i];
                j++;
            }
            if (sum / k < currentAvg) {
                currentAvg = sum / k;
                ind1 = j;
                ind2 = i;
            }

        }

        System.out.println(" Subarray between indexes " + ind1 + " and " + ind2);
    }

    private static int findMinDisBetweenTwoNumbers(int arr[], int x, int y) {

        int current = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x || arr[i] == y) {

                if (current != -1 && arr[current] != arr[i]) { // check we found at least one time x or y , and check that we didnt find the same x or y
                    min = Math.min(min, i - current);
                }

                current = i;
            }

        }

        if (current == Integer.MIN_VALUE) {
            return -1;
        }
        return min;


    }

    private static int best(int arr[]) {
        int current = 0, max = arr[0], firstIndex = 0, lastIndex = 0, potentialIndex = 0;


        for (int i = 0; i < arr.length; i++) {


            current += arr[i];

            if (current > max) {
                max = current;
                lastIndex = i;
                firstIndex = potentialIndex;
            }

            if (current <= 0) { // if we want longest number of edges we do current<0 , if we want shortest num of edges we do current<=0
                current = 0;
                potentialIndex = i + 1;
                continue;
            }

        }

        return max;
    }

    private static void rotateMatrix(int m, int n, int mat[][]) {
        int row = 0, col = 0;
        int prev, curr;

        /*
        row - Staring row index
        m - ending row index
        col - starting column index
        n - ending column index
        i - iterator
        */
        while (row < m && col < n) {

            if (row + 1 == m || col + 1 == n)
                break;

            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];

            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < n; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < m; i++) {
                curr = mat[i][n - 1];
                mat[i][n - 1] = prev;
                prev = curr;
            }
            n--;

            // Move elements of last row
            // from the remaining rows
            if (row < m) {
                for (int i = n - 1; i >= col; i--) {
                    curr = mat[m - 1][i];
                    mat[m - 1][i] = prev;
                    prev = curr;
                }
            }
            m--;

            // Move elements of first column
            // from the remaining rows
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }

        // Print rotated matrix
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++)
//                System.out.print(mat[i][j] + " ");
//            System.out.print("\n");
//        }
    }

    private static int[][] multMatrices(int[][] mat1, int[][] mat2, int[][] res) {

        // current N =4.
        int i, j, k;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                res[i][j] = 0;
                for (k = 0; k < N; k++)
                    res[i][j] += mat1[i][k]
                            * mat2[k][j];
            }
        }
        return res;
    }

    private static void upperLowerTriangular(int[][] mat) {
        // upper:
        int i, j;
        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                if (j >= i) {
                    System.out.print(mat[i][j] + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }

        // lower

        for (i = 0; i < mat.length; i++) {
            for (j = 0; j < mat[0].length; j++) {
                if (j <= i) {
                    System.out.print(mat[i][j] + " ");
                } else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    private static void distinctElementsCommonToAllRows(int mat[][]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!hashMap.containsKey(mat[i][j])) {
                    hashMap.put(mat[i][j], 1);
                } else {
                    hashMap.put(mat[i][j], hashMap.get(mat[i][j]) + 1);
                }
            }

            // now check the numbers that appears exactly n times.

            for (Map.Entry mapElement : hashMap.entrySet()) {
                int key = (int) mapElement.getKey();

                int value = ((int) mapElement.getValue());
                if (value == mat.length) {
                    System.out.println(key + " ");
                }


            }


        }
    }

    private static void printSpiralForm(int[][] a, int m, int n) {
        int i, k = 0, l = 0;

        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining
            // columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining
            // columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    private static void swapDiagonals(int mat[][], int size) {


        for (int i = 0; i < size; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][size - i - 1];
            mat[i][size - i - 1] = temp;
        }
    }

    private static int pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        return a * pow(a, --b);
    }


    private static String prefixToInfix(String prefix) {

        // first creating the stack
        Stack<String> strings = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {

            if (prefix.charAt(i) == '*' || prefix.charAt(i) == '/' || prefix.charAt(i) == '-' || prefix.charAt(i) == '+') {
                String operator1 = "(" + strings.pop();
                String operator2 = strings.pop() + ")";
                String res = operator1 + prefix.charAt(i) + operator2;
                strings.push(res);
            } else {
                strings.push(prefix.charAt(i) + "");
            }
        }
        return strings.pop();

    }

    private static String prefixToPostfix(String prefix) {

        // first creating the stack
        Stack<String> strings = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {

            if (prefix.charAt(i) == '*' || prefix.charAt(i) == '/' || prefix.charAt(i) == '-' || prefix.charAt(i) == '+') {
                String operator1 = strings.pop();
                String operator2 = strings.pop();
                String res = operator1 + operator2 + prefix.charAt(i);
                strings.push(res);
            } else {
                strings.push(prefix.charAt(i) + "");
            }
        }
        return strings.pop();

    }

    private static String postfixToprefix(String prefix) {

        // first creating the stack
        Stack<String> strings = new Stack<>();

        for (int i = 0; i < prefix.length(); i++) {

            if (prefix.charAt(i) == '*' || prefix.charAt(i) == '/' || prefix.charAt(i) == '-' || prefix.charAt(i) == '+') {
                String operator1 = strings.pop();
                String operator2 = strings.pop();
                String res = prefix.charAt(i) + operator2 + operator1;
                strings.push(res);
            } else {
                strings.push(prefix.charAt(i) + "");
            }
        }
        return strings.pop();

    }

    private static boolean balanceBrackets(String brackets) {
        Stack<Character> strings = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '{' || brackets.charAt(i) == '(' || brackets.charAt(i) == '[') {
                strings.push(brackets.charAt(i));
            } else {
                char check = strings.pop();
                char x = brackets.charAt(i);
                switch (x) {
                    case ')': {
                        if (check == '{' || check == '[')
                            return false;
                        break;
                    }
                    case '}': {
                        if (check == '(' || check == '[')
                            return false;
                        break;
                    }
                    case ']': {
                        if (check == '(' || check == '{')
                            return false;
                        break;
                    }

                }
            }
        }
        return true;
    }

    private static void NextGreaterElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                int tmp = stack.pop();
                System.out.println("The NGE of " + tmp + " = " + arr[i]);
            }
            if (i == arr.length - 1) {
                while (!stack.isEmpty()) {
                    int tmp = stack.pop();
                    System.out.println("The NGE of " + tmp + " = -1");
                }
                System.out.println("The NGE of " + arr[i] + " = -1");
            }
            stack.push(arr[i]);
        }

    }

    private static void reverseStack() {
        if (stack.size() > 0) {

            int x = stack.peek();
            stack.pop();
            reverseStack();


            insert_at_bottom(x);

        }
    }

    private static void insert_at_bottom(int x) {


        if (stack.isEmpty()) {
            stack.push(x);
        } else {

            int a = stack.peek();
            stack.pop();

            insert_at_bottom(x);

            stack.push(a);
        }

    }

    private static void sortStack() {

        if (stack.size() > 0) {

            int x = stack.peek();
            stack.pop();
            sortStack();


            sortRecursion(x);
        }
    }

    private static void sortRecursion(int x) {


        if (stack.isEmpty() || x > stack.peek()) {
            stack.push(x);
        } else {

            int y = stack.peek();
            stack.pop();

            sortRecursion(x);


            stack.push(y);


        }

    }

    private static Stack<Integer> sortStackUsingOtherStack(Stack<Integer> input) {

        Stack<Integer> tmp = new Stack<>();

        while (!input.isEmpty()) {

            int a = input.pop();

            if (tmp.isEmpty()) {
                tmp.push(a);
            } else if (a > tmp.peek()) {
                tmp.push(a);
            } else {
                while (!tmp.isEmpty() && tmp.peek() > a) {
                    stack.push(tmp.pop());
                }
                tmp.push(a);
            }
        }

        return tmp;

    }

    private static void deleteMidElement(Stack<Integer> s, int n, int cur) {

        if (s.size() > 0) {
            int a = s.pop();
            deleteMidElement(s, n, ++cur);
            cur--;
            if (cur != n / 2) {
                s.push(a);
            }
        }


    }

    private static void deleteElements(int arr[], int k) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < stack.peek()) {
                stack.push(arr[i]);
            } else if (k == 0) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && arr[i] > stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(arr[i]);
            }
        }

        System.out.println(stack);

    }

    private static void reverseQueue() {

        if (!queue.isEmpty()) {
            int a = queue.poll();
            reverseQueue();

            queue.add(a);
        }


    }

    private static void reverseQueueUsingStack() {

        Stack<Integer> s = new Stack<>();
        while (!queue.isEmpty()) {
            s.push(queue.poll());
        }
        while (!s.isEmpty()) {
            queue.add(s.pop());
        }

    }

    private static void sortQueue() {

        for (int i = 0; i < queue.size() ; i++) {
            int minIndex = findMinIndex(queue,queue.size()-i);
            insertMinFirst(minIndex);

        }
    }

    private static void insertMinFirst(int minIndex) {
        int currentMinIndex=-1;
        int size =queue.size();
        for (int i = 0; i <size ; i++) {

            int a = queue.poll();

            if(i!=minIndex){
                queue.add(a);
            }
            else{
               currentMinIndex=a;
            }

        }
        queue.add(currentMinIndex);
    }

    private static int findMinIndex(Queue<Integer> queue, int sortIndex) {

        int minIndex = -1;
        int currentMinValue = Integer.MAX_VALUE;
        for (int j = 0; j <queue.size() ; j++) {
            int current = queue.poll();

            // checking that j< sortIndex because we dont wanna repeat on sorted elements.
            if(current<currentMinValue && j <sortIndex){
                minIndex=j;
                currentMinValue=current;
            }
            queue.add(current);

        }
        return minIndex;
    }


}


