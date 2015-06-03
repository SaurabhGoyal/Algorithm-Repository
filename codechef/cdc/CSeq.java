package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class CSeq {

	public static long fact[], ifact[];

	public static void init(int range, int mod) {
		fact = new long[range];
		ifact = new long[range];
		fact[0] = ifact[0] = 1;
		for (int i = 1; i < range; i++) {
			fact[i] = (i * fact[i - 1]) % mod;
			ifact[i] = (pow(i, mod - 2, mod) * ifact[i - 1]) % mod;
		}
	}

	public static long pow(long base, long exp, long mod) {
		long res = 1;
		while (exp > 0) {
			if ((exp & 1) == 1)
				res = (res * base) % mod;
			exp >>= 1;
			base = (base * base) % mod;
		}
		return res;
	}

	public static long ncr(int n, int r, int mod) {
		long ans = fact[n] * ifact[r] * ifact[n - r];
		return ans % mod;
	}

	public static long lucas(int n, int r, int mod) {
		long ans = 1;
		while (n > 0 || r > 0) {
			int ni = n % mod;
			int ri = r % mod;
			n /= mod;
			r /= mod;
			if (ni >= ri) {
				ans = (ans * ncr(ni, ri, mod)) % mod;
			}
			else return 0;
		}
		return ans;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int mod = (int) 1e6 + 3;
		int range = mod;
		init(range, mod);
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int m = Integer.parseInt(ip[0]);
			int l = Integer.parseInt(ip[1]);
			int r = Integer.parseInt(ip[2]);
			int n = r - l + 1;
			long ans = lucas(n + m, m, mod) + mod - 1;
			ans %= mod;
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}