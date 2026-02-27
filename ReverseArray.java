/*
 Problem: Reverse an Array

 Problem Statement:
 Reverse the given array in-place without using extra space.

*/

import java.util.Arrays;

public class ReverseArray {

    public static void reverse(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        // Swap until pointers meet
        while (start < end) {

            // swap
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        reverse(nums);

        System.out.println("Reversed Array: " + Arrays.toString(nums));
    }
}
