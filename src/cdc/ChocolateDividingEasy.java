package cdc;

public class ChocolateDividingEasy {
	int[][] sum;
	int r, c;

	public int getSum(int i1, int j1, int i2, int j2) {
		if (i1 == 0 && j1 == 0)	return sum[i2][j2];
		else if (i1 == 0) return sum[i2][j2] - sum[i2][j1 - 1];
		else if (j1 == 0) return sum[i2][j2] - sum[i1 - 1][j2];
		else return sum[i2][j2] + sum[i1 - 1][j1 - 1]- (sum[i2][j1 - 1] + sum[i1 - 1][j2]);
	}

	public int getMin(int vert1, int vert2, int horiz1, int horiz2) {
		int min = 99999999, tempsum;
		tempsum = getSum(0, 0, horiz1 - 1, vert1 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(0, vert1, horiz1 - 1, vert2 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(0, vert2, horiz1 - 1, c - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz1, 0, horiz2 - 1, vert1 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz1, vert1, horiz2 - 1, vert2 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz1, vert2, horiz2 - 1, c - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz2, 0, r - 1, vert1 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz2, vert1, r - 1, vert2 - 1);
		min = min < tempsum ? min : tempsum;
		tempsum = getSum(horiz2, vert2, r - 1, c - 1);
		min = min < tempsum ? min : tempsum;
		return min;
	}

	public int findBest(String[] chocolate) {
		this.r = chocolate.length;
		this.c = chocolate[0].length();
		System.out.println("r and c are " + r + "," + c);
		sum = new int[r][c];
		sum[0][0] = chocolate[0].charAt(0) - '0';
		for (int i = 1; i < c; i++)
			sum[0][i] = sum[0][i - 1] + (chocolate[0].charAt(i) - '0');
		for (int i = 1; i < r; i++)
			sum[i][0] = sum[i - 1][0] + (chocolate[i].charAt(0) - '0');
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1]
						+ (chocolate[i].charAt(j) - '0');
			}
		}
		int max = -1;
		for (int i = 1; i < c; i++) {
			for (int j = i + 1; j < c; j++) {
				for (int k = 1; k < r; k++) {
					for (int l = k + 1; l < r; l++) {
//						System.out.println("h1 and h2 at " + k + "," + l
//								+ " ... v1 and v2 at " + i + "," + j);
						int minOfNine;
						minOfNine = getMin(i, j, k, l);
						System.out.println("minOfNine is " + minOfNine);
						if (minOfNine > max)
							max = minOfNine;
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] s) {
		System.out.println(new ChocolateDividingEasy().findBest(new String[] {
				"9768", "6767", "5313" }));
	}
}