package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // array is fixed
        // list is dynamic

        //init
        String str = "hello";
        double[] nums1 = {5, 6, 7}; // array with specific values
        double[] nums2 = new double[5];
        List<Double> nums3 = new ArrayList<>(); // inheritance

        //get element
        char c = str.charAt(0);
        double num1 = nums1[0];
        double num3 = nums3.get(0);

        // reset element
        // string cannot be changed
        nums1[0] = 9;
        nums3.set(0, 9.0);

        // the amount of elements
        int lenStr = str.length();
        int arratLen = nums1.length;
        int listLen = nums3.size();

        
    }
}