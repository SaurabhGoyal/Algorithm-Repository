package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Carlos {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int m = Integer.parseInt(ip[0]);
			int k = Integer.parseInt(ip[1]);
			int n = Integer.parseInt(ip[2]);
			boolean[][] adj = new boolean[m + 1][m + 1];
			int[][] dp = new int[n][m+1];
			int[] arr = new int[n];
			for (int i = 0; i <= m; i++)
				for (int j = 0; j <= m; j++)
					adj[i][j] = false;
			for (int i = 0; i < k; i++) {
				ip = br.readLine().split(" ");
				int x = Integer.parseInt(ip[0]);
				int y = Integer.parseInt(ip[1]);
				adj[x][y] = adj[y][x] = true;
			}
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= m; j++) {
					if(i==j){
						adj[i][j] = true;
						continue;
					}
					for (int r = 1; r <= m; r++) {
						if (adj[i][r] && adj[r][j])
							adj[i][j] = true;
					}
				}
			}
			
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(ip[i]);
			
			for(int i=0;i<n;i++) Arrays.fill(dp[i], 99999999);
			for(int i=0;i<n;i++){
				for(int j=1;j<=m;j++){
					if(adj[arr[i]][j]) dp[i][j] = 1;
					if(j==arr[i]) dp[i][j] = 0;
					if(i==0) dp[i][j] = Math.min(dp[i][j], dp[i][j-1]);
					else dp[i][j] = Math.min(dp[i-1][j], dp[i][j] + dp[i][j-1]);
				}
			}
			if(dp[n-1][m] == 99999999) sb.append("-1\n");
			else sb.append(dp[n-1][m]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}
}
