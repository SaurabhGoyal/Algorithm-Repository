package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PPerm {

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

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int range = 5000000;
		boolean[] sieve = getSieve(range);
		int[] primes = new int[range + 1];
		primes[1] = 0;
		primes[2] = 1;
		for (int i = 3; i <= range; i++) {
			primes[i] = primes[i - 1];
			if (sieve[i])
				primes[i] += 1;
		}
		long mod = 1000000007;
		long[] pperm = new long[range+1];
		pperm[1] = 1;
		for(int i=2;i<=range;i++){
			pperm[i] = (1+primes[i]) * pperm[i-1];
			pperm[i] %= mod;
		}
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(pperm[n] + "\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}
}
