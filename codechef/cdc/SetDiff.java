package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class SetDiff {

	public static long pow(long base, long exp, long mod) {
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base % mod;
		long result = pow(base, exp / 2, mod);
		result = (result * result) % mod;
		if (exp % 2 == 1)
			result = (result * base) % mod;
		return result;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long max = 0, min = 0, ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				max += ((pow(2, i , mod) * arr[i]) % mod);
				max %= mod;
			}
			for (int i = 0; i < n; i++) {
				min += ((pow(2, n-1-i , mod) * arr[i]) % mod);
				min %= mod;
			}
			ans = (max - min + mod) % mod;
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();

	}
}
