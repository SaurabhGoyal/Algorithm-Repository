package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Codigo {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			long[] arr = new long[n];
			long[] diff = new long[n+1];
			long ans = 0;
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
				if(i==0) diff[i] = arr[i];
				else diff[i] = arr[i] - arr[i-1];
			}
			for (int i = 0; i < m; i++) {
				ip = br.readLine().split(" ");
				int x = Integer.parseInt(ip[0])-1;
				int y = Integer.parseInt(ip[1])-1;
				diff[x]++;
				diff[y+1]--;
			}
			for(int i=0;i<n;i++){
				if(i==0) arr[i] = diff[i];
				else arr[i] = arr[i-1]+diff[i];
				if(i==0) sb.append(arr[i]);
				else sb.append(" ").append(arr[i]);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
