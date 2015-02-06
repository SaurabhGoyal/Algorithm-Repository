package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ANURRZ {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(ip[i]);
			}
			int[][] dp = new int[n][n];
			dp[0][0] = 1;
			
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();	
	}

}
