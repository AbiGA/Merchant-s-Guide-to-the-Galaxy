package com.merchantGalaxy.answers;

import com.merchant.galaxy.Input;
import com.merchant.galaxy.RomanToDecimalConvertor;

public class PrimitiveQuestion implements AnswerToQuestion {

		@Override
	public String answerToQuestion(String line, Input input) {
		// TODO Auto-generated method stub
		 String[] words = line.split(" ");
	        for (int i = 3; i < words.length - 1; i++) {
	            if (!input.getPrimitiveMap().containsKey(words[i])) {
	              //  Input.answerText="FAIL";
	            	return "FAIL";
	            }
	        }
	        StringBuilder romanString = new StringBuilder();
	        for (int i = 3; i < words.length - 1; i++) {
	            romanString.append(input.getPrimitiveMap().get(words[i]));
	        }
	        RomanToDecimalConvertor romanTodecimal = new RomanToDecimalConvertor();
	        int decimal = romanTodecimal.convertToDecimal(romanString.toString());
	        if (decimal == 0) {
	            return "FAIL";
	        } else {
	            String output = "";
	            for (int i = 3; i < words.length - 1; i++) {
	                output = output.concat(words[i] + " ");
	            }
	            output = output.concat("is " + decimal + " Credits");
	            return (output);
	        }
	}

}
