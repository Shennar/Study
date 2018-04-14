package GravyT;

import java.util.Scanner;

public class HumanPlayer implements Players {
    private int myMove;
    private String playerName = "Human player";
    private Marks mark = Marks.X;

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
    public Marks getMark() {
        return mark;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

}
