package te.TicTacToe;

public class ComputerPlayer {

	private static String marker = " O ";

	public String getMarker() {
		return marker;
	}

	public static void computerTurn(TicTacToe ticTacToe) {
		boolean madeMove = false;
		System.out.println("\n\nComputer's turn: \n");
		CheckWin.checkWin(ticTacToe);
		checkIfComputerWon(ticTacToe);
		madeMove = BlockOpponentWin.blockOpponentCanWin(ticTacToe);

		if (!madeMove) {
			madeMove = MarkEmptySquare.markCenter(ticTacToe);

		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markOppositeCorner(ticTacToe);

		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markEmptyCorner(ticTacToe);

		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markEmptySide(ticTacToe);

		}
		checkIfComputerWon(ticTacToe);
		ticTacToe.printBoard();

	}

	public static boolean checkIfComputerWon(TicTacToe ticTacToe) {
		if (ticTacToe.isVictory(marker)) {
			System.out.println("\nComputer Wins!");
			ticTacToe.printBoard();
			System.exit(0);
			return true;
		}
		return false;
	}
}
