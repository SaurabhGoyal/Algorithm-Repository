package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LOLOL {
	
	public static long numOfSubsequence(String string, String subSequence){
		int n = string.length();
		int m = subSequence.length();
		long[][] dp = new long[n+1][m+1];
		for(int i=0;i<=n;i++) dp[i][0] = 1;
		for(int i=1;i<=m;i++) dp[0][i] = 0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				dp[i][j] = dp[i-1][j];
				if(string.charAt(n-i)==subSequence.charAt(m-j)) dp[i][j] += dp[i-1][j-1];
			}
		}
		return dp[n][m];
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		String subSequence = "LOL";
		while (t-- > 0) {
			long ans = 0;
			String string = br.readLine();
			ans = numOfSubsequence(string, subSequence);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
