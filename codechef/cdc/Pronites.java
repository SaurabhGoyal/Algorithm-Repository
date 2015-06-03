package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pronites {

	public static String longestCommonSubsequence(String a, String b) {
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else {
					if (a.charAt(i - 1) == b.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		int i = n, j = m;
		StringBuilder lcs = new StringBuilder();
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				lcs.append(a.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}
		return lcs.reverse().toString();
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String s1 = br.readLine();
			String s2 = br.readLine();
			String s3 = br.readLine();
			String s4 = br.readLine();
			String lcs1 = longestCommonSubsequence(s1, s2);
			String lcs2 = longestCommonSubsequence(s3, s4);
			String lcs = longestCommonSubsequence(lcs1, lcs2);
			long ans = lcs.length();
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
