package cdc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Painting {

	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,m,h;
		String input1[]=br.readLine().split(" ");
		n=Integer.parseInt(input1[0]);
		m=Integer.parseInt(input1[1]);
		h=Integer.parseInt(input1[2]);
		Layer layers[]=new Layer[h];
		int sum=0;
		for(int i=0;i<h;i++){
			String input2[]=br.readLine().split(" ");
			int tk=Integer.parseInt(input2[0]);
			int ck=Integer.parseInt(input2[1]);
			layers[i]=new Layer(tk,ck);
			sum+=tk;
		}
		Arrays.sort(layers, new MyComp2());
		//for(Layer l:layers) System.out.print(l.tk+" ");
		if(sum<n*m){
			System.out.println("Impossible");
			return;
		}
		int i=0,cost=0,remaining=n*m;
		while(i<h){
			int numOfCellsToPaint=layers[i].tk>remaining?remaining:layers[i].tk;
			remaining-=numOfCellsToPaint;
			cost+=numOfCellsToPaint*layers[i].ck;
			i++;
		}
		System.out.println(cost);
	}

}
class Layer{
	int tk,ck;
	public Layer(int tk, int ck) {
		super();
		this.tk = tk;
		this.ck = ck;
	}	
}
class MyComp2 implements Comparator<Layer>{

	public int compare(Layer o1, Layer o2) {
		if(o1.ck>o2.ck) return 1;
		if(o1.ck<o2.ck) return -1;
		return 0;
	}
	
}