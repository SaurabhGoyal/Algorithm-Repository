package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lazy01 {

	private static int n;
	private static long l;
	private static long[][] dist;
	private static boolean[] visited;
	private static boolean possible;
	private static int nop = 0;

	public static void dfs(int source) {
		Arrays.fill(visited, false);
		visited[source] = true;
		//System.out.println(String.format("Path "));
		dfsUtil(source, 0, 1);
	}

	public static void dfsUtil(int source, long cost, int numOfNodes) {
		//System.out.print(String.format("%d ",source));
		for (int i = 0; i < n; i++) {
			if (i == source)
				continue;
			if (!visited[i]) {
				visited[i] = true;
				dfsUtil(i, cost + dist[source][i], numOfNodes + 1);
				visited[i] = false;
			} else {
				if (numOfNodes == n) {
					nop++;
					System.out.println(String.format("cost : %d",cost));
					if (cost == l) {
						possible = true;
						break;
					}
				}
			}
		}
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			n = Integer.parseInt(ip[0]);
			l = Long.parseLong(ip[1]);
			visited = new boolean[n];
			dist = new long[n][n];
			possible = false;
			for (int i = 0; i < n; i++) {
				ip = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					dist[i][j] = Integer.parseInt(ip[j]);
				}
			}
			for(int i=0;i<n;i++){
				dfs(i);
				if(possible) break;
			}
			System.out.println(String.format("nop %d",nop));
			if(possible) sb.append("POSSIBLE\n");
			else sb.append("IMPOSSIBLE\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();

	}

}
