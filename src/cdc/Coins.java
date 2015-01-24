package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Coins {

	public static Map<Long, Long> map;

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		map = new HashMap<Long, Long>();
		map.put(0l, 0l);
		map.put(1l, 1l);
		try {
			while ((input = br.readLine()) != null)
				System.out.println(getMaxDollars(Long.parseLong(input)));
		} catch (IOException e) {
		} catch (Exception e) {
			return;
		}
	}

	private static long getMaxDollars(long n) {

		Long maxValue = map.get(n);
		if (maxValue == null) {
			maxValue=Math.max(n, getMaxDollars(n/2)+getMaxDollars(n/3)+getMaxDollars(n/4));
			map.put(n, maxValue);
		}
		return maxValue;
	}
}
