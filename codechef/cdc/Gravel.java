package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gravel {
		
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split("\\s+");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			long c = Long.parseLong(ip[2]);
			long[] bit = new long[n+1];
			for (int i = 0; i < m; i++) {
				ip = br.readLine().split("\\s+");
				if(ip.length == 2){
					int index = Integer.parseInt(ip[1]);
					long sum = 0;
					while(index>0){
						sum += bit[index];
						index -= (index&(-index));
					}
					sb.append((sum+c)+"\n");
				}
				else{
					int x = Integer.parseInt(ip[1]);
					int y = Integer.parseInt(ip[2])+1;
					long k = Long.parseLong(ip[3]);
					while(x<=n){
						bit[x] += k;
						x += (x&(-x));
					}
					while(y<=n){
						bit[y] -= k;
						y += (y&(-y));
					}
				}
			}
			//sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();	
	}
}
