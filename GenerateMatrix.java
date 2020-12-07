import java.util.Arrays;

public class GenerateMatrix {
    public static int[][] GenerateMatrix(int row, int col) {
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        return matrix;
    }

    public static void main(String[] args) {

        // print
        for (int[] m : GenerateMatrix(5,5)) {
            System.out.println(Arrays.toString(m));
        }
    }
}
