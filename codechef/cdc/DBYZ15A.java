package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DBYZ15A {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		StringBuilder sb = new StringBuilder("");
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			String[] ip = br.readLine().split(" ");
			Set<Long> set = new HashSet<Long>();
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(ip[i]);
				set.add(arr[i]);
			}
			int n2 = set.size();
			long[] arr2 = new long[n2];
			Iterator<Long> it = set.iterator();
			int j=0;
			while(it.hasNext()){
				arr2[j++] = it.next();
			}
			Arrays.sort(arr2);
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			long ans = 0;
			for(int i=0;i<n2;i++){
				map.put(arr2[i], n2-i-1);
			}
			for(int i=0;i<n;i++){
				ans += map.get(arr[i]);
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}

}
