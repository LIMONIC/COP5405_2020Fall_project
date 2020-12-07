import java.util.Arrays;

public class Compare {
    public static void main(String[] args) {
        int row, col;
        int res , res2;
        double[] duration1 = new double[5];
        double[] duration2 = new double[5];




        for (int i = 1; i < 4; i++) {
            row = (int)Math.pow((double)10,(double)i);
            col = (int)Math.pow((double)10,(double)i);
            System.out.println("row=" + row + " col=" + col);
            int[][] matrix;
            matrix = GenerateMatrix.GenerateMatrix(row, col);

//            for (int[] m : matrix) {
//                System.out.println(Arrays.toString(m));
//            }
            double start1 = System.nanoTime();
            res = Task3.maximalRec(matrix,1);
            double end1 = System.nanoTime();
            duration1[i] = end1 - start1;
            double start2 = System.nanoTime();
            res2 = Task4.maximalRec(matrix, 1);
            double end2 = System.nanoTime();
            duration2[i] = end2 - start2;
        }
        System.out.println("----------");
        System.out.printf("Task1: \tTask2: \t\n");
        for (int i = 1; i < 4; i++){
            System.out.printf("%f \t %f \t\n", duration1[i],duration2[i]);
        }
    }


}
