package cdc;

public class Jumping {

	public String ableToGet(int x, int y, int[] jumpLengths) {
		int sum = 0, max = jumpLengths[0];
		int len = jumpLengths.length;
		double dist = Math.sqrt(x * x + y * y);
		if (len == 1)
			return (dist != jumpLengths[0]) ? "Not Able" : "Able";
		else {
			for (int i = 0; i < len; i++) {
				if (jumpLengths[i] > max)
					max = jumpLengths[i];
				sum += jumpLengths[i];
			}
			double mindist = 2 * max - sum;
			if (mindist < 0) mindist = 0;
			double maxdist = sum;
			return (dist <= maxdist && dist >= mindist) ? "Able" : "Not Able";
		}
	}

	public static void main(String[] s) {

		System.out.println(new Jumping().ableToGet(11, 12, new int[] { 1, 2, 3,
				4, 5, 6, 7, 8, 9, 100 }));

	}
}