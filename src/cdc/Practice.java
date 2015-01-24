package cdc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice {

	private static boolean isFirstGreater(StringBuilder s1, StringBuilder s2) {
		if (s1.length() == 0)
			return false;
		if (s1.length() > s2.length())
			return true;
		if (s1.length() < s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) > 58) {
				s1.replace(i, i + 1, "9");
				break;
			}
		}
		for (int j = 0; j < s2.length(); j++) {
			if (s2.charAt(j) > 58) {
				s2.replace(j, j + 1, "9");
				break;
			}
		}
		return s1.toString().compareTo(s2.toString()) >= 0 ? true : false;
	}

	public static void solve() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		int i;
		for (i = 0; i < inputString.length(); i++)
			if (inputString.charAt(i) != '0')
				break;
		if (i >= inputString.length()) {
			System.out.println("0");
			return;
		}
		StringBuilder maxValueString = new StringBuilder("");
		StringBuilder tempString = new StringBuilder("");
		boolean hasCharCome = false;
		int nextStartingPosition = i;
		while (i < inputString.length()) {
			if (inputString.charAt(i) > '9') {
				if (hasCharCome) {
					i = nextStartingPosition;
					if (isFirstGreater(tempString, maxValueString))
						maxValueString = tempString;
					tempString = new StringBuilder("");
					hasCharCome = false;
				} else {
					tempString.append(inputString.charAt(i));
					tempString = new StringBuilder(tempString.toString().replaceFirst("^0+(?!$)", ""));
					hasCharCome = true;
					nextStartingPosition = i + 1;
					i++;
				}
			} else {
				tempString.append(inputString.charAt(i));
				tempString = new StringBuilder(tempString.toString().replaceFirst("^0+(?!$)", ""));
				i++;
			}
		}
		if (tempString.length() > 0) {
			if (isFirstGreater(tempString, maxValueString))
				maxValueString = tempString;
			tempString = new StringBuilder("");
		}
		for (int k = 0; k < maxValueString.length(); k++) {
			if (maxValueString.charAt(k) > 58) {
				maxValueString.replace(k, k + 1, "9");
				break;
			}
		}
		System.out.println(maxValueString.toString());
	}

	public static void main(String[] args) throws NumberFormatException,IOException {
		solve();
	}
}
