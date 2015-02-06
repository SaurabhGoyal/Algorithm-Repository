package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Disubstr {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			long ans = nods(str);
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	private static long nods(String str) {
		int n = str.length();
		String[] substr = new String[n];
		for(int i=0;i<n;i++){
			substr[i] = str.substring(i);
		}
		Arrays.sort(substr);
		int nods = substr[0].length();
		for(int i=1;i<n;i++){
			nods += substr[i].length() - lcp(substr[i], substr[i-1]);
		}
		return nods;
	}

	private static int lcp(String string1, String string2) {
		// TODO Auto-generated method stub
		int len = Math.min(string1.length(), string2.length());
		int lcp = 0;
		while(lcp<len && string1.charAt(lcp) == string2.charAt(lcp)){
			lcp++;
		}
		return lcp;
	}
	
	public static void main(String[] args) throws Exception {
		solve();
		
	}

}
