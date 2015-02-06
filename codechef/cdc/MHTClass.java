package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MHTClass {
	
	public static void print(long[][] dp, int n){
		System.out.println("================dp===============");
		for(int i=0;i<26;i++){
			for(int j=0;j<n;j++){
				System.out.print(dp[j][i]+" ");
			}
			System.out.println();
		}
		System.out.println("=================================");
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		long mod = 1000000007;
		while (t-- > 0) {
			String str = br.readLine();
			int d = Integer.parseInt(br.readLine());
			int n = str.length();
			long[][] dp = new long[n][26];
			char firstChar = str.charAt(0); 
			if(firstChar =='.'){
				for(int i=0;i<26;i++){
					dp[0][i] = 1;
				}
			}
			else dp[0][firstChar-'a'] = 1;
			for(int i=1;i<n;i++){
				char c = str.charAt(i);
				if(c == '.'){
					for(int j=0;j<26;j++){
						for(int k=0;k<26;k++){
							if(Math.abs(j-k)<=d){
								dp[i][j] += dp[i-1][k];
							}
							dp[i][j] %= mod;
						}
					}
				}
				else{
					for(int j=0;j<26;j++){
						if(Math.abs(c-'a'-j)<=d) dp[i][c-'a'] += dp[i-1][j];
					} 
					dp[i][c-'a'] %= mod;
				}
			}
			long ans = 0;
			for(int i=0;i<26;i++){
				ans += dp[n-1][i];
			}
			ans %= mod;
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
