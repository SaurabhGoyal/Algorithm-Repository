package cdc;

public class SortishDiv2 {
	int[] seq;
	boolean[] used;
	int len, reqdSortedness, result = 0;

	public int getSortedness(int[] sequence) {
		int sortedness = 0;
		for (int i = 0; i < len; i++)
			for (int j = 0; j < i; j++)
				if (sequence[j] < sequence[i])
					sortedness++;
		return sortedness;
	}

	void backtrack(int pos) {
		System.out.println("at pos " + pos);
		if (pos == len) {
			System.out.println("at last pos " + pos);
			if (getSortedness(seq) == reqdSortedness)
				result++;
		} else {
			if (seq[pos] == 0) {
				for (int i = 1; i < len + 1; i++) {
					if (!used[i]) {
						used[i] = true;
						seq[pos] = i;
						System.out.println("Checking seq " + seq.toString());
						backtrack(pos + 1);
						seq[pos] = 0;
						used[i] = false;
					}
				}
			} else
				backtrack(pos + 1);
		}
	}

	public int ways(int sortedness, int[] seq) {
		this.seq = seq;
		this.len = seq.length;
		this.reqdSortedness = sortedness;
		this.used = new boolean[len + 1];
		for (int num : seq)
			used[num] = true;
		for (boolean b : used)
			System.out.println(b + " ");
		backtrack(0);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new SortishDiv2().ways(5,
				new int[] { 4, 0, 0, 2, 0 }));
	}
}