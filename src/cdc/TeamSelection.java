package cdc;

public class TeamSelection {
	public String simulate(int[] preference1, int[] preference2) {
		int p1 = 0, p2 = 0, length = preference1.length;
		int[] arr = new int[length];
		for (int i = 0; i < length; i++)
			arr[i] = 0;
		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				int boytochoose = preference1[p1++] - 1;
				while (arr[boytochoose] == 2)
					boytochoose = preference1[p1++] - 1;
				arr[boytochoose] = 1;
			} else {
				int boytochoose = preference2[p2++] - 1;
				while (arr[boytochoose] == 1)
					boytochoose = preference2[p2++] - 1;
				arr[boytochoose] = 2;
			}
		}
		String res="";
		for(int i=0;i<length;i++)
			res+=arr[i];
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new TeamSelection().simulate(new int[]{8, 7, 1, 2, 4, 5, 6, 3, 9}
		, new int[]{7, 2, 4, 8, 1, 5, 9, 6, 3}));
	}

}
