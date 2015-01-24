package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Smpair {
	public void solve() throws java.lang.Exception {
		StringBuilder op=new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] nums = br.readLine().split(" ");
			int smallest=9999999,secondSmallest=9999999;
			for(int i=0;i<n;i++){
				int num=Integer.parseInt(nums[i]);
				if(num<smallest){
					secondSmallest=smallest;
					smallest=num;
				}
				else if(num<secondSmallest)
					secondSmallest=num;
			}
			op.append(smallest+secondSmallest+"\n");
		}
		System.out.println(op.toString());
	}

	public static void main(String[] args) throws java.lang.Exception {
		new Smpair().solve();
	}

}
