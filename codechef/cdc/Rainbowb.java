package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Rainbowb {

	public static long mod = 1000000007;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long ans = 0;
			if (n >= 13) {
				n = (n - 13) / 2;
				ans = (n + 6);
				ans = (ans * (n + 5)) % mod;
				ans = (ans * (n + 4)) % mod;
				ans = (ans * (n + 3)) % mod;
				ans = (ans * (n + 2)) % mod;
				ans = (ans * (n + 1)) % mod;
				ans *= BigInteger.valueOf(720).modInverse(
						BigInteger.valueOf(mod)).longValue();
				ans %= mod;
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
