package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chefch {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			int n = str.length();
			int cost1 = 0 , cost2 = 0;
			for(int i=0;i<n;i++){
				char c = str.charAt(i);
				if(i%2==0){
					if(c=='+') cost1++;
					else cost2++;
				}
				else{
					if(c=='+') cost2++;
					else cost1++;
				}
			}
			sb.append(Math.min(cost1, cost2)).append("\n");
		}
		System.out.print(sb.toString());
	}
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
