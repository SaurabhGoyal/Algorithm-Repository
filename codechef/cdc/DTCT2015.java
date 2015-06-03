package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class DTCT2015 {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int c = 0;
		while (t-- > 0) {
			String[] ip = br.readLine().trim().split(" ");
			int n = Integer.parseInt(ip[0]);
			int s = Integer.parseInt(ip[1]);
			int[] d = new int[n];
			ip = br.readLine().trim().split(" ");
			for(int i=0;i<n;i++){
				d[i] = Integer.parseInt(ip[i]);
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
