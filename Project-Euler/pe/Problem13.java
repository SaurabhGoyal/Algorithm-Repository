package pe;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long mod = 10000000000l;
		long sum = 0;
		long carry = 0;
		for (int i = 0; i < 100; i++) {
			long num = Long.parseLong(br.readLine().substring(40));
			sum += num;
			carry += (sum/mod); 
			sum %= mod;
		}
		System.out.println(sum);		
	}
}
