package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // array is fixed
        // list is dynamic

        // init
        String str = "hello";
        double[] nums1 = {5, 6, 7};                                          // array with specific values
        double[] nums2 = new double[5];
        List<Double> nums3 = new ArrayList<>();                              // inheritance

        // get element
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

        // add/remove an element (list)
        nums3.add(9.0);                                                    // append at the end
        nums3.add(0, 9.0);                                   // add at the beginning
        nums3.remove(0);                                            // removes based on the index
        nums3.remove(9.0);                                            // removes based on the value

        // loops
        for (char chara : str.toCharArray()) {
            System.out.println(chara);
        }

        for (double num : nums1) {                                       // array
            System.out.println(num);
        }

        for (double num : nums3) {                                       // list
            System.out.println(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i]++;
        }

        // write a for loop to go through each element in a list and add 1 to them
        for (int i = 0; i < nums1.length; i++) {
            nums3.set(i, nums3.get(i) + 1);
        // this loop goes through each index in the list nums3, gets its current value, then adds 1
        }

        // compare (same or not)
        boolean strEqual = str.equals(str);                             // string
        boolean arrayEqual = Arrays.equals(nums1, nums2);               // array
        boolean listEquals = nums3.equals(nums3);                       // list

        // check if empty
        boolean strEmpty = str.isEmpty();                              // string
        boolean arrayEmpty = nums1.length == 0;                        // array
        boolean listEmpty = nums3.isEmpty();                           // list
    }
}