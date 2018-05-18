package com.merchant.galaxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToDecimalConvertor extends Validator {

    private static final Map<String, Integer> romanSymbolMap = new HashMap<>();

    static {
        getRomanSymbolmap().put("I", 1);
        getRomanSymbolmap().put("V", 5);
        getRomanSymbolmap().put("X", 10);
        getRomanSymbolmap().put("L", 50);
        getRomanSymbolmap().put("C", 100);
        getRomanSymbolmap().put("D", 500);
        getRomanSymbolmap().put("M", 1000);
    }

    static final List<Character> nonRepeatingRomanNumbers = new ArrayList<>(Arrays.asList('D', 'L', 'V'));

    public int convertToDecimal(String roman) {

        roman = roman.toUpperCase();  
       // System.out.println("\n Roman = "+roman);
        if (super.validateNoRepeatations(roman)) {                                   
            if (super.validateRepeatations(roman)) {                                 
                return (calculateDecimalFromRoman(roman));
            }
        }
        return 0;                                                              
    }

    public int calculateDecimalFromRoman(String romanSymbol) {
        int decimalValue = 0;                                                       
        int previousValue = 0;                                                    
     
        for (int x = romanSymbol.length() - 1; x >= 0; x--) {
            char toDecimalValue = romanSymbol.charAt(x);
            int value = getRomanSymbolmap().get(Character.toString(toDecimalValue)); 
   
            switch (toDecimalValue) {
                case 'I':
                	decimalValue = processDecimalValue(value, previousValue, decimalValue);
                    break;

                case 'V':
                	decimalValue += value;                                  
                    break;

                case 'X':
                	decimalValue = processDecimalValue(value, previousValue, decimalValue);
                    break;

                case 'L':
                	decimalValue += value;                                  
                    break;

                case 'C':
                	decimalValue = processDecimalValue(value, previousValue, decimalValue);
                    break;

                case 'D':
                	decimalValue += value;                                  
                    break;

                case 'M':
                	decimalValue = processDecimalValue(value, previousValue, decimalValue);
                    break;
            }
           
            previousValue = value;
        }
        return decimalValue;
    }

    public int processDecimalValue(int currentDecimal, int prevDecimal, int decimal) {
    	
        if (currentDecimal < prevDecimal && prevDecimal <= currentDecimal * 10) {
            return (decimal - currentDecimal);
        } else {
            return (decimal + currentDecimal);
        }
    } 

	public static Map<String, Integer> getRomanSymbolmap() {
		return romanSymbolMap;
	}
}
