package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHbill {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] a = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				a[i] = Long.parseLong(ip[i]);
			}
			long[] b = new long[n];
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				b[i] = Long.parseLong(ip[i]);
			}
			long d = Long.parseLong(br.readLine());
			long min = Long.MAX_VALUE;
			long minI = 0;
			for (int i = 0; i < n; i++) {
				long time = Long.MAX_VALUE;
				if (a[i] >= d)
					time = d;
				else {
					long steps = (long) Math.ceil(((double) (d - a[i]))
							/ ((double) (a[i] - b[i])));
					long dist = steps * (a[i] - b[i]);
					time = (steps * (a[i] + b[i])) + (d - dist);
				}
				if (time < min) {
					min = time;
					minI = i;
				}

				// System.out.println("i: "+i+" => time: "+time+", min: "+min);
			}
			sb.append(minI + 1).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}