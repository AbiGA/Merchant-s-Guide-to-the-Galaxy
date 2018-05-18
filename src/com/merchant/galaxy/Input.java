package com.merchant.galaxy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.merchantGalaxy.answers.AssignDerived;
import com.merchantGalaxy.answers.AssignPrimitive;
import com.merchantGalaxy.answers.DerivedQuestion;
import com.merchantGalaxy.answers.PrimitiveQuestion;

public class Input {

    private Map<String, String> primitiveMap = new HashMap<>();
    private Map<String, Float> derivedMap = new HashMap<>();
    private HashMap<String, GalaxyGuide> map = new HashMap<String,GalaxyGuide>();
    private static String output = "";
    
    public void ProcessInputFile(String filePath) throws IOException {
        BufferedReader bufferedReader;
        FileReader fileReader;
        fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
        Input input = new Input();
        String line;   
        
        while ((line = bufferedReader.readLine()) != null) {
        	output = "";
        	String ln = classifyLines(line);
        	buildHashMap(line,input);
           map.get(ln).galaxyRun();
        	 
            if (output.equals("FAIL")) {
            	output = "I have no idea what you are talking about";
            }
            if (!output.equals("SUCCESS") && !output.equals("")) {     
                System.out.println(output);
            }
        }
        bufferedReader.close();
    }
    
public String classifyLines(String line) {
        String[] words = line.split(" ");
  
        if (words.length == 3 && words[1].equals("is")) {                     
            return "ASSIGN PRIMITIVE";
                }
        
        else if (words[words.length - 1].equalsIgnoreCase("Credits") && words[words.length - 3].equalsIgnoreCase("is")) { 
            try {
                Integer.parseInt(words[words.length - 2]);                      
            } catch (NumberFormatException e) {
                return "FAIL";
            }
            return "ASSIGN DERIVED";
          }
        
        else if (words[words.length - 1].equalsIgnoreCase("?") && words.length > 4) {
            String validateQn = "";
            for (int i = 0; i < 3; i++) {
                validateQn = validateQn.concat(words[i] + " ");
            }
            if (validateQn.equalsIgnoreCase("how much is ")) {
                return "QUESTION PRIMITIVE";
                }
            else {
                validateQn = "";
                for (int i = 0; i < 4; i++) {
                    validateQn = validateQn.concat(words[i] + " ");
                }
                if (validateQn.equalsIgnoreCase("how many Credits is ")) {
                    return "QUESTION DERIVED";
                }
            }
        }
        return "FAIL";
    }
    public void buildHashMap(final String line, final Input input){
    	
    	map.put("ASSIGN PRIMITIVE", new GalaxyGuide() { 
			@Override
			public void galaxyRun() {
				// TODO Auto-generated method stub
			  (new AssignPrimitive()).answerToQuestion(line,input);
			}
		});
		map.put("ASSIGN DERIVED", new GalaxyGuide() { 
			@Override
			public void galaxyRun() {
				// TODO Auto-generated method stub
				(new AssignDerived()).answerToQuestion(line,input); 
			}
		});
		map.put("QUESTION PRIMITIVE",new GalaxyGuide() { 
			@Override
			public void galaxyRun() {
				// TODO Auto-generated method stub
				Input.output = new PrimitiveQuestion().answerToQuestion(line, input);
			}
		});
		map.put("QUESTION DERIVED", new GalaxyGuide() { 
			@Override
			public void galaxyRun() {
				// TODO Auto-generated method stub
				Input.output = new DerivedQuestion().answerToQuestion(line,input);
			}
		});
		map.put("FAIL", new GalaxyGuide() { 
			@Override
			public void galaxyRun() {
				// TODO Auto-generated method stub
				Input.output = "FAIL";
			}
		});
    }

	public Map<String, String> getPrimitiveMap() {
		return primitiveMap;
	}

	public Map<String, Float> getDerivedMap() {
		return derivedMap;
	}

}
