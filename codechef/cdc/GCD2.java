package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class GCD2 {
	
	public static long bigMod(String a, long b){
		//returns a%b;
		int len = a.length();
		long mod = (a.charAt(0)-'0')%b;
		for(int i=1;i<len;i++){
			mod = (mod*10+(a.charAt(i)-'0'))%b;
		}
		return mod;
	}
	
	public static long getGCD(long a, long b) {
		while (b != 0) {
			long t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long ans = 0;
			long a = Long.parseLong(ip[0]);
			String b = ip[1];
			if(a==0 || "0".equals(b)) ans = 0;
			else{
				long bl = bigMod(b, a);
				ans = getGCD(a, bl);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
