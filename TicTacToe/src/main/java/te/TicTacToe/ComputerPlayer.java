package te.TicTacToe;

public class ComputerPlayer {

	private String marker = " O ";

	public String getMarker() {
		return marker;
	}

	public boolean checkWin(Game gameBoard) {
		if (CheckWin.checkWinRowsCols(gameBoard)) {
			return true;
		}

		if (CheckWin.checkWinDiagonal(gameBoard)) {
			return true;
		}

		return false;
	}

	public boolean blockOpponentCanWin(Game gameBoard) {

		if (BlockOpponentWin.blockOpponentCanWinRowsCols(gameBoard)) {
			return true;
		}
		if (BlockOpponentWin.blockOpponentCanWinDiagonal(gameBoard)) {
			return true;
		}
		return false;

	}

}
