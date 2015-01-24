package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

public class Sbank27 {
	StringBuilder output = new StringBuilder();

	public void solve() throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String string;
			while((string=br.readLine()).isEmpty());
			int n = Integer.parseInt(string);
			TreeMap<String, Integer> stringMap = new TreeMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				Integer freq = stringMap.get(str);
				if (freq == null)
					stringMap.put(str, 1);
				else
					stringMap.put(str, freq + 1);
			}
			ArrayList<String> keyset = new ArrayList<String>(stringMap.keySet());
			Collections.sort(keyset);
			Iterator<String> it = keyset.iterator();
			while (it.hasNext()) {
				String key=it.next();
				output.append(key+" "+stringMap.get(key)+"\n");
			}
			output.append("\n");
		}
		//br.close();
		System.out.println(output.toString());
	}

	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		new Sbank27().solve();

	}

}
