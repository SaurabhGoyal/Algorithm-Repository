package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest21 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int k = Integer.parseInt(ip[1]);
			int p = Integer.parseInt(ip[2]);
			int[] arrA = new int[n];
			int[] arrB = new int[n];
			long ans = 0;
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arrA[i] = Integer.parseInt(ip[i]);
			}
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arrB[i] = Integer.parseInt(ip[i]);
			}
			long[][] dp = new long[n][2];
			dp[0][0] = arrA[0];
			dp[0][1] = arrB[0];
			for (int i = 1; i < n; i++) {
				long min = Long.MAX_VALUE;
				for (int j = Math.max(i - k, 0); j < i; j++) {
					min = Math.min(min, dp[j][0]);
					min = Math.min(min, dp[j][1] + p);
				}
				if (k > 0)
					dp[i][0] = min + arrA[i];
				else
					dp[i][0] = dp[i - 1][0] + arrA[i];
				min = Long.MAX_VALUE;
				for (int j = Math.max(i - k, 0); j < i; j++) {
					min = Math.min(min, dp[j][1]);
					min = Math.min(min, dp[j][0] + p);
				}
				if (k > 0)
					dp[i][1] = min + arrB[i];
				else
					dp[i][1] = dp[i - 1][1] + arrB[i];
			}
			ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
