package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Contest {
	
	public static void print(int[][] freq,int n){
		System.out.println("   1  2  3  4  5  6");
		for(int i=0;i<26;i++){
			System.out.print((char)(i+'a'));
			for(int j=0;j<n;j++){
				System.out.print("  "+freq[j][i]);
			}
			System.out.println();
		}
		System.out.println();
	}
    
    public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1;
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			String[] ip=br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int q = Integer.parseInt(ip[1]);
			String str = br.readLine();
			int[][] freq = new int[n][26];
			for(int j=0;j<26;j++){
				freq[0][j] = 0;	
			}
			freq[0][str.charAt(0)-'a'] = 1;
			for(int i=1;i<n;i++){
				freq[i] = Arrays.copyOf(freq[i-1], 26);
				freq[i][str.charAt(i)-'a']++;
			}
			print(freq, n);
			for(int j=0;j<q;j++){
				ip=br.readLine().split(" ");
				int l = Integer.parseInt(ip[0]);
				int r = Integer.parseInt(ip[1]);
				int k = Integer.parseInt(ip[2]);
				if(k>(r-l+1)) sb.append("Out of range\n");
				else{
					int[] count = new int[26];
					int ck = 0;
					int i;
					for(i=0;i<26;i++){
						if(l>1) count[i] = freq[r-1][i]-freq[l-2][i];
						else count[i] = freq[r-1][i];
						sb.append(freq[r-1][i]+"-"+freq[l-2][i]+"="+count[i]+"\n");
						ck += count[i];
						if(ck >= k){
							break;
						}
					}
					sb.append("i is "+i+"\n");
					sb.append((char)(i+'a')+"\n");
				}
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}