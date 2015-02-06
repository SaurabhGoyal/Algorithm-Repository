package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PT07Y {

	public static Map<Integer, List<Integer>> adjList;
	public static boolean[] visited;
	public static int count;
	public static boolean isTree;

	public static boolean dfs(Integer source) {
		if(!isTree) return false;
		visited[source] = true;
		count++;
		List<Integer> adjacents = adjList.get(source);
		int alreadyVisited = 0;
		for (Integer adjacent : adjacents) {
			if (!visited[adjacent])
				dfs(adjacent);
			else alreadyVisited++;
			if(alreadyVisited>1) isTree = false;
		}
		return isTree;
	}


	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			if(m!=n-1){
				sb.append("NO\n");
				continue;
			}
			adjList = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < n - 1; i++) {
				ip = br.readLine().split(" ");
				int a = Integer.parseInt(ip[0]);
				int b = Integer.parseInt(ip[1]);
				List<Integer> listA = null;
				if (adjList.get(a) == null)
					listA = new ArrayList<Integer>();
				else
					listA = adjList.get(a);
				listA.add(b);
				adjList.put(a, listA);
				List<Integer> listB = null;
				if (adjList.get(b) == null)
					listB = new ArrayList<Integer>();
				else
					listB = adjList.get(b);
				listB.add(a);
				adjList.put(b, listB);
			}
			visited = new boolean[n+1];
			isTree = true;
			count = 0;
			if(dfs(1)) if(count==n) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();
	}

}
