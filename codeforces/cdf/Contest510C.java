package cdf;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Contest510C {
	// FoxAndNames
	
	public static int[] pos;
	
	public static void showPos(){
		System.out.print("Pos : [");
		for(int i=0;i<26;i++){
			System.out.print((char)(i+'a')+":"+pos[i]);
			if(i<25) System.out.print(",");
		}
		System.out.println("]");
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//int t = Integer.parseInt(br.readLine());
		int t=1;
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[n][];
			long ans = 0;
			pos = new int[26];
			Arrays.fill(pos, -1);
			boolean possible = true;
			outerloop:
			for (int i = 0; i < n; i++) {
				arr[i] = br.readLine().toCharArray();
				if(i!=0){
					int len1 = arr[i-1].length;
					int len2 = arr[i].length;
					int k=0;
					for(; k<len1 && k<len2 ; k++) if(arr[i][k] != arr[i-1][k]) break;
					if((len2-k)==0 && (len1-k)>0){
						possible = false;
						break outerloop;
					}
					for(; k<len1 && k<len2 ; k++){
						int pos1 = pos[arr[i-1][k]-'a'];
						int pos2 = pos[arr[i][k]-'a'];
						if(pos1 == -1 || pos2 == -1){
							if(pos1==-1) pos[arr[i-1][k]-'a']++;
							pos[arr[i][k]-'a'] = pos[arr[i-1][k]-'a']+1;
							break;
						}
						else{
							if(pos1>pos2){
								possible = false;
								break outerloop;
							}
							else{
								pos[arr[i][k]-'a'] = pos1+1;
							}
						}
					}
				}
				showPos();
			}
			if(possible){
				Node[] order = new Node[26];
				for(int i=0;i<26;i++){
					order[i] = new Node((char)(i+'a'), pos[i]);
				}
				Arrays.sort(order);
				for(int i=0;i<26;i++){
					sb.append(order[i].c);
				}
				sb.append("\n");
			}
			else sb.append("Impossible\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		solve();
	}
}
class Node implements Comparable{
	char c;
	int value;
	public Node(char c, int value){
		this.c = c;
		this.value = value;
	}
	public int compareTo(Object obj){
		Node o = (Node)obj;
		if(this.value>o.value) return 1;
		if(this.value<o.value) return -1;
		return 0;
	}
}