package te.TicTacToe;

import java.util.Scanner;

public class Game {

	private final int ROWS = 3;
	private final int COLS = 3;
	private String board[][] = new String[ROWS][COLS];
	private String empty = "   ";

	public String[][] getBoard() {
		return board;
	}

	public int getROWS() {
		return ROWS;
	}

	public int getCOLS() {
		return COLS;
	}

	public void createBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				board[i][j] = empty;
			}
		}
	}

	public void printBoard() {
		System.out.println("");
		for (int i = 0; i < ROWS; i++) {

			System.out.println(board[i][0] + "|" + board[i][1] + "|" + board[i][2]);
			if (i != 2)
				System.out.println("-----------");
		}
	}

	public void placeMark(Integer x, Integer y, String player) {
		if (board[x][y].equals(empty))
			board[x][y] = player;
	}

	public boolean isVictory(String player) {

		if (isVictoryRows(player) || isVictoryCols(player) || isVictoryDiagonal(player)) {
			return true;
		}
		return false;

	}

	public boolean isVictoryRows(String player) {
		for (int i = 0; i < ROWS; i++) {
			if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
				return true;
			}
		}
		return false;
	}

	public boolean isVictoryCols(String player) {
		for (int i = 0; i < COLS; i++) {
			if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
				return true;
			}
		}
		return false;
	}

	public boolean isVictoryDiagonal(String player) {
		if ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))
				|| (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player))) {
			return true;
		}
		return false;

	}

	public String switchPlayer(String player) {
		if (player.equals(" X ")) {
			return " O ";
		} else {
			return " X ";

		}
	}
}
