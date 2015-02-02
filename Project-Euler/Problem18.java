import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Problem18 {
	
	
	public static int[][] grid, dp;
	public static int m, n;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			int n = 100;
			grid = new int[n][n];
			dp = new int[n][n];
			long ans = 0;
			for (int i = 0; i < n; i++) {
				String[] ip = br.readLine().split(" ");
				for (int j = 0; j < ip.length; j++) {
					grid[i][j] = Integer.parseInt(ip[j]);
				}
				for (int j = 0; j < ip.length; j++) {
					if(i==0) dp[i][j] = grid[i][j];
					else{
						if(j==0) dp[i][j] = dp[i-1][j] + grid[i][j];
						else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + grid[i][j];
					}
				}
			}
			int max = -1;
			for(int j=0;j<n;j++){
				max= Math.max(max, dp[n-1][j]);
			}
			sb.append(max + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
