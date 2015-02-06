package cdf;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Contest510A {
	//FoxAndSnake
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// int t = Integer.parseInt(br.readLine());
		int t = 1;
		while (t-- > 0) {
			String[] ip = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int m = Integer.parseInt(ip[1]);
			StringBuilder fullSnake = new StringBuilder();
			StringBuilder firstSnake = new StringBuilder();
			StringBuilder lastSnake = new StringBuilder();
			for (int i = 0; i < m; i++) {
				fullSnake.append('#');
				if (i == 0)
					firstSnake.append('#');
				else
					firstSnake.append('.');
				if (i == m - 1)
					lastSnake.append('#');
				else
					lastSnake.append('.');
			}
			for (int i = 0; i < n; i++) {
				if (i % 2 == 0)
					sb.append(fullSnake);
				else {
					if (((i + 1) / 2) % 2 == 0)
						sb.append(firstSnake);
					else
						sb.append(lastSnake);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
	}


	public static void main(String[] args) throws Exception {
		solve();

	}
}
