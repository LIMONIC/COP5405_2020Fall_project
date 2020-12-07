/*Design a Theta(mn) time Dynamic Programming algorithm for computing a largest area
square block with all cells have the height permit value at least h.*/

import java.util.Arrays;

public class Task1 {
    public static int maximalSquare(int[][] matrix, int h) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int x1, y1, x2 = 0, y2 = 0;
        int result = 0;
        int dp[][] = new int[row + 1][col + 1];
        // dp[][] = min(dp[i - 1][j - 1], dp[i][j -  1], dp[i - 1][j]) + 1
        // Starting from index (0,0), for every 1 found in the original matrix, we update the value of the current element
        for (int i = 1; i <= row; i ++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] >= h) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j -  1], dp[i - 1][j])) + 1;
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                        x2 = i - 1;
                        y2 = j - 1;
                    }
                }
            }
        }
        x1 = x2 - result + 1;
        y1 = y2 - result + 1;
        System.out.printf("%d %d %d %d\n", x1, y1, x2, y2);
        return result * result;
    }

    public static void main(String[] args) {
        int row, col;
        int res;

        for (int i = 0; i < 10; i++) {
            row = (int) (Math.random() * 10) + 1;
            col = (int) (Math.random() * 10) + 1;
            System.out.println("row=" + row + " col=" + col);
            int[][] matrix = new int[row][col];
            matrix = GenerateMatrix.GenerateMatrix(row, col);

            for (int[] m : matrix) {
                System.out.println(Arrays.toString(m));
            }
            res = maximalSquare(matrix, 2);
            System.out.println("res = [" + res + "]");

        }
    }
}
