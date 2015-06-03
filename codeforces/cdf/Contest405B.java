package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest405B {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			long ans = 0;
			char last = '.';
			int lastCharIndex = -1;
			for (int i = 0; i < n; i++) {
				char ch = str.charAt(i);
				if (ch == '.') {
					if (last == 'L')
						ans++;
				} else if (ch == 'L') {
					if(last=='R' && (i-lastCharIndex-1)%2==1) ans++;
					last = ch;
					lastCharIndex = i;
				} else {
					if(last=='.') ans+=i;
					last = ch;
					lastCharIndex = i;
				}
			}
			if(last=='.') ans = n;
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
