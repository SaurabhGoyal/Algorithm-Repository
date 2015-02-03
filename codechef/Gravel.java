import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Gravel {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			long c = Long.parseLong(ip[2]);
			long ans = 0;
			long[] arr = new long[n];
			arr[0] = c;
			for(int i=1;i<n;i++) arr[i] = arr[i-1]+c;
			FenwickTree ft = new FenwickTree(arr, n);
			for (int i = 0; i < m; i++) {
				ip = br.readLine().split(" ");
				if(ip.length == 2){
					int id = Integer.parseInt(ip[1]);
					System.out.println(ft.getSum(id));
				}
				else{
					int x = Integer.parseInt(ip[1]);
					int y = Integer.parseInt(ip[2]);
					long k = Integer.parseInt(ip[3]);
					ft.update(x, k);
					ft.update(y+1, -k);
					//System.out.println("updated");
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
