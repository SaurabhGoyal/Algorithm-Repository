package cdc;

public class DP {

	public static int getMax(int[] arr) {
		int max = -1;
		for (int a : arr)
			if (a > max)
				max = a;
		return max;
	}

	public static int getMin(int[] arr) {
		int min = 9999999;
		for (int a : arr)
			if (a < min)
				min = a;
		return min;
	}

	public static int coinChange(int[] coins, int requiredSum) {
		int[] sum = new int[requiredSum + 1];
		String[] res = new String[requiredSum + 1];
		res[0] = "";
		sum[0] = 0;
		for (int i = 1; i <= requiredSum; i++) {
			sum[i] = 999999;
			for (int coin : coins) {
				if (coin <= i && sum[i - coin] + 1 < sum[i]) {
					sum[i] = sum[i - coin] + 1;
					res[i] = res[i - coin] + " " + coin;
				}
			}
			// System.out.println("res for "+i+" "+res[i]);
		}
		return sum[requiredSum];
	}

	public static int maxSumSubsequence(int[] arr) {
		int[] maxsum = new int[arr.length];
		maxsum[0] = arr[0];
		int max = -1, x = 0, y = 0;
		for (int i = 1; i < arr.length; i++) {
			maxsum[i] = getMax(new int[] { maxsum[i - 1] + arr[i], arr[i] });
			if (maxsum[i] == arr[i])
				x = i;
			if (maxsum[i] > max) {
				max = maxsum[i];
				y = i;
			}
		}
		// System.out.println("Maxsum is "+max+" from index "+x+" to "+y+" inclusive.");
		return max;
	}

	public static int rodCutting(int[] cuts, int[] profit, int length) {
		int[] maxProfit = new int[length + 1];
		maxProfit[0] = 0;
		maxProfit[1] = profit[0];
		for (int i = 2; i <= length; i++) {
			int max = -1;
			for (int j = 1; j <= i; j++)
				max = getMax(new int[] { maxProfit[i - j] + profit[j - 1], max });
			maxProfit[i] = max;
		}
		return maxProfit[length];
	}

	public static int longestNonDecreasingSubsequence(int[] arr) {
		return 0;
	}

	public static int minimumCost(int[][] costMatrix, int r, int c) {
		int[][] minCost = new int[r + 1][c + 1];
		minCost[0][0] = costMatrix[0][0];
		for (int i = 1; i <= r; i++)
			minCost[i][0] = minCost[i - 1][0] + costMatrix[i][0];
		for (int i = 1; i <= c; i++)
			minCost[0][i] = minCost[0][i - 1] + costMatrix[0][i];
		for (int i = 1; i <= r; i++)
			for (int j = 1; j <= c; j++)
				minCost[i][j] = getMin(new int[] { minCost[i - 1][j],
						minCost[i][j - 1], minCost[i - 1][j - 1] })
						+ costMatrix[i][j];
		return minCost[r][c];
	}

	public static void main(String[] args) {
		// System.out.println(coinChange(new int[] { 1, 3, 5 }, 11));
		// System.out.println(maxSumSubsequence(new int[] { 5, -6, 7, 12, -3, 0, -11, -6 }));
		// System.out.println(rodCutting(new int[]{1,2,3,4,5,6,7,8}, new int[]{1,5,8,9,10,17,17,20}, 8));
		// System.out.println(minimumCost(new int[][] { { 1, 2, 3 }, { 4, 8, 2 },{ 1, 5, 3 } },2,2));
	}
}
