package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GSS3 {
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
			}
			SegmentTreeSum st = new SegmentTreeSum(arr, n);
			int m = Integer.parseInt(br.readLine());
			while(m-->0){
				ip = br.readLine().split(" ");
				int x = Integer.parseInt(ip[1]);
				int y = Integer.parseInt(ip[2]);
				if("0".equals(ip[0])){
					st.update(x-1, y);
				}
				else{
					SegmentTreeSum.Node node = st.get(x-1, y-1);
					sb.append(node.res).append("\n");
				}
			}
			
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
class SegmentTreeSum {
	int n;
	Node[] treeArray;
 
	class Node{
		long sum, pre, suf, res;
		
		@Override
		public String toString() {
			return "Node [sum=" + sum + ", pre=" + pre + ", suf=" + suf
					+ ", res=" + res + "]";
		}

		private void updateNode(Node left, Node right){
			if(left == null){
				this.sum = right.sum;
				this.pre = right.pre;
				this.suf = right.suf;
				this.res = right.res;
				return;
			}
			if(right == null){
				this.sum = left.sum;
				this.pre = left.pre;
				this.suf = left.suf;
				this.res = left.res;
				return;
			}
			this.sum = left.sum + right.sum;
			this.pre = Math.max(left.pre, left.sum + right.pre);
			this.suf = Math.max(right.suf, left.suf+right.sum);
			this.res = Math.max(left.suf+right.pre, Math.max(left.res, right.res));
		}
	}
 
	SegmentTreeSum(int[] arr, int length){
		n = length;
		buildSegTree(arr);
	}
 
	public Node get(int low, int high){
		return findNode(low, high);
	}
 
	public void update(int index, long newValue){
		updateValue(index, newValue);
	}
 
	private void buildSegTree(int[] arr) {
		int size;
		size = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		size = 2 * (int) Math.pow(2, size) - 1;
		treeArray = new Node[size];
		buildSegTreeUtil(arr, 0, n - 1, 0);
	}
 
	private Node buildSegTreeUtil(int[] arr, int low, int high, int index) {
		if (low == high) {
			treeArray[index] = new Node();
			treeArray[index].sum = arr[low];
			treeArray[index].pre = arr[low];
			treeArray[index].suf = arr[low];
			treeArray[index].res = arr[low];
			return treeArray[index];
		}
		int mid = low + (high - low) / 2;
		Node left = buildSegTreeUtil(arr, low, mid, 2 * index + 1);
		Node right = buildSegTreeUtil(arr, mid + 1, high, 2 * index + 2);
		treeArray[index] = new Node();
		treeArray[index].updateNode(left, right);
		return treeArray[index];
	}
 
	private Node findNode(int low, int high) {
		if (low >= 0 && high < n)
			return findNodeUtil(0, n - 1, low, high, 0);
		return null;
	}
 
	private Node findNodeUtil(int nodeL, int nodeR, int low, int high, int index) {
		if (nodeL >= low && nodeR <= high)
			return treeArray[index];
		else if (nodeL > high || nodeR < low)
			return null;
		int mid = nodeL + (nodeR - nodeL) / 2;
		Node left = findNodeUtil(nodeL, mid, low, high, 2 * index + 1);
		Node right = findNodeUtil(mid + 1, nodeR, low, high, 2 * index + 2);
		Node temp=new Node();
		temp.updateNode(left, right);
		System.out.println(String.format("Node[%d-%d] : %s",low,high,temp));
		return temp;
	}
 
	private void updateValue(int index, long newValue) {
		if (index < 0 || index > n - 1)
			return;
		updateValueUtil(0, n - 1, index, newValue, 0);
	}
 
	private Node updateValueUtil(int nodeL, int nodeR, int index,
			long newValue, int i) {
		if (index < nodeL || index > nodeR)
			return treeArray[i];
		if (nodeL != nodeR) {
			int mid = nodeL + (nodeR - nodeL) / 2;
			Node left = updateValueUtil(nodeL, mid, index, newValue, 2 * i + 1);
			Node right = updateValueUtil(mid + 1, nodeR, index, newValue, 2 * i + 2);
			treeArray[i].updateNode(left, right);
		}
		else{
			treeArray[i].sum = newValue;
			treeArray[i].pre = newValue;
			treeArray[i].suf = newValue;
			treeArray[i].res = newValue;
		}
		return treeArray[i]; 
	}
}
