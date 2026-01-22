package sudoky;

import java.util.Scanner;

public class sudokavmn {

    public static void main(String[] args) {

        int[][] board = {
                {5, 0, 9, 0, 0, 0, 4, 0, 0},
                {7, 0, 8, 3, 0, 4, 9, 0, 0},
                {6, 0, 1, 0, 0, 0, 7, 3, 0},
                {4, 6, 2, 5, 0, 0, 0, 0, 0},
                {3, 8, 5, 7, 2, 0, 6, 4, 0},
                {1, 0, 7, 4, 0, 8, 2, 0, 0},
                {2, 0, 0, 1, 0, 0, 0, 0, 4},
                {0, 0, 3, 0, 4, 0, 0, 8, 7},
                {0, 7, 0, 0, 5, 3, 0, 0, 6}
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            sudoku(board);

            System.out.println("введіть строку (0–8) или -1 для виходу:");
            int row = scanner.nextInt();
            if (row == -1) break;

            System.out.println("введіть стовпець (0–8):");
            int col = scanner.nextInt();

            System.out.println("введіть число (1–9):");
            int num = scanner.nextInt();

            makeMove(board, row, col, num);
        }

        System.out.println("гра завершена");
        scanner.close();
    }

    // вывод судоку
    static void sudoku(int[][] board) {
        System.out.println("- - - - - - - - - - - - ");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
                if ((j + 1) % 3 == 0) System.out.print("| ");
            }
            System.out.println();
            if ((i + 1) % 3 == 0)
                System.out.println("- - - - - - - - - - - - ");
        }
    }

    static boolean checkRow(int[][] board, int row, int num) {
        for (int col = 0; col < 9; col++)
            if (board[row][col] == num) return false;
        return true;
    }

    static boolean checkColumn(int[][] board, int col, int num) {
        for (int row = 0; row < 9; row++)
            if (board[row][col] == num) return false;
        return true;
    }

    static boolean checkBox(int[][] board, int row, int col, int num) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[startRow + i][startCol + j] == num) return false;

        return true;
    }

    static boolean isValidMove(int[][] board, int row, int col, int num) {
        return checkRow(board, row, num)
                && checkColumn(board, col, num)
                && checkBox(board, row, col, num);
    }

    static void makeMove(int[][] board, int row, int col, int num) {
        if (board[row][col] != 0) {
            System.out.println("клітинка вже заповнена!");
            return;
        }

        if (isValidMove(board, row, col, num)) {
            board[row][col] = num;
            System.out.println("дія виповнена");
        } else {
            System.out.println("невірна дія!");
        }
    }
}
