import java.util.*;

public class NumberBased {
	private String value;
	private int base;
	private boolean positive;
	private static String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
	                                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
					  "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
					  "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
					  "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
					  "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
	                                  "Y", "Z", ":", "/"};
	private static List<String> valuesList = Arrays.asList(values);
	
	public static int toBaseTen(String input, int base) {
		if (input.equals("")) {
            return 0;
        }
        int result = 0;
		int neg = 1;
		String temp;
		if (input.substring(0,1).equals("-")) {
			input = input.substring(1);
			neg = -1;
		}
		
		for (int i = 1; i <= input.length(); i++) { //base10 convert
			temp = input.substring(i-1, i);
			result += valuesList.indexOf(temp) * Math.pow(base, input.length()-i);
		}
		return result * neg;
	}
	
	public static List<String> getValues() {
		return valuesList;
	} 
	
	public static String convert(String input, int oldBase, int newBase) {
		int j = 0;
		int testValue = 0;
		String temp = "", result = "", neg = "";
		int baseTen = toBaseTen(input, oldBase);
		if (baseTen < 0) {
			baseTen *= -1;
			neg = "-";
		}
		
		while (testValue <= baseTen) { //find power of newbase that fits in base10 conversion
			testValue = (int)Math.pow(newBase, j++);
		}

		for (int n = j-2; n >= 0; n--) {
			for (int m = newBase-1; m >= 0; m--) {
				if (m * Math.pow(newBase, n) <= baseTen) {
					result += values[m];
					baseTen -= m * Math.pow(newBase, n);
					break;
				}
			}
		}
		return neg + result;
	}

	public static String add(String num1, int base1, String num2, int base2, int outputBase) {
		int sum = toBaseTen(num1, base1) + toBaseTen(num2, base2);
		System.out.println(sum);
		return convert(sum + "", 10, outputBase);
	}

	public static String multiply(String num1, int base1, String num2, int base2, int outputBase) {
		int product = toBaseTen(num1, base1) * toBaseTen(num2, base2);
		return convert(product + "", 10, outputBase);
	}
}
