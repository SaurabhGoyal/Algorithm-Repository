package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 DO NOT REMOVE THIS COMMENT, OR THIS CODE WILL NOT WORK.
 */
public class FirstCube {

	public static boolean[] getSieve(int range) {
		int i = 0;
		boolean[] sieve = new boolean[range + 1];
		for (i = 0; i <= range; i++)
			sieve[i] = true;
		for (i = 2; i < Math.sqrt(range); i++) {
			if (sieve[i] == true) {
				int j = i + i;
				while (j <= range) {
					sieve[j] = false;
					j += i;
				}
			}
		}
		return sieve;
	}

	public static long mod = 1000000007;

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("");
		boolean[] sieve = getSieve(100007);
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			long[] a = new long[n];
			long s = 1;
			HashMap<Long, Integer> map = new HashMap<Long, Integer>();
			String[] ip = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				a[j] = Long.parseLong(ip[j]);
				a[j] %= mod;
				s = (s * a[j]) % mod;
			}
			long ans = s;
			//System.out.println(String.format("s after * is %d",s));
			for(int i=2;(i*i*i)<=s;i++){
				if(s % (i*i*i) == 0) s/= (i*i*i);
			}
			//System.out.println(String.format("s after cubes-removal is %d",s));
			for(int i=2;i<=Math.sqrt(s);i++){
				if(!sieve[i]) continue;
				int current = 0;
				if(s%i==0){
					current++;
					s /= i;
				}
				if(s%i==0){
					current++;
					s /= i;
				}
				Long iL = Long.valueOf(i);
				Integer freq = map.get(iL);
				if(freq!=null) map.put(iL, (freq+current)%3);
				else map.put(iL, current);
			}
			//System.out.println(String.format("s after primes is %d",s));
			if(s>1){
				Integer freq = map.get(s);
				if(freq!=null) map.put(s, (freq+1)%3);
				else map.put(s, 1);
			}
			for (Map.Entry<Long, Integer> entry : map.entrySet()) {
				long key = entry.getKey();
				int value = entry.getValue();
				//System.out.println(key + " : " + value);
				long reqd = 1;
				if (value == 1)
					reqd = key * key;
				else if (value == 2)
					reqd = key;
				ans = (ans * reqd) % mod;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}