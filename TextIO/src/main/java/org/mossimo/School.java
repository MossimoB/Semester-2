package org.mossimo;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class School {
    private List<Teacher> teachers;

    public School() {
        loadTeacherData();
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void loadTeacherData() {
        // path to the file
        String relativePath = "src/main/resources/data";
        // make a new file
        File file = new File(relativePath);

        teachers = new ArrayList<>();

        // try with resources
        try (Scanner sc = new Scanner(file)) {
            // read and process the data
            //            String name = sc.next(); // will read a single word
            //            sc.nextLine(); // cancels the line breaker of the next() above
            //            String line = sc.nextLine();
            //            int num1 = sc.nextInt();
            //            double num2 = sc.nextDouble();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] elements = line.split(","); // separates values at the comma

                String name = elements[0]; // yi
                int age = Integer.parseInt(elements[1]); // 40

                Teacher.Gender gender = elements[2].equals("male") ? Teacher.Gender.MALE : Teacher.Gender.FEMALE; // male

                int experience = elements[3].isEmpty() ? 0 : Integer.parseInt(elements[3]); // if empty default is 0, else = 10 (from file)
                double salary = Double.parseDouble(elements[4]); // 100000

                Teacher teacher = new Teacher(name, age, gender, experience, salary);
                teachers.add(teacher);
                System.out.println(teacher);
            }
        } catch (FileNotFoundException e) {
            // ignore
        }
    }
}
