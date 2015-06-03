import java.util.Arrays;


public class Contest {

	public static long[] getSOD(int range) {
		int i = 0;
		long[] sod = new long[range + 1];
		for (i = 1; i <= range; i++)
			sod[i] = 1;
		for (i = 2; i <= Math.sqrt(range); i++) {
			sod[i] += i;
			int j = i + i;
			while (j <= range) {
				sod[j] += i;
				if(j*j != i && j%i==0) sod[j] += i/j;
				j += i;
			}
		}
		return sod;
	}

	public static int getGCD(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static void solve() throws Exception {
		int range = 1000000;
		for (int i = 0; i < range; i++) {
			int sum = 0;
			if (i % 2 == 0) {
				for (int j = 1; j < i/2; j++) {
					if (i % j == 0)
						sum += j;
				}
				if(sum == 0 || sum == i) System.out.println(String.format("%d : %d", i, sum));
			}
		}
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
