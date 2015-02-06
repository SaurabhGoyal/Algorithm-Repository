package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ParkingSlot {
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int k = Integer.parseInt(ip[1]);
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			Arrays.sort(arr);
			double diff = Math.log(arr[n-1]-arr[0])/ Math.log(2);
			long pow = (long) Math.ceil(diff);
			long x = (long)Math.pow(2, pow);
			long xlevel = x;
			while(xlevel>0){
				int count = 1;
				int last = 0;
				for(int i=1;i<n;i++){
					if(arr[i] - arr[last] >= x){
						count++;
						last = i;
					} 
				}
				xlevel /= 2;
				if(count>=k) x += xlevel;
				else x -= xlevel;
				if(xlevel==1) break;
			}
			int count = 1;
			int last = 0;
			for(int i=1;i<n;i++){
				if(arr[i] - arr[last] >= x){
					count++;
					last = i;
				} 
			}
			if(count<k) x -= 1;
			sb.append(x+"\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
