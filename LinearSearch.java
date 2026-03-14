/*
 Problem: Linear Search

 Problem Statement:
  Java program to search an element in an array using Linear Search.

*/

import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n, i, key;
        int[] arr = new int[100];

        // Input number of elements
        System.out.print("Enter number of elements: ");
        n = sc.nextInt();

        // Input array elements
        System.out.println("Enter elements:");
        for(i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input element to search
        System.out.print("Enter element to search: ");
        key = sc.nextInt();

        // Linear Search
        for(i = 0; i < n; i++) {
            if(arr[i] == key) {
                System.out.println("Element found at position: " + (i + 1));
                return;
            }
        }

        // If element not found
        System.out.println("Element not found");

        sc.close();
    }
}
