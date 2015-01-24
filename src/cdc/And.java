package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class And {

	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int k = 0;
		String[] nums=br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(nums[i]);
			int k1 = (int) Math.floor((double) Math.log(a[i])
					/ (double) Math.log(2)) + 1;
			k = k1 > k ? k1 : k;
		}
		long sum = 0;
		for (int i = 0; i < k; i++) {
			long numOfOne = 0;
			for (int j = 0; j < n; j++) {
				if (((a[j] >> i) & 1) == 1) numOfOne++;
			}
			sum += (long) ((numOfOne*(numOfOne-1))/2 * Math.pow(2, i));
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws java.lang.Exception {
		new And().solve();
	}
}
