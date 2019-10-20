package te.TicTacToe;

public class ComputerPlayer {

	private static String marker = " O ";

	public String getMarker() {
		return marker;
	}

	public static void computerTurn(Game ticTacToe) {
		boolean madeMove = false;
		CheckWin.checkWin(ticTacToe);
		if (ticTacToe.isVictory(marker)) {
			System.out.println("\nComputer Wins!");
			ticTacToe.printBoard();
			System.exit(0);
		}
		if (!madeMove) {
			madeMove = BlockOpponentWin.blockOpponentCanWin(ticTacToe);
			if (ticTacToe.isVictory(marker)) {
				System.out.println("\nComputer Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}
		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markCenter(ticTacToe);
			if (ticTacToe.isVictory(marker)) {
				System.out.println("\nComputer Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}
		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markOppositeCorner(ticTacToe);
			if (ticTacToe.isVictory(marker)) {
				System.out.println("\nComputer Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}
		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markEmptyCorner(ticTacToe);
			if (ticTacToe.isVictory(marker)) {
				System.out.println("\nComputer Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}
		}
		if (!madeMove) {
			madeMove = MarkEmptySquare.markEmptySide(ticTacToe);
			if (ticTacToe.isVictory(marker)) {
				System.out.println("\nComputer Wins!");
				ticTacToe.printBoard();
				System.exit(0);
			}
		}

	}

}
