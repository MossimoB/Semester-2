package org.mossimo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 5, 10, 1, 1, 2)); // takes a whole collection
        // faster than adding each element to the list
        Set<Integer> uniqueNums = new LinkedHashSet<>(nums);
        System.out.println("uniqueNums -> " + uniqueNums);
//----------------------------------------------------------------------------------------------------------------------
                        /*
                values on the left side need to be unique
                values on the right side have no restrictions

                Map<Integer, Integer>      // counts the amount of integer: map size = 2 parts
                1 -> 5
                2 -> 14
                3 -> 22

                Map<Character, Integer>    // counts the amount of each integer: map size = 3 parts
                a - 2004
                b - 102
                c - 1084
                d - 102

                Map<User, Boolean>         // checks which user has access: map size = 2 parts
                alice -> true
                bob -> false
                 */
//----------------------------------------------------------------------------------------------------------------------
//----- Map<Integer, Integer> -----

        Map<Integer, Integer> map = new HashMap<>();
        map.size();
        map.isEmpty();

        map.put(1, 10);
        System.out.println("\nmap.put(1, 10) -> " + map);

        map.put(2, 5);
        System.out.println("\nmap.put(2, 5) -> " + map);

        map.remove(1, 3);
        System.out.println("\nmap.remove(1, 3) -> " + map);
        System.out.println("\nmap.size() -> " + map.size());

//----------------------------------------------------------------------------------------------------------------------
//----- Map<Character, Integer> -----

        String str = "apple";
        Map<Character, Integer> cMap = countLetters(str);
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.printf("%c = %d\n", c, cMap.getOrDefault(c, 0));
        }
    }

    /**
     * counts the appearance of each letter in a string (case-insensitive)
     * @param str the input string
     * @return the appearance of each letter
     */
    public static Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> map = new TreeMap<>();

        for (char c : str.toLowerCase().toCharArray()) {
            map.put(c, (map.get(c) == null) ? 1 : map.get(c) + 1);
        }
//            if (map.get(c) == null) {
//                map.put(c, 1);
//            } else {
//                map.put(c, map.get(c) + 1);
//            }
//        }

        return map;
    }

//----------------------------------------------------------------------------------------------------------------------
//----- Map<User, Boolean> -----
}
