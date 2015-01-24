package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleArithmetics6 {
	StringBuilder output = new StringBuilder();

	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String input = br.readLine();
			String nums[] = input.split("[+-*]");
			String num1 = nums[0];
			String num2 = nums[1];
			input = input.replaceAll(num1, "").replaceAll(num2, "");
			char op = input.charAt(0);
			switch (op) {
			case '+':
				add(num1, num2);
				break;
			case '-':
				subtract(num1, num2);
				break;
			case '*':
				multiply(num1, num2);
				break;
			}
		}
	}

	private void multiply(String num1, String num2) {
		// TODO Auto-generated method stub

	}

	private void subtract(String num1, String num2) {
		// TODO Auto-generated method stub

	}

	private void add(String num1, String num2) {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
