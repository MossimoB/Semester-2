package org.mossimo;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Comparator;

@AllArgsConstructor
@ToString
// Comparable<User> means only comparable to user
public abstract class User implements Comparable<User> {
    protected String name;
    protected int age;

    @Override
    public int compareTo(User o) {
        // compares a name to a name (String to String)
        // +
        // compares an age to an age (int to int)
        // by adding 1000 *, name is worth more than age
        // meaning it'll make more of a difference than when comparing / sorting
//        return 1000 * name.compareTo(o.name) + age - o.age;

        int nameDifference = name.compareTo(o.name);

        return nameDifference == 0 ?
                age - o.age : nameDifference;

//        if (name.compareTo(o.name) == 0) {
//            return age - o.age;
//        } else {
//            return  name.compareTo(o.name);
//        }
    }

    public static class UserAgeComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.age - o2.age;
        }
    }

    public static class UserNameComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {

            return o1.name.compareTo(o2.name);
        }
    }
}
