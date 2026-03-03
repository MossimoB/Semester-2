package org.mossimo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        School school = new School();
        school.addTeacher(new Teacher("Jane", 40, Teacher.Gender.FEMALE, 1, 20000));
        System.out.println(school.getTeachers());


    }
}
