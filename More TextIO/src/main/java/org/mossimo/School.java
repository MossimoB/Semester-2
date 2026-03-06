package org.mossimo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
    private List<User> users;
    private static final String USER_PATH = "src/main/resources/user.csv";

    public School() {
        loadUsers();
    }
    public void loadUsers() {
        File file = new File(USER_PATH);
        users = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] elements = line.split(",");

                String name = elements[0];
                int age = Integer.parseInt(elements[1]);

                User user = new User(name, age);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUser(User user) {
        users.add(user);

        File file = new File(USER_PATH);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            String name = user.getName();
            int age = user.getAge();
            fileWriter.write(String.format("%s, %d\n", name, age));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportUsers() {
        File file = new File(USER_PATH);

        try (FileWriter fileWriter = new FileWriter(file)) {
            for (User user : users) {
                String name = user.getName();
                int age = user.getAge();
                fileWriter.write(String.format("%s, %d\n", name, age));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
