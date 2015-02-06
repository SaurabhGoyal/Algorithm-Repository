package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BytelandFunRaiser {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];
			int[][] dp = new int[n][n];
			double ans = 0.0;
			for (int i = 0; i < n; i++) {
				String[] ip = br.readLine().split("\\s+");
				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(ip[j]);
				}
			}
			dp[0][0] = 0;
			for(int i=1;i<n;i++){
				dp[0][i] = dp[0][i-1] + grid[0][i];
				dp[i][0] = dp[i-1][0] + grid[i][0];
			}
			for(int i=1;i<n;i++){
				for(int j=1;j<n;j++){
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];;
				}
			}
			ans = (dp[n-1][n-1])/(double)(2*n-3);
			if(ans<0) sb.append("No funds\n");
			else sb.append(String.format("%.6f",ans) + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
