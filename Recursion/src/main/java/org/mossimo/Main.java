package org.mossimo;

public class Main {
    public static void main(String[] args) {

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


    // THIS IS INCOMPLETE, LOOK AT SOURCE CODE ON OMNIVOX

//    public static boolean isPalindrome(String str) {
//        for (int i = 0; i <= str.length() / 2; i++) {
//
//        }
//
//        return false;
//    }
//
//    public static boolean isPalindromeRecursion(String str) {
//        if (str.length() <= 1) {
//            return true;
//        }
//
//        return isPalindromeRecursion();
//    }
}
