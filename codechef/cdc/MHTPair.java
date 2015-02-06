package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MHTPair {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] bit = new int[n+1];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(ip[i]);
				int index = num;
				int sum = 0;
				while(index>0){
					sum += bit[index];
					index -= (index & (-index));
				}
				index = num;
				while(index<=n){
					bit[index] += 1;
					index += (index & (-index));
				}
				sb.append(num-sum);
				if(i<n-1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
