package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SerejaTwoStrings {

	public static int getMin(int a, int b, int c) {
		return (a < b) ? ((a < c) ? a : c) : ((b < c) ? b : c);
	}

	public static int getDistance2(String s, String w, int removeCost,
			int addCost, int replaceCost, int maxCost) {
		int len1 = s.length();
		int len2 = w.length();

		int[][] costMatrix = new int[len2 + 1][len1 + 1];
		costMatrix[0][0] = 0;
		for (int i = 1; i <= len2; i++)
			costMatrix[i][0] = costMatrix[i - 1][0] + 1;
		for (int i = 1; i <= len1; i++)
			costMatrix[0][i] = costMatrix[0][i - 1] + 1;
		for (int i = 1; i <= len2; i++) {
			for (int j = 1; j <= len1; j++) {
				costMatrix[i][j] = getMin(
						costMatrix[i - 1][j] + removeCost,
						costMatrix[i][j - 1] + addCost,
						costMatrix[i - 1][j - 1]
								+ (s.charAt(j - 1) == w.charAt(i - 1) ? 0
										: replaceCost));
				if (costMatrix[i][j] > maxCost)
					return -1;
			}
		}
		System.out.println("\n=====matrix======");
		for (int i = 0; i <= len2; i++) {
			for (int j = 0; j <= len1; j++) {
				System.out.print(costMatrix[i][j] + " ");
			}
			System.out.println();
		}

		return costMatrix[len2][len1];
	}

	public static int getDistance(String s, String w, int removeCost,
			int addCost, int replaceCost, int maxCost) {
		int len1 = s.length();
		int len2 = w.length();
		int lastDiagonal, oldDiagonal;
		//int min=len1<len2?len1:len2;
		//int max=len1>len2?len1:len2;
		int cost[]=new int[len1+1];
		for(int i=1;i<=len1;i++)
			cost[i]=i;
		for(int i=1;i<=len2;i++){
			cost[0]=i;
			int j;
			for(j=1,lastDiagonal=i-1;j<=len1;j++){
				oldDiagonal=cost[j];
				cost[j]=getMin(cost[j]+removeCost,cost[j-1]+addCost,lastDiagonal+(s.charAt(j-1)==w.charAt(i-1)?0:replaceCost));
				if(cost[j]>maxCost) return -1;
				lastDiagonal=oldDiagonal;
			}
		}
		return cost[len1];
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int removeCost, addCost, replaceCost, maxCost;
			String s = br.readLine();
			String w = br.readLine();
			String str[] = br.readLine().split(" ");
			removeCost = addCost = Integer.parseInt(str[0]);
			replaceCost = Integer.parseInt(str[1]);
			maxCost = Integer.parseInt(str[2]);
			System.out.println(getDistance(s, w, removeCost, addCost, replaceCost,
							maxCost));
		}
	}

}
