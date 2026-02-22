/*
 Problem: Find Maximum Element in an Array
 Topic: Arrays
 Problem Statement:
 Given an array of integers, return the maximum element.
*/

public class FindMaximum {
    public static int findMax(int[] nums) {
        // Assume first element is maximum
        int max = nums[0];
        // Traverse array
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {
                max = nums[i]; // update max
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {3, 7, 2, 9, 5};
        int result = findMax(nums);
        System.out.println("Maximum Element: " + result);
    }
}
