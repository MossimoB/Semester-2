package org.mossimo;

import java.util.*;

public class Main {

    // ─────────────────────────────────────────────
    // Task 1: Reverse a string using a Stack
    // ─────────────────────────────────────────────
    public static String reverse(String str) {
        Stack<Character> stack = new Stack<>();

        // Push every character onto the stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        // Pop characters off (LIFO order = reversed)
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    // ─────────────────────────────────────────────
    // Task 2: Check balanced parentheses using a Stack
    // ─────────────────────────────────────────────
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // Push any opening bracket
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // For a closing bracket, check if it matches the top of the stack
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty())
                    return false; // nothing to match against

                char top = stack.pop();
                if (c == ')' && top != '(')
                    return false;
                if (c == '}' && top != '{')
                    return false;
                if (c == ']' && top != '[')
                    return false;
            }
        }

        // Balanced only if every opener was matched
        return stack.isEmpty();
    }

    // ─────────────────────────────────────────────
    // Task 3: Interleave first and second halves of a Queue
    // ─────────────────────────────────────────────
    public static void interleaveQueue(Queue<Integer> queue) {
        int size = queue.size();
        int half = size / 2;

        // Use a stack to hold the first half
        Stack<Integer> stack = new Stack<>();

        // Step 1: Move the first half into the stack
        for (int i = 0; i < half; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Push the stack contents back to the queue (reverses them)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Step 3: Move the second half (now at front) to the back
        for (int i = 0; i < half; i++) {
            queue.add(queue.poll());
        }

        // Step 4: Move the first half (reversed, now at front) to the stack again
        for (int i = 0; i < half; i++) {
            stack.push(queue.poll());
        }

        // Step 5: Interleave — pop from stack (first-half element) then dequeue (second-half element)
        while (!stack.isEmpty()) {
            queue.add(stack.pop());        // first-half element
            queue.add(queue.poll());       // second-half element
        }
    }

    // ─────────────────────────────────────────────
    // Task 4: Check if two Sets are disjoint
    // ─────────────────────────────────────────────
    public static boolean areDisjointSets(Set<Integer> set1, Set<Integer> set2) {
        // Check every element of set1 — if any exists in set2, not disjoint
        for (int num : set1) {
            if (set2.contains(num))
                return false;
        }
        return true;
    }

    // ─────────────────────────────────────────────
    // Main — test all tasks
    // ─────────────────────────────────────────────
    public static void main(String[] args) {

        // Task 1 — reverse
        System.out.println("=== Task 1: reverse ===");
        System.out.println(reverse("hello"));   // olleh
        System.out.println(reverse("abcde"));   // edcba

        // Task 2 — isBalanced
        System.out.println("\n=== Task 2: isBalanced ===");
        System.out.println(isBalanced("({[]})"));   // true
        System.out.println(isBalanced("(((())))"));  // true
        System.out.println(isBalanced("{}[()]"));    // true
        System.out.println(isBalanced("{[}]"));      // false

        // Task 3 — interleaveQueue
        System.out.println("\n=== Task 3: interleaveQueue ===");
        Queue<Integer> q = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        interleaveQueue(q);
        System.out.println(q); // [1, 4, 2, 5, 3, 6]

        // Task 4 — areDisjointSets
        System.out.println("\n=== Task 4: areDisjointSets ===");
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6));
        Set<Integer> c = new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println(areDisjointSets(a, b)); // true
        System.out.println(areDisjointSets(a, c)); // false
    }
}
