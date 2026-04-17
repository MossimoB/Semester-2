package org.mossimo;

import java.util.*;

// Side Note:
// A functional interface is an interface with only one abstract method

public class Main {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>(Arrays.asList(
                new Cat("snowy", 4, 40),
                new Cat("hailey", 5, 50),
                new Cat("rainy", 6, 60),
                new Cat("fiery", 7, 70),
                new Cat("windy", 8, 80),
                new Cat("rocky", 9, 90)
        ));

        // lambda expression: in -> out
        // can be used to replace the using of a functional interface
        Collections.sort(cats, (Cat c1, Cat c2) -> (Double.compare(c1.getPrice(), c2.getPrice())));
        System.out.println(cats);

        // stream: fast way to apply operations on collections
        List<Cat> cats2 = new ArrayList<>();

        // removes expensive cats
        for (Cat cat : cats) {
            if (cat.getPrice() < 50) {
                cats2.add(cat);
            }
        }

        // .stream() converts a collection to a stream
        // .filter(lambda expression) removes the elements that do not satisfy the lambda expression
        // you can use .filer() an unlimited number of times
        List<Cat> cats3 = cats.stream()
                            // lambda expression
                .filter(cat -> cat.getPrice() < 50)
// example  →   .filter(cat -> cat.getGender == Gender.Male)
                .toList();
        System.out.println(cats3);

//---------------------------------------------------------------------------------------------------------------------

        // .map(lambda expression) converts each element to a new value based on the lambda expression
        // .forEach(lambda expression) handles and returns void
        List<Integer> nums = new ArrayList<>(Arrays.asList(5, 1, 2, 3, 5, 7, 4));

        List<Boolean> nums2 = nums.stream()
                .filter(num -> num < 4)
                .map(num -> num < 3)
// if you put .forEach() here, before .toList(), .toList() won't work.
//                        ↓
                .toList();
//              .forEach() always goes at the end

        System.out.println(nums2);


        cats.stream()
                .forEach(cat -> cat.setAge(cat.getAge() + 1));

        cats.stream()
                .filter(cat -> cat.getPrice() >=50)
                .forEach(cat -> cat.setPrice(cat.getPrice() - 5));

        System.out.println(cats);

//---------------------------------------------------------------------------------------------------------------------

        List<String> strs = new ArrayList<>(Arrays.asList("hello", "apple", "laval", "lol", "java", "pineapple", "university"));

        // remove words that are longer than 5 letters
        // reverse the remaining words
        List<String> strs2 = strs.stream()
                .filter(str -> str.length() <= 5)       // removes "university" and "pineapple"
                .map(str -> reverse2(str))              // reversed the rest of the words
                .map(Main::reverse2)    // this is called method reference (reverses the reverse words)
                .toList();              //          |
//                                                  ↓
        // method reference:
        // used if there is only one method calling on the right side of the ->
        // the lambda expression can be replaced by class::methodName
        System.out.println(strs2);


        // filter out words with length longer than 5
        // filter out non-palindromes
        // convert the other words to uppercase
        List<String> strs3 = strs.stream()
                .filter(str -> str.length() <= 5)       // keep length ≤ 5
                .filter(Main::isPalindrome)                   // keep only palindromes
                .map(String::toUpperCase)                     // converts to uppercase
                .toList();

        System.out.println(strs3);
    }

    // to identify palindromes
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // Reverse List<String> using a loop
    private static String reverse1(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.insert(0, c);
        }

        return sb.toString();
    }

    // Reverse List<String> using recursion
    private static String reverse2(String str) {
        // base case
        if (str.length() <= 1) {
            return str;
        }

        return reverse2(str.substring(1)) + str.charAt(0);
    }
}
