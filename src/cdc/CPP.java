package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPP {

	public static void solve() throws NumberFormatException, IOException {
		StringBuilder output=new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0){
			String pattern=br.readLine();
			int n=Integer.parseInt(br.readLine());
			pattern=getRegex(pattern);
			while(n-->0){
				String id=br.readLine();
				
			}
		}
	}

	private static String getRegex(String pattern) {
		pattern=pattern.trim();
		return null;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}

}
