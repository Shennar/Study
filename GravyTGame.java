package gravyt;

import java.util.Scanner;

public class GravyTGame {
    public static void main(String[] args) {
        Game newGame = new Game();
        newGame.showRules();
        Scanner inputScanner = new Scanner(System.in);
        boolean gameTypeChosen = false;
        do {
            try {
                System.out.println("Please choose game type:");
                System.out.println("1: Human VS PC");
                System.out.println("2: Human VS Human");
                System.out.println("3: PC VS PC");
                System.out.print("Enter your choice:");
                String inputChoice = inputScanner.nextLine();
                int choice = Integer.parseInt(inputChoice);
                switch (choice) {
                    case 1: {
                        newGame.player1 = new HumanPlayer();
                        newGame.player1.setPlayerName("Human player");
                        newGame.player2 = new PCPlayer();
                        newGame.player2.setPlayerName("PC player");
                        gameTypeChosen = true;
                        break;
                    }
                    case 2: {
                        newGame.player1 = new HumanPlayer();
                        newGame.player1.setPlayerName("1st Human player");
                        newGame.player2 = new HumanPlayer();
                        newGame.player2.setPlayerName("2nd Human player");
                        gameTypeChosen = true;
                        break;
                    }
                    case 3: {
                        newGame.player1 = new PCPlayer();
                        newGame.player1.setPlayerName("1st PC player");
                        newGame.player2 = new PCPlayer();
                        newGame.player2.setPlayerName("2nd PC player");
                        gameTypeChosen = true;
                        break;
                    }
                    default: {
                        System.out.println("Invalid choice. Try again.");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        } while (!gameTypeChosen);
        // Add players type choice
        // Add "Who 1st"
        // Add player1 and player2 creation and mark assignment
        newGame.startGame();
        inputScanner.close();
    }
}
