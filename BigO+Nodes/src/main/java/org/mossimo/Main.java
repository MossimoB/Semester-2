package org.mossimo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        System.out.println(singlyLinkedList);


//----------------------------------------------------------------------------------------------------------------------

       // ArrayList<>
       // LinkedList<>                // DoublyLinkedList (jumps two elements to reach the final element)


        // From good to bad, *we always consider the worst situation
        /*
            Best
            O(1)        constant (any piece of code that isn't related to the size
            O(logn)     BST (Binary Search Tree)
            O(n)        linearly related (usually to the size)
            O(n^2)      usually in a nested for loop (usually related to the size of a 2D array0
            O(2^n)
            Worst
         */
    }

    // Big O(n)
    public static double avg(List<Integer> nums) {
        double sum = 0;

        for (int num : nums) {
            sum += num;
        }

        return sum / nums.size();
    }

    // Big O(n^2) (we take the worst case possible)
    public static double sum(int[][] numss) {
        int sum = 0;

        for (int i = 0; i < 10; i++) { //  <- Big O 1 (not linearly dependent to the size

        }

        for (int[] nums : numss) {
            for (int num : nums) {
                sum += num;
            }
        }

        return sum;
    }

    // Big O(n)
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    // Big O(2^n)
    public static int fibonacciRecursion(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }

    // Big O(n)
    public static int fibonacci(int num) {
        if (num <= 0) {
            return num;
        }

        int num1 = 0;
        int num2 = 1;
        int result = 0;

        for (int i = 0; i <= num; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }

        return result;
    }

    // Big O(2^n)
    public static void hanoiTower(int disk, char start, char end, char assist) {
        hanoiTower(disk - 1, start, assist, end);
        System.out.printf("%c -> %c\n", start, end);
        hanoiTower(disk - 1, assist, end, start);
    }
}
