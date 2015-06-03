package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest515B {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			boolean[] happyB = new boolean[n];
			boolean[] happyG = new boolean[m];
			int numOfHAppy = 0;
			ip = br.readLine().split(" ");
			int b = Integer.parseInt(ip[0]);
			for(int i=0;i<b;i++){
				int index = Integer.parseInt(ip[i+1]);
				happyB[index] = true;
			}
			ip = br.readLine().split(" ");
			int g = Integer.parseInt(ip[0]);
			for(int i=0;i<g;i++){
				int index = Integer.parseInt(ip[i+1]);
				happyG[index] = true;
			}
			numOfHAppy = b+g;
			for(int i=0;i<2*Math.max(n, m);i++){
				if(happyB[i%n] && happyG[i%m]);
				else{
					if(!happyB[i%n] && !happyG[i%m]);
					else{
						happyB[i%n] = true;
						happyG[i%m] = true;
						numOfHAppy++;
					}
				}
			}
			if(numOfHAppy == (n+m)) sb.append("Yes\n");
			else sb.append("No\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}