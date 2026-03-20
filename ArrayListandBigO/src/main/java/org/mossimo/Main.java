package org.mossimo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Array is good at reading and writing one element,
// bad at inserting and deleting
public class Main {
    public static void main(String[] args) {
        int[] numsArray = {1,2,3,2,2,41,4,4,24,234,234};
        // original: 100
        // new: 100;
        // copy: 100 times, each time copy (100, 101, 102, 103)

        Arrays.copyOf(numsArray, numsArray.length + 1);

        List<Integer> numsList = new ArrayList<>(200);
        // Like a stretchy array—easy and fast to get items, but adding/removing in the middle is slow

        // Resizable array implementation of a list that provides fast random access (O(1))
        // but slower insertions/removals in the middle due to shifting elements

        List<Integer> numsList2 = new LinkedList<>();
        // Like a chain—easy to add/remove items, but slow to find something

        // Doubly linked list implementation that allows fast insertions and deletions (especially at ends)
        // but slower access (O(n)) since elements must be traversed

        numsList2.add(100);

        numsList.add(100);      // add to the end
        // original: 100
        // new: 100
        // copy: 0 times because there are 100 additional spaces
        // new: 110
        // copy: 1 time, create a new arrayList when at max capacity with 50% more than the current capacity

        numsList.add(0, 100);
        // adds a new element at specific location
        // shifts all elements after the index to the next location

        // ArrayList
        // Good at Getting and Setting: directly calculate the address in one shot

        // (Bad) Adding:
        // 1. add at the end -> most of the time no copy-pasting, only when the capacity is full
        // then a new arrayList with 50% capacity is created
        // and all current elements are copy-pasted into the new arrayList

        // 2. insert at a specific location -> all elements after the index
        // are copy-pasted to the next location

        // (Bad) Deleting:
        // 1. remove(idx):
        // a. idx is pointing at the last element (no copy-pasting)
        // b. idx is not pointing at the last element (shift elements after the index to the previous location)

        // 2. remove(obj):
        // java applies a search in the list
        // worst case, it goes through the entire list

        //-----------------------------------------------------------------------------------------------------------//

        // LinkedLIst (DoublyLInkedList jumps two elements to reach the final element)

        // (Bad) Getting and Setting: Worst case, you have to iterate through half of the list
        // in order to read/modify an element

        // (Good) Adding and Removing: Locally update the previous and next values of the element

        //-----------------------------------------------------------------------------------------------------------//

        // Big O Notation

        // O(1)         y = a * 1       Constant
        // O(logn)      y = a * logn    BST(Binary Search Tree)
        // O(n)         y = a * x       Linearly Related
        // O(n^2)       y = a * x^2     
        // O(2^n)       y = a * 2^x     

        // Big O n
        public static double avg(List<Integer> nums) {
            double sum = 0;

            for (int num : nums) {
                sum += num;
            }

            return sum / nums.size();
        }

        // Big O n^2 (we take the worst case possible)
        public static double sum(int[][] numss) {
            int sum = 0;

            for (int[] num : numss) {
                for (int num : nums) {
                    sum += num;
                }
            }

            return sum;
        }

        // Big O n
        public static boolean isPalindrome(String str) {
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            }

            return true;
        }

        // Big O 2^n
        public static int fibonacciRecursion(int num) {
            if (num <= 1) {
                return num;
            }

            return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
        }
    }
}
