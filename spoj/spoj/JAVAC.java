package spoj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JAVAC {

	public static String toCamelCase(String variableName) {
		StringBuffer res = new StringBuffer("");
		Pattern pattern = Pattern.compile("_[a-z]");
		Matcher matcher = pattern.matcher(variableName);
		int i = 0;
		while (matcher.find()) {
			i++;
			int end = matcher.end();
			char c = variableName.charAt(end - 1);
			c += 'A' - 'a';
			matcher.appendReplacement(res, c + "");
		}
		if (i == 0)
			return variableName;
		matcher.appendTail(res);
		return res.toString();
	}

	public static String toSnakeCase(String variableName) {
		StringBuffer res = new StringBuffer("");
		Pattern pattern = Pattern.compile("[a-z][A-Z]");
		Matcher matcher = pattern.matcher(variableName);
		int i = 0;
		while (matcher.find()) {
			i++;
			int end = matcher.end();
			char c1 = variableName.charAt(end - 2);
			char c2 = variableName.charAt(end - 1);
			c2 -= 'A' - 'a';
			matcher.appendReplacement(res, c1 + "_" + c2);
		}
		if (i == 0)
			return null;
		matcher.appendTail(res);
		return res.toString();
	}

	public static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = null;
		while ((input = br.readLine()) != null) {
			String ans = toSnakeCase(input);
			if(ans == null) ans = toCamelCase(input);
			if(ans == null) sb.append("Error!\n");
			else sb.append(ans + "\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		solve();
	}

}
