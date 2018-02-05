package com.zinkirin;
/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
		if (s == null || s.length() < 1)
			return false;

		// filter ".e1"
		if (s.matches("^[.e][.e][0-9]*$"))
			return false;
		// filter ".", "-"
		if (s.matches("[.-]+"))
			return false;
		// pass "3" "-3" "+3" "-0000" "+0000"
		
		if (s.matches("[-+]?[0-9]+[.]?[0-9]*([e][-+]?[0-9]+)?"))
			return true;
		if (s.matches("[-+]?[0-9]*[.][0-9]*([e][-+]?[0-9]+)?"))
			return true;

		return false;
	}

	public boolean isNumber1(String s) {
		if (s.trim().isEmpty()) {
			return false;
		}
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		if (s.trim().matches(regex)) {
			return true;
		} else {
			return false;
		}
	}
}
