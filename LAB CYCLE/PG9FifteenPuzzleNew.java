import java.util.Scanner;
import java.util.Random;

class PG9FifteenPuzzleNew {
    int SIZE = 4;
    int[][] board;
    int emptyRow;
    int emptyCol;

    public PG9FifteenPuzzleNew() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        shuffleBoard();
    }

    // Initialize solved board
    public void initializeBoard() {
        int num = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1) {
                    board[i][j] = 0;
                    emptyRow = i;
                    emptyCol = j;
                } else {
                    board[i][j] = num++;
                }
            }
        }
    }

    // Shuffle board using valid moves
    public void shuffleBoard() {
        Random rand = new Random();
        int[] moves = { -1, 1 };

        for (int i = 0; i < 100; i++) {
            int newRow = emptyRow + moves[rand.nextInt(2)];
            int newCol = emptyCol + moves[rand.nextInt(2)];

            if (newRow >= 0 && newRow < SIZE &&
                newCol >= 0 && newCol < SIZE) {

                board[emptyRow][emptyCol] = board[newRow][newCol];
                board[newRow][newCol] = 0;
                emptyRow = newRow;
                emptyCol = newCol;
            }
        }
    }

    // Display board
    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0)
                    System.out.print("_ ");
                else
                    System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Move tile
    public boolean moveTile(int tile) {
        int tileRow = -1, tileCol = -1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == tile) {
                    tileRow = i;
                    tileCol = j;
                }
            }
        }

        if ((Math.abs(tileRow - emptyRow) == 1 && tileCol == emptyCol) ||
            (Math.abs(tileCol - emptyCol) == 1 && tileRow == emptyRow)) {

            board[emptyRow][emptyCol] = tile;
            board[tileRow][tileCol] = 0;
            emptyRow = tileRow;
            emptyCol = tileCol;
            return true;
        }
        return false;
    }

    // Check if puzzle is solved
    public boolean isSolved() {
        int num = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == SIZE - 1 && j == SIZE - 1)
                    return board[i][j] == 0;
                if (board[i][j] != num++)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PG9FifteenPuzzleNew puzzle = new PG9FifteenPuzzleNew();
        Scanner sc = new Scanner(System.in);

        while (true) {
            puzzle.displayBoard();

            if (puzzle.isSolved()) {
                System.out.println("Congratulations! Puzzle Solved");
                break;
            }

            System.out.print("Enter tile number to move (or 0 to exit): ");
            int tile = sc.nextInt();

            if (tile == 0)
                break;

            if (!puzzle.moveTile(tile))
                System.out.println("Invalid move. Try again.");
        }
        sc.close();
    }
}
