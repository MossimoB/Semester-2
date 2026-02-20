package org.mossimo;

/**
 * RECURSION EXAMPLE
 * ------------------------------------------------------------
 * Recursion = a method calls itself.
 *
 * MUST HAVE:
 * 1. Base case (stopping condition)
 * 2. Recursive case (method calls itself)
 */

public class Recursion {

    /**
     * Calculates factorial using recursion.
     * factorial(5) = 5 * 4 * 3 * 2 * 1
     */
    public static int factorial(int n) {

        // BASE CASE: stops recursion
        if (n == 0) {
            return 1;
        }

        // RECURSIVE CASE
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println("Factorial = " + result);
    }
}
