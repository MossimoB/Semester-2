package flexiblestudentcomparator;

import java.util.Comparator;
import java.util.Random;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private double score;
    private int age;

    private static int counter = 1;

    public Student(String name, int age) {
        this.id = String.format("%04d", counter++);
        this.name = name;
        this.age = age;

        Random rand = new Random();
        this.score = 60 + rand.nextDouble() * 40; // 60-100
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + String.format("%.2f", score) + " | " + age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student s)) {
            return false;
        }
        return id.equals(s.id);
    }

    public enum SortType {
        SCORE, NAME, AGE, ID
    }

    public static class StudentComparator implements Comparator<Student> {
        private final SortType sortType;

        public StudentComparator(SortType sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Student s1, Student s2) {
            switch (sortType) {
                case SCORE:
                    int scoreCmp = Double.compare(s2.getScore(), s1.getScore()); // descending
                    if (scoreCmp != 0) {
                        return scoreCmp;
                    }
                    return Integer.compare(s1.getAge(), s2.getAge()); // age ascending

                case NAME:
                    int nameCmp = s1.getName().compareTo(s2.getName()); // ascending
                    if (nameCmp != 0) {
                        return nameCmp;
                    }
                    return s1.getId().compareTo(s2.getId()); // ID ascending

                case AGE:
                    int ageCmp = Integer.compare(s1.getAge(), s2.getAge()); // ascending
                    if (ageCmp != 0) {
                        return ageCmp;
                    }
                    return s1.getId().compareTo(s2.getId()); // ID ascending

                case ID:
                default:
                    int idCmp = s1.getId().compareTo(s2.getId()); // ascending
                    if (idCmp != 0) {
                        return idCmp;
                    }
                    return Integer.compare(s2.getAge(), s1.getAge()); // age descending
            }
        }
    }
}
