package com.codingBlock.DP;

public class CountNumberOfBinaryString {
	
	public static void main(String[] args){
		int n = 100;
		int [] ones = new int[n];
		int [] zeros = new int[n];
		
		//seed
		
		zeros[0]=1;
		ones[0] =1;
		for(int i =1; i<zeros.length;i++){
			zeros[i] = zeros[i-1] +ones[i-1];
			ones[i] =zeros[i-1];
		}
		int ans = zeros[n-1] + ones[n-1];
		System.out.println(ans);
	}

}
