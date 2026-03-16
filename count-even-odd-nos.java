/*

 Problem Statement:
 Count the number of even and odd numbers in an array.

*/

public class EvenOddCount {
    public static void main(String[] args) {
        int[] arr = {12, 7, 9, 14, 20, 33};
        int even = 0, odd = 0;

        for (int num : arr) {
            if (num % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Number of even elements: " + even);
        System.out.println("Number of odd elements: " + odd);
    }
}
