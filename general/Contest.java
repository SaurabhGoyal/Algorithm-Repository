import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Contest {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int k = Integer.parseInt(ip[1]);
			String str = br.readLine();
			int len = str.length();
			int bestStart = -1;
			int start = 0;
			int count = 1;
			for (int i = 1; i < len; i++) {
				if(bestStart == -1){
					if(str.charAt(i)>=str.charAt(i-1)){
						count++;
					}
					else{
						start = i;
						count = 1;
					}
					if(count==k){
						bestStart = start;
						count = 0;
					}
				}
				else{
					if(count==0){
						start = i;
						if(str.charAt(i)<=str.charAt(bestStart)){
							count++;
						}
					}
					else{
						if(str.charAt(i)<=str.charAt(bestStart + i-start) && str.charAt(i)>= str.charAt(i-1)){
							count++;
						}
						else{
							count = 0;
						}
						if(count==k){
							bestStart = start;
							count = 0;
						}
					}
				}
			}
			if(bestStart!=-1) sb.append("Yes\n").append(str.substring(bestStart, bestStart+k)).append("\n");
			else sb.append("No\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
