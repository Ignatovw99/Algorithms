public class EightQueensPuzzle {

    private static char[][] chessboard = {
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' },
            { '-', '-', '-', '-', '-', '-', '-', '-' }
    };

    //It is better to solve this problem with recursion, because the iterative way will be vary difficult to be maintained
    private static void findQueenPositionOnRow(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < chessboard[row].length; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositionOnRow(row + 1);
                    removeQueen(row, col);  // <-- Backtracking
                }
            }
        }
    }

    private static void putQueen(int row, int col) {
        chessboard[row][col] = '*';
    }

    private static boolean isColumnFree(int col) {
        for (int row = 0; row < chessboard.length; row++) {
            if (chessboard[row][col] == '*') {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimaryDiagonalFree(int row, int col) {
        int startRow = row;
        int startCol = col;

        while (startRow >= 0 && startCol >= 0) {
            if (chessboard[startRow--][startCol--] == '*') {
                return false;
            }
        }
        while (row < chessboard.length && col < chessboard[row].length) {
            if (chessboard[row++][col++] == '*') {
                return false;
            }
        }
        return true;
    }

    private static boolean isSecondaryDiagonalFree(int row, int col) {
        int startRow = row;
        int startCol = col;

        while (startRow >= 0 && startCol < chessboard[startRow].length) {
            if (chessboard[startRow--][startCol++] == '*') {
                return false;
            }
        }
        while (row < chessboard.length && col >= 0) {
            if (chessboard[row++][col--] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void removeQueen(int row, int col) {
        chessboard[row][col] = '-';
    }

    private static boolean canPlaceQueen(int row, int col) {
        return isColumnFree(col)
                && isPrimaryDiagonalFree(row, col)
                && isSecondaryDiagonalFree(row, col);
    }

    private static void printSolution() {
        for (char[] row : chessboard) {
            for (char symbol : row) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printAllPossibleQueensPositions() {
        findQueenPositionOnRow(0);
    }
}
