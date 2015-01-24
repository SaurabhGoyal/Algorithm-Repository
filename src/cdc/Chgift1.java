package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chgift1 {
	public void solve() throws java.lang.Exception {
		StringBuilder op = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = new int[n];
			long[] minvalue = new long[n];
			String[] str = br.readLine().split(" ");
			nums[0]=Integer.parseInt(str[0]);
			minvalue[0]=nums[0];
			for (int i = 1; i < n; i++) {
				nums[i]=Integer.parseInt(str[i]);
				minvalue[i]=getmin(minvalue[i-1]+nums[i],minvalue[i-1]-nums[i],minvalue[i-1]*nums[i]);
			}
			op.append(minvalue[n-1]+"\n");
		}
		System.out.println(op.toString());
	}

	private long getmin(long l, long m, long n) {
		return l<m?l<n?l:n:m<n?m:n;
	}

	public static void main(String[] args) throws java.lang.Exception {
		new Chgift1().solve();
	}
}