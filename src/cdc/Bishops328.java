package cdc;

public class Bishops328 {
	boolean[][] board;
	int size, numOfSafeBishops = 0;
	int max = -1;

	void findMaxSafeBishops() throws Exception {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// String input;
		// while ((input = br.readLine()) != null) {
		// int n = Integer.parseInt(input);
		int n = 5;
		this.size = n;
		board = new boolean[n][n];
		backtrack(0, 0);
		System.out.println(max);
		max = -1;
		// }
	}

	void backtrack(int i, int j) {
		//System.out.println("at " + i + "," + j);
		if (i == size - 1 && j == size - 1) {
			if (isSafe(i, j)) {
				board[i][j] = true;
				numOfSafeBishops++;
			}
			if (numOfSafeBishops > max)
				max = numOfSafeBishops;
			printBoard();
		} else if (isSafe(i, j)) {
			numOfSafeBishops++;
			board[i][j] = true;
			int nextI = getNextI(i, j), nextJ = getNextJ(i, j);
			while (nextI < size && nextJ < size) {
				backtrack(nextI, nextJ);
				nextI = getNextI(nextI, nextJ);
				nextJ = getNextJ(nextI, nextJ);
			}
			board[i][j] = false;
			numOfSafeBishops--;
		}
	}

	private void printBoard() {
		System.out.println("\nBoard is====\n");
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(board[i][j]) System.out.print("b"+" ");
				else System.out.print("-"+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private boolean isSafe(int i, int j) {
		for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--)
			if (board[k][l])
				return false;
		for (int k = i - 1, l = j + 1; k >= 0 && l < size; k--, l++)
			if (board[k][l])
				return false;
		return true;
	}

	int getNextI(int i, int j) {
		if (j == size - 1)
			return i + 1;
		return i;
	}

	int getNextJ(int i, int j) {
		if (j == size - 1)
			return 0;
		return j + 1;
	}

	public static void main(String[] args) throws Exception {
		Bishops328 b = new Bishops328();
		b.findMaxSafeBishops();
	}

}
