package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UnluckyNumber {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			Arrays.sort(arr);
			long res = 1;
			for(int i=0;i<n;i++){
				if(arr[i]<=res) res += arr[i];
				else break;
			}
			sb.append(res + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
