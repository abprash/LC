package group.LC2;

public class TicTacToe {

	char[][] board;

	/** Initialize your data structure here. */
	public TicTacToe(int n) {
		board = new char[n][n];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++)
				board[i][j] = '-';
		}
	}

	public void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		char symbol = 'X';
		if (player == 2)
			symbol = 'O';
		// mark it
		board[row][col] = symbol;
		// printBoard();
		// check for winners now
		boolean res1 = checkRow(row, symbol);
		if (res1)
			return player;
		boolean res2 = checkColumn(col, symbol);
		if (res2)
			return player;
		// check the diagonals and the anti diag
		// and this should be checked only if the row and col values are equal
		if (row == col || row + col == board.length - 1) {
			boolean res3 = checkDiag(symbol);
			boolean res4 = checkAntiDiag(symbol);
			if (res3 || res4)
				return player;
		}

		return 0;
	}

	public boolean checkColumn(int col, char symbol) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] != symbol)
				return false;
		}
		return true;
	}

	public boolean checkRow(int row, char symbol) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] != symbol)
				return false;
		}
		return true;
	}

	public boolean checkDiag(char symbol) {
		//

		if (symbol == '-')
			return false;
		boolean isExit = false;
		int j = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][j] != symbol)
				return false;
			j++;
		}
		return true;
	}

	public boolean checkAntiDiag(char symbol) {
		// char symbol = board[0][board.length-1];

		int j = this.board.length - 1;
		for (int i = 0; i < this.board.length; i++) {

			if (this.board[i][j] != symbol)
				return false;
			j--;
		}
		return true;
	}
}

/**
 * Your TicTacToe object will be instantiated and called as such: 
 * TicTacToe obj = new TicTacToe(n); 
 * int param_1 = obj.move(row,col,player);
 */
