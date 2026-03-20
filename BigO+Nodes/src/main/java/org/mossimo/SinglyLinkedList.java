package org.mossimo;

/*
    Generic
    T: Type
    E: Element
    K: Key
    V: Value
 */

public class SinglyLinkedList<E> {
    // The <E> makes this class generic — meaning it can hold any type
    // (ex: SinglyLinkedList<Integer>, SinglyLinkedList<String>)
    private int size;
    private Node head;

    public void add(E value) {
        /*
             Adds a new element to the end of the list. If the list is empty, the new
             node becomes the head. Otherwise, a temporary pointer starting at the head
             traverses the list until it reaches the last node, where the new node is
             then appended.
         */
        Node node = new Node(value);

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 1; i++) {
                temp = temp.next;
            }

            temp.next = node;
        }

        // VISUAL WALKTHROUGH
        //
        // Say the list is `[A] → [B] → [C]` and you call `add("D")`:
        //
        // Before:
        // head → [A] → [B] → [C] → null
        //
        // temp starts at [A]
        // i=0 → temp moves to [B]
        // i=1 → temp moves to [C]   ← last node
        //
        // temp.next = new node [D]
        //
        // After:
        // head → [A] → [B] → [C] → [D] → null
    }

//----------------------------------------------------------------------------------------------------------------------

    public class Node {
        private E value;
        private Node next;
        // Each node holds two things:
        //
        // value — the actual data stored (of type E)
        // next — a pointer to the next node in the list (or null if it's the last one)
        //
        // This is what makes it a linked list — nodes chain together via these next references


        // VISUAL STRUCTURE
        //
        // Once complete, the list would look like this in memory:
        //
        // head
        // ↓
        // [A | next] → [B | next] → [C | null]
        // Each box is a Node, with value on the left and next pointer on the right.

        public Node(E value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        } else {
            String str = "[";

            Node temp = head;
            for (int i = 0; i < size - 1; i++) {
                str += temp.value + ((i == size - 1) ? "]" : ", ");
                temp = temp.next;
            }

            return str;
        }
    }
}
