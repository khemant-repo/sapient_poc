package com.tuf.dsa.java8;

public class ChangeVariableJavaToCPlusPlus {

	public static void main(String[] args) {
		
		String input =  "thisIsAVariable" ;//"this_is_a_variable";
		
		System.out.println(input.substring(0, 1)+"substring");
		System.out.println(input.substring(1)+"substring1");
		String result = cPlusPlusToJava(input);
		
		System.out.println(result);
	}

	private static String cPlusPlusToJava(String input) {
		// TODO Auto-generated method stub
		String result = "";
		if(input.contains("_")) {
			 String[] str =  input.split("_");
			 result = str[0];
			for (int i = 1; i < str.length; i++) {
				result = result + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
			}
		}else {
			char[] chars = input.toCharArray();
			
			for (int i = 0; i < chars.length; i++) {
				if(chars[i] == Character.toUpperCase(input.charAt(i))) {
					result = result + "_"+String.valueOf(chars[i]).toLowerCase();
				}else {
					result = result + String.valueOf(chars[i]);
				}
			}
		}
		return result;
	}
}
