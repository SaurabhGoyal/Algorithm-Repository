package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Icode {

	public void solve() throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		TreeSet<Basket> baskets = new TreeSet<Basket>(new BasketComparator());
		for (int i = 1; i <= m; i++) {
			Basket bs = new Basket(0, i, m);
			baskets.add(bs);
		}
		for (int i = 1; i <= n; i++) {
			Basket bs=baskets.first();
			sb.append(bs.pos+"\n");
			baskets.pollFirst();
			baskets.add(new Basket(bs.value+1,bs.pos,m));
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		new Icode().solve();
	}
}

class Basket {
	public int value, pos, distanceFromMiddle;

	public Basket(int value, int pos, int numOfBaskets) {
		super();
		this.value = value;
		this.pos = pos;
		this.distanceFromMiddle = Math.abs((numOfBaskets + 1) / 2 - pos);
	}

	@Override
	public String toString() {
		return "Basket [value=" + value + ", pos=" + pos
				+ ", distanceFromMiddle=" + distanceFromMiddle + "]";
	}

}

class BasketComparator implements Comparator<Basket> {
	public int compare(Basket o1, Basket o2) {
		if (o1.value > o2.value)
			return 1;
		else if (o1.value < o2.value)
			return -1;
		else {
			if (o1.distanceFromMiddle > o2.distanceFromMiddle)
				return 1;
			else if (o1.distanceFromMiddle < o2.distanceFromMiddle)
				return -1;
			else {
				if (o1.pos > o2.pos)
					return 1;
				return -1;
			}
		}
	}

}
