package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

class ChefPaint {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n, m, k;
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);

		int grid[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				grid[i][j] = 0;

		for (int i = 0; i < k; i++) {
			String cell[] = br.readLine().split(" ");
			int x = Integer.parseInt(cell[0]) - 1;
			int y = Integer.parseInt(cell[1]) - 1;
			grid[x][y] = 1;
		}
		// System.out.println("======Grid=======");
		// for (int i = 0; i < n; i++) {
		// for (int j = 0; j < m; j++) {
		// System.out.print(grid[i][j] + " ");
		// }
		// System.out.println("\n");
		// }

		ArrayList<Move> verticalMoveSet = new ArrayList<Move>();
		ArrayList<Move> horizontalMoveSet = new ArrayList<Move>();
		for (int i = 0; i < m; i++) {
			int startx = 0, starty = i, endx, endy, dist = 0;
			// System.out.println("Checking column " + i);
			for (int j = 0; j < n; j++) {
				// System.out.println("Checking row " + j);
				if (grid[j][i] != 1) {
					if (dist == 0) {
						startx = j;
						starty = i;
						// System.out.println("move started\n");
					}
					dist++;
				} else {
					if (dist != 0) {
						endx = j - 1;
						endy = i;
						dist = 0;
						Move move = new Move(1, startx, starty, endx, endy);
						verticalMoveSet.add(move);
						// System.out.println("Added move --> " + move);
						// System.out.println("------no of moves in treeset="+
						// moveSet.size() + "---------");
					}
				}
			}
			if (dist > 0) {
				endx = n - 1;
				endy = i;
				dist = 0;
				Move move = new Move(1, startx, starty, endx, endy);
				verticalMoveSet.add(move);
				// System.out.println("Added move --> " + move);
				// System.out.println("------no of moves in treeset="+
				// moveSet.size() + "---------");
			}
		}

		for (int i = 0; i < n; i++) {
			int startx = i, starty = 0, endx, endy, dist = 0;
			// System.out.println("Checking row " + i);
			for (int j = 0; j < m; j++) {
				// System.out.println("Checking column " + j);
				if (grid[i][j] != 1) {
					if (dist == 0) {
						startx = i;
						starty = j;
						// System.out.println("move started\n");
					}
					dist++;
				} else {
					if (dist != 0) {
						endx = i;
						endy = j - 1;
						dist = 0;
						Move move = new Move(1, startx, starty, endx, endy);
						horizontalMoveSet.add(move);
						// System.out.println("Added move --> " + move);
						// System.out.println("------no of moves in treeset="+
						// moveSet.size() + "---------");
					}
				}
			}
			if (dist > 0) {
				endx = i;
				endy = m - 1;
				dist = 0;
				Move move = new Move(1, startx, starty, endx, endy);
				horizontalMoveSet.add(move);
				// System.out.println("Added move --> " + move);
				// System.out.println("------no of moves in treeset="+
				// moveSet.size() + "---------");
			}
		}

		// Collections.sort(verticalMoveSet, new MyComparator());

		// System.out.println("=======moveset=======");
		// Iterator<Move> it = moveSet.iterator();
		// while (it.hasNext()) {
		// Move mv = it.next();
		// System.out.println(mv);
		// }

		if (verticalMoveSet.size() < horizontalMoveSet.size()) {
			System.out.println(verticalMoveSet.size());
			Iterator<Move> it = verticalMoveSet.iterator();
			while (it.hasNext()) {
				Move move = it.next();
				System.out.println((((move.startx + move.endx) / 2) + 1) + " "
						+ (move.starty + 1) + " 1");
			}
		} else {
			System.out.println(horizontalMoveSet.size());
			Iterator<Move> it = horizontalMoveSet.iterator();
			while (it.hasNext()) {
				Move move = it.next();
				System.out.println((move.startx + 1) + " "
						+ (((move.starty + move.endy) / 2) + 1) + " 0");
			}
		}
	}
}

class Move {
	int type, startx, starty, endx, endy;

	public Move(int type, int startx, int starty, int endx, int endy) {
		super();
		this.type = type;
		this.startx = startx;
		this.starty = starty;
		this.endx = endx;
		this.endy = endy;
	}

	public String toString() {
		String str;
		str = "type " + type + ", start=" + startx + "," + starty + " ,end="
				+ endx + "," + endy + " , dist="
				+ (endx - startx + endy - starty + 1);
		return str;
	}

}

class MyComparator implements Comparator<Move> {
	@Override
	public int compare(Move o1, Move o2) {
		int dist1 = o1.endx - o1.startx + o1.endy - o1.starty + 1;
		int dist2 = o2.endx - o2.startx + o2.endy - o2.starty + 1;
		int diff = dist2 - dist1;
		if (diff > 0)
			return 1;
		else if (diff < 0)
			return -1;
		else
			return 0;
	}

}