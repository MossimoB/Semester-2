package org.mossimo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Sorting

        Collections
            List    ArrayList   LinkedList  add()   remove()
            Queue   Queue   PriorityQueue   add()   remove()
            Stack                           push()  poll()
            Set     HashSet (no order)  LinkedHashSet (insertion order)    TreeSet (ordered)   add()   remove()
            Map<Key, Value>     HashMap     LinkedHashMap       TreeMap     put()   remove()


            Java collections are like different kinds of toy containers, each with its own rules:
                LIST    -> A List (like ArrayList or LinkedList) is like a line of toys where order matters and duplicates are allowed, and you can add or remove items
                QUEUE   -> A Queue (like PriorityQueue) is like a line at a playground where the first one in is the first one out
                STACK   -> A Stack is like a stack of pancakes where you can only add or remove from the top, so the last item added is the first one taken off
                SET     -> A Set (like HashSet, LinkedHashSet, or TreeSet) is a collection where you cannot have duplicates, and depending on the type, it may keep no order, insertion order, or sorted order.
                MAP     -> A Map (like HashMap, LinkedHashMap, or TreeMap) stores pairs of keys and values, where each key is used to find its corresponding value

                  |  add   |  remove   |   get                      |   set
           -------------------------------------------------------------------
            List  |  add() |  remove() |   get()                    |   set()
            Queue |  add() |  poll()   |   peek()                   |   x
            Set   |  add() |  remove() |   x                        |   x
            Map   |  put() |  remove() |   get() / getOrDefault()   |   put()
            Stack |  push()|  pop()    |   peek()                   |   x

         */

//        Map<Character, Integer> map = new HashMap<>();

        // count the appearance of the letters
        // know the average price of different categories of products
        // class Product      enum Category
//        Map<Product.Category, Double>

        // group students based on their letter scores
//        Map<Character, List<Student>>

        // Map is good at counting, grouping

        System.out.println(groupWords("I have a cat and she has a cat too"));
        System.out.println("\n");
        Map<Character, Set<String>> map = groupWords("I have a cat and she has a cat too");
        System.out.println("Sentence -> I have a cat and she has a cat too");
        System.out.println("These are the map's values -> " + map.values());
        System.out.println("\n");
        System.out.println("This is a map datatype -> " + map);
        System.out.println("This is a set datatype -> " + map.entrySet());
    }

    // COUNTING
    //
    // Counts how many times each character appears in a given string and returns the results as a map
    // Each character is a key, and its frequency is the corresponding value
    public static Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : str.toLowerCase().toCharArray()) {
            // adding
            map.put(c, 1);

            // getting
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    // GROUPING
    //
    // Groups words from a given string by their characters and returns a map
    // Each character is a key, and the value is a set of words containing that character
    //
    // use List<String> if you want duplicated words for each group
    // use Set<String> if you want unique words for each group
    // if you want to have duplicated words with their frequencies: Map<Character, Map<String, Integer>>
    public static Map<Character, Set<String>>groupWords(String str) {
        Map<Character, Set<String>> map = new TreeMap<>();

        String[] words = str.toLowerCase().split(" ");

        for (String word : words) {
            char firstLetter = word.charAt(0);
            if (map.get(firstLetter) == null) {
                map.put(firstLetter, new TreeSet<>());
            }

//            // if it's the first time we see a letter
//            // first prepare the set, then add to the map
//            Set<String> wordSet = new TreeSet<>();
//            wordSet.add(word);
//            map.put(firstLetter, wordSet);
//
//            // first add empty set to the map, then update the set
//            map.put(firstLetter, new TreeSet<>());

            map.get(firstLetter).add(word);
        }

        return map;
    }
}
