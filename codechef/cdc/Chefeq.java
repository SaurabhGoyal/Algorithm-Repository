package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chefeq {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int range = 100000;
			int[] freq = new int[range+1];
			int ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(ip[i]);
				freq[num]++; 
			}
			int maxFreq = Integer.MIN_VALUE;
			for(int i=1;i<=range;i++) maxFreq = Math.max(maxFreq, freq[i]);
			ans = n-maxFreq;
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	public static void main(String[] args) throws Exception {
		solve();
	}
}
