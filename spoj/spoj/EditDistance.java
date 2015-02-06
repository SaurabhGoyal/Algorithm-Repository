package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EditDistance {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String source = br.readLine();
			String target = br.readLine();
			long ans = getEditDistance(source, target);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static long getEditDistance(String source, String target) {
		int n = source.length();
		int m = target.length();
		int[][] dp = new int[n+1][m+1];
		dp[0][0] = 0;
		for(int i=0;i<=n;i++){
			for(int j=0;j<=m;j++){
				if(i==0 && j==0) dp[i][j] = 0;
				else if(i==0 || j==0){
					if(i==0) dp[i][j] = dp[i][j-1]+1;
					else dp[i][j] = dp[i-1][j]+1;
				}
				else{
					if(source.charAt(i-1)==target.charAt(j-1)){
						dp[i][j] = dp[i-1][j-1];
					}
					else{
						dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
						dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]) + 1;
					}
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
