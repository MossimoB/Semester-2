package org.mossimo;

import java.util.*;

public class SecondHalf {
    static void main() {

    }

    public static Map<Integer, Set<String>> groupUniqueWords(List<String> strs) {
        // Group strings by their length into a sorted map:
        // key = string length, value = sorted set of unique lowercase words
        Map<Integer, Set<String>> map = new TreeMap<>();  // TreeMap keeps lengths sorted

        // Iterate over each input string
        for (String str : strs) {
            int length = str.length();  // Compute length once per string

            // If no set exists yet for this length, create a new TreeSet
            // TreeSet ensures words are unique and sorted lexicographically
            if (!map.containsKey(length)) {
                map.put(length, new TreeSet<>());
            }

            // Add the word in lowercase to make grouping case-insensitive
            map.get(length).add(str.toLowerCase());
        }

        // Return map: lengths -> unique, sorted, lowercase words of that length
        return map;
    }

    public static List<String> process(List<String> strs) {
        // Compute the average length of all strings in the list
        double avgLen = 0;

        // Sum the lengths of all strings
        for (String str : strs) {
            avgLen += str.length();
        }

        // Divide total length by number of strings to get the average
        avgLen /= strs.size();

        // Store average in effectively-final variable for use inside the stream lambda
        double finalAvg = avgLen;

        // Build a new list by streaming over the original strings:
        return strs.stream()
                // Keep only strings whose length is <= average length
                .filter(str -> str.length() <= finalAvg)  // Stream.filter keeps elements matching the predicate
                // Convert each remaining string to lowercase
                .map(String::toLowerCase)                 // Stream.map transforms each element
                // Duplicate each string by concatenating it with itself
                .map(str -> str + str)
                // Collect the stream into an immutable List
                .toList();                                // Stream.toList() creates a List from the elements
    }

    public static void bubble(int[] nums) {

        // Outer loop: each iteration is one full "pass" through the array.
        // After pass i, the last (i + 1) elements are guaranteed sorted.
        for (int i = 0; i < nums.length - 1; i++) {

            // Inner loop: walk through adjacent pairs.
            // We stop at nums.length - 1 - i because:
            //   - nums.length - 1 → avoids going out of bounds when accessing j + 1
            //   - the extra - i   → skips already-sorted elements at the end
            for (int j = 0; j < nums.length - 1 - i; j++) {

                // If left neighbor is bigger than right neighbor, they're out of order
                if (nums[j] > nums[j + 1]) {

                    // Classic 3-step swap using a temporary variable
                    int temp     = nums[j];
                    nums[j]      = nums[j + 1];
                    nums[j + 1]  = temp;
                }
            }
        }
    }

    public static void selection(int[] nums) {

        // i = the position we're trying to fill with the correct (minimum) value
        for (int i = 0; i < nums.length - 1; i++) {

            // Assume the minimum is at the current position i
            int minIdx = i;

            // Scan everything to the RIGHT of i to find a smaller value
            for (int j = i + 1; j < nums.length; j++) {

                // nums[j] for comparison.
                if (nums[j] < nums[minIdx]) {
                    minIdx = j; // Found a new minimum — remember its index
                }
            }

            // Now swap the found minimum into position i
            // (Even if minIdx == i, this swap is harmless because it's swapping with itself)
            int temp       = nums[i];
            nums[i]        = nums[minIdx];
            nums[minIdx]   = temp;
        }
    }

    public static void insertion(int[] nums) {

        // i starts at 1 because a single element (index 0) is trivially sorted.
        // We go up to nums.length - 1 (second to last element).
        // NOTE: This stops one short of the last element (a subtle behavior —
        //       changing to i < nums.length would also sort the final element).
        for (int i = 1; i < nums.length; i++) {

            // "value" is the card we just picked up — we need to place it correctly.
            int value = nums[i];

            // j is our "comparison finger" — starts just left of i and moves left.
            int j = i - 1;

            // Keep shifting elements right as long as:
            //   1. We haven't gone past the start of the array (j >= 0)
            //   2. The element to the left is bigger than our value (nums[j] > value)
            while (j >= 0 && nums[j] > value) {
                nums[j + 1] = nums[j]; // Slide the bigger element one spot to the right
                j--;                   // Move our finger one step left
            }

            // The while loop stopped — either j went out of bounds,
            // or we found an element smaller than value.
            // Either way, j + 1 is the correct insertion spot.
            nums[j + 1] = value;
        }
    }
}
