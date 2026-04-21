package org.mossimo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
         * ============================================================
         *   SORTING ALGORITHMS - EXPLAINED
         * ============================================================
         *
         * This file contains three classic sorting algorithms:
         *   1. Insertion Sort
         *   2. Selection Sort
         *   3. Bubble Sort
         *
         * All three take an ARRAY OF INTEGERS and sort them
         * from smallest to largest (ascending order).
         *
         * WHAT IS AN ARRAY?
         * -----------------
         * An array is just a list of values stored in a row,
         * each with a numbered position called an INDEX.
         * Indexes START AT ZERO, not one.
         *
         *   Array:  { 3, 1, 2, 1, 4, 1, 0 }
         *            |  |  |  |  |  |  |
         *   Index:   0  1  2  3  4  5  6
         *
         * So nums[0] = 3, nums[1] = 1, nums[6] = 0, etc.
         *
         * GOAL: rearrange into { 0, 1, 1, 1, 2, 3, 4 }
         *
         * ============================================================
         */

        // Our starting array
        int[] nums = {3, 1, 2, 1, 4, 1, 0};
        //             ^                 ^
        //          index 0           index 6

        /*
        original: 3 1 2 1 4 1 0

         1 : 1 3 2 1 4 1 0
         2 : 1 2 3 1 4 1 0
         3 : 1 2 1 3 4 1 0
         4 : 1 1 2 3 4 1 0
         5 : 1 1 2 3 1 4 0
         6 : 1 1 2 1 3 4 0
         7 : 1 1 1 2 3 4 0
         8 : 1 1 1 2 3 0 4
         9 : 1 1 1 2 0 3 4
        10 : 1 1 1 0 2 3 4
        11 : 1 1 0 1 2 3 4
        12 : 1 0 1 1 2 3 4
        13 : 0 1 1 1 2 3 4

        */


        // --- Run Insertion Sort and print result ---
        insertion(nums);
        System.out.println("=== INSERTION SORT ===");
        System.out.println(Arrays.toString(nums));
        // Arrays.toString() converts the array to a readable string like: [0, 1, 1, 1, 2, 3, 4]

        // --- Run Selection Sort and print result ---
        selection(nums);
        System.out.println("\n=== SELECTION SORT ===");
        System.out.println(Arrays.toString(nums));
        // "\n" just adds a blank line before printing

        // --- Run Bubble Sort and print result ---
        bubble(nums);
        System.out.println("\n=== BUBBLE SORT ===");
        System.out.println(Arrays.toString(nums));
    }

    /* ============================================================
     *   1. INSERTION SORT
     * ============================================================
     *
     * ANALOGY: Sorting playing cards in your hand.
     * -------------------------------------------------
     * Imagine you're picking up cards one at a time.
     * Each new card gets slid LEFT into the right spot
     * among the cards you're already holding.
     *
     *   Hand (sorted so far): [ 1, 3, 5 ]
     *   New card picked up:     2
     *
     *   - 2 < 5? Yes → slide 5 right:   [ 1, 3, _, 5 ]
     *   - 2 < 3? Yes → slide 3 right:   [ 1, _, 3, 5 ]
     *   - 2 < 1? No  → insert 2 here:   [ 1, 2, 3, 5 ]
     *
     * -------------------------------------------------
     * STEP-BY-STEP WITH OUR ARRAY: { 3, 1, 2, 1, 4, 1, 0 }
     * -------------------------------------------------
     *
     * We start at index 1 (the second element).
     * Everything to the LEFT is considered "already sorted."
     *
     *  i = 1, value = 1
     *  Sorted side  | Unsorted side
     *  [3]          | [1, 2, 1, 4, 1, 0]
     *   nums[0]=3 > 1 → shift 3 right
     *  [_, 3]       → insert 1 at index 0
     *  Result: [1, 3, 2, 1, 4, 1, 0]
     *
     *  i = 2, value = 2
     *  Sorted side  | Unsorted side
     *  [1, 3]       | [2, 1, 4, 1, 0]
     *   nums[1]=3 > 2 → shift 3 right
     *   nums[0]=1 > 2? No → insert 2 at index 1
     *  Result: [1, 2, 3, 1, 4, 1, 0]
     *
     *  i = 3, value = 1
     *  Sorted side  | Unsorted side
     *  [1, 2, 3]    | [1, 4, 1, 0]
     *   nums[2] = 3 > 1 → shift right
     *   nums[1] = 2 > 1 → shift right
     *   nums[0] = 1 > 1? No (equal, stop) → insert at index 1
     *  Result: [1, 1, 2, 3, 4, 1, 0]
     *
     *  ... and so on until sorted.
     *
     * -------------------------------------------------
     * VISUAL FLOW OF THE LOOP:
     * -------------------------------------------------
     *
     *  for i = 1 to end:
     *  ┌────────────────────────────────────────────┐
     *  │  value = nums[i]    ← grab current element │
     *  │  j = i - 1          ← look left            │
     *  │                                            │
     *  │  while j >= 0 AND nums[j] > value:         │
     *  │  ┌─────────────────────────────────────┐   │
     *  │  │  nums[j + 1] = nums[j] ← shift right│   │
     *  │  │  j--                   ← move left  │   │
     *  │  └─────────────────────────────────────┘   │
     *  │                                            │
     *  │  nums[j + 1] = value  ← drop value in gap  │
     *  └────────────────────────────────────────────┘
     *
     * -------------------------------------------------
     * TIME COMPLEXITY:
     * -------------------------------------------------
     *
     *  Best Case  O(n)   → array is already sorted,
     *                       inner while-loop never runs
     *
     *  Worst Case O(n²)  → array is reverse sorted,
     *                       every element must shift all the way
     *
     *  n = number of elements. O(n²) means if n = 100,
     *  you might do up to 10,000 operations. Slow for big arrays!
     *
     * ============================================================
     */
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

    /* ============================================================
     *   2. SELECTION SORT
     * ============================================================
     *
     * ANALOGY: Lining up kids by height for a school photo.
     * -------------------------------------------------
     * Look at everyone still unlined-up, find the shortest,
     * and move them to the next open spot in line.
     * Repeat until everyone is lined up.
     *
     * -------------------------------------------------
     * STEP-BY-STEP WITH OUR ARRAY: { 3, 1, 2, 1, 4, 1, 0 }
     * -------------------------------------------------
     *
     *  Pass 1 (i = 0): Find minimum in entire array
     *  [ 3, 1, 2, 1, 4, 1, 0 ]
     *                        ^-- min is 0, at index 6
     *  Swap index 0 and index 6:
     *  [ 0, 1, 2, 1, 4, 1, 3 ]
     *    ^-- LOCKED IN (sorted)
     *
     *  Pass 2 (i = 1): Find minimum from index 1 onward
     *  [ 0 | 1, 2, 1, 4, 1, 3 ]
     *          ^-- min is 1, at index 1 (already in place)
     *  Swap index 1 with index 1 (no change):
     *  [ 0, 1, 2, 1, 4, 1, 3 ]
     *       ^-- LOCKED IN
     *
     *  Pass 3 (i = 2): Find minimum from index 2 onward
     *  [ 0, 1 | 2, 1, 4, 1, 3 ]
     *              ^-- min is 1, at index 3
     *  Swap index 2 and index 3:
     *  [ 0, 1, 1, 2, 4, 1, 3 ]
     *          ^-- LOCKED IN
     *
     *  ... and so on.
     *
     * -------------------------------------------------
     * VISUAL FLOW OF THE LOOP:
     * -------------------------------------------------
     *
     *  for i = 0 to end:
     *  ┌──────────────────────────────────────────────────┐
     *  │  minIdx = i    ← assume current spot is minimum  │
     *  │                                                  │
     *  │  for j = i + 1 to end:                           │
     *  │  ┌────────────────────────────────────────────┐  │
     *  │  │  if nums[j] < nums[minIdx]:                │  │
     *  │  │      minIdx = j  ← found a new minimum     │  │
     *  │  └────────────────────────────────────────────┘  │
     *  │                                                  │
     *  │  swap nums[i] ↔ nums[minIdx]                     │
     *  └──────────────────────────────────────────────────┘
     *
     * -------------------------------------------------
     * SWAP MECHANIC (why we need "temp"):
     * -------------------------------------------------
     *
     *  Imagine two cups of liquid. To swap them,
     *  you need an empty third cup (temp):
     *
     *  Cup A = 🍊  Cup B = 🧃  temp = empty
     *
     *  Step 1: temp = Cup A       → temp = 🍊
     *  Step 2: Cup A = Cup B      → Cup A = 🧃
     *  Step 3: Cup B = temp       → Cup B = 🍊
     *
     *  In code:
     *    int temp    = nums[i];        // save A
     *    nums[i]     = nums[minIdx];   // A = B
     *    nums[minIdx]= temp;           // B = saved A
     *
     * -------------------------------------------------
     * TIME COMPLEXITY:
     * -------------------------------------------------
     *
     *  Always O(n²) — even if already sorted, it still
     *  scans the whole remaining array every pass.
     *  Good news: it makes at most n swaps (efficient
     *  if swapping is expensive).
     *
     * ============================================================
     */
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

    /* ============================================================
     *   3. BUBBLE SORT
     * ============================================================
     *
     * ANALOGY: Bubbles rising to the surface of water.
     * -------------------------------------------------
     * In each pass through the array, large values
     * "float" toward the right end, one step at a time.
     * After each full pass, the largest unsorted value
     * has settled into its final position on the right.
     *
     * -------------------------------------------------
     * STEP-BY-STEP WITH OUR ARRAY: { 3, 1, 2, 1, 4, 1, 0 }
     * -------------------------------------------------
     *
     *  PASS 1 (i = 0): Compare every adjacent pair
     *  j = 0: [3,1] → 3>1? YES swap → [1, 3, 2, 1, 4, 1, 0]
     *  j = 1: [3,2] → 3>2? YES swap → [1, 2, 3, 1, 4, 1, 0]
     *  j = 2: [3,1] → 3>1? YES swap → [1, 2, 1, 3, 4, 1, 0]
     *  j = 3: [3,4] → 3>4? NO       → [1, 2, 1, 3, 4, 1, 0]
     *  j = 4: [4,1] → 4>1? YES swap → [1, 2, 1, 3, 1, 4, 0]
     *  j = 5: [4,0] → 4>0? YES swap → [1, 2, 1, 3, 1, 0, 4]
     *                                                    ^
     *                                              4 is LOCKED IN ✓
     *
     *  PASS 2 (i = 1): Stop one earlier (no need to touch index 6)
     *  j = 0: [1,2] → NO
     *  j = 1: [2,1] → YES swap → [1, 1, 2, 3, 1, 0, 4]
     *  j = 2: [2,3] → NO
     *  j = 3: [3,1] → YES swap → [1, 1, 2, 1, 3, 0, 4]
     *  j = 4: [3,0] → YES swap → [1, 1, 2, 1, 0, 3, 4]
     *                                            ^  ^
     *                                      3 and 4 LOCKED IN ✓
     *
     *  ... continue until fully sorted.
     *
     * -------------------------------------------------
     * WHY "nums.length - 1 - i" IN INNER LOOP?
     * -------------------------------------------------
     *
     *  After each pass, the last i elements are already
     *  sorted and don't need to be touched again.
     *
     *  Pass 0: check indices 0–5  (length 6 comparisons)
     *  Pass 1: check indices 0–4  (length 5 comparisons)
     *  Pass 2: check indices 0–3  (length 4 comparisons)
     *  ...
     *
     *  This is what "j < nums.length - 1 - i" achieves.
     *  It also ensures j + 1 never goes out of bounds.
     *
     * -------------------------------------------------
     * VISUAL FLOW OF THE LOOP:
     * -------------------------------------------------
     *
     *  for i = 0 to end:                     ← pass number
     *  ┌──────────────────────────────────────────────┐
     *  │  for j = 0 to (end - i):            ← pairs  │
     *  │  ┌────────────────────────────────────────┐  │
     *  │  │  if nums[j] > nums[j + 1]:             │  │
     *  │  │  ┌──────────────────────────────────┐  │  │
     *  │  │  │  swap nums[j] and nums[j + 1]    │  │  │
     *  │  │  └──────────────────────────────────┘  │  │
     *  │  └────────────────────────────────────────┘  │
     *  └──────────────────────────────────────────────┘
     *
     * -------------------------------------------------
     * TIME COMPLEXITY:
     * -------------------------------------------------
     *
     *  Best Case  O(n)   → with an "early exit" optimization
     *                       (if no swaps in a pass, it's sorted).
     *                       This code doesn't implement that,
     *                       so in practice it's always O(n²) here.
     *
     *  Worst Case O(n²)  → reverse-sorted array.
     *
     * ============================================================
     */
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
}

/*
 * ============================================================
 *   QUICK COMPARISON OF ALL THREE ALGORITHMS
 * ============================================================
 *
 *  Algorithm      | Best     | Worst  | Swaps      | Stable?
 *  ---------------|----------|--------|------------|--------
 *  Insertion Sort | O(n)     | O(n²)  | Up to n²   | YES
 *  Selection Sort | O(n²)    | O(n²)  | Exactly n  | NO
 *  Bubble Sort    | O(n)†    | O(n²)  | Up to n²   | YES
 *
 *  † Only with early-exit optimization (not implemented here)
 *
 *  "Stable" means equal elements keep their original order.
 *
 * ============================================================
 *   WHICH SHOULD YOU USE?
 * ============================================================
 *
 *  - Small arrays or nearly sorted data → Insertion Sort ✓
 *  - Minimizing swaps is critical        → Selection Sort ✓
 *  - General learning / simplicity       → Bubble Sort ✓
 *  - Real production code                → Use Arrays.sort() which
 *                                          uses a much faster algorithm
 *                                          (TimSort, O(n log n))
 *
 * ============================================================
 */
