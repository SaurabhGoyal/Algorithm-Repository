package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chefinv {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			long[] arr = new long[n];
			long ans = 0;
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			for (int i = 0; i < m; i++) {
				ip = br.readLine().split(" ");
				int x = Integer.parseInt(ip[0]);
				int y = Integer.parseInt(ip[1]);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
