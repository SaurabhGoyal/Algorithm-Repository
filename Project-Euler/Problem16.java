
public class Problem16 {
	
	public static long getSumOfDigitsInPower(int base, int exp) {
		if (exp == 0)
			return 1;
		if (exp == 1)
			return base;
		int size = (int) Math.ceil(exp * Math.log10(base));
		int[] digits = new int[size];
		digits[0] = base;
		for (int i = 1; i < exp; i++) {
			int carry = 0;
			for (int j = 0; j < digits.length; j++) {
				int product = (digits[j] * base) + carry;
				digits[j] = product % 10;
				carry = product / 10;
			}
		}
		long sum = 0;
		for (int digit : digits)
			sum += digit;
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		//solve();
		System.out.println(String.format("%d",getSumOfDigitsInPower(2, 1000)));
	}

}
