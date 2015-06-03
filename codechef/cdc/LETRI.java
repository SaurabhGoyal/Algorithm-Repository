package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LETRI {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int[] recur = new int[]{1, 1, 6, 1, 3, 6, 1, 3, 2, 1};
		// found using commented part in main()
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			long a = Long.parseLong(ip[0]);
			long b = Long.parseLong(ip[1]);
			long c = Long.parseLong(ip[2]);
			long p = Long.parseLong(ip[3]);
			a = sod(a);
			b = b % recur[(int)a];
			long fab = sod((long)Math.pow(a, b));
			long nom = (fab+p) / c;
			long smaller = 0;
			long ans = 0;
			for(int i=1;i<=nom;i++){
				 if(i<=2)
			}
			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
//		for (int i = 2; i < 10; i++) {
//			System.out.print("i : " + i + "   => ");
//			for (int j = 1; j < 10; j++) {
//				int pow = (int) Math.pow(i, j);
//				int sod = sod(pow);
//				System.out.print(sod+", ");
//			}
//			System.out.println();
//		}
	}
	
	private static long phi(long n){
		
	}

	private static long sod(long x) {
		long s = 0;

		while (x > 0)

		{

			s = s + x % 10;

			x = x / 10;

		}

		if (s > 9)

			s = sod(s);

		return s;
	}
}
