package GravyT;

import java.util.Random;

public class Game {
    public void startGame() {
        Board gameBoard = new Board();
        Players playerHuman = new HumanPlayer();
        Players playerPC = new PCPlayer();
        Players currentPlayer;
        System.out.println("Welcome to the Gravytrips game created by ShennaR! :)");
        System.out.println("The rules of this game, also known ar 4-in-a-row.");
        System.out.println("Your goal is to collect 4 of your marks along ");
        System.out.println("any horizontal, vertical or diagonal line");
        System.out.println("on a game field, which consists of 6 rows and 7 columns.");
        System.out.println("Your move is to choose a column to place your mark,");
        System.out.println("which will be moved by gravity to the bottom of the column");
        System.out.println("which will be moved by gravity to the bottom of the column.");
        System.out.println("Good luck an have fun! :)");
        Random rand = new Random();
        int whoBegins = rand.nextInt(2);
        if (whoBegins == 0) {
            currentPlayer = playerPC;
        } else {
            currentPlayer = playerHuman;
        }
        System.out.println("The " + currentPlayer.getPlayerName() + " begins!");
        int currentMove;
        boolean hasWinner = false;
        do {
            boolean correctMove = false;
            gameBoard.showBoard();
            do {
                currentMove = currentPlayer.makeNextMove();
                if (!gameBoard.checkMove(currentMove)) {
                    if (currentPlayer.getMark() == Marks.X) {
                        System.out.println("The column " + currentMove + " is full.");
                        System.out.println("Choose another column.");
                    }
                } else {
                    correctMove = true;
                }
            } while (!correctMove);
            if (currentPlayer.getMark()==Marks.O) {
                System.out.println(currentPlayer.getPlayerName()+"'s move:");
            }
            gameBoard.setPlayerMark(currentPlayer.getMark());
            gameBoard.placeMark(currentMove);
            if (gameBoard.checkHorizontalLine() || gameBoard.checkVerticalLine() ||
                    gameBoard.checkDiagonalDownLine() || gameBoard.checkDiagonalUpLine()) {
                hasWinner = true;
            } else {
                if (currentPlayer.getMark() == Marks.X) {
                    currentPlayer = playerPC;
                } else {
                    currentPlayer = playerHuman;
                }
            }
        } while (!hasWinner);
        gameBoard.showBoard();
        System.out.println("The winner is - " + currentPlayer.getPlayerName() + "!");
        System.out.println("Congratulations to the Winner!!!");
        System.out.println("Good bye!");
    }
}
