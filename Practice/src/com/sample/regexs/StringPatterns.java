package com.sample.regexs;

public class StringPatterns {

	
	public static void main(String[] args) {
		int i='a'; // 97
		int j = 'z'; // 122
		System.out.println(j);
		System.out.println(reverseString("abcde"));
	}

	private static char[] reverseString(String word) {
		char[] carr = word.toCharArray();
		int len = carr.length;
		for (int i=len; i>0; i++) {
			System.out.println(carr[i-1]);
		}
		return carr;
	}
	
}
