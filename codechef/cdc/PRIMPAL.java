package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PRIMPAL {
	
	public static long mod = 1000000007;
	
	public static long power(long base, long exp){
		if(exp == 0) return 1;
		if(exp == 1) return base;
		long sub = power(base, exp/2);
		long res = (sub*sub)%mod;
		if(exp%2==1) res = (res*base)%mod;
		return res;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] nop = new int[]{0, 4, 25, 168, 1229, 9592, 78498, 664579, 5761455, 50847534};
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long n = Long.parseLong(ip[0]);
			int k = Integer.parseInt(ip[1]);
			long palinl = n-k;
			long ans = 0;
			if(palinl%2==0){
				long half = (n-k)/2;
				ans += (9*power(10, half-1));
			}
			else{
				long half = (n-k)/2;
				ans += (9*power(10, half));
			}
			ans = (ans*nop[k])%mod;
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
