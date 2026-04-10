package org.mossimo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
         * BINARY SEARCH TREE (BST)
         * ─────────────────────────────────────────────────────────────────
         * A node-based data structure where each node has at most 2 children.
         * Every node obeys one rule: all values in its LEFT subtree are
         * SMALLER, and all values in its RIGHT subtree are LARGER.
         * This makes searching, inserting, and deleting very efficient.
         *
         * Complexity: O(log n) average | O(n) worst case (unbalanced tree)
         * ─────────────────────────────────────────────────────────────────
         *
         *   STRUCTURE:
         *
         *              [ 50 ]           <-- root (top of the tree)
         *             /       \
         *          [ 30 ]   [ 70 ]      <-- internal nodes
         *          /    \   /    \
         *       [ 20 ][ 40 ][ 60 ][ 80 ]  <-- leaves (no children)
         *
         *   RULE (holds at EVERY node, not just the root):
         *       left child < parent < right child
         *
         * ─────────────────────────────────────────────────────────────────
         *
         *   SEARCHING for 60:
         *       start at root [50] → 60 > 50, go RIGHT
         *       at node  [70] → 60 < 70, go LEFT
         *       at node  [60] → found! ✓
         *       (eliminated half the tree at each step)
         *
         *   INSERTING 35:
         *       start at root [50] → 35 < 50, go LEFT
         *       at node  [30] → 35 > 30, go RIGHT
         *       right child is NULL → insert [35] here ✓
         *
         *   DELETING a node has 3 cases:
         *       1. No children  → just remove it
         *       2. One child    → replace node with its child
         *       3. Two children → replace with in-order successor
         *                         (smallest value in right subtree)
         *
         * ─────────────────────────────────────────────────────────────────
         *
         *   IN-ORDER TRAVERSAL (left → root → right) gives sorted output:
         *       20, 30, 40, 50, 60, 70, 80
         *
         */

        System.out.println("Practice BST");

        System.out.println("-------------------------------");
        System.out.println("\nGiven Tree:");
        System.out.println("\n        20\n" +
                "      /    \\\n" +
                "    10      40\n" +
                "     \\      /\n" +
                "     15    30\n" +
                "    / \\   /\n" +
                "   14 16 25");
        System.out.println("\nPre: 20 10 15 14 16 40 30 25");
        System.out.println("In: 10 14 15 16 20 25 30 40");
        System.out.println("Post: 14 16 15 10 25 30 40 20");

//-----------------------------------------------------------------------------------------------------------------
        // Generics and Wildcard
        /*
        T: type
        E: element      SinglyLinkedList<E>
        K: key          Map<K,V>
        V: value
         */

        FootballPlayer footballPlayer = new FootballPlayer("Michael");
        BasketballPlayer basketballPlayer = new BasketballPlayer("Jaquavious");

        Team<FootballPlayer> footballTeam = new Team<>();
        Team<BasketballPlayer> basketballTeam = new Team<>();
        footballTeam.add(footballPlayer);         // will only take a football player
        basketballTeam.add(basketballPlayer);       // will only take a basketball player
    }

    // Method-level Generics
    public static <T extends Comparable<T>> T min(T value1, T value2) {
        return (value1.compareTo(value2) < 0) ? value1 : value2;
    }

    //Wildcard
    public static void m(List<? extends Player> players) {

    }

    public static <T> void add(List<T> list, T... value) {
        // what is  ...
        //
        // ... (varargs) allows a method to accept multiple values of same type
        // Treated as an array inside the method
        // Must be the last parameter in the method
        // Example: void fun(int... nums)
    }

    /*
    LAB05

    1. Widlcard: write a method to calculate the average of a list of Numbers
    2. Generics:
            - Create a Cat class
            - Create a Dog class
            - Create a Pet class (filed String name)
            - Create a Box class with generics that can hold either a box of cats or a box of dogs
                    - include an add() method to add a cat/dog to a cat/dog box
     */
}
