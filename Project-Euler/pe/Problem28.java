package pe;

public class Problem28 {
	public static void main(String[] args) throws Exception {
		int topRight=1;
		long sum = 1;
		int range = 1001;
		for(int i=3;i<=range;i+=2){
			sum += (topRight+1*(i-1));
			sum += (topRight+2*(i-1));
			sum += (topRight+3*(i-1));
			sum += (topRight+4*(i-1));
			topRight = (topRight+4*(i-1));
		}		
		System.out.println(sum);
	}

}
