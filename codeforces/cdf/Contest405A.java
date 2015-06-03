package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Contest405A {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				if(i!=0) sb.append(" ");
				sb.append(arr[i]);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
