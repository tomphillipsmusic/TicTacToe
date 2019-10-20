package te.TicTacToe;

import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);
	private static String userInput;
	private static String player = " X ";

	public static void main(String[] args) {

		Game ticTacToe = new Game();
		// Begin the game
		System.out.println("Welcome to TicTacToe!\n\nChoose your opponent:\n1) Human\n2) Computer");
		userInput = input.nextLine();
		boolean computerOpponent = false;
		if (userInput.equals("2")) {
			computerOpponent = true;
		}
		System.out.println("Let's play TicTacToe! Xs go first");
		ticTacToe.createBoard();
		ticTacToe.printBoard();
		int xCoordinate, yCoordinate;
		int turnCounter = 0;

		// While there is no victory, take turns putting down marks
		while (turnCounter < 9) {
			playerTurn(ticTacToe);

			// Alternates player between X and O and increases turn count
			if (!computerOpponent) {
				player = ticTacToe.switchPlayer(player);
				turnCounter++;
			}

			// Alternates between player and computer if computer opponent selected
			else {
				turnCounter++;
				System.out.println("\n\nComputer's turn: \n");
				CheckWin.checkWin(ticTacToe);
				ComputerPlayer.computerTurn(ticTacToe);
				ticTacToe.printBoard();
				turnCounter++;

			}
		}
		System.out.println("Draw!");
		input.close();
	}

	public static void playerTurn(Game ticTacToe) {
		System.out.println("\n\n" + player + "'s turn:");
		System.out.print("\n" + "Enter the X coordinate for where you would like to go: ");
		userInput = input.nextLine();
		int xCoordinate = Integer.parseInt(userInput);
		System.out.print("Enter the Y coordinate for where you would like to go: ");
		userInput = input.nextLine();
		int yCoordinate = Integer.parseInt(userInput);
		ticTacToe.placeMark(xCoordinate, yCoordinate, player);
		ticTacToe.printBoard();

		// Tests if game is over
		if (ticTacToe.isVictory(player)) {
			System.out.println("\n" + player + "Wins!");
			ticTacToe.printBoard();
			System.exit(0);
		}

	}

}
