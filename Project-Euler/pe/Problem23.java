package pe;
import java.util.Arrays;

public class Problem23 {

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
		int range = 28123;
		boolean[] isAbd = new boolean[range + 1];
		boolean[] isAbdPair = new boolean[range + 1];
		Arrays.fill(isAbd, false);
		for (int i = 1; i <= range; i++) {
			if (sumOfDivisors(i) > i)
				isAbd[i] = true;
		}
		for (int i = 1; i <= range; i++) {
			for (int j = 1; j <= range; j++) {
				if (isAbd[i] && isAbd[j] && i + j <= range) {
					isAbdPair[i + j] = true;
				}
			}
		}
		long sum = 0;
		for (int i = 1; i <= range; i++) {
			if (!isAbdPair[i])
				sum += i;
		}
		System.out.println(sum);
	}

}
