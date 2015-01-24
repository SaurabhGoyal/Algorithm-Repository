package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

class Cameras {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nk[] = br.readLine().split(" ");
		long n = Long.parseLong(nk[0]);
		long k = Long.parseLong(nk[1]);
		LinkedList<Long> cameras = new LinkedList<Long>();
		String camerastr[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			cameras.add(Long.parseLong(camerastr[i]));
		Collections.sort(cameras);
		ArrayList<Surge> surges = new ArrayList<Surge>();
		for (int i = 0; i < k; i++) {
			String str[] = br.readLine().split(" ");
			long a = Long.parseLong(str[0]);
			long b = Long.parseLong(str[1]);
			surges.add(new Surge(a, b));
		}
		Collections.sort(surges, new MyComp());
		//System.out.println("===cameras===\n"+cameras);
		//System.out.println("===surges===\n"+surges);
		TreeSet<Long> disabledSet = new TreeSet<Long>();
		Iterator<Surge> it1 = surges.iterator();
		while (it1.hasNext()) {
			Surge surge = it1.next();
			while (!cameras.isEmpty()) {
				long cameraPos = cameras.peek();
				if(cameraPos<surge.x){
					cameras.remove();
				}
				else if (cameraPos <= surge.y) {
					//System.out.println("camera "+cameraPos+" disabled by surge "+surge.x+" , "+surge.y);
					cameras.remove();
					disabledSet.add(cameraPos);
				}
				else break;
			}
		}
		System.out.println(cameras.size());
		System.out.println(disabledSet.size());
	}
}

class Surge {
	long x, y;

	public Surge() {
		super();
	}

	public Surge(long x, long y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

}

class MyComp implements Comparator<Surge> {

	@Override
	public int compare(Surge o1, Surge o2) {
		if (o1.x == o2.x)
			return 0;
		if (o1.x > o2.x)
			return 1;
		return -1;
	}

}