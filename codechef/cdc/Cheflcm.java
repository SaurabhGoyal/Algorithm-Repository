package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cheflcm {
	
	public static boolean[] getSieve(int range) {
		int i = 0;
		boolean[] sieve = new boolean[range + 1];
		for (i = 0; i <= range; i++)
			sieve[i] = true;
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
		int range = 100000;
		boolean[] sieve = getSieve(range);
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long ans = 1;
			for(int i=2;i<=Math.sqrt(n);i++){
				if(sieve[i]){
					int exp = 0;
					while(n%i == 0){
						n /= i;
						//System.out.println(String.format("n is %d",n));
						exp++;
					}
					//System.out.println(String.format("i : %d, exp : %d",i,exp));
					ans *= (((long)Math.pow(i, exp+1) - 1)/(i - 1));
				}
			}
			if(n>1){
				ans *= (n+1);
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
