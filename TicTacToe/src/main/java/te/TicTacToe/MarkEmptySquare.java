package te.TicTacToe;

public class MarkEmptySquare {

	private static String marker = " O ";

	public static boolean markEmptySquare(Game gameBoard) {
		if (markCenter(gameBoard)) {
			return true;
		}
		if (markOppositeCorner(gameBoard)) {
			return true;
		}
		if (markEmptyCorner(gameBoard)) {
			return true;
		}
		if (markEmptySide(gameBoard)) {
			return true;
		}
		return false;
	}

	public static boolean markCenter(Game gameBoard) {
		if (gameBoard.getBoard()[1][1].equals("   ")) {
			gameBoard.placeMark(1, 1, marker);
			return true;
		}
		return false;
	}

	public static boolean markOppositeCorner(Game gameBoard) {
		String[][] board = gameBoard.getBoard();
		String playerMarker = " X ";

		if (board[0][0].equals(playerMarker) && board[2][2].equals("   ")) {
			gameBoard.placeMark(2, 2, marker);
			return true;
		}
		if (board[0][2].equals(playerMarker) && board[2][0].equals("   ")) {
			gameBoard.placeMark(2, 0, marker);
			return true;
		}

		if (board[2][0].equals(playerMarker) && board[0][2].equals("   ")) {
			gameBoard.placeMark(0, 2, marker);
			return true;
		}
		if (board[2][2].equals(playerMarker) && board[0][0].equals("   ")) {
			gameBoard.placeMark(0, 0, marker);
			return true;
		}
		return false;
	}

	public static boolean markEmptyCorner(Game gameBoard) {
		String board[][] = gameBoard.getBoard();

		if (board[2][2].equals("   ")) {
			gameBoard.placeMark(2, 2, marker);
			return true;
		}
		if (board[2][0].equals("   ")) {
			gameBoard.placeMark(2, 0, marker);
			return true;
		}

		if (board[0][2].equals("   ")) {
			gameBoard.placeMark(0, 2, marker);
			return true;
		}
		if (board[0][0].equals("   ")) {
			gameBoard.placeMark(0, 0, marker);
			return true;
		}
		return false;
	}

	public static boolean markEmptySide(Game gameBoard) {
		String board[][] = gameBoard.getBoard();

		if (board[0][1].equals("   ")) {
			gameBoard.placeMark(0, 1, marker);
			return true;
		}
		if (board[1][0].equals("   ")) {
			gameBoard.placeMark(1, 0, marker);
			return true;
		}

		if (board[1][2].equals("   ")) {
			gameBoard.placeMark(1, 2, marker);
			return true;
		}
		if (board[2][1].equals("   ")) {
			gameBoard.placeMark(2, 1, marker);
			return true;
		}

		return false;
	}

}
