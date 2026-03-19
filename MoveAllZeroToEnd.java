// Problem Statement

// Given an array, move all 0s to the end while maintaining the order of non-zero elements.

package expLab;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        moveZerosToEnd(arr);

        System.out.print("Updated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void moveZerosToEnd(int[] arr) {
        int index = 0; // position for non-zero elements

        // Step 1: Move non-zero elements forward
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Step 2: Fill remaining positions with 0
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
}
