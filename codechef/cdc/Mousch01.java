package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Mousch01 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().trim().split(" ");
			String s1 = ip[0], s2 = ip[1];
			int cost = Math.min(getEditDistMod(s1, s2), getEditDistMod(s2, s1));
			sb.append(cost).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static int getEditDistMod(String source, String target) {
		int n = source.length();
		int m = target.length();
		int[][] dp = new int[n + 1][m + 1];
		dp[0][0] = 0;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int i = 1; i <= m; i++) {
			dp[0][i] = i;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.println(String.format("checking i:%d and j:%d",i,j));
				System.out.println(String.format("till %s , %s",source.substring(0, i), target.substring(0, j)));
				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
					if (i>1 && j>1 && source.charAt(i - 2) == target.charAt(j - 1)
							&& source.charAt(i - 1) == target.charAt(j - 2))
						dp[i][j] = Math.min(dp[i][j], dp[i - 2][j - 2] + 1);
				}

			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
