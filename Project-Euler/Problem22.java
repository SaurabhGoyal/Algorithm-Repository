import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Problem22 {
	public static void main(String[] args) throws Exception {
		//solve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		String[] names = ip.replaceAll("\"", "").split(",");
		Arrays.sort(names);
		long score = 0;
		for(int i=1;i<=names.length;i++){
			char[] name = names[i-1].toCharArray();
			int alphaScore = 0;
			for(char c:name) alphaScore += (c-'A'+1);
			score += (alphaScore * i);
			//System.out.println(names[i-1]+" -> as: "+alphaScore +" ... Totalscore : "+score);			
		}
		System.out.println(score);
	}
}
