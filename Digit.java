public class Digit extends Number {
	private static String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
	                                  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
									  "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
									  "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", 
									  "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
									  "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
	                                  "Y", "Z", ":", "/"};
	
	public Digit(String value, int base) {
		if (value.length() = 1) {
			super(value, base);
		}
	}
	
	@Override
	public Number add(Digit a, base b) {
		int temp = this.value() + a.value();
		if (temp >= b) { //handles carryover (if 8 + 9 returns 17)
			return new Number(values[1] + values[temp % b], b);
		}
		else { 
			return new Digit(temp, b);
		}			
	}
	

}
