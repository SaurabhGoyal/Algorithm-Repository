package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Devstr {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int k = Integer.parseInt(ip[1]);
			char[] str = br.readLine().trim().toCharArray();
			int ans = 0;
			if(k==1){
				int withZero = 0, withOne = 0;
				for(int i=0;i<n;i++){
					if(i%2==0){
						if(str[i]=='0') withOne++;
						else withZero++;
					}
					else{
						if(str[i]=='1') withOne++;
						else withZero++;
					}
				}
				ans = Math.min(withOne, withZero);
				char c = '0';
				if(ans==withOne) c = '1';
				for(int i=0;i<n;i++){
					str[i] = c;
					c = (char)('1'-c+'0');
				}
			}
			else{
				char c = str[0];
				int kd = 1, start = 0;
				for(int i=1;i<n;i++){
					if(str[i]==c){
						kd++;
					}
					else{
						if(kd>k){
							int nof = (int)Math.floor((double)kd/(double)(k+1));
							ans += nof;
							if(nof==1){
								str[start+(kd/2)] = str[i];
							}
							else{
								for(int j=1;j<=nof;j++){
									str[start+(j*k)] = str[i];
								}								
							}
						}
						c = str[i];
						kd = 1;
						start = i;
					}
				}				
			}
			sb.append(ans).append("\n").append(new String(str)).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
