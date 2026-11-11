import java.util.Scanner;
class PG9FifteenPuzzle {
    int SIZE = 4;
    int[][] board;
    int emptyRow;
    int emptyCol;

    public PG9FifteenPuzzle() {
        board = new int[SIZE][SIZE];
        initializeBoard();
    }
    public void initializeBoard() {
        int num = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    board[i][j] = 0; // Empty space
                    emptyRow = i;
                    emptyCol = j;
                } else {
                    board[i][j] = num++;
                }
            }
        }
    }
    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print("_ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean moveTile(int tile) {
        int tileRow = -1;
        int tileCol = -1;

        // Find the position of the tile
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == tile) {
                    tileRow = i;
                    tileCol = j;
                }
            }
        }

        // Check if the tile is adjacent to the empty space
        if ((Math.abs(tileRow - emptyRow) == 1 && tileCol == emptyCol) ||
            (Math.abs(tileCol - emptyCol) == 1 && tileRow == emptyRow)) {
            // Swap the tile with the empty space
            board[emptyRow][emptyCol] = tile;
            board[tileRow][tileCol] = 0;
            emptyRow = tileRow;
            emptyCol = tileCol;
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        PG9FifteenPuzzle puzzle = new PG9FifteenPuzzle();
        Scanner sc = new Scanner(System.in);
        while (true) {
            puzzle.displayBoard();
            System.out.print("Enter tile number to move (or 0 to exit): ");
            int tile = sc.nextInt();
            if (tile == 0) {
                break;
            }
            if (!puzzle.moveTile(tile)) {
                System.out.println("Invalid move. Try again.");
            }
        }
        sc.close();
    }
}