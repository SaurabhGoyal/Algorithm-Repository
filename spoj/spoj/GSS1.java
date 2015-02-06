package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GSS1 {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			
			int m = Integer.parseInt(br.readLine());
			while(m-->0){
				ip = br.readLine().split(" ");
				int x = Integer.parseInt(ip[0]);
				int y = Integer.parseInt(ip[0]);
			}
			
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
