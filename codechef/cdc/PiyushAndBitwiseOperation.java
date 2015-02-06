package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PiyushAndBitwiseOperation {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long ans = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			Arrays.sort(arr);
			for(int i=0;i<n-1;i++){
				long and = arr[i] & arr[i+1];
				ans = Math.max(ans, and);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
