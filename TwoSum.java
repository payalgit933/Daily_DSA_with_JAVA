//Day 1: Solve Two Sum using HashMap (Arrays)
//Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to the target.
// Example 
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

// Explanation:
// nums[0] + nums[1] = 2 + 7 = 9

import java.util.Arrays;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Check all pairs
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
