package GravyT;

import static GravyT.Marks.EMPTY;

public class Board {
    private Marks[][] board = new Marks[6][7];
    private Marks playerMark;

    public Board() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < 6; i++) {
            System.out.print("| ");
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("+---------------+");
        System.out.println("| 1 2 3 4 5 6 7 |");
    }

    boolean checkMove(int move) {
        if (board[0][move] == EMPTY) {
            return true;
        } else return false;
    }

    public void placeMark(int place) {
        int rowToPlace = 0;
        for (int i = 0; i < 6; i++) {
            if (board[i][place] == EMPTY) {
                rowToPlace++;
            } else break;
        }
        board[rowToPlace - 1][place] = playerMark;
    }

    public boolean checkHorizontalLine() {
        boolean gotLine = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if ((board[i][j] == playerMark) & (board[i][j + 1] == playerMark) &
                        (board[i][j + 2] == playerMark) & (board[i][j + 3] == playerMark)) {
                    gotLine = true;
                }
                if (gotLine) break;
            }
            if (gotLine) break;
        }
        return gotLine;
    }

    public boolean checkVerticalLine() {
        boolean gotLine = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                if ((board[i][j] == playerMark) & (board[i + 1][j] == playerMark) &
                        (board[i + 2][j] == playerMark) & (board[i + 3][j] == playerMark)) {
                    gotLine = true;
                }
                if (gotLine) break;
            }
            if (gotLine) break;
        }
        return gotLine;
    }

    public boolean checkDiagonalUpLine() {
        boolean gotLine = false;
        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if ((board[i][j] == playerMark) & (board[i - 1][j + 1] == playerMark) &
                        (board[i - 2][j + 2] == playerMark) & (board[i - 3][j + 3] == playerMark)) {
                    gotLine = true;
                }
                if (gotLine) break;
            }
            if (gotLine) break;
        }
        return gotLine;
    }

    public boolean checkDiagonalDownLine() {
        boolean gotLine = false;
        for (int i = 5; i > 2; i--) {
            for (int j = 6; j > 2; j--) {
                if ((board[i][j] == playerMark) & (board[i - 1][j - 1] == playerMark) &
                        (board[i - 2][j - 2] == playerMark) & (board[i - 3][j - 3] == playerMark)) {
                    gotLine = true;
                }
                if (gotLine) break;
            }
            if (gotLine) break;
        }
        return gotLine;
    }

    public Marks setPlayerMark(Marks mark) {
        return playerMark = mark;
    }
}
