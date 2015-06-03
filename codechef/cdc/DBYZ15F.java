package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DBYZ15F {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int k = Integer.parseInt(ip[0]);
			long n = Long.parseLong(ip[1]);
			long[] arr = new long[k];
			ip = br.readLine().split(" ");
			for (int i = 0; i < k; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			long x = (long) Math.pow(2, 52);
			long xlevel = x;
			while (xlevel > 0) {
				long toys = 0;
				for (int i = 0; i < k; i++) {
					toys += (x / arr[i]);
				}
				System.out.println(String.format("t:%d",toys));
				xlevel /= 2;
				if (toys < n){
					x += xlevel;
					if(xlevel == 0) x += 1;
				}
				else{
					x -= xlevel;
				}
				System.out.println(String.format("x:%d",x));
			}
			sb.append(x + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
