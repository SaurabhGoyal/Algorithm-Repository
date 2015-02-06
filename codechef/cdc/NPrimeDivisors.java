package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class NPrimeDivisors {

	public static int[] nop;
	public static int[][] grid;
	public static int range;
	
	public static void showGrid(){
		for(int i=1;i<=20;i++){
			for(int j=1;j<=6;j++){
				System.out.print(grid[i][j] +" ");
			}
			System.out.println();
		}
	}

	public static void makeGrid(int range) {
		int i = 0;
		boolean[] sieve = new boolean[range + 1];
		nop = new int[range + 1];
		Arrays.fill(nop, 0);
		nop[1] = 1;
		for (i = 0; i <= range; i++)
			sieve[i] = true;
		for (i = 2; i < range; i++) {
			if (sieve[i] == true) {
				nop[i] = 1;
				//System.out.println(String.format("setting nop[%d] : %d",i,nop[i]));
				int j = i + i;
				while (j <= range) {
					sieve[j] = false;
					nop[j]++;
					j += i;
				}
			}
		}
		return;
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		range = 100000;
		makeGrid(range);
		grid = new int[range+1][7];
//		for(int i=0;i<=range;i++){
//			System.out.println(String.format("i (%d) : %d",i,nop[i]));
//		}
		//System.out.println(grid[0][1]);
		for(int j=1;j<=6;j++){
			grid[1][j] = 0;
		}
		for(int i=2;i<=range;i++){
			for(int j=1;j<=6;j++){
				grid[i][j] = grid[i-1][j];
				if(nop[i] == j) grid[i][j]++;
			}
		}
		showGrid();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int ans = 0;
			String[] ip = br.readLine().split(" ");
			int x = Integer.parseInt(ip[0]);
			int y = Integer.parseInt(ip[1]);
			int k = Integer.parseInt(ip[2]);
			if(k<=6) ans = grid[y][k] - grid[x-1][k];
			else ans = 0;
			sb.append(ans+"\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();

	}
}
