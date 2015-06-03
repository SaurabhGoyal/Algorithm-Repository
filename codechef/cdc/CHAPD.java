package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CHAPD {
	
	public static long getGCD(long a, long b) {
		while (b != 0) {
			long t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long a = Long.parseLong(ip[0]);
			long b = Long.parseLong(ip[1]);
			long gcd = getGCD(a, b);
			b /= gcd;
			while(true){
				long gcd2 = getGCD(gcd, b);
				b /= gcd2;
				if(gcd2==1) break;
			}
			if(b==1) sb.append("Yes\n");
			else sb.append("No\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
