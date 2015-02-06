package pe;
import java.util.Arrays;

public class Problem14 {

	public static int[] memo;
	public static int range;

	public static int getNOI(long n) throws Exception {
		// System.out.println("n is " + n + ", proceed?");
		// new BufferedReader(new InputStreamReader(System.in)).readLine();
		if (n == 1)
			return 1;
		if (n > range) {
			long next = 0;
			if (n % 2 == 0)
				next = n / 2;
			else
				next = 3 * n + 1;
			return (1 + getNOI(next));
		}
		int nint = (int) n;
		if (memo[nint] == -1) {
			long next = 0;
			if (n % 2 == 0)
				next = nint / 2;
			else
				next = 3 * nint + 1;
			memo[nint] = 1 + getNOI(next);
		}
		return memo[nint];
	}

	public static void main(String[] args) throws Exception {

		range = 1000000;
		memo = new int[range + 1];
		Arrays.fill(memo, -1);
		int max = Integer.MIN_VALUE;
		int maxi = 0;
		for (int i = range; i > 2; i--) {
			int noi = getNOI(i);
			// System.out.println(String.format("%d = %d", i, noi));
			if (noi > max) {
				max = noi;
				maxi = i;
			}
		}
		// System.out.println("noi : "+getNOI(999999));
		System.out.println(maxi);
	}
}
