package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeMap;

public class Chefgraph {

	public static long mod = 1000000007;
	public static long n;
	public static int m;

	public static long power(int base, long exp) {
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		long subPow = power(base, exp / 2);
		long res = (subPow * subPow) % mod;
		if (exp % 2 == 1)
			res = (res * base) % mod;
		return res;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			n = Long.parseLong(ip[0]);
			m = Integer.parseInt(ip[1]);
			int k = Integer.parseInt(ip[2]);
			TreeMap<Integer, Layer> map = new TreeMap<Integer, Layer>();
			for (int i = 0; i < k; i++) {
				ip = br.readLine().split(" ");
				long l1 = Long.parseLong(ip[0]);
				int p1 = Integer.parseInt(ip[1]);
				long l2 = Long.parseLong(ip[2]);
				int p2 = Integer.parseInt(ip[3]);
				Layer lyr1 = map.get(l1);
				if (lyr1 == null)
					lyr1 = new Layer(l1);
				Layer lyr2 = map.get(l2);
				if (lyr2 == null)
					lyr2 = new Layer(l2);
				Vertex pt1 = lyr1.map.get(p1);
				if (pt1 == null)
					pt1 = new Vertex(l1, p1);
				Vertex pt2 = lyr2.map.get(p2);
				if (pt2 == null)
					pt2 = new Vertex(l2, p2);
				pt1.otherEnds.add(pt2);
			}
		}
		System.out.print(sb.toString());
	}

	static class Layer implements Comparable<Layer> {
		long layerNum;
		long fromAll;
		long fromAllVerteces;
		long total;
		HashMap<Integer, Vertex> map;

		public Layer(long layerNum) {
			super();
			this.layerNum = layerNum;
		}

		@Override
		public int compareTo(Layer o) {
			if (this.layerNum < o.layerNum)
				return -1;
			if (this.layerNum > o.layerNum)
				return 1;
			return 0;
		}

	}

	static class Vertex {
		long layer;
		int point;
		List<Vertex> otherEnds;

		public Vertex(long layer, int point) {
			super();
			this.layer = layer;
			this.point = point;
			this.otherEnds = new ArrayList<Vertex>();
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
