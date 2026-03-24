package org.mossimo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Queue<Integer> queue1 = new Queue<Integer>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean offer(Integer integer) {
                return false;
            }

            @Override
            public Integer remove() {
                return 0;
            }

            @Override
            public Integer poll() {
                return 0;
            }

            @Override
            public Integer element() {
                return 0;
            }

            @Override
            public Integer peek() {
                return 0;
            }
        };
         */

        //--------------------------------------------------------------------------------------------------------------

        List<Integer> list = new ArrayList<>();        // upper casting

        // interface = class
        Queue<Integer> nums2 = new LinkedList<>();

        // class = class
        Queue<Integer> queue = new LinkedList<>();      // interface

        // add(); can only add at the tail
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Queue\n" + queue);

        // remove(); can only remove at the head
        queue.remove();     // throws exception if queue is empty
        queue.poll();       // safer (no exception)

        // peek(); retrieves the element at the head
        queue.peek();

        // general methods
        queue.size();       // checks the size of the queue
        queue.isEmpty();    // checks if the queue is empty
        queue.clear();      // removes all the elements of the collection


        //--------------------------------------------------------------------------------------------------------------

        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        pqueue.add(1);
        pqueue.add(2);
        pqueue.add(3);
        pqueue.add(1);
        pqueue.add(2);
        pqueue.add(3);

        System.out.println("\nPriorityQueue\n" + pqueue);

        pqueue.remove();
        pqueue.remove();
        pqueue.poll();
        pqueue.peek();
        pqueue.size();
        pqueue.isEmpty();

        //--------------------------------------------------------------------------------------------------------------

        TicketSystem ticketSystem = new TicketSystem();
        ticketSystem.addTicket(new Ticket("Mouse broken", "my mouse does not work", 3));
        ticketSystem.addTicket(new Ticket("Keyboard broken", "my keyboard does not work", 1));
        ticketSystem.addTicket(new Ticket("Smoke comes out", "noooo my pcccccccc", 0));

        System.out.println("\nTicketSystem" + ticketSystem.getTickets());

        //--------------------------------------------------------------------------------------------------------------

        int size = ticketSystem.getTickets().size();
        for (int i = 0; i < size; i++) {
            System.out.println(ticketSystem.getTickets().poll());
        }
    }
}