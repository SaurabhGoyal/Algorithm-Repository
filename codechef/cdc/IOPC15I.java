package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOPC15I {
	
	public static long mod = 1000000007;
	public static long[] fib;
	public static int n;
	
	public static long[] getFib(int range){
		long[] fib = new long[range+1];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2;i<=range;i++){
			fib[i] = fib[i-1] + fib[i-2];
			fib[i] %= mod;
		}
		return fib;
	}
	
	public static void update(long[] bit, int i, int d){
		int fi = i;
		while(i<=n){
			long add = fib[Math.max(0, d-(i-fi))]; 
			bit[i] += add;
			System.out.println(String.format("adding %d to bit[%d]",add,i));
			i += (i & (-i));
		}
	}
	
	public static long get(long[] bit, int i){
		long sum = 0;
		while(i>0){
			sum += bit[i];
			sum %= mod;
			i -= (i & (-i));
		}
		return sum;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int range = 100000;
		fib = getFib(range);
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			n = Integer.parseInt(ip[0]);
			long[] bit = new long[n+1];
			int q = Integer.parseInt(ip[1]);
			while(q-->0){
				ip = br.readLine().split(" ");
				int type = Integer.parseInt(ip[0]);
				if(type == 1){
					int x = Integer.parseInt(ip[1]);
					int d = Integer.parseInt(ip[2]);
					update(bit, x, d);
				}
				else{
					int x = Integer.parseInt(ip[1]);
					int y = Integer.parseInt(ip[2]);
					long ans = get(bit, y);
					if(x>1) ans -= get(bit, x-1);
					if(ans<0) ans += mod;
					sb.append(ans).append("\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
