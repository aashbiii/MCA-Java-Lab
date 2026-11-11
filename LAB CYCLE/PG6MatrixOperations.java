import java.util.Scanner;

public class PG6MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input dimensions for first matrix
        System.out.print("Enter rows of first matrix: ");
        int r1 = sc.nextInt();
        System.out.print("Enter columns of first matrix: ");
        int c1 = sc.nextInt();
        
        // Input dimensions for second matrix
        System.out.print("Enter rows of second matrix: ");
        int r2 = sc.nextInt();
        System.out.print("Enter columns of second matrix: ");
        int c2 = sc.nextInt();
        
        // Declare matrices
        int[][] matrix1 = new int[r1][c1];
        int[][] matrix2 = new int[r2][c2];
        
        // Input elements of first matrix
        System.out.println("\nEnter elements of first matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }
        
        // Input elements of second matrix
        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }
        
        // Display first matrix
        System.out.println("\nFirst Matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print(matrix1[i][j] + " ");
            }
            System.out.println();
        }
        
        // Display second matrix
        System.out.println("\nSecond Matrix:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }
        
        // Matrix Addition
        // Check if addition is possible (dimensions must be same)
        if (r1 == r2 && c1 == c2) {
            int[][] sum = new int[r1][c1];
            
            // Add corresponding elements
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    sum[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            
            // Display sum matrix
            System.out.println("\nSum of matrices:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c1; j++) {
                    System.out.print(sum[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nMatrix addition not possible! Dimensions must be same.");
        }
        
        // Matrix Multiplication
        // Check if multiplication is possible (columns of first = rows of second)
        if (c1 == r2) {
            int[][] product = new int[r1][c2];
            
            // Multiply matrices
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    product[i][j] = 0;
                    // Calculate dot product of row i and column j
                    for (int k = 0; k < c1; k++) {
                        product[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            
            // Display product matrix
            System.out.println("\nProduct of matrices:");
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    System.out.print(product[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nMatrix multiplication not possible!");
            System.out.println("Columns of first matrix must equal rows of second matrix.");
        }
        
        sc.close();
    }
}