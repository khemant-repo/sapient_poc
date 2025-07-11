package com.tuf.dsa.java8;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class FindSmallestSubstring {

	public static void main(String[] args) {
		
		String mainString = "ADOBECODEBANC";
		String pattern = "ABC";
		
		String smallestSubstring = findSmallestSubstring(mainString,pattern);
		System.out.println("Smallest Substring from String: ("+mainString +") for pattern: ("+pattern +") is "+ smallestSubstring);
	}

	private static String findSmallestSubstring(String mainString, String pattern) {
		// TODO Auto-generated method stub
		String result = "";
		if(StringUtils.isEmpty(mainString) || StringUtils.isEmpty(pattern))
			return result;
		else {
			Map<String , Integer> countPattern = new HashMap<String, Integer>();
			Map<String , Integer> window = new HashMap<String, Integer>();
			
			for (int i = 0; i < pattern.length(); i++) {
				if(countPattern.isEmpty())
				 countPattern.put(String.valueOf(pattern.charAt(i)), Integer.valueOf(countPattern.get(String.valueOf(pattern.charAt(i)))+1));
			}
			System.out.println("countPattern map: "+countPattern);
			
		}
		return result;
	}
}
