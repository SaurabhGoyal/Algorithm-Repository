package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BrokPhon {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			boolean[] counted = new boolean[n];
			Arrays.fill(counted, false);
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			for (int i = 0; i < n-1; i++) {
				if(arr[i]!=arr[i+1]){
					ans++;
					counted[i+1] = true;
					if(!counted[i]){
						ans++;
						counted[i] = true;
					}
				}
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
