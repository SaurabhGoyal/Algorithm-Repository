package resources;
class SegmentTree {
	int n;
	Node[] treeArray;
	private final Node nullNode;
 
	class Node{
		long sum, min, max;
		boolean isIncreasing, isDecreasing;
		public String toString(){
			StringBuffer sb= new StringBuffer("");
			sb.append("[ sum = "+sum+", min = "+min+", max = "+max+", isIncreasing = "+isIncreasing+", isDecreasing = "+isDecreasing+" ]");
			return sb.toString();
		}
		private void updateNode(Node left, Node right){
			this.sum = left.sum + right.sum;
			this.min = left.min < right.min ? left.min : right.min ;
			this.max = left.max > right.max ? left.max : right.max ;		
			this.isIncreasing = left.isIncreasing && right.isIncreasing && right.min>=left.max;
			this.isDecreasing = left.isDecreasing && right.isDecreasing && right.max<=left.min;
		}
	}
 
	SegmentTree(long[] array, int length){
		n = length;
		nullNode = new Node();
		nullNode.sum=0;
		nullNode.min=(1<<30);
		nullNode.max=-(1<<30);
		nullNode.isIncreasing = true;
		nullNode.isDecreasing = true;		
		buildSegTree(array);
	}
 
	public Node get(int low, int high){
		return findNode(low, high);
	}
 
	public void update(int index, long newValue){
		updateValue(index, newValue);
	}
 
	private void buildSegTree(long[] array) {
		int size;
		size = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		size = 2 * (int) Math.pow(2, size) - 1;
		treeArray = new Node[size];
		buildSegTreeUtil(array, 0, n - 1, 0);
	}
 
	private Node buildSegTreeUtil(long[] array, int low, int high, int index) {
		if (low == high) {
			treeArray[index] = new Node();
			treeArray[index].sum = array[low];
			treeArray[index].min = array[low];
			treeArray[index].max = array[low];
			treeArray[index].isIncreasing = true;
			treeArray[index].isDecreasing = true;
			return treeArray[index];
		}
		int mid = low + (high - low) / 2;
		Node left = buildSegTreeUtil(array, low, mid, 2 * index + 1);
		Node right = buildSegTreeUtil(array, mid + 1, high, 2 * index + 2);
		treeArray[index] = new Node();
		treeArray[index].updateNode(left, right);
		return treeArray[index];
	}
 
	private Node findNode(int low, int high) {
		if (low >= 0 && high < n)
			return findNodeUtil(0, n - 1, low, high, 0);
		return nullNode;
	}
 
	private Node findNodeUtil(int nodeL, int nodeR, int low, int high, int index) {
		if (nodeL >= low && nodeR <= high)
			return treeArray[index];
		else if (nodeL > high || nodeR < low)
			return nullNode;
		int mid = nodeL + (nodeR - nodeL) / 2;
		Node left = findNodeUtil(nodeL, mid, low, high, 2 * index + 1);
		Node right = findNodeUtil(mid + 1, nodeR, low, high, 2 * index + 2);
		Node temp=new Node();
		temp.updateNode(left, right);
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
			treeArray[i].min = newValue;
			treeArray[i].max = newValue;
			treeArray[i].isIncreasing = true;
			treeArray[i].isDecreasing = true;
		}
		return treeArray[i]; 
	}
}