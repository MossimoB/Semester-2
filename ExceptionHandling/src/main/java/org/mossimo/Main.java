package org.mossimo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        |-NullPointerException
        |-InputMismatchException
        |-ArithmeticException
        |-IndexOutOfBoundException
         |- StringIndexOutOfBoundException
         |- ArrayIndexOutOfBoundException

        |- StackOverFlowError
         */
        try {
            m1();
            m2();
        } catch (ArithmeticException | InputMismatchException e) {

        }
    }

    public static void m() {
        int num1 = 10;
        int num2 = 0;
        int result;
        // handle exception
//        System.out.println(10 / 0);
        try {
            num2 = new Scanner(System.in).nextInt();
            if (num2 % 3 == 0) {
                throw new InvalidNumberException(String.format("%d is not valid", num2));
            }
            result = num1 / num2;
        } catch (InputMismatchException | ArithmeticException e) {        // can only handle one kind of exception
//            result = 0;     // give a default value to the result
            System.out.printf("Exception in thread \"main\" %s: %s\n", e.getClass(), e.getMessage());
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.printf("\tat %s\n", stackTraceElement);
            }
        }

//        System.out.println(result);
        System.out.println("the end of code");


    }

    public static void m1() throws ArithmeticException, InputMismatchException {
        int num1 = 50;
        int num2 = new Scanner(System.in).nextInt();
        System.out.println(num1 / num2);
    }

    public static void m2() throws ArithmeticException, InputMismatchException {
        int num1 = 100;
        int num2 = new Scanner(System.in).nextInt();
        System.out.println(num1 / num2);
    }
}