package cdc;

public class PikachuEasy {
	public String check(String word) {
		String modstr = word;
		while (true) {
			String str = modstr;
			modstr = modstr.replace("pi", "");
			modstr = modstr.replace("ka", "");
			modstr = modstr.replace("chu", "");
			if (modstr.equals(str))	break;
		}
		if (modstr.length() > 0)
			return "NO";
		return "YES";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PikachuEasy().check("pikakapichu"));
	}

}
