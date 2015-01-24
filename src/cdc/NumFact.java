package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumFact {
	boolean[] sieve;
	public void generateSieve(int n){
		sieve=new boolean[n+1];
		for(int i=0;i<=n;i++) sieve[i]=true;
		sieve[0]=sieve[1]=false;
		for(int i=2;i*i<n;i++){
			if(sieve[i]){
				int j=i+i;
				while(j<=n){
					sieve[j]=false;
					j+=i;
				}
			}
		}
	}
	public void solve() throws java.lang.Exception {
		generateSieve(1000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int prod=1;
			int n = Integer.parseInt(br.readLine());
			int[] nums=new int[n];
			int[] powers=new int[1001];
			for(int i=0;i<=1000;i++) powers[i]=0;
			String[] input=br.readLine().split(" ");
			for(int i=0;i<n;i++){
				nums[i]=Integer.parseInt(input[i]);
				System.out.println("===finding for "+nums[i]+" ===");
				for(int j=2;j<=nums[i];j++){
					if(sieve[j]){
						int pow=0;
						System.out.println("checking power of "+j);
						while(nums[i]%j==0){
							pow++;
							nums[i]/=j;
						}
						System.out.println("setting it "+pow);
						powers[j]+=pow;
					}
				}
			}
			for(int i=2;i<=10;i++){
				System.out.println("power["+i+"] is "+powers[i]);
				System.out.println("prod was "+prod);
				prod*=(powers[i]+1);
				System.out.println("prod is "+prod);
			}
			System.out.println(prod);
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		new NumFact().solve();
	}

}
