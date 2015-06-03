package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

class Chefck {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long mod = 1000000007;
		String[] ip = br.readLine().split(" ");
		int n = Integer.parseInt(ip[0]);
		int k = Integer.parseInt(ip[1]);
		int q = Integer.parseInt(ip[2]);
		long[] arr = new long[n + 1];
		long a, b, c, d, e, f, r, s, t, m;
		ip = br.readLine().split(" ");
		a = Long.parseLong(ip[0]);
		b = Long.parseLong(ip[1]);
		c = Long.parseLong(ip[2]);
		d = Long.parseLong(ip[3]);
		e = Long.parseLong(ip[4]);
		f = Long.parseLong(ip[5]);
		r = Long.parseLong(ip[6]);
		s = Long.parseLong(ip[7]);
		t = Long.parseLong(ip[8]);
		m = Long.parseLong(ip[9]);
		arr[1] = Long.parseLong(ip[10]) % m;
		a %= m;
		b %= m;
		c %= m;
		d %= m;
		e %= m;
		f %= m;
		long tPowXModS = t % s;
		for (int x = 2; x <= n; x++) {
			tPowXModS = (tPowXModS * t % s) % s;
			if (tPowXModS <= r) {
				long square = (arr[x - 1] * arr[x - 1]) % m;
				long first = (a * square) % m;
				long second = (b * arr[x - 1]) % m;
				long third = c;
				arr[x] = (first + second + third) % m;
			} else {
				long square = (arr[x - 1] * arr[x - 1]) % m;
				long first = (d * square) % m;
				long second = (e * arr[x - 1]) % m;
				long third = f;
				arr[x] = (first + second + third) % m;
			}
		}
		//SegmentTreeMin st = new SegmentTreeMin(arr, n + 1);
		RmqSparseTable st = new RmqSparseTable(arr);
		long l1, la, lc, lm, d1, da, dc, dm;
		ip = br.readLine().split(" ");
		l1 = Long.parseLong(ip[0]);
		la = Long.parseLong(ip[1]);
		lc = Long.parseLong(ip[2]);
		lm = Long.parseLong(ip[3]);
		d1 = Long.parseLong(ip[4]);
		da = Long.parseLong(ip[5]);
		dc = Long.parseLong(ip[6]);
		dm = Long.parseLong(ip[7]);
		l1 %= lm;
		la %= lm;
		lc %= lm;
		d1 %= dm;
		da %= dm;
		dc %= dm;
		long sum = 0, prod = 1;
		int range = 100000000;
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 1; i <= q; i++) {
			l1 = ((la * l1) % lm + lc) % lm;
			d1 = ((da * d1) % dm + dc) % dm;
			long L = l1 + 1;
			long R = Math.min(L + k - 1 + d1, n);
			Long quality = map.get(L * range + R);
			if (quality == null) {
				quality = arr[st.minPos((int) L, (int) R)];
				map.put(L * range + R, quality);
			}
			sum += quality;
			prod = (prod * quality) % mod;
		}
		sb.append(sum).append(" ").append(prod).append("\n");
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();

	}

}

class SegmentTreeMin {
	int n;
	long[] treeArray;

	SegmentTreeMin(long[] array, int length) {
		n = length;
		buildSegTree(array);
	}

	private void buildSegTree(long[] array) {
		int size;
		size = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		size = 2 * (int) Math.pow(2, size) - 1;
		treeArray = new long[size];
		buildSegTreeUtil(array, 0, n - 1, 0);
	}

	private void buildSegTreeUtil(long[] array, int low, int high, int index) {
		if (low == high) {
			treeArray[index] = array[low];
			return;
		}
		int mid = low + (high - low) / 2;
		buildSegTreeUtil(array, low, mid, 2 * index + 1);
		buildSegTreeUtil(array, mid + 1, high, 2 * index + 2);
		treeArray[index] = Math.min(treeArray[2*index+1], treeArray[2*index+2]);
	}

	public long findNode(int low, int high) {
		if (low >= 0 && high < n)
			return findNodeUtil(0, n - 1, low, high, 0);
		return Long.MAX_VALUE;
	}

	private long findNodeUtil(int nodeL, int nodeR, int low, int high, int index) {
		if (nodeL >= low && nodeR <= high)
			return treeArray[index];
		else if (nodeL > high || nodeR < low)
			return Long.MAX_VALUE;
		int mid = nodeL + (nodeR - nodeL) / 2;
		long left = findNodeUtil(nodeL, mid, low, high, 2 * index + 1);
		long right = findNodeUtil(mid + 1, nodeR, low, high, 2 * index + 2);
		return Math.min(left, right);
	}
}

class RmqSparseTable {

	int[] logTable;
	int[][] rmq;
	long[] a;

	public RmqSparseTable(long[] a) {
		this.a = a;
		int n = a.length;

		logTable = new int[n + 1];
		for (int i = 2; i <= n; i++)
			logTable[i] = logTable[i >> 1] + 1;

		rmq = new int[logTable[n] + 1][n];

		for (int i = 0; i < n; ++i)
			rmq[0][i] = i;

		for (int k = 1; (1 << k) < n; ++k) {
			for (int i = 0; i + (1 << k) <= n; i++) {
				int x = rmq[k - 1][i];
				int y = rmq[k - 1][i + (1 << k - 1)];
				rmq[k][i] = a[x] <= a[y] ? x : y;
			}
		}
	}

	public int minPos(int i, int j) {
		int k = logTable[j - i];
		int x = rmq[k][i];
		int y = rmq[k][j - (1 << k) + 1];
		return a[x] <= a[y] ? x : y;
	}

//	public static void main(String[] args) {
//		int[] a = { 1, 5, -2, 3 };
//		RmqSparseTable st = new RmqSparseTable(a);
//		System.out.println(2 == st.minPos(0, 3));
//	}

}

