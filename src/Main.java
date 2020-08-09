import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
     */
    static int N = 4;

    public static void main(String[] args) {

        //   int arr[] = {1,464,123,435,664,2};
        int board[][] = new int[N][N];


        //    QueensProblem queensProblem = new QueensProblem(board, N);

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(2);
        l1.add(4);
        l1.add(3);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(5);
        l2.add(6);
        l2.add(4);
        l2.add(7);

        System.out.println(addTwoNumbers(l1, l2));

        int arr[] = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(maxProfit(arr));

        int a[] = {1, 3};
        int b[] = {2};
        //System.out.println(findMedianSortedArrays(a, b));

       // System.out.println(longestPalindrome("ac"));

        int arr2 [] = {4,5,6,5,4,56,5,2,3,4,5,5,6,2};
        System.out.println(isRepeatsKtimes(arr2,5));

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


}