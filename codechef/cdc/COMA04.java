package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class COMA04 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int q = Integer.parseInt(ip[1]);
			long[] arr = new long[n];
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			long[][] dp = new long[n][n+1];
			dp[0][1] = 1;
			for(int i=1;i<n;i++){
				for(int x=1;x<=i;x++) dp[i][x] = dp[i-1][x];
				dp[i][1] += 1;
				for(int j=i-1;j>=0;j--){
					for(int x=2;x<=i+1;x++){
						if(arr[i]>arr[j]) dp[i][x] += dp[j][x-1];
						dp[i][x] %= mod;
					}
				}
				for(int x=1;x<=i+1;x++) System.out.println(String.format("dp[%d][%d] : %d",i,x,dp[i][x]));
			}
			for(int i=0;i<q;i++){
				int x = Integer.parseInt(br.readLine());
				sb.append(dp[n-1][x]).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
