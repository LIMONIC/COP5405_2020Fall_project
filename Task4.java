import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Task4 {
    public static int maximalRec(int[][] matrix, int h) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int result = 0;
        int x1, y1, x2 = 0, y2 = 0;
        int[][] dp = new int[row][col + 1];
        // calculate how many continued buildings are allowed below the first row
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && matrix[i][j] >= h) {
                    dp[i][j] = 1;
                    continue;
                }
                if (matrix[i][j] >= h) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            int largestRecArea = largestRecArea(dp[i])[0];
            if (largestRecArea > result) {
                x2 = Math.max(x2, i);
                result = largestRecArea;
            }
        }
        int tmp[] = largestRecArea(dp[x2]);
        y2 = tmp[1];
        y1 = y2 - tmp[2] + 1;
        x1 = x2 - (result / (tmp[2] ))+1 ;

        System.out.printf("%d %d %d %d\n", x1, y1, x2, y2);
        return result;
    }

    private static int[] largestRecArea(int[] height) {
        // 上大下小单调栈
        Stack<Integer> stack = new Stack<>();
        int sum = 0, lowerRight = 0;
        int width = 0;
        int res[] = new int[3];

        for (int i = 0; i < height.length; i++) {
            if (stack.empty() || height[i] > height[stack.peek()]) {
                stack.push(i);
            } else {
                int tmp = stack.pop();
                if (stack.empty()) {
                    if (sum < height[tmp] * i) {
                        sum = height[tmp] * i;
                        lowerRight = Math.max(lowerRight, i - 1);
                        width = i;
                    }
                } else {
                    int area = height[tmp] * (i - stack.peek() - 1);
                    if (sum < area) {
                        sum = area;
                        lowerRight = Math.max(lowerRight,i - 1);
                        width =(i - stack.peek() - 1);
                    }
                }
                i--;
            }
        }
        res[0] = sum;
        res[1] = lowerRight ;
        res[2] = width;
        return res;
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
//        int[][] matrix = {{1, 8, 2, 0, 7, 8},{1, 8, 9, 8, 5, 9}, {4, 5, 5, 5, 7, 5},{7, 3, 5, 8, 5, 9},{9, 5, 6, 6, 0, 3},{0, 8, 0, 1, 1, 1},{7, 1, 1, 2, 6, 3},{1, 5, 0, 2, 9, 7}};
//        res = maximalRec(matrix, 2);
//        System.out.println("res = [" + res + "]");
//        for (int[] m : matrix){
//            System.out.println(Arrays.toString(m));
//        }
//        int res2 = Task3.maximalRec(matrix, 2);
    }

}
