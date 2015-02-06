
public class Myclass {
	
	public static long[][] powerMatrix(long[][] m, long exp, long mod) {
		if (exp == 1)
			return m;
		if (exp == 2)
			return matrixMultiplication(m, m, mod);
		long[][] subMatrix = powerMatrix(m, exp / 2, mod);
		long[][] result = matrixMultiplication(subMatrix, subMatrix, mod);
		if (exp % 2 == 1)
			result = matrixMultiplication(result, m, mod);
		return result;
	}

	public static long[][] matrixMultiplication(long[][] m1, long[][] m2, long mod) {
		if (m1[0].length != m2.length)
			return null;
		int rows = m1.length, cols = m2[0].length;
		long[][] result = new long[rows][cols];
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				result[i][j] = 0;
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				for (int k = 0; k < m1[0].length; k++){
					result[i][j] += (m1[i][k] * m2[k][j]);
					result[i][j] %= mod;
				}
			}
		}
		return result;
	}

	public static long nthFibonacciRecurrence(long n, long mod){
		if(n==1 || n==2) return 1;
		long[][] f1 = new long[2][1];
		f1[0][0] = 1;
		f1[1][0] = 1;
		long[][] t = new long[2][2];
		t[0][0] = 0;
		t[0][1] = 1;
		t[1][0] = 1;
		t[1][1] = 1;
		long[][] tpow = powerMatrix(t, n-1, mod);
		long[][] fn = matrixMultiplication(tpow, f1, mod);
		return fn[0][0];
	}
	public static void main(String[] args) throws Exception {
		long mod = 1000000007;
		long n = 3;
		System.err.println(nthFibonacciRecurrence(n, mod));
		
	}

}
