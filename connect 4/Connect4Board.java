
public class Connect4Board {
    public final int ROWS = 6;
    public final int COLUMNS = 7;
    private final char[][] board = new char[ROWS][COLUMNS];
    public Connect4Board() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = ' ';
            }
        }
    }
    public void displayBoard() {
        System.out.println("-----------------------------");
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
            System.out.println("-----------------------------");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    public int[] updateBoard(int col, char symbol) {
        int rowIndex = 0;
        for (int i = ROWS-1; i >= 0; i--) {
            if (board[i][col-1] == ' ') {
                rowIndex = i;
                board[rowIndex][col-1] = symbol;
                break;
            }
        }
        return new int[]{rowIndex, col - 1};
    }
    public boolean checkWin(int startRow, int startCol) {
        int[][] directions = {
                {0, 1},
                {1, 0},
                {1, 1},
                {1, -1}
        };
        for (int[] pos : directions) {
            int count = 1;
            int row = startRow;
            int col = startCol;
            for (int i = 0; i < 2; i++) {
                row += pos[0];
                col += pos[1];
                while (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS && board[row][col] ==  board[startRow][startCol]){
                    count++;
                    row += pos[0];
                    col += pos[1];
                }
            }
            if (count >= 4) {
                System.out.println( board[startRow][startCol] + " wins!");
                return true;
            }
        }
        return false;
    }
}
