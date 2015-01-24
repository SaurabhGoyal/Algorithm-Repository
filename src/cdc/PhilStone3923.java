package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PhilStone3923 {
	int[][] nums,maxvalue;
	
	private int getMax(int a,int b,int c){
		return a>b?a>c?a:c:b>c?b:c;
	}
	
	private int findMaxSum(int i,int j){
		if(i<0||i>=nums.length||j<0||j>=nums[0].length) return -1;
		if(maxvalue[i][j]!=-1)  return maxvalue[i][j];
		int left=findMaxSum(i+1,j-1);
		int down=findMaxSum(i+1,j);
		int right=findMaxSum(i+1,j+1);
		int max=getMax(left,down,right);
		max=max==-1?0:max;
		maxvalue[i][j]=max+nums[i][j];
		return maxvalue[i][j];
	}
	
	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input=br.readLine().split(" ");
			int h=Integer.parseInt(input[0]);
			int w=Integer.parseInt(input[1]);
			nums=new int[h][w];
			maxvalue=new int[h][w];
			for(int i=0;i<h;i++){
				String[] ip=br.readLine().split(" ");
				for(int j=0;j<w;j++){
					nums[i][j]=Integer.parseInt(ip[j]);
					maxvalue[i][j]=-1;
				}
			}
			int max=-1;
			for(int j=0;j<h;j++){
				int temp=findMaxSum(0,j);
				if(temp>max) max=temp;
			}	
			System.out.println(max);
			nums=null;
			maxvalue=null;
		}
	}
	public static void main(String[] args) throws java.lang.Exception {
		new PhilStone3923().solve();
	}

}
