package com.codingBlock.DP;

public class Fibonacci {
	
	public static void main(String[] args){
		System.out.println(fibMinSpace(8));
		System.out.println(fibMinSpaceArray(8));
	}
	
	private static int fibMinSpace(int n){
		int first = 0;
		int second = 1;
		
		for(int i =1;i <=n -1; i++ ){
			int sum = first+second;
			first = second;
			second = sum;
		}
		
		return second;
	}
	
	private static int fibMinSpaceArray(int n){
		int[] strg = new int[2];
		strg[0]  =0;
		strg[1]  =1;
		
		for(int slide =1;slide <=n -1; slide++ ){
			int sum = strg[0]+strg[1];
			strg[0] = strg[1];
			strg[1] = sum;
		}
		return strg[1];
	}
}
