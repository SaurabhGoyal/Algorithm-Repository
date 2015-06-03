import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class LargestString {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split(",");
			Arrays.sort(arr, new Comparator<String>() {
				public int compare(String a, String b) {
					return -1 * (a+b).compareTo(b+a);
				}
			});
			StringBuilder ans = new StringBuilder("");
			for(String s:arr){
				ans.append(s);
			}
			System.out.println(ans);
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
