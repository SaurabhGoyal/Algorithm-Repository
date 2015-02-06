package cdc;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ThreeSortedArrays {

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int p = Integer.parseInt(br.readLine());
			long[] arrP = new long[p];
			String[] ip = br.readLine().split(" ");
			for (int i = 0; i < p; i++) {
				arrP[i] = Long.parseLong(ip[i]);
			}
			int q = Integer.parseInt(br.readLine());
			long[] arrQ = new long[q];
			ip = br.readLine().split(" ");
			for (int i = 0; i < q; i++) {
				arrQ[i] = Long.parseLong(ip[i]);
			}
			int r = Integer.parseInt(br.readLine());
			long[] arrR = new long[r];
			ip = br.readLine().split(" ");
			for (int i = 0; i < r; i++) {
				arrR[i] = Long.parseLong(ip[i]);
			}
			long[] countI = new long[p];
			long[] countJ = new long[q];
			long total = 0;
			int j = q-1, k = r-1;
			for(int i=p-1;i>=0;i--){
				while(j>=i && arrP[i]<=arrQ[j]){
					while(k>=j && arrQ[j]<=arrR[k]){
						k--;
					}
					countJ[j] = (r-k-1);
					if(j<q-1) countJ[j] += countJ[j+1];
					//System.out.println(String.format("countJ[%d] = %d",j,countJ[j]));
					j--;
				}
				if(j<q-1){
					countI[i] = countJ[j+1];
					if(i<p-1) countI[i] += countI[i+1];
				}
			}
			sb.append(countI[0]+"\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		solve();		
	}

}
