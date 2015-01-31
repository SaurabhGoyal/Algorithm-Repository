import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BitmapSpojBfs {

	public static Pair[][] grid;
	public static int n, m;

	public static void bfs(Pair source) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(source);
		while (!q.isEmpty()) {
			Pair src = q.remove();
			//System.out.println("src is "+src);
			List<Pair> adjList = src.getAdjacents();
			for (Pair adj : adjList) {
				//System.out.println("adj is "+adj);
				if (adj.dist > src.dist + 1){
					adj.dist = src.dist + 1;
					q.add(adj);
				}
			}
		}
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String input = br.readLine();
			if("".equals(input)) input = br.readLine();
			String[] ip = input.split(" ");
			n = Integer.parseInt(ip[0]);
			m = Integer.parseInt(ip[1]);
			grid = new Pair[n][m];
			List<Pair> whiteList = new ArrayList<Pair>();
			for (int i = 0; i < n; i++) {
				String word = br.readLine();
				for (int j = 0; j < m; j++) {
					grid[i][j] = new Pair(i, j);
					if (word.charAt(j) == '1') {
						grid[i][j].dist = 0;
						whiteList.add(grid[i][j]);
					}
				}
			}
			for (Pair white : whiteList) {
				//System.out.println("\n===========bfsing for "+white);
				bfs(white);
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					sb.append(grid[i][j].dist);
					if(j<m-1) sb.append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

	public static class Pair {
		int i, j;
		int dist = Integer.MAX_VALUE;

		Pair(int i, int j) {
			this.i = i;
			this.j = j;
		}

		@Override
		public String toString() {
			return "Pair [i=" + i + ", j=" + j + ", dist=" + dist + "]";
		}

		public List<Pair> getAdjacents() {
			List adjList = new ArrayList<Pair>();
			if (i - 1 >= 0)
				adjList.add(grid[i - 1][j]);
			if (j - 1 >= 0)
				adjList.add(grid[i][j - 1]);
			if (i + 1 < n)
				adjList.add(grid[i + 1][j]);
			if (j + 1 < n)
				adjList.add(grid[i][j + 1]);
			return adjList;
		}
	}
}