// Problem Statement

// You are given an array of size n-1 containing numbers from 1 to n with one number missing. Find the missing number.

package expLab;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};

        int missing = findMissing(arr);

        System.out.println("Missing Number = " + missing);
    }

    public static int findMissing(int[] arr) {
        int n = arr.length + 1;

        // Sum of first n natural numbers
        int totalSum = n * (n + 1) / 2;

        // Sum of elements in array
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        return totalSum - arraySum;
    }
}
