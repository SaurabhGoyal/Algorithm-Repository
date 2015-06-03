package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Frmq {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		//int t = 1;
		while (t-- > 0) {
			System.err.println(String.format("=====Case: ====================="));
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			long ans = 0;
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			SegmentTree st = new SegmentTree(arr, n);
			ip = br.readLine().split(" ");
			int m = Integer.parseInt(ip[0]);
			int x = Integer.parseInt(ip[1]);
			int y = Integer.parseInt(ip[2]);
			int ix = x, iy = y;
			int x1 = Math.min(x, y);
			int y1 = Math.max(x, y);
			ans += st.get(x1, y1);
			for (int i = 0; i < m-1; i++) {
				x = (x + 7) % (n - 1);
				y = (y + 11) % n;
				if(x == ix && y == iy) System.out.println(String.format("Repeat Start at m : %d",i));
				x1 = Math.min(x, y);
				y1 = Math.max(x, y);
				ans += st.get(x1, y1);
			}
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		//solve();
		for(int i=100000;i<=100000;i++){
			int n = i;
			int x = 0, y = n/2;
			int ix = x, iy = y;
			int c = 0;
			while(true){
				x = (x + 7) % (n - 1);
				y = (y + 11) % n;
				c++;
				if(x == ix && y == iy){
					System.out.println(String.format("i : %d => c : %d",i,c));
					break;
				} 
			}
		}
	}

}

class SegmentTree {
	int n;
	long[] treeArray;

	SegmentTree(long[] array, int length) {
		n = length;
		buildSegTree(array);
	}

	public long get(int low, int high) {
		return findNode(low, high);
	}

	private void buildSegTree(long[] array) {
		int size;
		size = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		size = 2 * (int) Math.pow(2, size) - 1;
		treeArray = new long[size];
		buildSegTreeUtil(array, 0, n - 1, 0);
	}

	private long buildSegTreeUtil(long[] array, int low, int high, int index) {
		if (low == high) {
			treeArray[index] = array[low];
			return treeArray[index];
		}
		int mid = low + (high - low) / 2;
		long left = buildSegTreeUtil(array, low, mid, 2 * index + 1);
		long right = buildSegTreeUtil(array, mid + 1, high, 2 * index + 2);
		treeArray[index] = Math.max(left, right);
		return treeArray[index];
	}

	private long findNode(int low, int high) {
		if (low >= 0 && high < n)
			return findNodeUtil(0, n - 1, low, high, 0);
		return Long.MIN_VALUE;
	}

	private long findNodeUtil(int nodeL, int nodeR, int low, int high, int index) {
		if (nodeL >= low && nodeR <= high)
			return treeArray[index];
		else if (nodeL > high || nodeR < low)
			return Long.MIN_VALUE;
		int mid = nodeL + (nodeR - nodeL) / 2;
		long left = findNodeUtil(nodeL, mid, low, high, 2 * index + 1);
		long right = findNodeUtil(mid + 1, nodeR, low, high, 2 * index + 2);
		return Math.max(left, right);
	}
}
