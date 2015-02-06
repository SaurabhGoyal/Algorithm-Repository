package pe;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Problem11 {
	
	//Takes input from console
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long ans = 0;
		String input;
		int[][] grid = new int[20][20];
		for (int i = 0; i < 20; i++) {
			String[] ip = br.readLine().trim().split(" ");
			for (int j = 0; j < 20; j++) {
				grid[i][j] = Integer.parseInt(ip[j]);
			}
		}
		long max = 1;
		int dig = 3;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20 - dig; j++) {
				long prod = grid[i][j];
				int k = j + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[i][k++];
				}
				max = Math.max(max, prod);
				prod = grid[j][i];
				k = j + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[k++][i];
				}
				max = Math.max(max, prod);
			}
		}
		for (int i = 0; i < 20 - dig; i++) {
			for (int j = 0; j < 20 - i - dig; j++) {
				long prod = grid[i][j];
				int k = i + 1, l = j + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[k++][l++];
				}
				max = Math.max(max, prod);
			}
		}
		for (int i = 1; i < 20 - dig; i++) {
			for (int j = 0; j < 20 - i - dig; j++) {
				long prod = grid[j][i];
				int k = j + 1, l = i + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[k++][l++];
				}
				max = Math.max(max, prod);
			}
		}
		for (int i = dig; i < 20; i++) {
			for (int j = 0; j < i - dig; j++) {
				long prod = grid[i][j];
				int k = i - 1, l = j + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[k--][l++];
				}
				max = Math.max(max, prod);
			}
		}
		for (int i = 1; i < 20 - dig; i++) {
			for (int j = 19; j > i + dig; j--) {
				long prod = grid[j][i];
				int k = j - 1, l = i + 1;
				for (int d = 0; d < dig; d++) {
					prod *= grid[k--][l++];
				}
				max = Math.max(max, prod);
			}
		}
		System.out.println(max);
	}
}