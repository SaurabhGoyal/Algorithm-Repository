package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RankList {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long n = Long.parseLong(ip[0]);
			long s = Long.parseLong(ip[1]);
			long desiredSum = (n*(n+1))/2;
			long diff = desiredSum - s ;
			long b = ((2*n)-1);
			double d = Math.sqrt(b*b - 8*diff);
			long ans = (long)Math.ceil((b-d)/(double)2);
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();		
	}
}
