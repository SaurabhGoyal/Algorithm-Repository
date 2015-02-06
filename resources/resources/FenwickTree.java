package resources;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FenwickTree {

	public long[] tree;
	public int n;

	public FenwickTree(long[] arr, int size) {
		n = size;
		tree = new long[n + 1];
		tree[0] = 0;
		for(int i=1;i<=n;i++) tree[i] = tree[i-1]+arr[i-1];
	}
	
	public long getSum(int index){
		long sum = 0;
		while(index>0){
			sum += tree[index];
			index -= (index&(-index));
		}
		return sum;
	}
	
	public void update(int index, long addition){
		while(index<=n){
			tree[index] += addition;
			index += (index&(-index));
		}
	}
	
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			Arrays.fill(arr, 0);
			FenwickTree ft = new FenwickTree(arr, n);
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int index = Integer.parseInt(ip[i]);
				sb.append(index-ft.getSum(index)+" ");
				ft.update(index, 1);
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
//		int index = 23;
//		while(index < 43){
//			System.out.println(String.format("index is %d",index));
//			System.out.println(String.format("index : %s , -index : %s , AND : %s(%d)",Integer.toBinaryString(index),Integer.toBinaryString(-index), Integer.toBinaryString(index&-index), (index&-index)));
//			index += (index&(-index));
//			System.out.println(String.format("final-index : "+index));
//		}
		
	}

}
