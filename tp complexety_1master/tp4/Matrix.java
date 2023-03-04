package tp5;

class Matrix {

    // Function to print Matrix
    static void printMatrix(int M[][],
                            int rowSize,
                            int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(M[i][j] + " ");

            System.out.println();
        }
    }

    // Function to add the two matrices
    // and store in matrix C
    static int[][] add(int A[][], int B[][],
                       int size) {
        int i, j;
        int C[][] = new int[size][size];

        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
                C[i][j] = A[i][j] + B[i][j];

        return C;
    }

    // Function to multiply
    // two matrices A[][] and B[][]
    static int[][] multiplyMatrix(
            int row1, int col1, int A[][],
            int row2, int col2, int B[][]) {
        int i, j, k;

        // Print the matrices A and B
        System.out.println("\nMatrix A:");
        printMatrix(A, row1, col1);
        System.out.println("\nMatrix B:");
        printMatrix(B, row2, col2);

        // Check if multiplication is Possible
        if (row2 != col1) {

            System.out.println(
                    "\nMultiplication Not Possible");
            return null;
        }

        // Matrix to store the result
        // The product matrix will
        // be of size row1 x col2
        int C[][] = new int[row1][col2];

        // Multiply the two matrices
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        return C;
    }

    // Driver code
    public static void main(String[] args) {
        int size = 4;

        int A[][] = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};
        // Print the matrices A
        System.out.println("\nMatrix A:");
        printMatrix(A, size, size);

        int B[][] = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}};
        // Print the matrices B
        System.out.println("\nMatrix B:");
        printMatrix(B, size, size);

        // Add the two matrices
        int C[][] = add(A, B, size);

        // Print the result
        System.out.println("\nResultant Matrix:");
        printMatrix(C, size, size);

        int row1 = 4, col1 = 3, row2 = 3, col2 = 4;

        int A2[][] = {{1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}};

        int B2[][] = {{1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3}};

        int[][] C2 = multiplyMatrix(row1, col1, A2,
                row2, col2, B2);
        // Print the result
        System.out.println("\nResultant Matrix:");
        printMatrix(C2, row1, col2);
    }
}
