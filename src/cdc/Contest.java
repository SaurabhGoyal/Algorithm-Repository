package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contest {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String[] ip=br.readLine().split(" ");
			int r = Integer.parseInt(ip[0]);
			int x = Integer.parseInt(ip[1]);
			int y = Integer.parseInt(ip[2]);
			int xd = Integer.parseInt(ip[3]);
			int yd = Integer.parseInt(ip[4]);
			double dist = Math.sqrt(Math.pow(xd-x, 2)+Math.pow(yd-y, 2));
			//System.out.println("dist is "+dist);
			int steps = (int)Math.ceil(dist / (2*r));
			sb.append(steps+"\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}