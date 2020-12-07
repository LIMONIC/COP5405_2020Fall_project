import java.util.Arrays;

public class Task2 {
    public static int maximalSquBottomUp(int[][] matrix, int h) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[] dp = new int [col + 1];
        int x1 = 0, y1 = 0, x2, y2;
        int result = 0;

        for (int i = row - 1; i >= 0; i--) {
            int prev = 0;
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] < h) {
                    prev = dp[j];
                    dp[j] = 0;
                    continue;
                }
                int current = dp[j];
                //dp[j] = Integer.MAX_VALUE;
                dp[j] = Math.min(prev, Math.min(current, dp[j + 1]));
                dp[j] ++;
                prev = current;
                if (result < dp[j]) {
                    result = dp[j];
                    x1 = i;
                    y1 = j;
                }
            }
        }
        x2 = x1 + result - 1;
        y2 = y1 + result - 1;
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
            res = maximalSquBottomUp(matrix, 2);
//            int res2 = Task1.maximalSquare(matrix, 2);
            System.out.println("res = [" + res + "]");
//            if (res == res2) {
//                System.out.println("MATCH!!");
//            } else {
//                System.out.println("WRONG!");
//            }
        }
    }


}
