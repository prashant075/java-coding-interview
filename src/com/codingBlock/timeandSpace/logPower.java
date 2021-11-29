package com.codingBlock.timeandSpace;

public class logPower {
	
	public static int power(int x, int n){
		
		if(n ==0){
			return 1;
		}
		
		if(n%2==1){
			return power(x,n/2)*power(x,n/2) *x;
		}else{
			return power(x,n/2)*power(x,n/2) ;
		}
	}
	public static void main(String [] args){
		
		System.out.println(power(2,4));
	}

}
