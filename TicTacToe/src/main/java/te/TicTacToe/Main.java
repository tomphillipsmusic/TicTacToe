package te.TicTacToe;

import java.util.Scanner;

public class Main {

	private static Scanner input = new Scanner(System.in);
	private static String userInput;
	private static String player = " X ";
	private static boolean computerOpponent;

	public static void main(String[] args) {

		Game ticTacToe = new Game();
		beginGame(ticTacToe);
		int turnCounter = 0;
		int maxNumberOfTurns = 9;

		// While there is no victory, take turns putting down marks
		while (turnCounter < maxNumberOfTurns) {
			playerTurn(ticTacToe);
			turnCounter++;

			// Alternates player between X and O and increases turn count
			if (!computerOpponent) {
				player = ticTacToe.switchPlayer(player);
				turnCounter++;
			}

			// Alternates between player and computer if computer opponent selected
			else {
				turnCounter++;
				ComputerPlayer.computerTurn(ticTacToe);
				turnCounter++;

			}
		}
		System.out.println("Draw!");
		input.close();
	}

	public static void beginGame(Game ticTacToe) {
		System.out.println("Welcome to TicTacToe!\n\nChoose your opponent:\n1) Human\n2) Computer");
		userInput = input.nextLine();
		if (userInput.equals("2")) {
			computerOpponent = true;
		}
		System.out.println("Let's play TicTacToe! Xs go first");
		ticTacToe.createBoard();
		ticTacToe.printBoard();
	}

	public static void playerTurn(Game ticTacToe) {
		System.out.println("\n\n" + player + "'s turn:");
		boolean canPlaceMark = false;
		enterCoordinates(ticTacToe);
		ticTacToe.printBoard();

		// Tests if game is over
		if (ticTacToe.isVictory(player)) {
			gameOver(player, ticTacToe);
		}

	}

	public static void gameOver(String player, Game ticTacToe) {
		System.out.println("\n" + player + "Wins!");
		ticTacToe.printBoard();
		System.exit(0);
	}
	public static boolean canPlaceMark(Game ticTacToe, int xCoordinate, int yCoordinate) {
		String empty = "   ";
		if (ticTacToe.getBoard()[xCoordinate][yCoordinate].equals(empty)) {
			return true;
		}
		System.out.println("You must select an empty square\n");
		ticTacToe.printBoard();
		return false;
	}

	public static boolean enterCoordinates(Game ticTacToe) {
		int xCoordinate = 0, yCoordinate = 0;
		boolean validCoordinates = false;
		while (!validCoordinates) {
			try {
				System.out.print("\n" + "Enter the X coordinate for where you would like to go: ");
				userInput = input.nextLine();
				xCoordinate = Integer.parseInt(userInput);
				System.out.print("Enter the Y coordinate for where you would like to go: ");
				userInput = input.nextLine();
				yCoordinate = Integer.parseInt(userInput);
				ticTacToe.placeMark(xCoordinate, yCoordinate, player);
				validCoordinates = true;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You must select coordinates between 0 and 2");
			}
			catch (NumberFormatException e) {
				System.out.println("You must enter coordinates");
			}
			
		}
		return true;

	}
}
