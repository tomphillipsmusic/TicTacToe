package te.TicTacToe;

public class BlockOpponentWin {
	
	private static String marker = " O ";
	
	public static boolean blockOpponentCanWin(Game gameBoard) {

		if (BlockOpponentWin.blockOpponentCanWinRowsCols(gameBoard)) {
			return true;
		}
		if (BlockOpponentWin.blockOpponentCanWinDiagonal(gameBoard)) {
			return true;
		}
		return false;

	}
	
	public static boolean blockOpponentCanWinRowsCols(Game gameBoard) {
		String[][] board = gameBoard.getBoard();
		String playerMarker = " X ";
		String empty = "   ";

		// Check rows
		for (int i = 0; i < gameBoard.getROWS(); i++) {

			if (board[i][0].equals(playerMarker) && board[i][1].equals(playerMarker) && board[i][2].equals(empty)) {
				gameBoard.placeMark(i, 2, marker);
				return true;
			} else if (board[i][0].equals(playerMarker) && board[i][1].equals(empty)
					&& board[i][2].equals(playerMarker)) {
				gameBoard.placeMark(i, 1, marker);
				return true;
			} else if (board[i][0].equals(empty) && board[i][1].equals(playerMarker)
					&& board[i][2].equals(playerMarker)) {
				gameBoard.placeMark(i, 0, marker);
				return true;
			}

			// Check COLs
			if (board[0][i].equals(playerMarker) && board[1][i].equals(playerMarker) && board[2][i].equals(empty)) {
				gameBoard.placeMark(2, i, marker);
				return true;
			} else if (board[0][i].equals(playerMarker) && board[1][i].equals(empty)
					&& board[2][i].equals(playerMarker)) {
				gameBoard.placeMark(1, i, marker);
				return true;
			} else if (board[0][i].equals(empty) && board[1][i].equals(playerMarker)
					&& board[2][i].equals(playerMarker)) {
				gameBoard.placeMark(0, i, marker);
				return true;
			}

		}
		return false;
	}
	
	public static boolean blockOpponentCanWinDiagonal(Game gameBoard) {
		String[][] board = gameBoard.getBoard();
		String playerMarker = " X ";
		String empty = "   ";
		// Check diagonals
				if (board[0][0].equals(playerMarker) && board[1][1].equals(playerMarker) && board[2][2].equals(empty)) {
					gameBoard.placeMark(2, 2, marker);
					return true;
				}

				if (board[0][0].equals(playerMarker) && board[1][1].equals(empty) && board[2][2].equals(playerMarker)) {
					gameBoard.placeMark(1, 1, marker);
					return true;
				}

				if (board[0][0].equals(empty) && board[1][1].equals(playerMarker) && board[2][2].equals(playerMarker)) {
					gameBoard.placeMark(0, 0, marker);
					return true;
				}

				if (board[0][2].equals(playerMarker) && board[1][1].equals(playerMarker) && board[2][0].equals(empty)) {
					gameBoard.placeMark(2, 0, marker);
					return true;
				}

				if (board[0][2].equals(playerMarker) && board[1][1].equals(empty) && board[2][0].equals(playerMarker)) {
					gameBoard.placeMark(1, 1, marker);
					return true;
				}

				if (board[0][2].equals(empty) && board[1][1].equals(playerMarker) && board[2][0].equals(playerMarker)) {
					gameBoard.placeMark(0, 2, marker);
					return true;
				}
		return false;
	}

}
