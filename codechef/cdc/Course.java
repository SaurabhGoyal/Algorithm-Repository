package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Course {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int r = Integer.parseInt(ip[0]);
			int R = Integer.parseInt(ip[1]);
			int n = Integer.parseInt(br.readLine());
			long ans = 0;
			for (int i = 0; i < n; i++) {
				ip = br.readLine().split(" ");
				int a = Integer.parseInt(ip[0]);
				int b = Integer.parseInt(ip[1]);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

}
