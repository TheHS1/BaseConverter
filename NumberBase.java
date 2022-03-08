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
	
	public NumberBase add(NumberBase a, int b) {
		if (this instanceOf Digit && a instanceOf Digit) {
			return this.add(a).digits[1];
		}
		else {
			this.length() = len1;
			a.length() = len2;
			int max;
			int longer = 0;
			
			if (len1 >= len2) { max = len2; longer = 1; } //take smaller length, keep track of which is longer
			else { max = len1; longer = 2; }
			
			String result = "";
			NumberBase tempsum, carry; //tempsum used for adding digits, carry used for carryover
			
			for (int i = 1; i <= max; i--) { //add digits starting from the right
				tempsum = this.digits[len1-i].add(a.digits[len2-i]).add(carry);
				result = this.add(a).digits[1].value + result; //adds the current sum to the beginning of the current result
				carry = result.digits[0]; //set carryover
			} //finish
			if (longer == 1) { result = this.value.substring(0, len1-len2-1) + this.digits[len1-len2-1].add(carry) + result; }
			else if (longer == 2) { result = a.value.substring(0, len2-len1-1) + a.digits[len2-len1-1].add(carry) + result; }
			
			return NumberBase(result);
		}
	}

}
