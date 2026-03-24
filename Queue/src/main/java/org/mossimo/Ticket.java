package org.mossimo;

import java.util.Comparator;

public class Ticket {
    private String id;
    private String title;
    private String description;
    private int priority;

    private static int nextId = 1;

    public Ticket(String title, String description, int priority) {
        this.id = String.format("04%d", nextId++);
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "\n" + "Ticket{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                '}' + "\n";
    }

    public static class PriorityCopmarator implements Comparator<Ticket> {

        @Override
        public int compare(Ticket o1, Ticket o2) {
            return (o1.priority == o2.priority) ? o1.id.compareTo(o2.id) : o1.priority - o2.priority;
        }
    }
}
