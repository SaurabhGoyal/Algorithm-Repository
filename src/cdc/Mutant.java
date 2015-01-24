package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Mutant {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char grid[][] = new char[8][8];
		int px=0, py=0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				grid[i][j] = '1';
			}
		}
		for (int i = 0; i < 8; i++) {
			String row = br.readLine();
			//System.out.println("row "+(i+1)+", got string "+row);
			for (int j = 0; j < 8; j++) {
				char c = row.charAt(j);
				//System.out.println("char "+c);
				if (c == 'P') {
					grid[i][j] = 'P';
					px = i;
					py = j;
				}
				if (c == 'S') {
					grid[i][j] = 'S';
					if (i - 1 < 8 && i - 1 >= 0 && j - 1 < 8 && j - 1 >= 0)
						if (grid[i - 1][j - 1] == '1')
							grid[i - 1][j - 1] = '0';
					if (i - 1 < 8 && i - 1 >= 0 && j < 8 && j >= 0)
						if (grid[i - 1][j] == '1')
							grid[i - 1][j] = '0';
					if (i - 1 < 8 && i - 1 >= 0 && j + 1 < 8 && j + 1 >= 0)
						if (grid[i - 1][j + 1] == '1')
							grid[i - 1][j + 1] = '0';
					if (i < 8 && i >= 0 && j - 1 < 8 && j - 1 >= 0)
						if (grid[i][j - 1] == '1')
							grid[i][j - 1] = '0';
					if (i < 8 && i >= 0 && j + 1 < 8 && j + 1 >= 0)
						if (grid[i][j + 1] == '1')
							grid[i][j + 1] = '0';
					if (i + 1 < 8 && i + 1 >= 0 && j - 1 < 8 && j - 1 >= 0)
						if (grid[i + 1][j - 1] == '1')
							grid[i + 1][j - 1] = '0';
					if (i + 1 < 8 && i + 1 >= 0 && j < 8 && j >= 0)
						if (grid[i + 1][j] == '1')
							grid[i + 1][j] = '0';
					if (i + 1 < 8 && i + 1 >= 0 && j + 1 < 8 && j + 1 >= 0)
						if (grid[i + 1][j + 1] == '1')
							grid[i + 1][j + 1] = '0';
				}
				if (c == 'Q') {
					grid[i][j] = 'Q';
					for (int k = i - 1; k>=0 && grid[k][j] == '1'; k--)
						grid[k][j] = '0';
					for (int k = i + 1; k<8 && grid[k][j] == '1'; k++)
						grid[k][j] = '0';
					for (int k = j - 1; k>=0 && grid[i][k] == '1'; k--)
						grid[i][k] = '0';
					for (int k = j + 1; k<8 && grid[i][k] == '1'; k++)
						grid[i][k] = '0';
					for (int k = i - 1, l = j - 1; k>=0 && l>=0 && grid[k][l] == '1'; k--, l--)
						grid[k][l] = '0';
					for (int k = i - 1, l = j + 1; k>=0 && l<8 && grid[k][l] == '1'; k--, l++)
						grid[k][l] = '0';
					for (int k = i + 1, l = j - 1; k<8 && l>=0 && grid[k][l] == '1'; k++, l--)
						grid[k][l] = '0';
					for (int k = i + 1, l = j + 1; k<8 && l<8 && grid[k][l] == '1'; k++, l++)
						grid[k][l] = '0';
				}
				if (c == 'B') {
					grid[i][j] = 'B';
					for (int k = i - 1, l = j - 1; k>=0 && l>=0 && grid[k][l] == '1'; k--, l--)
						grid[k][l] = '0';
					for (int k = i - 1, l = j + 1; k>=0 && l<8 && grid[k][l] == '1'; k--, l++)
						grid[k][l] = '0';
					for (int k = i + 1, l = j - 1; k<8 && l>=0 && grid[k][l] == '1'; k++, l--)
						grid[k][l] = '0';
					for (int k = i + 1, l = j + 1; k<8 && l<8 && grid[k][l] == '1'; k++, l++)
						grid[k][l] = '0';
				}

				if (c == 'R') {
					grid[i][j] = 'R';
					for (int k = i - 1; k>=0 && grid[k][j] == '1'; k--)
						grid[k][j] = '0';
					for (int k = i + 1; k<8 && grid[k][j] == '1'; k++)
						grid[k][j] = '0';
					for (int k = j - 1; k>=0 && grid[i][k] == '1'; k--)
						grid[i][k] = '0';
					for (int k = j + 1; k<8 && grid[i][k] == '1'; k++)
						grid[i][k] = '0';
				}
			}
		}
		System.out.println("=====chess board=====\n");
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("\n");
		}
		if(px-1<8&&px-1>0&&py-1<8&&py-1>=0){
			if(grid[px-1][py-1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px-1<8&&px-1>0&&py<8&&py>=0){
			if(grid[px-1][py]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px-1<8&&px-1>0&&py+1<8&&py+1>=0){
			if(grid[px-1][py+1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px<8&&px>0&&py-1<8&&py-1>=0){
			if(grid[px][py-1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px<8&&px>0&&py+1<8&&py+1>=0){
			if(grid[px][py+1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px+1<8&&px+1>0&&py-1<8&&py-1>=0){
			if(grid[px+1][py-1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px+1<8&&px+1>0&&py<8&&py>=0){
			if(grid[px+1][py]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		if(px+1<8&&px+1>0&&py+1<8&&py+1>=0){
			if(grid[px+1][py+1]=='1'){
				System.out.println("NOT YET!");
				return;
			}
		}
		System.out.println("CHECKMATE!");
		return;
	}
}
