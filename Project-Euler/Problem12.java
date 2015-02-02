import java.util.ArrayList;
import java.util.List;

public class Problem12 {
	
	public static List<Integer> primeList;
	public static int nop; 

	public static boolean[] getSieve(int range) {
		int i = 0;
		boolean[] sieve = new boolean[range + 1];
		for (i = 0; i <= range; i++)
			sieve[i] = true;
		for (i = 2; i < Math.sqrt(range); i++) {
			if (sieve[i] == true) {
				int j = i + i;
				while (j <= range) {
					sieve[j] = false;
					j += i;
				}
			}
		}
		return sieve;
	}

	public static List<Integer> getPrimesList(int n) {
		boolean[] sieve = getSieve(n);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < sieve.length; i++) {
			if (sieve[i])
				list.add(i);
		}
		return list;
	}
	
	public static int numOfDivisors(int num){
		int currentNum = num;
		int nod = 1;
		for(int i=0;i<nop;i++){
			int prime = primeList.get(i);
			if(prime*prime>num){
				nod *= 2;
				break;
			}
			int exponent = 1;
			while(currentNum%prime == 0){
				//System.out.println("prime : "+prime+", exp : "+exponent);
				currentNum /= prime;
				exponent++;
			}
			nod *= exponent;
			if(currentNum == 1) break;
		}
		return nod;
	}


	public static void main(String[] args) {
		int range = 1000001;
		int[] ta = new int[range];
		primeList = getPrimesList(range);
		nop = primeList.size();
		for(int i=0;i<range;i++){
			ta[i] = (i*(i+1))/2;
		}
		int i=0;
		for(int num:ta){
			int nod = numOfDivisors(num);
			if(nod>500){
				System.out.println(num+" : "+nod);
				break;
			}
			i++;
		}
	}
}
