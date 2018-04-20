package gravyt;

import java.util.Scanner;

public class HumanPlayer implements Player {
    private int myMove;
    private Mark mark;
    private String playerName;

    @Override
    public int makeNextMove() {
        boolean correctInput = false;
        do {
            Scanner inputScanner = new Scanner(System.in);
            try {
                System.out.println("Make your move - input number from 1 to 7.");
                System.out.print("Your choice: ");
                String userInput = inputScanner.nextLine();
                myMove = Integer.parseInt(userInput);
                if ((myMove < 1) | (myMove > 7)) {
                    System.out.println("Please enter correct number.");
                } else {
                    correctInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        } while (!correctInput);
        return myMove-1;
    }

    @Override
    public Mark setMark(int playerNumber) {
        if (playerNumber==1)return mark=Mark.X;
        else return mark=Mark.O;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public Mark getMark(){
        return mark;
    }

    @Override
    public void setPlayerName(String name){
        playerName = name;
    }
}
