package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChefAndDaughter {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] p = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				p[i] = Long.parseLong(ip[i]);
			}
			int[] suffix = new int[n];
			for(int i=0;i<n;i++){
				int count = 0;
				for(int j=i+1;j<n;j++){
					if(p[j] < p[i]) count++;
				}
				suffix[i] = count;
			}
			long ways = 0;
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){
					if(p[j]<p[i]){
						ways += suffix[j];
					}
				}
			}
			sb.append(ways + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
