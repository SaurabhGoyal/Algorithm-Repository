
public class Problem30 {
	
	public static void main(String[] args) throws Exception {
		//solve();
		int[] p4 = new int[10];
		for(int i=0;i<10;i++) p4[i] = i*i*i*i; 
		int[] p5 = new int[10];
		for(int i=0;i<10;i++) p5[i] = i*i*i*i*i;
		long sum = 0;
		for(long i=10;i<=10000000l;i++){
			long digSum = 0;
			long num = i;
			while(num>0){
				int dig = (int)(num%10);
				digSum += p5[dig];
				num /= 10;
			}
			if(i==digSum){
				System.out.println(i);
				sum += i;
			}
		}
		System.out.println("sum : " + sum);
	}

}
