package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Friendship18176 {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] residents=new int[n];
		int k=0;
		for(int i=0;i<n;i++){
			residents[i]=Integer.parseInt(br.readLine());
			int k1=(int)Math.floor((double)Math.log(residents[i])/(double)Math.log(2))+1;
			k=k1>k?k1:k;
		}
		long sum=0;
		for(int i=0;i<k;i++){
			long numOfOne=0,numOfZero=0;
			for(int j=0;j<n;j++){
				if(((residents[j]>>i)&1)==0) numOfZero++;
				else numOfOne++;
			}
			sum+=(long)(numOfOne*numOfZero*Math.pow(2, i));
		}
		System.out.println(sum);
	}
}
