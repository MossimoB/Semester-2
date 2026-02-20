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

        } catch (RuntimeException e) {
            e.getMessage();
            e.getClass();        // Arithmetic or IndexOutOfBound
            e.getStackTrace();
            System.exit(0); // Stops everything immediately. 
                            // 0 is good
                            // 1 is bad
        
        } finally {
            // ALWAYS runs
            System.out.println("Program finished attempt.");
        }

        /**
         * Example of manually throwing an exception
         * 
         * For this to work, we'd have to have a separate class
         * That class would be called IllegalArgumentException.java
         * In the file, the first line (not including the package), should be:
         * public class IllegalArgumentException extends Exception { }
         */
        int age = -5;
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}


