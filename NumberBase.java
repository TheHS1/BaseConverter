import java.util.*;

public class NumberBase {
	private String value;
	private int base;
	private ArrayList<Digit> digits;
	
	public NumberBase(String value, int base) {
		this.value = value;
		this.base = base;
		
		if (value.length() > 1) {
			for (int i = 0; i < value.length(); i++) { //add digits to arraylist
				digits.add(new Digit(value.substring(i,i+1), base));
			}
		}
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setbase(int base) {
		this.base = base;
	}
	
	public int length() {
		return this.digits.size();
	}
	
	public String toString() {
		return this.value;
	}
	
	/*public NumberBase add(NumberBase a, int b) {
		if (this instanceof Digit && a instanceof Digit) {
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
			
			return NumberBase(result, b);
		}
	}*/
	
	public static void main(String[] args) {
		Digit one = new Digit("5",6);
		Digit two = new Digit("2",6);
		System.out.println(one.add(two,6));
	}
	
	
}
