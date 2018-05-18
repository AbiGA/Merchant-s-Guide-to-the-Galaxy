package com.merchantGalaxy.answers;

import com.merchant.galaxy.Input;
import com.merchant.galaxy.RomanToDecimalConvertor;

public class AssignPrimitive implements AnswerToQuestion {


	@Override
	public String answerToQuestion(String line, Input input) {
		// TODO Auto-generated method stub
		String[] words = line.split(" ");
        if (RomanToDecimalConvertor.getRomanSymbolmap().containsKey(words[2])) {
            input.getPrimitiveMap().put(words[0], words[2]);
            return "SUCCESS";
        }
        return "FAIL";
	}

	
}
