package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PSG02 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			if (n % 2 == 0) {
				sb.append("2 2 ");
				n -= 4;
			} else {
				sb.append("2 3 ");
				n -= 5;
			}
			for (int i = 2; i <= n / 2; i++) {
				if (new BigInteger("" + i).isProbablePrime(3) && new BigInteger("" + (n-i)).isProbablePrime(3)) {
					sb.append(i + " " + (n - i)).append("\n");
					break;
				}
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();

	}

}
