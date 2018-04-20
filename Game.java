package gravyt;

import java.util.Random;

public class Game {
    private Board gameBoard = new Board();
    Player player1;
    Player player2;
    Player currentPlayer;

    public void showRules() {
        System.out.println("Welcome to the Gravytrips game created by ShennaR! :)");
        System.out.println("The rules of this game, also known ar 4-in-a-row.");
        System.out.println("Your goal is to collect 4 of your marks along ");
        System.out.println("any horizontal, vertical or diagonal line");
        System.out.println("on a game field, which consists of 6 rows and 7 columns.");
        System.out.println("Your move is to choose a column to place your mark,");
        System.out.println("which will be moved by gravity to the bottom of the column.");
        System.out.println("Mark for 1st player is X, for 2nd - O.");
        System.out.println("Good luck an have fun! :)");
    }

    public boolean checkLines(Mark currentMark) {
        if (gameBoard.checkHorizontalLine(currentMark) ||
                gameBoard.checkVerticalLine(currentMark) ||
                gameBoard.checkDiagonalDownLine(currentMark) ||
                gameBoard.checkDiagonalUpLine(currentMark)) {
            return true;
        } else {
            return false;
        }
    }

    public void startGame() {
//        Player player1 = new PCPlayer();//HumanPlayer();
//        Player player2 = new PCPlayer();
//        Player currentPlayer;
        Random rand = new Random();
        int whoBegins = rand.nextInt(2);
        if (whoBegins == 0) {
            player1.setMark(1);
            player2.setMark(2);
            currentPlayer = player1;
            System.out.println("The 1st move is for "+currentPlayer.getPlayerName()+"!");
        } else {
            player2.setMark(1);
            player1.setMark(2);
            currentPlayer = player2;
            System.out.println("The 1st move is for "+currentPlayer.getPlayerName()+"!");
        }
        System.out.println("The " + currentPlayer.getPlayerName() + " begins!");
        int currentMove;
        boolean hasWinner = false;
        do {
            boolean correctMove = false;
            gameBoard.showBoard();
            do {
                System.out.println("Current move is for "+currentPlayer.getPlayerName()+".");
                currentMove = currentPlayer.makeNextMove();
                if (!gameBoard.checkMove(currentMove)) {
                    if (currentPlayer.getPlayerName().equals("Human player")|
                            currentPlayer.getPlayerName().equals("1st Human player")|
                            currentPlayer.getPlayerName().equals("2nd Human player")) {
                        System.out.println("The column " + currentMove + " is full.");
                        System.out.println("Choose another column.");
                    }
                } else {
                    correctMove = true;
                }
            } while (!correctMove);
            //           if (currentPlayer.getMark() == Mark.O) {
//          System.out.println(currentPlayer.getPlayerName() + "'s move:");
//        }
            gameBoard.placeMark(currentPlayer.getMark(), currentMove);
            hasWinner = checkLines(currentPlayer.getMark());
            if (!hasWinner) { // LAZHA! podumatj, kak sdelatj cmenu igrokom pri nefiksirovannoj metke
                if (currentPlayer.getMark() == Mark.X) {
                    if (player1.getMark()==Mark.X){
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                } else {
                    if (player1.getMark()==Mark.O){
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }
                }
                if (!hasWinner && gameBoard.isBoardFull()) {
                    break;
                }
            }
        } while (!hasWinner);
        gameBoard.showBoard();
        if (hasWinner)

        {
            System.out.println("The winner is - " + currentPlayer.getPlayerName() + "!");
            System.out.println("Congratulations to the Winner!!!");
            System.out.println("Good bye!");
        } else

        {
            System.out.println("Game board is full. No winner.");
        }
    }
}
