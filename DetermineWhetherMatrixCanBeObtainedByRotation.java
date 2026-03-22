// LEET CODE PROBLEM
// Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

// Example 1:
// Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
// Output: true
  
// Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
  
  class Solution {
    public boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Function to rotate matrix 90 degrees clockwise
    public void rotate(int[][] mat) {
        int n = mat.length;

        int[][] temp = new int[n][n];

        // Rotate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = mat[i][j];
            }
        }

        // Copy back to original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[i][j];
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {

        // Try 4 rotations
        for (int k = 0; k < 4; k++) {

            if (isEqual(mat, target)) {
                return true;
            }

            rotate(mat); // rotate 90 degree
        }

        return false;
    }
}
