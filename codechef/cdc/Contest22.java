package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contest22 {

	public static Map<Integer, List<Integer>> parentList, childrenList;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			int q = Integer.parseInt(ip[2]);
			long[] sum = new long[n + 1];
			long[] value = new long[n + 1];
			int[] parent = new int[n + 1];
			childrenList = new HashMap<Integer, List<Integer>>();
			for (int i = 1; i <= n; i++) {
				parent[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < m; i++) {
				String[] operation = br.readLine().split(" ");
				int x = Integer.parseInt(operation[1]);
				int y = Integer.parseInt(operation[2]);
				if ("ADD".equals(operation[0])) {
					value[x] += y;
					while(parent[x] != 0){
						sum[parent[x]] += y;
						x = parent[x];
					}
				} else {
					value[x] += y;
					int depth = 1;
					while(parent[x] != 0){
						value[parent[x]] += y;
						sum[parent[x]] += (y*depth);
						depth++;
						x = parent[x];
					}
				}
			}
			for (int i = 0; i < q; i++) {
				String[] query = br.readLine().split(" ");
				int x = Integer.parseInt(query[1]);
				if ("VAL".equals(query[0])) {
					sb.append(value[x]+"\n");
				} else {
					sb.append((sum[x]+value[x])+"\n");
				}
			}
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
