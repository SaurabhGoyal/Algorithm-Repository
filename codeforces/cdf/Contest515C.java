package cdf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest515C {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long oldNum = Long.parseLong(br.readLine());
			String num = oldNum + "";
			StringBuilder ans = new StringBuilder("");
			n = num.length();
			int[] freq = new int[10];
			for(int i=0;i<n;i++){
				int dig = num.charAt(i)-'0';
				for(int j=2;j<=dig;j++){
					if(j%3==0){
						switch(j){
							case 3: freq[j]++; break;
							case 6: freq[2]++; freq[3]++; break;
							case 9: freq[3]+=2; break;
						}
					}
					else if(j%2==0){
						switch(j){
							case 2: freq[j]++; break;
							case 4: freq[2]+=2; break;
							case 8: freq[2]+=3; break;
						}
					}
					else freq[j]++;
				}
			}
			boolean ok = true;
			for(int i=3;i<=9;i++){
				//System.out.println(String.format("freq[%d] : %d",i,freq[i]));
				if(freq[i]>freq[i-1]){
					ok = false;
					break;
				} 
			}
			if(ok){
				for(int i=2;i<=8;i++){
					freq[i] -= freq[i+1];
				}
				for(int i=9;i>1;i--){
					while(freq[i]-->0){
						ans.append(i);
					}
				}
				long newNum = Long.parseLong(ans.toString());
				if(newNum>oldNum) sb.append(newNum).append("\n");
				else sb.append(oldNum).append("\n"); 
			}
			else sb.append(oldNum).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
