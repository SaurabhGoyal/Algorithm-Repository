package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHGift1 {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long[] dpmin = new long[n];
			long[] dpmax = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
				if (i == 0)
					dpmin[i] = dpmax[i] = arr[i];
				else {
					if(arr[i]==0){
						dpmin[i] = Math.min(dpmin[i-1], 0);
						dpmax[i] = Math.max(dpmax[i-1], 0);
					}
					else if(arr[i]>0){
						dpmin[i] = Math.min(dpmin[i-1]-arr[i], dpmin[i-1]*arr[i]);
						dpmax[i] = Math.max(dpmax[i-1]+arr[i], dpmax[i-1]*arr[i]);
					}
					else{
						dpmin[i] = Math.min(dpmin[i-1]+arr[i], dpmax[i-1]*arr[i]); 
						dpmax[i] = Math.max(dpmax[i-1]-arr[i], dpmin[i-1]*arr[i]);
					}
					//System.out.println(String.format("dpmin[%d] : %d, dpmax[%d] : %d",i,dpmin[i],i,dpmax[i]));
				}
			}
			sb.append(dpmin[n-1] + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
