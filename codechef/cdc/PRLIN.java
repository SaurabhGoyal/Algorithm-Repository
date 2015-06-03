package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRLIN {
	
	public static boolean[] getSieve(int range) {
		int i = 0;
		boolean[] sieve = new boolean[range + 1];
		for (i = 0; i <= range; i++)
			sieve[i] = true;
		sieve[1] = false;
		for (i = 2; i < Math.sqrt(range); i++) {
			if (sieve[i] == true) {
				int j = i + i;
				while (j <= range) {
					sieve[j] = false;
					j += i;
				}
			}
		}
		return sieve;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int range = 100000000;
		boolean[] sieve = getSieve(range);
		long[] sum = new long[1001];
		int step = 1;
		int k = 1;
		int count = 0;
		long temp = 0;
		for(int i=1;i<500501;i++){
			count++;
			if(sieve[i]) temp += i;
			if(count == step){
				sum[k++] = temp;
				step++;
				count = 0;
				temp = 0;
			}
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long ans = sum[n];
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
