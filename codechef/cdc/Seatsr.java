package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Seatsr {

	public static long getEditDistance(String source, String target,
			int insertionCost, int deletionCost, int replacementCost) {
		int n = source.length();
		int m = target.length();
		long[][] dp = new long[n + 1][m + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = i * insertionCost;
		}
		for (int i = 1; i <= m; i++) {
			dp[0][i] = i * deletionCost;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + insertionCost,
							dp[i][j - 1] + deletionCost);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]
							+ replacementCost);
				}

			}
		}
		return dp[n][m];
	}
	
	
	public static int[][] grid;
	public static int m, n;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String src = br.readLine();
			String target = br.readLine();
			String[] ip = br.readLine().trim().split("\\s+");
			int a = Integer.parseInt(ip[0]);
			int b = Integer.parseInt(ip[1]);
			int k = Integer.parseInt(ip[2]);
		}
		System.out.print(sb.toString());
	}

}
