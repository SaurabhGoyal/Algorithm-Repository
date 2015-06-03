package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Ticket5 {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine().trim();
			int len = str.length();
			if(str.charAt(0) == str.charAt(1)) sb.append("NO\n");
			else if(len == 2) sb.append("YES\n");
			else{
				char[] c = new char[]{str.charAt(0), str.charAt(1)};
				boolean ok = true;
				for(int i=2;i<len;i++){
					if(str.charAt(i) != c[i%2]){
						ok = false;
						break;
					}
				}
				if(ok) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
