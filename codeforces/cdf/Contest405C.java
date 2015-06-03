package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest405C {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] diag = new int[n];
			int sum = 0;
			for(int i=0;i<n;i++){
				String[] ip = br.readLine().split(" ");
				diag[i] = Integer.parseInt(ip[i]);
				sum += diag[i];
				sum %= 2;
			}
			int q = Integer.parseInt(br.readLine());
			while(q-->0){
				String[] ip = br.readLine().split(" ");
				if(ip.length>1){
					int i = Integer.parseInt(ip[1]);
					sum -= diag[i-1];
					if(sum<0) sum += 2;
					diag[i-1] = 1 - diag[i-1];
					sum += diag[i-1];
					sum %= 2;
				}
				else{
					sb.append(sum);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
