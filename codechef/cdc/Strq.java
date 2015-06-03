package cdc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Strq {

	public static void solve() throws Exception {
		InputReader ir = new InputReader(System.in);
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (t-- > 0) {
			String str = ir.readString();
			int n = str.length();
			char[] c = new char[] { 'c', 'h', 'e', 'f' };
			int[][] freq = new int[n][4];
			long[][][] dp = new long[n][4][4];
			if (n > 1) {
				char current = str.charAt(0);
				int ci = 0;
				for (int j = 0; j < 4; j++) {
					if (c[j] == current)
						ci = j;
				}
				freq[0][ci]++;
				for (int i = 1; i < n; i++) {
					current = str.charAt(i);
					for (int j = 0; j < 4; j++) {
						if (c[j] == current)
							ci = j;
						freq[i][j] = freq[i - 1][j];
					}
					for (int j = 0; j < 4; j++) {
//						for (int k = 0; k < 4; k++) {
//							dp[i][j][k] = dp[i - 1][j][k];
//						}
						dp[i][j] = Arrays.copyOf(dp[i-1][j], 4);
					}
					for (int j = 0; j < 4; j++) {
						dp[i][j][ci] += freq[i - 1][j];
					}
					freq[i][ci]++;
				}
			}
			for(int i=0;i<n;i++){
				System.out.println(String.format("freq = {%d,%d,%d,%d}",freq[i][0],freq[i][1],freq[i][2],freq[i][3]));
				System.out.println(String.format("dp = {%d,%d,%d,%d}",dp[i][0][0],dp[i][1][1],dp[i][2][2],dp[i][3][3]));
			}
			int q = ir.readInt();
			while (q-- > 0) {
				char a = ir.readCharacter();
				char b = ir.readCharacter();
				int l = ir.readInt();
				int r = ir.readInt();
				int index1 = 0, index2 = 0;
				for (int j = 0; j < 4; j++) {
					if (a == c[j])
						index1 = j;
					if (b == c[j])
						index2 = j;
				}
				long ans = 0;
				if (n == 1)
					ans = 0;
				else if (l == 1)
					ans = dp[r - 1][index1][index2];
				else {
					ans = dp[r - 1][index1][index2] - dp[l - 1][index1][index2];
					int extra = (freq[l - 2][index1])
							* (freq[r - 1][index2] - freq[l - 1][index2]);
					ans -= extra;
				}
				sb.append(ans).append("\n");
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}

class InputReader {

	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			if (Character.isValidCodePoint(c))
				res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	public static boolean isWhitespace(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public char readCharacter() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		return (char) c;
	}

	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}