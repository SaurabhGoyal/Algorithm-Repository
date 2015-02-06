package pe;

public class Problem25 {
	
	public static String add(String op1, String op2) {
		int op1Length = op1.length();
		int op2Length = op2.length();
		int smallerLength = op1Length < op2Length ? op1Length : op2Length;
		int largerLength = (op1Length + op2Length) - smallerLength;
		op1 = new StringBuffer(op1).reverse().toString();
		op2 = new StringBuffer(op2).reverse().toString();
		StringBuffer result = new StringBuffer();
		int carry = 0;
		int i;
		for (i = 0; i < smallerLength; i++) {
			int sum = (op1.charAt(i) - '0') + (op2.charAt(i) - '0') + carry;
			carry = sum / 10;
			result.append(sum % 10);
		}
		if (op1Length > op2Length) {
			while (i < largerLength) {
				int sum = (op1.charAt(i) - '0') + carry;
				carry = sum / 10;
				result.append(sum % 10);
				i++;
			}
		} else {
			while (i < largerLength) {
				int sum = (op2.charAt(i) - '0') + carry;
				carry = sum / 10;
				result.append(sum % 10);
				i++;
			}
		}
		while (carry > 0) {
			result.append(carry % 10);
			carry /= 10;
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) throws Exception {
		//solve();
		int dig = 1000;
		String a = "2";
		String b = "3";
		String c = "";
		int i = 4;
		while(true){
			c = add(a, b);
			i++;
			//System.out.println(c+", ");
			if(c.length()==dig) break;
			a = b;
			b = c;
		}
		System.out.println(i);
	}

}
