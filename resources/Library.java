import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {

	public static final String longitudeLatitutdeRegex = "[(][+-]?(([0-8][0-9]([.][0-9]+)?)|(90([.][0]+)?)|([1-9]([.][0-9]+)?)), [+-]?(([0-9]{1,2}([.][0-9]+)?)|(1[0-7][0-9]([.][0-9]+)?)|(180([.][0]+)?))[)]";
	public static final String ip4byte = "((2[0-4][0-9])|(25[0-5])|(1[0-9]{2})|([0-9]{1,2}))";
	public static final String ip4pattern = ip4byte + "\\." + ip4byte + "\\."
			+ ip4byte + "\\." + ip4byte;
	public static final String ip6byte = "(([0-9]|[a-f]){0,4})";
	public static final String ip6pattern = ip6byte + ":" + ip6byte + ":"
			+ ip6byte + ":" + ip6byte + ":" + ip6byte + ":" + ip6byte + ":"
			+ ip6byte + ":" + ip6byte;
	public static final String nameRegex = "[a-zA-Z]+( [a-zA-Z]+)*";
	public static final String time24FormatRegex = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public static <T> String arrayToString(T[] arr) {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < arr.length; i++) {
			if (i != 0)
				sb.append(", ");
			sb.append(arr[i].toString());
		}
		sb.append(" ]");
		return sb.toString();
	}

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

	public static String add(String op1, String op2) {
		int op1Length = op1.length();
		int op2Length = op2.length();
		int smallerLength = op1Length < op2Length ? op1Length : op2Length;
		int largerLength = (op1Length + op2Length) - smallerLength;
		op1 = new StringBuffer(op1).reverse().toString();
		op2 = new StringBuffer(op2).reverse().toString();
		StringBuffer result = new StringBuffer();
		int carry = 0;
		int i;
		for (i = 0; i < smallerLength; i++) {
			int sum = (op1.charAt(i) - '0') + (op2.charAt(i) - '0') + carry;
			carry = sum / 10;
			result.append(sum % 10);
		}
		if (op1Length > op2Length) {
			while (i < largerLength) {
				int sum = (op1.charAt(i) - '0') + carry;
				carry = sum / 10;
				result.append(sum % 10);
				i++;
			}
		} else {
			while (i < largerLength) {
				int sum = (op2.charAt(i) - '0') + carry;
				carry = sum / 10;
				result.append(sum % 10);
				i++;
			}
		}
		while (carry > 0) {
			result.append(carry % 10);
			carry /= 10;
		}
		return result.reverse().toString();
	}

	public static String subtract(String op1, String op2) {
		int len1 = op1.length();
		int len2 = op2.length();
		int smallerLength = len1 < len2 ? len1 : len2;
		int largerLength = (len1 + len2) - smallerLength;
		op1 = new StringBuffer(op1).reverse().toString();
		op2 = new StringBuffer(op2).reverse().toString();
		String temp1 = "", temp2 = "";
		if (len1 > len2) {
			temp1 = op1;
			temp2 = op2;
		} else if (len1 < len2) {
			temp1 = op2;
			temp2 = op1;
		} else {
			int i;
			for (i = len1 - 1; i >= 0; i--) {
				if (op1.charAt(i) == op2.charAt(i))
					;
				else {
					if (op1.charAt(i) > op2.charAt(i)) {
						temp1 = op1;
						temp2 = op2;
					} else {
						temp1 = op2;
						temp2 = op1;
					}
					break;
				}
			}
			if (i == -1)
				return "0";
		}
		StringBuffer result = new StringBuffer();
		int borrow = 0;
		int i;
		for (i = 0; i < smallerLength; i++) {
			int difference = 0;
			int digit1 = (temp1.charAt(i) - '0');
			int digit2 = (temp2.charAt(i) - '0');
			if (borrow == 1) {
				if ((temp1.charAt(i) - '0') != 0) {
					digit1--;
					difference = digit1 - digit2;
					borrow = 0;
				} else {
					difference = 9 - digit2;
				}
			} else
				difference = digit1 - digit2;
			if (difference < 0) {
				borrow = 1;
				difference = digit1 + 10 - digit2;
			}
			result.append(difference);
		}
		while (i < largerLength) {
			int difference = 0;
			int digit1 = (temp1.charAt(i) - '0');
			if (borrow == 1) {
				if (digit1 != 0) {
					digit1--;
					difference = digit1;
					borrow = 0;
				} else {
					difference = 9;
				}
			} else
				difference = digit1;
			i++;
			result.append(difference);
		}
		int numOfTrailingZeroes = 0;
		for (int j = result.length() - 1; j >= 0; j--) {
			if (result.charAt(j) == '0')
				numOfTrailingZeroes++;
			else
				break;
		}
		result = new StringBuffer(result.substring(0, result.length()
				- numOfTrailingZeroes));
		if (temp1 == op2)
			result.append("-");
		return result.reverse().toString();
	}

	public static int partition(int arr[], int l, int r) {
		int x = arr[new Random().nextInt(r - l + 1) + l];
		int i = (l - 1);
		for (int j = l; j <= r - 1; j++) {
			if (arr[j] <= x) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[r];
		arr[r] = arr[i + 1];
		arr[i + 1] = temp;
		return (i + 1);
	}

	public static int kthOrder(int[] arr, int l, int r, int k) {
		if (l == r)
			return arr[l];
		int pivotIndex = partition(arr, l, r);
		int pivotRank = pivotIndex - l + 1;
		if (pivotRank == k)
			return arr[pivotIndex];
		if (pivotRank > k)
			return kthOrder(arr, l, pivotIndex - 1, k);
		else
			return kthOrder(arr, pivotIndex + 1, r, k - pivotRank);
	}

	public static void printMatrix(double[][] m) {
		int rows = m.length, cols = m[0].length;
		System.out.print("  ");
		for (int i = 0; i < 26; i++)
			System.out.print((char) ('a' + i) + "     ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print((char) ('a' + i) + " "
						+ String.format("%.2f", m[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public String longestCommonPrefix(String a, String b) {
		int minLength = Math.min(a.length(), b.length());
		for (int i = 0; i < minLength; i++) {
			if (a.charAt(i) != b.charAt(i)) {
				return a.substring(0, i);
			}
		}
		return a.substring(0, minLength);
	}

	public static double[][] powerMatrix(double[][] m, long exp) {
		if (exp == 1)
			return m;
		if (exp == 2)
			return matrixMultiplication(m, m);
		double[][] subMatrix = powerMatrix(m, exp / 2);
		double[][] result = matrixMultiplication(subMatrix, subMatrix);
		if (exp % 2 == 1)
			result = matrixMultiplication(result, m);
		return result;
	}

	public static double[][] matrixMultiplication(double[][] m1, double[][] m2) {
		if (m1[0].length != m2.length)
			return null;
		int rows = m1.length, cols = m2[0].length;
		double[][] result = new double[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				result[i][j] = 0;
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				for (int k = 0; k < m1[0].length; k++)
					result[i][j] += (m1[i][k] * m2[k][j]);
		return result;
	}

	public static void reverseArray(long[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			long temp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = temp;
		}
	}

	public static int getBitsCount(long num) {
		if (num == 0)
			return 0;
		int numOfBits = 1;
		while (num >> 1 != 0) {
			numOfBits++;
			num = num >> 1;
		}
		return (numOfBits);
	}

	public static int getSetBitsCount(long value) {
		int count = 0;
		while (value > 0) {
			if ((value & 1) == 1)
				count++;
			value >>= 1;
		}
		return count;
	}

	public static long powerWithMod(long num, long exp, long mod) {
		long result = 1;
		while (exp > 0) {
			if (exp % 2 == 1) {
				result = (result * num) % mod;
			}
			exp >>= 1;
			num = (num * num) % mod;
		}
		return result;
	}

	public static long getGCD(long a, long b) {
		while (b != 0) {
			long t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static long getNcr(long n, long r) {
		long ans = 1;
		r = r > n - r ? n - r : r;
		long j = 1;
		for (; j <= r; j++, n--) {
			if (n % j == 0)
				ans *= n / j;
			else if (ans % j == 0)
				ans = (ans / j) * n;
			else
				ans = (ans * n) / j;

		}
		return ans;
	}

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
				int product = (digits[i] * base) + carry;
				digits[i] = product % 10;
				carry = product / 10;
			}
		}
		long sum = 0;
		for (int digit : digits)
			sum += digit;
		return sum;
	}

	public static long numOfDigitsInFactorialN(int n) {
		if (n == 1)
			return 1;
		double numOfDigits = 0.0;
		for (int i = 1; i <= n; i++)
			numOfDigits += Math.log10((double) i);
		return (long) Math.ceil(numOfDigits);
	}

	public static long MooreVotingMajority(long[] arr, int n) {
		int current = 0, count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == arr[current])
				count++;
			else
				count--;
			if (count == 0) {
				current = i;
				count = 1;
			}
		}
		return arr[current];
	}

	public static String arrayToString(char[] arr) {
		StringBuffer sb = new StringBuffer();
		for (char c : arr)
			sb.append(c);
		return sb.toString();
	}

	public static String nextBig(char[] arr, int n){
		String big = "NO NXTBIG";
		int start = -1, end = -1;
		for(int i=0;i<n-1;i++){
			if(arr[i] < arr[i+1]){
				start = i;
			}
		}
		if(start != -1){
			for(int i=start+1;i<n;i++){
				if(arr[i] > arr[start]){
					end = i;
				}
			}
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			char[] first = Arrays.copyOfRange(arr, 0, start+1);
			char[] second = Arrays.copyOfRange(arr, start+1, n);
			Arrays.sort(second);
			big = arrayToString(first)+arrayToString(second);
		}
		return big;
	}


	public static String toCamelCase(String variableName) {
		StringBuffer res = new StringBuffer("");
		Pattern pattern = Pattern.compile("_.");
		Matcher matcher = pattern.matcher(variableName);
		int i = 0;
		while (matcher.find()) {
			i++;
			int end = matcher.end();
			char c = variableName.charAt(end - 1);
			c += 'A' - 'a';
			matcher.appendReplacement(res, c + "");
		}
		if (i == 0)
			return variableName;
		matcher.appendTail(res);
		return res.toString();
	}

	public static String toSnakeCase(String variableName) {
		StringBuffer res = new StringBuffer("");
		Pattern pattern = Pattern.compile("[a-z][A-Z]");
		Matcher matcher = pattern.matcher(variableName);
		int i = 0;
		while (matcher.find()) {
			i++;
			int end = matcher.end();
			char c1 = variableName.charAt(end - 2);
			char c2 = variableName.charAt(end - 1);
			c2 -= 'A' - 'a';
			matcher.appendReplacement(res, c1 + "_" + c2);
		}
		if (i == 0)
			return variableName;
		matcher.appendTail(res);
		return res.toString();
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

	public static Long knapsackZeroOne(int w, int[] wt, int[] profit, int n) {
		long[][] profitDP = new long[n + 1][w + 1];
		long[][] weightDP = new long[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				if (i == 0 || j == 0) {
					profitDP[i][j] = 0;
					weightDP[i][j] = 0;
				} else if (wt[i - 1] <= j) {
					profitDP[i][j] = Math.max(profitDP[i - 1][j - wt[i - 1]]
							+ profit[i - 1], profitDP[i - 1][j]);
					if (profitDP[i][j] == profitDP[i - 1][j])
						weightDP[i][j] = weightDP[i - 1][j];
					else
						weightDP[i][j] = weightDP[i - 1][j - wt[i - 1]]
								+ wt[i - 1];
				} else {
					profitDP[i][j] = profitDP[i - 1][j];
					weightDP[i][j] = weightDP[i - 1][j];
				}
			}
		}
		return profitDP[n][w];
	}

	public static Pair knapsackZeroOneWithLeastWeight(int w, Pair[] arr, int n) {
		Pair[][] dp = new Pair[n + 1][w + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= w; j++) {
				dp[i][j] = new Pair();
				if (i == 0 || j == 0) {
					dp[i][j].profit = 0;
					dp[i][j].wt = 0;
				} else if (arr[i - 1].wt <= j) {
					dp[i][j].profit = Math.max(
							dp[i - 1][j - arr[i - 1].wt].profit
									+ arr[i - 1].profit, dp[i - 1][j].profit);
					if (dp[i][j].profit == dp[i - 1][j].profit)
						dp[i][j].wt = dp[i - 1][j].wt;
					else
						dp[i][j].wt = dp[i - 1][j - arr[i - 1].wt].wt
								+ arr[i - 1].wt;
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}

	public static int getMostFrequent(int[] arr) {
		// only for positive numbers
		int k = getMax(arr) + 1;
		for (int a : arr)
			arr[a % k] += k;
		int index = 0;
		for (int i = 0; i < arr.length; i++)
			if (arr[i] > arr[index])
				index = i;
		return index;
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

	public static long nthFibnocciNumber(int n) {
		double rootFive = Math.sqrt(5);
		double phy = (1 + rootFive) / 2;
		return Math.round(Math.floor(Math.pow(phy, n) / rootFive + 0.5));
	}

	public static void main(String[] s) {

	}
}

class TrieNode {
	char value;
	TrieNode links[];
	boolean isFullWord;

	TrieNode(char value) {
		this.value = value;
		links = new TrieNode[26];
		isFullWord = false;
	}

	public int addString(String str) {
		if (str.isEmpty() || !str.matches("[a-z]*"))
			return 0;
		str = str.toLowerCase();
		TrieNode temp = this;
		for (int i = 0; i < str.length(); i++) {
			int childindex = str.charAt(i) - 'a';
			while (temp.links[childindex] != null) {
				temp = temp.links[childindex];
				childindex = str.charAt(++i) - 'a';
			}
			char value = (char) (childindex + 'a');
			temp.links[childindex] = new TrieNode(value);
			if (i == str.length() - 1)
				temp.links[childindex].isFullWord = true;
			temp = temp.links[childindex];
		}
		return 1;
	}

	public String[] findMatch(String str) {
		if (str.isEmpty() || !str.matches("[a-z]*"))
			return null;
		TrieNode temp = this, tempParent = null;
		StringBuilder matchedPart = new StringBuilder("");
		StringBuilder matches = new StringBuilder("");
		boolean broke = false;
		for (int i = 0; i < str.length(); i++) {
			int childindex = str.charAt(i) - 'a';
			tempParent = temp;
			temp = temp.links[childindex];
			if (temp == null) {
				broke = true;
				break;
			}
			matchedPart.append(temp.value);
		}
		if (matchedPart.length() > 0)
			matchedPart.replace(matchedPart.length() - 1, matchedPart.length(),
					"");
		if (broke)
			getMatchesFrom(tempParent, matchedPart.toString(), matches);
		else
			getMatchesFrom(temp, matchedPart.toString(), matches);
		return matches.toString().split("\n");
	}

	private void getMatchesFrom(TrieNode node, String parent,
			StringBuilder matches) {
		if (node == null)
			return;
		parent += node.value;
		if (node.isFullWord)
			matches.append(parent + "\n");
		for (int i = 0; i < 26; i++)
			getMatchesFrom(node.links[i], parent, matches);
	}
}

class Pair implements Comparable {
	int wt, profit;

	Pair() {
	}

	Pair(int wt, int profit) {
		this.wt = wt;
		this.profit = profit;
	}

	public int compareTo(Object obj) {
		Pair o = (Pair) obj;
		if (o.wt < this.wt)
			return 1;
		else if (o.wt > this.wt)
			return -1;
		return 0;
	}
}