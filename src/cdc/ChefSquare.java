package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class ChefSquare {

	public static void main(String[] args) throws java.lang.Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Long[] x, y;
		x = new Long[n];
		y = new Long[n];
		HashMap<Long, ArrayList<Long>> map = new HashMap<Long, ArrayList<Long>>(n);
		for (int i = 0; i < n; i++) {
			String[] point = br.readLine().split(" ");
			x[i] = Long.parseLong(point[0]);
			y[i] = Long.parseLong(point[1]);
			ArrayList<Long> ylist;
			if (map.get(x[i]) == null) ylist = new ArrayList<Long>();
			else ylist = map.get(x[i]);
			ylist.add(y[i]);
			map.put(x[i], ylist);
		}
		if (n == 0) {
			System.out.println("4");
			return;
		}
		if (n == 1) {
			System.out.println("3");
			return;
		}
		if (n == 2) {
			System.out.println("2");
			return;
		}
		int hasThree = 0, hasFour = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				long x1, y1, x2, y2, x3, y3;
				int upper=0,lower=0;
				x1 = x[i];
				y1 = y[i];
				x2 = x[j];
				y2 = y[j];
				// System.out.println("checking for "+x1+","+y1+" and "+x2+","+y2);
				ArrayList<Long> ylist;
				Iterator<Long> it;
				x3 = x1 - (y2 - y1);
				y3 = y1 + (x2 - x1);
				// System.out.println("x3,y3 should be "+x3+","+y3);
				ylist = map.get(x3);
				if (ylist != null) {
					it = ylist.iterator();
					while (it.hasNext()) {
						long ycordinate = it.next();
						if (ycordinate == y3) {
							hasThree=1;
							upper++;
						}
					}
				}
				x3 = x2 + (y1 - y2);
				y3 = y2 - (x1 - x2);
				// System.out.println("x3,y3 should be "+x3+","+y3);
				ylist = map.get(x3);
				if (ylist != null) {
					it = ylist.iterator();
					while (it.hasNext()) {
						long ycordinate = it.next();
						if (ycordinate == y3) {
							hasThree=1;
							upper++;
							if(upper==2){
								hasFour=1;
								break;
							}
						}
					}
				}
				x3 = x1 + (y2 - y1);
				y3 = y1 - (x2 - x1);
				// System.out.println("x3,y3 should be "+x3+","+y3);
				ylist = map.get(x3);
				if (ylist != null) {
					it = ylist.iterator();
					while (it.hasNext()) {
						long ycordinate = it.next();
						if (ycordinate == y3) {
							hasThree=1;
							lower++;
						}
					}
				}
				x3 = x2 - (y1 - y2);
				y3 = y2 + (x1 - x2);
				// System.out.println("x3,y3 should be "+x3+","+y3);
				ylist = map.get(x3);
				if (ylist != null) {
					it = ylist.iterator();
					while (it.hasNext()) {
						long ycordinate = it.next();
						if (ycordinate == y3) {
							hasThree=1;
							lower++;
							if(lower==2){
								hasFour=1;
								break;
							}
						}
					}
				}
				if(hasFour==1) break;				
			}
			if(hasFour==1) break;
		}
		if (hasFour == 1) {
			System.out.println("0");
			return;
		} else if (hasThree == 1) {
			System.out.println("1");
			return;
		} else {
			System.out.println("2");
			return;
		}
	}
}