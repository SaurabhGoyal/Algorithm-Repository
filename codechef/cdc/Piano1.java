package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Piano1 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			String seq = br.readLine().trim();
			int n = Integer.parseInt(br.readLine().trim());
			n *= 12;
			int len = seq.length();
			int sum = 0;
			for(int i=0;i<len;i++){
				sum += (seq.charAt(i)=='T'?2:1);
			}
			int ans = 0;
			int l = 1;
			while(l*sum <= n){
				ans += (n - (l*sum));
				l++;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
