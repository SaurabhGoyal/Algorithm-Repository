package pe;
import java.util.Arrays;

public class Problem21 {

	public static int sumOfDivisors(int num) {
		int sumOfDivisors = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				sumOfDivisors += i;
		}
		return sumOfDivisors;
	}

	public static void main(String[] args) throws Exception {
		// solve();
		int range = 10000;
		int[] sod = new int[range + 1];
		boolean[] ami = new boolean[range + 1];
		Arrays.fill(ami, false);
		for (int i = 1; i <= range; i++) {
			sod[i] = sumOfDivisors(i);
		}
		for (int i = 1; i <= range; i++) {
			if (sod[i] <= range && sod[sod[i]] == i && i != sod[i]) {
				System.out.println("ami pairs are " + sod[i] + " and " + i);
				ami[i] = true;
				ami[sod[i]] = true;
			}
		}
		long sum = 0;
		for (int i = 1; i <= range; i++) {
			if (ami[i])
				sum += i;
		}
		System.out.println(sum);
	}
}
