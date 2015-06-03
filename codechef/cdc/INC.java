package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class INC {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			int range = 1000000;
			boolean[] arr = new boolean[range+1];
			boolean[] counted = new boolean[range+1];
			Arrays.fill(counted, false);
			long ans = 0;
			ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int a = Integer.parseInt(ip[i]);
				arr[a] = true;
			}
			ip = br.readLine().split(" ");
			for (int i = 0; i < m; i++) {
				int a = Integer.parseInt(ip[i]);
				if(arr[a] && !counted[a]){
					ans++;
					counted[a] = true;
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
