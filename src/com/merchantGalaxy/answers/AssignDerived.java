package com.merchantGalaxy.answers;

import com.merchant.galaxy.Input;
import com.merchant.galaxy.RomanToDecimalConvertor;

public class AssignDerived implements AnswerToQuestion {


	@Override
	public String answerToQuestion(String line, Input input) {
		// TODO Auto-generated method stub
		 String[] words = line.split(" ");
		
	        for (int i = 0; i < words.length - 4; i++) {
	            if (!input.getPrimitiveMap().containsKey(words[i])) {
	            	return "FAIL";
	            }
	        }
	        
	        StringBuilder romanString = new StringBuilder();

	        for (int i = 0; i < words.length - 4; i++) {
	            romanString.append(input.getPrimitiveMap().get(words[i]));
	        }
	        RomanToDecimalConvertor romanTodecimal = new RomanToDecimalConvertor();
	        int decimal = romanTodecimal.convertToDecimal(romanString.toString());
	        if (decimal == 0) {
	            return "FAIL";
	        } 
	        else {	       
		       	float derivedValue = Float.parseFloat(words[words.length - 2]) / decimal;
	            input.getDerivedMap().put(words[words.length - 4], derivedValue);
	          //  System.out.println(words[words.length - 4]+" "+ derivedValue);
	            return "SUCCESS";
	        }	
	}

	
	}
