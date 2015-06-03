package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TheWarehouse {
	
	public static long getMinTimeWithOrder(String str, char first, char second, char third){
		long time = 0;
		int len = str.length();
		char[] arr = str.toCharArray();
		int lastFirst = -1, lastSecond = -1, lastThird = -1;
		for(int i=0;i<len;i++){
			int add = 0;
			if(arr[i] == first){
				add = i - lastFirst - 1;
				lastFirst++;
				lastSecond++;
				lastThird++;
			}
			else if(arr[i] == second){
				add = i - lastSecond - 1;
				lastSecond++;
				lastThird++;
			}
			else{
				add = i - lastThird- 1;
				lastThird++;
			}
			time += add;
		}
		return time;
	}
	
	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String str = br.readLine();
			long minTime = Long.MAX_VALUE;
			long time1 = getMinTimeWithOrder(str, 'r', 'g', 'b');
			minTime = Math.min(minTime, time1);
			time1 = getMinTimeWithOrder(str, 'r', 'b', 'g');
			minTime = Math.min(minTime, time1);
			time1 = getMinTimeWithOrder(str, 'g', 'r', 'b');
			minTime = Math.min(minTime, time1);
			time1 = getMinTimeWithOrder(str, 'g', 'b', 'r');
			minTime = Math.min(minTime, time1);
			time1 = getMinTimeWithOrder(str, 'b', 'r', 'g');
			minTime = Math.min(minTime, time1);
			time1 = getMinTimeWithOrder(str, 'b', 'g', 'r');
			minTime = Math.min(minTime, time1);
			//System.out.println(String.format("mintime : %d", minTime));
			sb.append(minTime).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
