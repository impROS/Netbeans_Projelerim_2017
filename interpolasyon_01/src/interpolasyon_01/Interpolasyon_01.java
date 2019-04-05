/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpolasyon_01;

/**
 *
 * @author impROS
 */
public class Interpolasyon_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 4;
        double[][] A = {
            {1,3.2,10.24,32.768},
            {1,2.7,7.29,19.683},
            {1,1,1,1},
            {1,4.8,23.04,110.592}
        };
        double[] b = {22.0, 17.8, 14.2,38.3};
        double[] x = lsolve(A, b);

        // print results
        double araDeger=3.0;
        double sonuc =0;
        for (int i = 0; i < n; i++) {
            
            sonuc +=Math.pow(araDeger, i)*x[i];
            System.out.println(x[i]);
        }
        System.out.println(araDeger+" : "+sonuc);
    }
    private static final double EPSILON = 1e-10;

    // Gaussian elimination with partial pivoting
    public static double[] lsolve(double[][] A, double[] b) {
        int n = b.length;

        for (int p = 0; p < n; p++) {

            // find pivot row and swap
            int max = p;
            for (int i = p + 1; i < n; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p];
            A[p] = A[max];
            A[max] = temp;
            double t = b[p];
            b[p] = b[max];
            b[max] = t;

            // singular or nearly singular
            if (Math.abs(A[p][p]) <= EPSILON) {
                throw new ArithmeticException("Matrix is singular or nearly singular");
            }

            // pivot within A and b
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
}
