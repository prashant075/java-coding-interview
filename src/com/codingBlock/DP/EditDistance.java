package com.codingBlock.DP;


//Min Ops need to make both string equal
public class EditDistance {
	
	public static void main(String[] args) {
		String s1 = "abdd", s2 = "abcd";
		int [][] strg = new int[s1.length()][s2.length()];
		
		for(int i=0; i< strg.length; i++) {
			for(int j=0; j<strg[0].length;j++) {
				strg[i][j] =-1;
			}
		}
		System.out.println(EDRecursion(s1,s2));
		System.out.println(EDRecursionvidx(s1,s2,0,0));
		System.out.println(EDTD(s1,s2,0,0,strg));
		System.out.println(EDBU(s1,s2));
	}
	public static int EDRecursion(String s1, String s2) {
		
		if(s1.length() == 0 || s2.length() ==0) {
			return Math.max(s1.length(),s2.length());
		}
		
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		
		int ans =0;
		if(ch1 == ch2) {
			ans = EDRecursion(ros1, ros2);
		}else {
			int i = EDRecursion(ros1, s2);
			int d = EDRecursion(s1, ros2);
			int r = EDRecursion(ros1, ros2);
			
			ans = Math.min(i, Math.min(d, r)) +1;
		}
		
		return ans ;
	}
	
	public static int EDRecursionvidx(String s1, String s2,int index1, int index2) {
		
		if(s1.length() ==index1  || s2.length() ==index2) {
			return Math.max(s1.length() -index1,s2.length() -index2);
		}
		
		char ch1 = s1.charAt(index1);
		char ch2 = s2.charAt(index2);
		
		
		int ans =0;
		if(ch1 == ch2) {
			ans = EDRecursionvidx(s1, s2,index1+1,index2+1);
		}else {
			int i = EDRecursionvidx(s1, s2,index1 +1,index2 );
			int d = EDRecursionvidx(s1, s2,index1, index2+1);
			int r = EDRecursionvidx(s1, s2,index1+1, index2+1);
			
			ans = Math.min(i, Math.min(d, r)) +1;
		}
		
		return ans ;
	}
	
public static int EDTD(String s1, String s2,int index1, int index2, int[][] strg) {
		
		if(s1.length() ==index1  || s2.length() ==index2) {
			return Math.max(s1.length() -index1,s2.length() -index2);
		}
		if(strg[index1][index2] !=-1) {
			return strg[index1][index2];
		}
		
		char ch1 = s1.charAt(index1);
		char ch2 = s2.charAt(index2);
		
		int ans =0;
		if(ch1 == ch2) {
			ans = EDTD(s1, s2,index1+1,index2+1,strg);
		}else {
			int i = EDTD(s1, s2,index1 +1,index2,strg );
			int d = EDTD(s1, s2,index1, index2+1,strg);
			int r = EDTD(s1, s2,index1+1, index2+1,strg);
			
			ans = Math.min(i, Math.min(d, r)) +1;
		}
		
		return ans ;
	}

	public static int EDBU(String s1, String s2) {
	
		int [][] strg = new int[s1.length() +1][s2.length() +1];
		
		
		for(int row =s1.length() ; row >=0; row--) {
			for(int col =s2.length();col>=0;col--) {
				
				//base case : deletion ops
				if(row == s1.length()) {
					strg[row][col] = s2.length() -col;
				}
				
				//base case: insertion Ops
				else if(col == s2.length()) {
					strg[row][col] = s1.length() -row;
				}
				//you are filling middle cells
				else {
					if(s1.charAt(row) == s2.charAt(col)) {
						strg[row][col] = strg[row+1][col+1];
					}else{
						
						int i = strg[row+1][col];
						int d = strg[row][col+1];
						int r = strg[row+1][col+1];
						strg[row][col] = Math.min(i, Math.min(d, r)) +1;
						
					}
					
				}
			}
		}
		
		return strg[0][0] ;
	}
}
