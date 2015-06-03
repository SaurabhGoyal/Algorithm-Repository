package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sftm {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int range = 10000000;
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]) * 2;
			long[] fact = new long[range + 1];
			fact[0] = 1;
			for (int i = 1; i <= range; i++) {
				fact[i] = (fact[i-1] * i) % m;
			}
			ip = br.readLine().split(" ");
			long sum = 0;
			for (int i = 0; i < n; i++) {
				long elem = Long.parseLong(ip[i]);
				long index = (int) (elem % m);
				long second = (index * ((index+1)%m)) % m;
				second = (second * index) % m;
				long ans = (2*(fact[((int)index)+1] - 1) + second) % m;
				sum += ans;
				sum %= m;
			}
			sb.append(sum/2 + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
