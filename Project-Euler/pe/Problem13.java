package pe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem13 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger sum = new BigInteger("0");
		for (int i = 0; i < 100; i++) {
			BigInteger num = new BigInteger(br.readLine());
			sum = sum.add(num);
		}
		System.out.println(sum);
	}
}
