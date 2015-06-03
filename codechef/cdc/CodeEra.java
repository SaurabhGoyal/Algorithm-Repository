package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CodeEra {

	// public static void solve() throws Exception {
	// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// StringBuilder sb = new StringBuilder();
	// int t = Integer.parseInt(br.readLine());
	// // int t = 1;
	// while (t-- > 0) {
	// char[] str = br.readLine().toCharArray();
	// int n = str.length;
	// int acost = Integer.parseInt(br.readLine().trim());
	// int bcost = Integer.parseInt(br.readLine().trim());
	// int cost = 0;
	// boolean ok = true;
	// for (int i = 0; i < n / 2; i++) {
	// if (str[i] == '/' && str[n - i - 1] == '/') {
	// cost += 2 * Math.min(acost, bcost);
	// } else if (str[i] == '/') {
	// if (str[n - i - 1] == 'b')
	// cost += bcost;
	// else
	// cost += acost;
	// } else if (str[n - i - 1] == '/') {
	// if (str[i] == 'b')
	// cost += bcost;
	// else
	// cost += acost;
	// } else if (str[i] != str[n - i - 1]) {
	// ok = false;
	// break;
	// }
	// // System.out.println(String.format("cost : %d",cost));
	// }
	// if (ok)
	// sb.append(cost).append("\n");
	// else
	// sb.append("-1\n");
	// }
	// System.out.print(sb.toString());
	// }

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			long s = Long.parseLong(ip[1]);
			long e = Long.parseLong(ip[2]);
			Node[] arr = new Node[n];
			for (int i = 0; i < n; i++) {
				ip = br.readLine().split(" ");
				long x = Long.parseLong(ip[0]);
				long p = Long.parseLong(ip[1]);
				arr[i] = new Node(x, p);
			}
			Arrays.sort(arr);
			long ans = 0, last = 0;
			for(int i=0;i<n;i++){
				if(i==0) last = 0;
				ans += getOverlap(s, e, last, Math.max(0,arr[i].x-arr[i].p));
				last = arr[i].x + arr[i].p;
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static long getOverlap(long s1, long e1, long s2, long e2){
		if(s2>=e2) return 0;
		if(e1<=s2 || e2<=s1) return 0;
		return Math.min(e1, e2) - Math.max(s1, s2);
	}

	public static class Node implements Comparable<Node> {
		long x, p;

		Node(long x, long p) {
			this.x = x;
			this.p = p;
		}

		public int compareTo(Node o) {
			if (this.x < o.x)
				return 1;
			if (this.x > o.x)
				return -1;
			return 0;
		}
	}

	// public static BigInteger operate(BigInteger op1, BigInteger op2, int op)
	// {
	// if (op == 0)
	// return op1.add(op2);
	// if (op == 1)
	// return op1.subtract(op2);
	// if (op == 2)
	// return op1.multiply(op2);
	// return null;
	// }

	public static void main(String[] args) throws Exception {
		solve();
	}
}
