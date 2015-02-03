import java.util.Arrays;


public class Problem29 {

	public static void main(String[] args) throws Exception {
		// solve();
		int l = 2;
		int h = 5;
		int noe = h-l+1;
		int nod = 0;
		int[] nop = new int[noe];
		Arrays.fill(nop, noe);
		int total = 0;		
		for(int a=l;a<=h;a++){
			total += nop[a];
			int num = a*a;
			while(num<=h){
				
			}
		}
	}
}
