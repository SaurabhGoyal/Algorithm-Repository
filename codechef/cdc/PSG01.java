package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PSG01 {
	
	public static int getSetBitsCount(long value) {
		int count = 0;
		while (value > 0) {
			if ((value & 1) == 1)
				count++;
			value >>= 1;
		}
		return count;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int c1 = Integer.parseInt(ip[0]);
			int c2 = Integer.parseInt(ip[1]);
			int cm = Integer.parseInt(ip[2]);
			if(getSetBitsCount(c1^c2)==1) sb.append("No\n");
			else sb.append("Yes\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
