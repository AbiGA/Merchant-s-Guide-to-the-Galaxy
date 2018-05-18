package com.merchant.galaxy;

public class Main {
	public static void main(String[] args) {
		 String fileLocation = "resources/file/sampleInput.txt";
		   
		  try {
			  Input ip = new Input();
	            ip.ProcessInputFile(fileLocation);
	        } catch (Exception e) {
	            System.out.println("File not found!!");
	        }
	    }
	}
