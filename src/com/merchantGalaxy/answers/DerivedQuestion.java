package com.merchantGalaxy.answers;

import com.merchant.galaxy.Input;
import com.merchant.galaxy.RomanToDecimalConvertor;

public class DerivedQuestion implements AnswerToQuestion {


	public String answerToQuestion(String line, Input input) {
		// TODO Auto-generated method stub
		 String[] words = line.split(" ");
	       
	        for (int i = 4; i < words.length - 2; i++) {
	            if (!input.getPrimitiveMap().containsKey(words[i])) {
	            	return "FAIL";
	            }
	        }
	        
	        if (!input.getDerivedMap().containsKey(words[words.length - 2])) {
	        	return "FAIL";
	        }
	
	        StringBuilder romanString = new StringBuilder();
	        for (int i = 4; i < words.length - 2; i++) {
	            romanString.append(input.getPrimitiveMap().get(words[i]));
	        }
	        RomanToDecimalConvertor romanTodecimal = new RomanToDecimalConvertor();
	        int decimal = romanTodecimal.convertToDecimal(romanString.toString());
	        if (decimal == 0) {
	            return "FAIL";
	        } else {
	            String output = "";
	            for (int i = 4; i < words.length - 1; i++) {
	                output = output.concat(words[i] + " ");
	            }
	 
	            float derivedValue = decimal * (input.getDerivedMap().get(words[words.length - 2]));
	            output = output.concat("is " + Math.round(derivedValue) + " Credits");
	            return (output);
	        }
	}
	}


