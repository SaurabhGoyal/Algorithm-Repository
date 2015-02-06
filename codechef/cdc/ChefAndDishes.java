package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChefAndDishes {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int k = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			for (int i = 0; i < m; i++) {
				String section = br.readLine();
				
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
