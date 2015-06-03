package pe;

import java.io.BufferedReader;
import java.io.FileReader;


public class Problem42 {
	
	public static int getValue(String word){
		int value = 0;
		int len = word.length();
		for(int i=0;i<len;i++){
			value += (word.charAt(i)-'A'+1);
		}
		return value;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("files/p042_words.txt"));
		String[] words = br.readLine().replaceAll("\"", "").split(",");
		int count = 0;
		int wc = 0;
		for(String word : words){
			wc++;
			int value = getValue(word);
			System.out.println(word+" : "+value);
			if(isPerectSquare(value*8 + 1)) count++;
		}
		System.out.println("wc: "+wc+", count: "+count);
	}
	private static boolean isPerectSquare(int i) {
		int root = (int)Math.sqrt(i);
		return i == (root*root);
	}

}
