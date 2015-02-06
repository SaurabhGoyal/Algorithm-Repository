package resources;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph {

	int numOfVertices, numOfEdges;
	Map<Integer, LinkedList<Integer>> adjListMap;

	Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjListMap = new HashMap<Integer, LinkedList<Integer>>();
		for (int i = 1; i <= numOfVertices; i++) {
			adjListMap.put(i, new LinkedList<Integer>());
		}
	}

	public void addEdge(int firstVertex, int secondVertex) {
		adjListMap.get(firstVertex).add(secondVertex);
		adjListMap.get(secondVertex).add(firstVertex);
		numOfEdges++;
	}

	public void removeEdge(int firstVertex, int secondVertex) {
		adjListMap.get(firstVertex).remove(secondVertex);
		adjListMap.get(secondVertex).remove(firstVertex);
		numOfEdges--;
	}

	public void printGraph() {
		for (int i = 1; i <= numOfVertices; i++) {
			System.out.println("Node " + (i) + " -> ");
			Iterator<Integer> it = adjListMap.get(i).iterator();
			while (it.hasNext()) {
				System.out.println(it.next() + " ");
			}
		}
	}

	public void bfs(int source) {
		int[] distance = new int[numOfVertices + 1];
		for (int i = 1; i <= numOfVertices; i++)
			distance[i] = -1;
		distance[source] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int tempSource = queue.poll();
			for (int adjVertex : adjListMap.get(tempSource)) {
				if (distance[adjVertex] == -1) {
					distance[adjVertex] = distance[tempSource] + 1;
					queue.add(adjVertex);
				}
			}
		}
	}

	public void dfs(int source) {
		boolean[] isVisited = new boolean[numOfVertices + 1];
		for (int i = 1; i <= numOfVertices; i++)
			isVisited[i] = false;
		dfsVisit(source, isVisited);
	}

	private void dfsVisit(int tempSource, boolean[] isVisited) {
		System.out.println("visiting "+tempSource);
		isVisited[tempSource] = true;
		for (int adjVertex : adjListMap.get(tempSource)) {
			if (!isVisited[adjVertex])
				dfsVisit(adjVertex, isVisited);
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(5);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 4);
		g.printGraph();
		g.dfs(1);
	}

}

class MyTree extends Graph {
	boolean[] isSafe;
	int[] parent;

	MyTree(int v) {
		super(v);
		isSafe = new boolean[numOfVertices + 1];
		for (int i = 1; i <= numOfVertices; i++)
			isSafe[i] = false;
		parent = new int[numOfVertices + 1];
	}

	public int[] bfsIfGraphIsTree(int source) {
		int[] distance = new int[numOfVertices + 1];
		for (int i = 1; i <= numOfVertices; i++)
			distance[i] = -1;
		distance[source] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		while (!queue.isEmpty()) {
			int tempSource = queue.poll();
			for (int adjVertex : adjListMap.get(tempSource)) {
				parent[adjVertex] = tempSource;
				if (distance[adjVertex] == -1) {
					distance[adjVertex] = distance[tempSource] + 1;
					queue.add(adjVertex);
				}
			}
		}
		return distance;
	}
	
}

/*
 * 
 * Safety pig _ _._ _..._ .-', _.._(`)) '-. ` ' /-._.-' ',/ ) \ '. / _ _ | \ | a
 * a / | \ .-. ; '-('' ).-' ,' ; '-; | .' \ \ / | 7 .__ _.-\ \ | | | ``/ /` /
 * /,_| | /,_/ / /,_/ '`-'
 */
