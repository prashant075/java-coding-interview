package com.codingBlock.DP;

public class CatalanNumber {
	public static void main(String[] args) {
		//using n on of BST = 2n(C)n / n+1 
		// n =3 node then total unique BST = 5
		// 0 1 2 3 ...
		// 0 1 2 4 ...
		//catalana Series
		int n =5;
		System.out.println(NoofBSTsRec(n));
		System.out.println(NoofBSTsTD(n, new int[n+1]));
		System.out.println(NoofBSTsBU(n));
	}
	
	public static int NoofBSTsRec(int n) {
		
		if(n <=1) {
			return 1;
		}
		int total =0;
		for(int i=1; i<=n;i++) {
			
			int l = NoofBSTsRec(i-1);
			int r = NoofBSTsRec(n-i);
			
			int ans = l * r;
			total +=ans;
		}
		return total;
	}
	public static int NoofBSTsTD(int n, int[] strg) {
		
		if(n <=1) {
			return 1;
		}
		if(strg[n] !=0) {
			return strg[n];
		}
		int total =0;
		for(int i=1; i<=n;i++) {
			
			int l = NoofBSTsTD(i-1,strg);
			int r = NoofBSTsTD(n-i,strg);
			
			int ans = l * r;
			total +=ans;
		}
		strg[n] = total;
		return total;
	}
	public static int NoofBSTsBU(int tn) {
		
		
		int[] strg = new int[tn+1];
		strg[0]= strg[1]=1;
		
		for(int n=2; n <strg.length;n++) {
			int total =0;
			for(int i=1; i<=n;i++) {
				
				int l = strg[i-1];
				int r = strg[n-i];
				
				int ans = l * r;
				total +=ans;
			}
			strg[n] = total;
		}
		
		return strg[tn];
	}
}
