import java.util.*;

public class NumberBase {
	private String value;
	private int base;
	private List<Digit> digits;
	
	public NumberBase(String value, int base) {
		this.value = value;
		this.base = base;
		
		for (int i = 0; i < value.length(); i++) { //add digits to arraylist
			digits.add(new Digit(value.substring(i,i+1)));
		}
	}
	
	public String value() {
		return this.value;
	}
	
	public int length() {
		return this.digits.length;
	
	public NumberBase add(NumberBase a, base b) {
		if (this instanceOf Digit && a instanceOf Digit) {
			return this.add(a);
		}
		else {
			this.length() = len1;
			a.length() = len2;
			
			if (len1 >= len2) {int iter = len2; } //take smaller length
			else { int max = len1; }
			
			String result = "";
			NumberBase tempsum;
			for (int i = 0; i < max; i--) {
				tempsum = this[].add(a);
				result = this.add(a).digits[] + result; //requires 
			}
		}
		return Number(result);
	}

}
