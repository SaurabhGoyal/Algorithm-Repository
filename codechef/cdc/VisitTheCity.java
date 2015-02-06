package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitTheCity {

	public static Map<Integer, List<Integer>> adjList;
	public static boolean[] visited;
	public static int maxDepth;
	public static Integer farthestNode;

	public static void dfs(Integer source, int depth) {
		visited[source] = true;
		List<Integer> adjacents = adjList.get(source);
		for (Integer adjacent : adjacents) {
			if (!visited[adjacent])
				dfs(adjacent, depth + 1);
		}
		if (depth > maxDepth) {
			maxDepth = depth;
			farthestNode = source;
		}
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if (n <= 1) {
				sb.append("0\n");
				continue;
			}
			adjList = new HashMap<Integer, List<Integer>>();
			for (int i = 0; i < n - 1; i++) {
				String[] ip = br.readLine().split(" ");
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
			maxDepth = 0;
			farthestNode = 1;
			visited = new boolean[n + 1];
			dfs(1, 0);
			maxDepth = 0;
			visited = new boolean[n + 1];
			dfs(farthestNode, 0);
			sb.append(maxDepth + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
