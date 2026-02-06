package org.mossimo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        List<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 3, 1, 2, 4));
//        System.out.println(nums1);
//        Collections.sort(nums1);
//        System.out.println(nums1);
//        Collections.reverse(nums1);
//        System.out.println(nums1);
//
//        List<String> strings1 = new ArrayList<>(Arrays.asList("how", "hi", "bye"));
//        Collections.sort(strings1);
//        System.out.println(strings1);


        User user1 = new PermanentTeacher("Yi", 40);
        User user2 = new ContractedTeacher("Mike", 50);
        User user3 = new RegularStudent("John", 16);
        User user4 = new CountedStudent("Bill", 17);
        User user5 = new CountedStudent("Bill", 10);
        User user6 = new CountedStudent("Bill", 11);

        // not a class now, it's an interface
        List<User> users = new ArrayList<>();
        List<Park> usersCanPark = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        // giving user the option to choose which way to sort
        System.out.println("Choose the sorting strategy: ");
        System.out.println("1. Sort by age");
        System.out.println("2. Sort by name");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        // their possible choices
        Comparator comparator = switch (choice) {
            case 1 -> new User.UserAgeComparator();
            case 2 -> new User.UserNameComparator();
            default -> null;
        };

        // you have to be able to compare in order to be able to sort
        Collections.sort(users, comparator);
        System.out.println(users);

        // whoever can park will be added to the list (code above)
        for (User user : users) {
            if (user instanceof Park) {
                ((Park) user).register();
                // by writing ((Park) user1)
                // this is called dumb-casting
                usersCanPark.add((Park) user);
            }
        }

        System.out.println(usersCanPark);
    }
}
