package te.TicTacToe;

public class CheckWin {
	private static String marker = " O ";
	private static String empty = "   ";

	public static boolean checkWin(TicTacToe ticTacToe) {
		String[][] board = ticTacToe.getBoard();
		if (CheckWin.checkWinRowsCols(ticTacToe, board)) {
			return true;
		}

		if (CheckWin.checkWinDiagonal(ticTacToe, board)) {
			return true;
		}

		return false;
	}

	public static boolean checkWinRowsCols(TicTacToe ticTacToe, String[][] board) {

		for (int i = 0; i < ticTacToe.getROWS(); i++) {

			// Check rows
			if (checkWinRows(ticTacToe, i, board)) {
				return true;
			}

			// Check COLs
			if (checkWinCols(ticTacToe, i, board)) {
				return true;
			}
		}
		return false;

	}

	public static boolean checkWinRows(TicTacToe ticTacToe, int i, String[][] board) {
		if (board[i][0].equals(marker) && board[i][1].equals(marker) && board[i][2].equals(empty)) {
			ticTacToe.placeMark(i, 2, marker);
			return true;
		} else if (board[i][0].equals(marker) && board[i][1].equals(empty) && board[i][2].equals(marker)) {
			ticTacToe.placeMark(i, 1, marker);
			return true;
		} else if (board[i][0].equals(empty) && board[i][1].equals(marker) && board[i][2].equals(marker)) {
			ticTacToe.placeMark(i, 0, marker);
			return true;
		}
		return false;
	}

	public static boolean checkWinCols(TicTacToe ticTacToe, int i, String[][] board) {
		if (board[0][i].equals(marker) && board[1][i].equals(marker) && board[2][i].equals(empty)) {
			ticTacToe.placeMark(2, i, marker);
			return true;
		} else if (board[0][i].equals(marker) && board[1][i].equals(empty) && board[2][i].equals(marker)) {
			ticTacToe.placeMark(1, i, marker);
			return true;
		} else if (board[0][i].equals(empty) && board[1][i].equals(marker) && board[2][i].equals(marker)) {
			ticTacToe.placeMark(0, i, marker);
			return true;
		}
		return false;
	}

	public static boolean checkWinDiagonal(TicTacToe ticTacToe, String[][] board) {

		if (board[0][0].equals(marker) && board[1][1].equals(marker) && board[2][2].equals(empty)) {
			ticTacToe.placeMark(2, 2, marker);
			return true;
		}

		if (board[0][0].equals(marker) && board[1][1].equals(empty) && board[2][2].equals(marker)) {
			ticTacToe.placeMark(1, 1, marker);
			return true;
		}

		if (board[0][0].equals(empty) && board[1][1].equals(marker) && board[2][2].equals(marker)) {
			ticTacToe.placeMark(0, 0, marker);
			return true;
		}

		if (board[0][2].equals(marker) && board[1][1].equals(marker) && board[2][0].equals(empty)) {
			ticTacToe.placeMark(2, 0, marker);
			return true;
		}

		if (board[0][2].equals(marker) && board[1][1].equals(empty) && board[2][0].equals(marker)) {
			ticTacToe.placeMark(1, 1, marker);
			return true;
		}

		if (board[0][2].equals(empty) && board[1][1].equals(marker) && board[2][0].equals(marker)) {
			ticTacToe.placeMark(0, 2, marker);
			return true;
		}
		return false;
	}
}
