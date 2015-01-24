package cdc;

public class Target {

	public String[] drawByRecursion(int n) {
		String[] lines = new String[n];
		if (n == 1) {
			lines[0] = "#";
			return lines;
		}
		lines[0] = "";
		lines[1] = "#";
		for (int j = 0; j < n; j++)
			lines[0] = lines[0] + "#";
		lines[n - 1] = lines[0];
		for (int j = 1; j < n - 1; j++)
			lines[1] = lines[1] + " ";
		lines[1] = lines[1] + "#";
		lines[n - 2] = lines[1];
		String[] smallertarget = drawByRecursion(n - 4);
		for (int i = 2; i < n - 2; i++) 
			lines[i] = "# " + smallertarget[i - 2]+ " #";
		return lines;
	}

	public static void main(String[] args) {
		String lines[];
		lines = new Target().drawByRecursion(9);
		for (int i = 0; i < lines.length; i++)
			System.out.println(lines[i]);
	}

}
