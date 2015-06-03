package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PSG03 {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long[] sum = new long[n];
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
				if(i==0) sum[i] = arr[i];
				else sum[i] = arr[i] + sum[i-1];
			}
			int q = Integer.parseInt(br.readLine());
			for(int i=0;i<q;i++){
				ip = br.readLine().split(" ");
				int a = Integer.parseInt(ip[0]) - 1;
				int b = Integer.parseInt(ip[1]) - 1;
				ans = sum[b];
				if(a>0) ans -= sum[a-1];
				sb.append(ans + "\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
