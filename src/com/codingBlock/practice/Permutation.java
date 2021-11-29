package com.codingBlock.practice;

public class Permutation {
	
	public static void main(String[] args) {
		String str ="abc";
		String	res ="";
		permutation( str, res);
		printSS(str,res);
	}

	private static void permutation(String str, String res) {

		if(str.length()==0) {
			System.out.println(res);
			return ;
		}
		for(int i=0; i<str.length();i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0,i) + str.substring(i+1);
			permutation(ros, cc+ res);
		}
		
	}
	
	private static void printSS(String str, String res) {

		if(str.length()==0) {
			System.out.println(res);
			return ;
		}
			char cc = str.charAt(0);
			String ros = str.substring(1);
			printSS(ros,  res);
			printSS(ros, res+cc);
		
		
	}
}
