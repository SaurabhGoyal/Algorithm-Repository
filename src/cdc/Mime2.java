package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mime2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> map = new HashMap<String, String>();
		String str;
		str=br.readLine();
		String[] num=new String[2];
		num=str.split(" ");
		int n=Integer.parseInt(num[0]);
		int q=Integer.parseInt(num[1]);
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			String[] pair = new String[2];
			pair = str.split(" ");
			map.put(pair[0], pair[1]);
		}
		for (int i = 0; i < q; i++) {
			str = br.readLine();
			String ext = str.substring(str.lastIndexOf(".") + 1);
			String mimetype=map.get(ext);
			if(mimetype!=null) System.out.println(mimetype);
			else System.out.println("unknown");
		}
	}

}
