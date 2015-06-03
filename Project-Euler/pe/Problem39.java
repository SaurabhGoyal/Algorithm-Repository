package pe;

public class Problem39 {
	public static void main(String[] args) throws Exception {
		int range = 1500;
		int maxp = -1;
		int maxnos = 0;
		for(int p=3;p<=range;p++){
			int nos = 0;
			for(int a=1;a<p;a++){
				for(int b=a+1;(a+b)<p;b++){
					int c = p-(a+b);
					if(c<=a || c<=b) continue;
					if((a*a + b*b == c*c)||(c*c + b*b == a*a)||(a*a + c*c == b*b)) nos++;
				}
			}
			if(nos>maxnos){
				maxnos = nos;
				maxp = p;
			}
		}
		System.out.println(maxp+": "+maxnos);
		
	}

}
