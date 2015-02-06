package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CPAL {
	
	public static boolean isPalindrome(int h, int m, int s){
		int srev = (s%10)*10+(s/10);
		if(srev == h) if(m == 0 || m==11 || m==22 || m==33 || m==44 || m==55) return true;
		return false;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long[] palin = new long[86400];
		int h = 0, m=0, s = 1;
		palin[0] = 1;
		for(int i=1;i<86400;i++){
			palin[i] = palin[i-1];
			int time = h*3600 + m*60 + s;
			if(isPalindrome(h,m,s)) palin[i] += 1;
			s++;
			if(s==60){
				s = 0;
				m++;
			}
			if(m==60){
				m = 0;
				h++;
			}
		}
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			String[] t1 = ip[0].split(":");
			String[] t2 = ip[1].split(":");
			int h1 = Integer.parseInt(t1[0]);
			int m1 = Integer.parseInt(t1[1]);
			int s1 = Integer.parseInt(t1[2]);
			int time1 = h1*3600 + m1*60 + s1;
			int h2 = Integer.parseInt(t2[0]);
			int m2 = Integer.parseInt(t2[1]);
			int s2 = Integer.parseInt(t2[2]);
			int time2 = h2*3600 + m2*60 + s2;
			//System.out.println(isPalindrome(0, 0, 1));
			if(time1==0) ans = palin[time2];
			else ans = palin[time2]-palin[time1-1];
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
