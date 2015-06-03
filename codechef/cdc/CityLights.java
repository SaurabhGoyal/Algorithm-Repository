package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CityLights {

	public static int[][] grid, dp;
	public static int m, n;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			m = Integer.parseInt(ip[0]);
			n = Integer.parseInt(ip[1]);
			grid = new int[m][n];
			dp = new int[m][n];
			long ans = 0;
			for (int i = 0; i < m; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					grid[i][j] = str.charAt(i) == 'H' ? 1 : 0;
				}
			} 
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					
				}
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
}
