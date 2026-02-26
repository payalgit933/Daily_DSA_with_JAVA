/*
 Problem: Check if Array is Sorted
 
 Problem Statement:
 Given an array, check whether it is sorted in ascending order.

*/

public class CheckSortedArray {

    public static boolean isSorted(int[] nums) {

        // Traverse array
        for (int i = 0; i < nums.length - 1; i++) {

            // If current element greater than next
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5};

        boolean result = isSorted(nums);

        System.out.println("Is array sorted? " + result);
    }
}
