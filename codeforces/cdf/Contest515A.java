package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest515A {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long a = Long.parseLong(ip[0]);
			long b = Long.parseLong(ip[1]);
			long s = Long.parseLong(ip[2]);
			long minDist = Math.abs(a) + Math.abs(b);
			if (s < minDist)
				sb.append("No\n");
			else {
				if ((s - minDist) % 2 == 0)
					sb.append("Yes\n");
				else
					sb.append("No\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}