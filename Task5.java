import java.util.Arrays;
import java.util.Stack;

public class Task5 {
    public static int maximalRec(int[][] matrix, int h) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int result = 0;
        int[] dp = new int[col + 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] >= h) {
                    dp[j] ++;
                } else {
                    dp[j] = 0;
                }
            }
            result = Math.max(result, largestRecArea(dp));
        }
        return result;
    }

    private static int largestRecArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[i] > height[stack.peek()]) {
                stack.push(i);
            } else {
                int tmp = stack.pop();
                if (stack.empty()) {
                    sum = Math.max(sum, height[tmp] * i);
                } else {
                    sum = Math.max(sum, height[tmp] * (i - stack.peek() - 1));
                }
                i--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int row, col;
        int res;

        for (int i = 0; i < 10; i++) {
            row = (int) (Math.random() * 10) + 1;
            col = (int) (Math.random() * 10) + 1;
            System.out.println("row=" + row + " col=" + col);
            int[][] matrix ;
            matrix = GenerateMatrix.GenerateMatrix(row, col);

            for (int[] m : matrix) {
                System.out.println(Arrays.toString(m));
            }
            res = maximalRec(matrix, 2);
            System.out.println("res = [" + res + "]");
            int res2 = Task3.maximalRec(matrix, 2);

            if (res == res2) {
                System.out.println("MATCH!!");
            } else {
                System.out.println("WRONG!");
            }

        }
    }

}
