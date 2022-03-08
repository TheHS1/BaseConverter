import java.util.*;

public class Digit extends NumberBase {
	private static String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
	                                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
					  "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
					  "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
					  "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
					  "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
	                                  "Y", "Z", ":", "/"};
	private static List<String> valuesList = Arrays.asList(values);
	
	public Digit(String value, int base) {
		super(value, base);
	}
	
	
	
	public NumberBase add(Digit a, int b) {
		int temp = valuesList.indexOf(this.toString()) + valuesList.indexOf(a.toString());
		if (temp >= b) { //handles carryover (if 8 + 9 returns 17)
			return new NumberBase(values[1] + values[temp % b], b);
		}
		else { 
			return new NumberBase("0" + values[temp], b);
		}			
	}
}
