package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WiseAndMiser {
	
	
	public static int[][] grid;
	public static int n, m;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t=1;
		while (t-- > 0) {
			String[] ip = br.readLine().split("\\s+");
			n = Integer.parseInt(ip[0]);
			m = Integer.parseInt(ip[1]);
			grid = new int[n][m];
			int[][] dp = new int[n][m];
			int ans = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				ip = br.readLine().split("\\s+");
				for (int j = 0; j < m; j++) {
					grid[i][j] = Integer.parseInt(ip[j]);
					if(i==0) dp[i][j] = grid[i][j];
					else{
						int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,c=Integer.MAX_VALUE;
						if(j>0) a = dp[i-1][j-1];
						b = dp[i-1][j];
						if(j<m-1) c = dp[i-1][j+1];
						dp[i][j] = Math.min(a, Math.min(b, c)) + grid[i][j];
					}
				}
			}
			for(int j=0;j<m;j++) ans = Math.min(ans, dp[n-1][j]);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
