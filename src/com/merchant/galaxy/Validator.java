package com.merchant.galaxy;

public class Validator {
	
	public boolean validateRepeatations(String roman) {
        char[] result = roman.toCharArray();
        int i;
        if (result.length > 3) {
            for (i = 0; i < result.length - 3; i++) {
               
                if ((result[i] == result[i + 1]) && (result[i + 1] == result[i + 2])) {
                    if (result[i] == result[i + 3]) {
                        return false;
                    }
                    if (result.length > i + 5) {  
                        if (result[i + 4] == result[i]) {
                            if (RomanToDecimalConvertor.getRomanSymbolmap().get(Character.toString(result[i + 3])) > RomanToDecimalConvertor.getRomanSymbolmap().get(Character.toString(result[i + 4]))) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
	
	 public boolean validateNoRepeatations(String roman) {
	        char[] result = roman.toCharArray();
	        int i, j;
	        for (i = 0; i < result.length; i++) {
	            for (j = i + 1; j < result.length; j++) {
	                if (result[i] == result[j]) {
	                    if (RomanToDecimalConvertor.nonRepeatingRomanNumbers.contains(result[i])) {
	                        return false;
	                    }
	                }
	            }
	        }
	        return true;
	    }

}
