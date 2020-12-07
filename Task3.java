/*Brute Force */
/*O(N^3M^3)*/

import java.util.Arrays;

public class Task3 {
    public static int maximalRec(int[][] matrix, int h) {
        if (matrix.length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int x1, y1, x2, y2;
        int xx1 = 0, yy1 = 0, xx2 = 0, yy2 = 0;
        int result = 0;
        //  iterating over all possible combinations of coordinates (x1, y1) and (x2, y2) and letting them define a rectangle with the coordinates being opposite corners.
        for (int i = 0; i < row; i++) {
            x1 = i;
            for (int j = i; j < row; j++) {
                x2 = j;
                for (int k = 0; k < col; k++) {
                    y1 = k;
                    for (int l = k; l < col; l++) {
                        y2 = l;
//                        System.out.println(x1+" "+y1+" "+x2+" "+y2);
//                        System.out.println(((x2 - x1 + 1) * (y2 - y1 + 1)));
                        if (isValid(x1,y1,x2,y2,matrix,h)) {
                            int area = ((x2 - x1 + 1) * (y2 - y1 + 1));
                            if (result < area) {
                                result = area;
                                xx1 = x1;
                                yy1 = y1;
                                xx2 = x2;
                                yy2 = y2;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        System.out.printf("%d %d %d %d\n", xx1, yy1, xx2, yy2);
        return result;
    }

    private static boolean isValid (int x1,int y1, int x2, int y2, int[][] matrix, int h) {
        for (int m = x1; m <= x2; m++) {
            for (int n = y1; n <= y2; n++) {
                if (matrix[m][n] < h) {

                    return false;
                }
            }
        }
        return true;
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
            for (int[] m : matrix) {
                System.out.println(Arrays.toString(m));
            }
        }
    }


}
