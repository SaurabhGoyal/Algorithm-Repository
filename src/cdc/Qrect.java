package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Qrect {

	public static void main(String[] args) throws java.lang.Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		t = Integer.parseInt(br.readLine());
		List<MyRectangle> rectlist = new LinkedList<MyRectangle>();
		while (t-- > 0) {
			String input, param[];
			input = br.readLine();
			if (input.charAt(0) == 'I') {
				param = input.split(" ");
				long x1, y1, x2, y2;
				x1 = Long.parseLong(param[1]);
				y1 = Long.parseLong(param[2]);
				x2 = Long.parseLong(param[3]);
				y2 = Long.parseLong(param[4]);
				rectlist.add(new MyRectangle(x1, y1, x2, y2));
				System.out.println(x1 + "," + y1 + " " + x2 + "," + y2
						+ " inserted, list is");
				printlist(rectlist);
			}
			if (input.charAt(0) == 'D') {
				param = input.split(" ");
				long index = Long.parseLong(param[1]);
				System.out.println("index "+index+ " deleted, list is");
				Iterator<MyRectangle> i = rectlist.iterator();
				while (i.hasNext()&&index-->0) {
					i.next();
				}
				i.remove();
				printlist(rectlist);
			}
			if (input.charAt(0) == 'Q') {
				param = input.split(" ");
				long x1, y1, x2, y2;
				x1 = Long.parseLong(param[1]);
				y1 = Long.parseLong(param[2]);
				x2 = Long.parseLong(param[3]);
				y2 = Long.parseLong(param[4]);
				System.out.println("list is");
				printlist(rectlist);
				System.out.println(getOverlappingCount(rectlist,
						new MyRectangle(x1, y1, x2, y2)));
			}
		}
	}

	private static void printlist(List<MyRectangle> rectlist) {
		Iterator<MyRectangle> i = rectlist.iterator();
		while (i.hasNext()) {
			MyRectangle temp = i.next();
			System.out.println(temp.x1+","+temp.y1+" "+temp.x2+","+temp.y2);
		}
	}

	private static long getOverlappingCount(List<MyRectangle> rectlist,
			MyRectangle rect) {
		Iterator<MyRectangle> i = rectlist.iterator();
		long count = 0;
		while (i.hasNext()) {
			MyRectangle temp = i.next();
			if (!(temp.x1 > rect.x2 || temp.x2 < rect.x1 || temp.y1 > rect.y2 || temp.y2 < rect.y1))
				count++;
		}
		return count;
	}

}

class MyRectangle {
	long x1, y1, x2, y2;

	public MyRectangle(long x1, long y1, long x2, long y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
