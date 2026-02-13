package org.mossimo;

public class Main {
    public static void main(String[] args) {
        // FIBONACCI SEQUENCE
        int num = 10;
        System.out.println(fibonacci1(num));
        System.out.println(fibonacciRecursion(num));

        // TOWER OF HANOI
        int n = 10; // number of disks
        hanoi(n, 'A', 'C', 'B');
        // Calculate and print the total number of moves
        int totalMoves = (int) Math.pow(2, n) - 1;
        System.out.println("Total moves: " + totalMoves);
    }

    /**
     * sums the values in range [0, upperBound]
     * @param upperBound the upper bound of the range
     * @return the sum of values in range [0, upperBound]
     */
    public static int sum(int upperBound) {
        // base case
        int sum = 0;

        for (int i=0; i < upperBound; i++){
            sum += 1;
        }

        return sum;
    }

    public static int sumRecursion(int upperBound) {
        // base case (the case can directly return an actual value without any calculations)
        if (upperBound == 1) {
            return 0;
        }

        // general pattern (the method calls itself)
        return sumRecursion(--upperBound - 1) + upperBound - 1;
    }

    public static String reverse(String strIn) {
        String strOut = "";

        for (char c : strIn.toCharArray()) {
            strOut += c;        // strOut = strOut + c
        }

        return strOut;
    }

    public static String reverseRecursion(String str) {
        if (str.length() <= 1) {
            return str;
        }

        return reverseRecursion(str.substring(1)) + str.charAt(0);
    }

    public static boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        // If they match, recursively check the substring
        // that excludes the first and last characters
        // The string is a palindrome only if BOTH conditions are true
        int len = str.length();
        return str.charAt(0) == str.charAt(len - 1) &&
                isPalindrome(str.substring(1, len -1));
    }

    /**
     * f(0) = 0
     * f(1) = 1
     * f(2) = f(0) + f(1) = 1
     * f(3) = f(1) + f(2) = 2
     * f(n) = f(n-1) + f(n-2)
     * @param num
     * @return
     */
    public static int fibonacciRecursion(int num) {
        if (num <= 1) {
            return num;
        }

        return fibonacciRecursion(num - 1) + fibonacciRecursion(num - 2);
    }

    public static int fibonacci1(int num) {
        // Base cases
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        // Recursive case
        return fibonacci1(num - 1) + fibonacci1(num - 2);
    }

    public static int fibonacci2(int num) {
        // Base cases
        if (num == 0)  {
            return 0;
        }
        if (num == 1) {
            return 1;
        }

        // Create array to store Fibonacci values up to num
        int[] fib = new int[num + 1];

        // Base cases
        fib[0] = 0;
        fib[1] = 1;

        // Filling the array
        for (int i = 2; i <= num; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[num];
    }

        // This method solves the Tower of Hanoi problem using recursion
        // It moves n disks from the source rod to the destination rod using an auxiliary rod
        // The idea: move n-1 disks to the auxiliary rod, move the largest disk to the destination,
        // then move the n-1 disks from auxiliary to destination. The base case is n == 1
        public static void hanoi(int n, char from, char to, char aux) {
            // base case
            if (n == 0) {
                System.out.println("Move disk 1 from " + from + " to " + to);
                return;
            }

            // Move n-1 disks from source to auxiliary (helper rod)
            // Move the top (n-1) disks from 'from' (start) to 'aux' (helper), using 'to' (destination) as temporary storage
            hanoi(n - 1, from, aux, to);

            // Move the largest disk
            System.out.println("Move disk " + n + " from " + from + " to " + to);

            // Move n-1 disks from auxiliary to destination
            // Move the top (n-1) disks from 'aux' (helper) to 'to' (destination), using 'from' (source) as temporary storage
            hanoi(n - 1, aux, to, from);
        }

        // only consider positive exponents
        // n^0 = 1
        // 2^5 = 2 2 2 2 2
        // 3^5 = 3 3 3 3 3
        public static int pow(int base, int exp) {
            // base case
            if (exp == 0) {
                return 1;
            }
            // recursive step
            return base * pow(base, exp - 1);
        }

        // only consider positive num
        // 123 = 1 + 2 + 3 = 6
        public static int sumDigit(int num) {
            // base case
            if (num == 0) {
                return 0;
            }
            // recursive step
            return (num % 10) + sumDigit(num / 10);
        }
}
