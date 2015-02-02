import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest {

	public static int[][] grid;
	public static int[][] memo;
	public static int m, n, x, y, d;

	public static void solveRec(int i, int j, int nob) {
		System.out.println(String.format("in %d,%d", i, j));
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return;
		}
		if (i == x && j == y) {
			if (nob < memo[i][j]) {
				memo[i][j] = nob;
			}
			return;
		}
		if (nob < memo[i][j]) {
			memo[i][j] = nob;
			if (j > 0)
				if (Math.abs(grid[i][j - 1] - grid[i][j]) <= d)
					solveRec(i, j - 1, nob + 1);
			if (j < n - 1)
				if (Math.abs(grid[i][j + 1] - grid[i][j]) <= d)
					solveRec(i, j + 1, nob + 1);
			if (i > 0)
				if (Math.abs(grid[i - 1][j] - grid[i][j]) <= d)
					solveRec(i - 1, j, nob + 1);
			if (i < m - 1)
				if (Math.abs(grid[i + 1][j] - grid[i][j]) <= d)
					solveRec(i + 1, j, nob + 1);
		}
		return;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			m = Integer.parseInt(ip[0]);
			n = Integer.parseInt(ip[1]);
			x = Integer.parseInt(ip[2]) - 1;
			y = Integer.parseInt(ip[3]) - 1;
			d = Integer.parseInt(ip[4]);
			grid = new int[m][n];
			memo = new int[m][n];
			for (int i = 0; i < m; i++) {
				ip = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(ip[j]);
					memo[i][j] = Integer.MAX_VALUE;
				}
			}
			solveRec(0, 0, -1);
			sb.append(memo[x][y] + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
