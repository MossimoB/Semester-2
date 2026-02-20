package org.mossimo;

/**
 * EXCEPTION HANDLING EXAMPLE
 * ------------------------------------------------------------
 * Exceptions are runtime errors that can crash programs.
 *
 * Java provides:
 * - try
 * - catch
 * - finally
 * - throw
 * - throws
 */

public class ExceptionHandling {

    /**
     * Method demonstrating 'throws'
     */
    static int divide(int a, int b) throws ArithmeticException {
        return a / b; // may throw exception
    }

    public static void main(String[] args) {

        try {
            int result = divide(10, 0); // risky code
            System.out.println(result);

        } catch (ArithmeticException e) {
            // runs if exception occurs
            System.out.println("Cannot divide by zero!");
            System.out.println("Error message: " + e.getMessage());

        } finally {
            // ALWAYS runs
            System.out.println("Program finished attempt.");
        }

        /**
         * Example of manually throwing an exception
         */
        int age = -5;
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
