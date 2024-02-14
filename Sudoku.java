public class Sudoku {

    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {

        // down check(coloumn)
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }

        // horizontal (row)
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        // grid(3*3)
        int nrow = (row / 3) * 3;
        int ncol = (col / 3) * 3;

        for (int i = nrow; i < nrow + 3; i++) {
            for (int j = ncol; j < ncol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokusolver(int sudoku[][], int row, int col) {
        // base
        if (row == 9) {
            return true;
        }

        // recursion
        int nextrow = row, nextcol = col + 1;
        if (col + 1 == 9) {
            nextrow = row + 1;
            nextcol = 0;
        }

        if (sudoku[row][col] != 0) {
            return sudokusolver(sudoku, nextrow, nextcol);

        }
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokusolver(sudoku, nextrow, nextcol)) {// sol exist
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;

    }

    public static void print(int sudoku[][]) {
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = { 
                { 7, 0, 0, 0, 0, 0, 2, 0, 0 },
                { 4, 0, 2, 0, 0, 0, 0, 0, 3 },
                { 0, 0, 0, 2, 0, 1, 0, 0, 0 },
                { 3, 0, 0, 1, 8, 0, 0, 9, 7 },
                { 0, 0, 9, 0, 7, 0, 6, 0, 0 },
                { 6, 5, 0, 0, 3, 2, 0, 0, 1 },
                { 0, 0, 0, 4, 0, 9, 0, 0, 0 },
                { 5, 0, 0, 0, 0, 0, 1, 0, 6 },
                { 0, 0, 6, 0, 0, 0, 0, 0, 8 }
        };

        if (sudokusolver(sudoku, 0, 0)) {
            System.out.println("Solution Exist");
            print(sudoku);
        } else {
            System.out.println("Solution doesnt exist !!!!");
        }
    }
}
