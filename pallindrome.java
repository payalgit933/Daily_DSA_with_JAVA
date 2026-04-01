package leetcode;

/*
 * Problem: Check whether a number is a Palindrome
 * A palindrome number reads the same forward and backward.
 * Example:
 * 121 -> Palindrome
 * 123 -> Not Palindrome
 */

public class leet2 {

    // Method to check if number is palindrome
    public boolean palindrome(int num) {

        // Negative numbers are not palindrome
        if (num < 0) {
            return false;
        }

        int original = num;
        int reverse = 0;

        // Reverse the number
        while (num > 0) {
            int digit = num % 10;        // Get last digit
            reverse = reverse * 10 + digit; // Add digit to reverse
            num = num / 10;              // Remove last digit
        }

        // Compare original and reversed number
        return original == reverse;
    }

    // Main method to run program
    public static void main(String[] args) {

        leet2 obj = new leet2();

        // Test numbers
        int number1 = 121;
        int number2 = 123;

        // Check first number
        if (obj.palindrome(number1)) {
            System.out.println(number1 + " is a Palindrome");
        } else {
            System.out.println(number1 + " is NOT a Palindrome");
        }

        // Check second number
        if (obj.palindrome(number2)) {
            System.out.println(number2 + " is a Palindrome");
        } else {
            System.out.println(number2 + " is NOT a Palindrome");
        }
    }
}
