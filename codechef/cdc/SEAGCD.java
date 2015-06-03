package cdc;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SEAGCD {

	public static long mod = 1000000007;

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

	public static void solve() throws Exception {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		Reader rd = new Reader();
		StringBuilder sb = new StringBuilder();
		int t = rd.nextInt();
		while (t-- > 0) {
			int n = rd.nextInt();
			int m = rd.nextInt();
			int l = rd.nextInt();
			int r = rd.nextInt();
			long ans = 0;
			long[] a = new long[m + 1];
			int lastBase = 0;
			for (int i = 1; i <= m; i++) {
				int base = m / i;
				if (base == lastBase) {
					a[i] = a[i - 1];
					continue;
				}
				a[i] = powerWithMod(base, n, mod);
				lastBase = base;
			}
			for (int i = m; i >= 1; i--) {
				for (int x = 2 * i; x <= m; x += i) {
					a[i] -= a[x];
				}
				a[i] %= mod;
				if (a[i] < 0)
					a[i] += mod;
			}
			for (int i = l; i <= r; i++) {
				ans += a[i];
				ans %= mod;
			}
			// ans %= mod;
			sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}

class Reader {
	final private int BUFFER_SIZE = 1 << 16;
	private DataInputStream din;
	private byte[] buffer;
	private int bufferPointer, bytesRead;

	public Reader() {
		din = new DataInputStream(System.in);
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public Reader(String file_name) throws IOException {
		din = new DataInputStream(new FileInputStream(file_name));
		buffer = new byte[BUFFER_SIZE];
		bufferPointer = bytesRead = 0;
	}

	public String readLine() throws IOException {
		byte[] buf = new byte[64];
		int cnt = 0, c;
		while ((c = read()) != -1) {
			if (c == '\n')
				break;
			buf[cnt++] = (byte) c;
		}
		return new String(buf, 0, cnt);
	}

	public int nextInt() throws IOException {
		int ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public long nextLong() throws IOException {
		long ret = 0;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (neg)
			return -ret;
		return ret;
	}

	public double nextDouble() throws IOException {
		double ret = 0, div = 1;
		byte c = read();
		while (c <= ' ')
			c = read();
		boolean neg = (c == '-');
		if (neg)
			c = read();
		do {
			ret = ret * 10 + c - '0';
		} while ((c = read()) >= '0' && c <= '9');
		if (c == '.')
			while ((c = read()) >= '0' && c <= '9')
				ret += (c - '0') / (div *= 10);
		if (neg)
			return -ret;
		return ret;
	}

	private void fillBuffer() throws IOException {
		bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
		if (bytesRead == -1)
			buffer[0] = -1;
	}

	private byte read() throws IOException {
		if (bufferPointer == bytesRead)
			fillBuffer();
		return buffer[bufferPointer++];
	}

	public void close() throws IOException {
		if (din == null)
			return;
		din.close();
	}
}
