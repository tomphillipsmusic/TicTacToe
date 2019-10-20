package te.TicTacToe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Create scanner and declare variables
		Scanner input = new Scanner(System.in);
		Game ticTacToe = new Game();
		String userInput;
		int xCoordinate, yCoordinate;
		String player = " X ";
		int turnCounter = 0;
		ComputerPlayer opponent = null;

		// Begin the game
		System.out.println("Welcome to TicTacToe!\n\nChoose your opponent:\n1) Human\n2) Computer");
		userInput = input.nextLine();
		boolean computerOpponent = false;
		if (userInput.equals("2")) {
			computerOpponent = true;
			opponent = new ComputerPlayer();
		}
		System.out.println("Let's play TicTacToe! Xs go first");
		ticTacToe.createBoard();
		ticTacToe.printBoard();

		// While there is no victory, take turns putting down marks
		while (turnCounter < 9) {
			System.out.println("\n\n" + player +"'s turn:");
			System.out.print("\n" + "Enter the X coordinate for where you would like to go: ");
			userInput = input.nextLine();
			xCoordinate = Integer.parseInt(userInput);
			System.out.print("Enter the Y coordinate for where you would like to go: ");
			userInput = input.nextLine();
			yCoordinate = Integer.parseInt(userInput);
			ticTacToe.placeMark(xCoordinate, yCoordinate, player);
			ticTacToe.printBoard();

			// Tests if game is over
			if (ticTacToe.isVictory(player)) {
				System.out.println("\n" + player + "Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}

			if (computerOpponent) {
				turnCounter++;
				System.out.println("\n\nComputer's turn: \n");
				String opponentMarker = opponent.getMarker();
				boolean madeMove = false;
				opponent.checkWin(ticTacToe);
				if (ticTacToe.isVictory(opponentMarker)) {
					System.out.println("\nComputer Wins!");
					ticTacToe.printBoard();
					System.exit(0);
				}
				if (!madeMove) {
					madeMove = opponent.blockOpponentCanWin(ticTacToe);
					if (ticTacToe.isVictory(opponentMarker)) {
						System.out.println("\nComputer Wins!");
						ticTacToe.printBoard();
						System.exit(0);
					}
				}
				if (!madeMove) {
					madeMove = opponent.markCenter(ticTacToe);
					if (ticTacToe.isVictory(opponentMarker)) {
						System.out.println("\nComputer Wins!");
						ticTacToe.printBoard();
						System.exit(0);
					}
				}
				if (!madeMove) {
					madeMove = opponent.markOppositeCorner(ticTacToe);
					if (ticTacToe.isVictory(opponentMarker)) {
						System.out.println("\nComputer Wins!");
						ticTacToe.printBoard();
						System.exit(0);
					}
				}
				if (!madeMove) {
					madeMove = opponent.markEmptyCorner(ticTacToe);
					if (ticTacToe.isVictory(opponentMarker)) {
						System.out.println("\nComputer Wins!");
						ticTacToe.printBoard();
						System.exit(0);
					}
				}
				if (!madeMove) {
					madeMove = opponent.markEmptySide(ticTacToe);
					if (ticTacToe.isVictory(opponentMarker)) {
						System.out.println("\nComputer Wins!");
						ticTacToe.printBoard();
						System.exit(0);
					}
				}
				ticTacToe.printBoard();
				turnCounter++;

			}

			// Alternates player between X and O and increases turn count
			else {
				player = ticTacToe.switchPlayer(player);
				turnCounter++;
			}
		}
		System.out.println("Draw!");
		input.close();
	}

}
