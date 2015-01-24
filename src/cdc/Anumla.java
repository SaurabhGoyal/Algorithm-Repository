package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

class Anumla {

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n;
			n = Integer.parseInt(br.readLine());
			ArrayList<Integer> sumset = new ArrayList<Integer>();
			ArrayList<Integer> subsumset = new ArrayList<Integer>();
			ArrayList<Integer> set = new ArrayList<Integer>();
			String sums[] = br.readLine().split(" ");
			for (int i = 0; i < sums.length; i++)
				sumset.add(Integer.parseInt(sums[i]));
			Collections.sort(sumset);
			Iterator<Integer> it = sumset.iterator();
			it.next();
			while (it.hasNext()) {
			}
			System.out.println(set.size());
		}
	}
}
