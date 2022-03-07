import java.util.*;

public class Number {
	private String value;
	private int base;
	private List<Digit> digits;
	
	public Number(String value, int base) {
		this.value = value;
		this.base = base;
		
		for (int i = 0; i < value.length(); i++) { //add digits to arraylist
			digits.add(new Digit(value.substring(i,i+1)));
		}
	}
	
	public String value() {
		return this.value;
	}
	
	public Number add(Digit a, base b) {
		return Number("0");
		
		
	}

}
