package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Floori4 {

	public static long getSum(long n, long mod) {
		long first = n % mod;
		long second = (first + 1) % mod;
		long third = (2 * first + 1) % mod;
		long fourth = (3 * first * second - 1) % mod;
		long sum = (first * second) % mod;
		sum = (sum * ((third * fourth) % mod)) % mod;
		return sum;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long n = Long.parseLong(ip[0]);
			long m = Long.parseLong(ip[1]) * 30;
			long ans = 0;
			int root = (int) Math.sqrt(n);
			for (long i = 1; i <= root; i++) {
				long from = n / (i + 1) + 1;
				long to = n / i;
				ans += ((i * ((getSum(to, m) - getSum(from - 1, m) + m) % m)) % m);
				ans %= m;
			}
			for (long i = 1; i <= n / (root + 1); i++) {
				long i2 = (i * i) % m;
				long i4 = (i2 * i2) % m;
				ans += (30 * i4 * ((n / i) % m));
				ans %= m;
			}
			sb.append(ans / 30 + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
