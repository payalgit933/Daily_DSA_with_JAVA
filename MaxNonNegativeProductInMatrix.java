// You are given a m x n matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.
// Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (m - 1, n - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
// Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative, return -1.

// Notice that the modulo is performed after getting the maximum product.
// Example 1:
// Input: grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
// Output: -1
// Explanation: It is not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.

// Example 2:
// Input: grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
// Output: 8
// Explanation: Maximum non-negative product is shown (1 * 1 * -2 * -4 * 1 = 8).

class Solution {
    public int maxProductPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        long MOD = 1000000007;

        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        // Starting point
        max[0][0] = grid[0][0];
        min[0][0] = grid[0][0];

        // First column
        for (int i = 1; i < m; i++) {
            max[i][0] = max[i-1][0] * grid[i][0];
            min[i][0] = max[i][0];
        }

        // First row
        for (int j = 1; j < n; j++) {
            max[0][j] = max[0][j-1] * grid[0][j];
            min[0][j] = max[0][j];
        }

        // Fill remaining cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                long val = grid[i][j];

                long a = max[i-1][j] * val;
                long b = max[i][j-1] * val;
                long c = min[i-1][j] * val;
                long d = min[i][j-1] * val;

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long result = max[m-1][n-1];

        if (result < 0)
            return -1;

        return (int)(result % MOD);
    }
}
