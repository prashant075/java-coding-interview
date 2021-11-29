package com.codingBlock.DP;

public class RodCutting {

	public static void main(String[] args) {
		int [] price= {0,1,5,8,9,10,17,17,20};
		System.out.println(RodCuttingRec(price, price.length-1));
		System.out.println(RodCuttingTD(price, price.length-1, new int[price.length]));
		System.out.println(RodCuttingBU(price));
	}
	public static int RodCuttingRec(int[] price, int n ) {
		
		int max = price[n];
		int left =1;
		int right =n-1;
		
		while(left <= right) {
			
			int fp = RodCuttingRec(price, left);
			int sp = RodCuttingRec(price, right);
			int total = fp+ sp;
			
			if(total > max) {
				max = total;
			}
			
			left++;
			right--;
		}
		
		return max;
	}
	
	public static int RodCuttingTD(int[] price, int n, int[] strg ) {
		
		if(strg[n] !=0) {
			return strg[n];
		}
		int max = price[n];
		int left =1;
		int right =n-1;
		
		while(left <= right) {
			
			int fp = RodCuttingTD(price, left,strg);
			int sp = RodCuttingTD(price, right,strg);
			int total = fp+ sp;
			
			if(total > max) {
				max = total;
			}
			
			left++;
			right--;
		}
		strg[n] = max;
		return max;
	}
	public static int RodCuttingBU(int[] price) {
		
		int[] strg = new int[price.length];
		strg[0] = price[0];
		strg[1] = price[1];
		
		for(int n=2; n < strg.length;n++) {
			int max = price[n];
			int left =1;
			int right =n-1;
			while(left <= right) {
				
				int fp = strg[left];
				int sp = strg[right];
				int total = fp+ sp;
				
				if(total > max) {
					max = total;
				}
				
				left++;
				right--;
			}
			strg[n] = max;
		}
		return strg[strg.length-1];
	}
	
	

}
