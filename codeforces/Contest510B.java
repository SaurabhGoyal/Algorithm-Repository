import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest510B {
	//FoxAndTwoDots

	private static int n, m;
	private static char[][] grid;
	private static int[][] color;
	private static boolean hasCycle;
	private static int[] dx = new int[] { 0, 1, 0, -1 };
	private static int[] dy = new int[] { 1, 0, -1, 0 };

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			n = Integer.parseInt(ip[0]);
			m = Integer.parseInt(ip[1]);
			grid = new char[n][m];
			color = new int[n][m];
			hasCycle = false;
			for (int i = 0; i < n; i++) {
				grid[i] = br.readLine().toCharArray();
			}
			outerloop: for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (color[i][j] == 0) {
						checkCycle(i, j, -1, -1);
						if (hasCycle)
							break outerloop;
					}
				}
			}
			if (hasCycle)
				sb.append("Yes\n");
			else
				sb.append("No\n");
		}
		System.out.print(sb.toString());
	}

	private static void checkCycle(int i, int j, int lastI, int lastJ) {
		color[i][j] = 1;
		for (int k = 0; k < 4; k++) {
			int nextI = i + dx[k];
			int nextJ = j + dy[k];
			if (nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= m
					|| color[nextI][nextJ] == 2
					|| grid[i][j] != grid[nextI][nextJ]
					|| (nextI == lastI && nextJ == lastJ)) {
				continue;
			}
			if (color[nextI][nextJ] == 1) {
				hasCycle = true;
				return;
			}
			checkCycle(nextI, nextJ, i, j);
		}
		color[i][j] = 2;
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}