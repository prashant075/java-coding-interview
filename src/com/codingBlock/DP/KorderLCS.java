package com.codingBlock.DP;

import java.util.Arrays;

public class KorderLCS {

	public static void main(String[] args) {
		String s1 = "abchd";
		String s2= "agcfd";
		int k =1;
		int[][][] strg = new int[k+1][s1.length()][s2.length()];
		
		for(int i =0; i< strg.length;i++) {
			for(int j=0; j <strg[0].length;j++) {
				Arrays.fill(strg[i][j], -1);
			}
		}
		System.out.println(KorderLCS(s1,s2,k,0,0));
		System.out.println(KorderTD(s1,s2,k,0,0, strg));
		System.out.println(KorderBU(s1,s2,k));

	}
	
	public static int KorderLCS(String s1, String s2, int k, int vidx1, int vidx2) {
		
		if(s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}
		
		int ans =0;
		if(s1.charAt(vidx1) == s2.charAt(vidx2)){
			ans =KorderLCS(s1, s2, k, vidx1 +1, vidx2+1) +1;
		}else {
			int o1 =KorderLCS(s1, s2, k, vidx1, vidx2+1);
			int o2 =KorderLCS(s1, s2, k, vidx1 +1, vidx2);
			int o3 = 0;
			
			if(k>=1)
				o3= KorderLCS(s1, s2, k-1, vidx1 +1, vidx2+1) +1;
		
			ans = Math.max(o1, Math.max(o2,o3));
		}
		return ans;
	}
	
	public static int KorderTD(String s1, String s2, int k, int vidx1, int vidx2, int[][][] strg) {
		
		if(s1.length() == vidx1 || s2.length() == vidx2) {
			return 0;
		}
		
		if(strg[k][vidx1][vidx2] !=-1) {
			return strg[k][vidx1][vidx2] ;
		}
		int ans =0;
		if(s1.charAt(vidx1) == s2.charAt(vidx2)){
			ans =KorderTD(s1, s2, k, vidx1 +1, vidx2+1,strg) +1;
		}else {
			int o1 =KorderTD(s1, s2, k, vidx1, vidx2+1,strg);
			int o2 =KorderTD(s1, s2, k, vidx1 +1, vidx2,strg);
			int o3 = 0;
			
			if(k>=1)
				o3= KorderTD(s1, s2, k-1, vidx1 +1, vidx2+1,strg) +1;
		
			ans = Math.max(o1, Math.max(o2,o3));
		}
		strg[k][vidx1][vidx2] = ans;
		return ans;
	}
	
	public static int KorderBU(String s1, String s2, int tk ) {
		
		int[][][] strg =new int[tk+1][s1.length()+1][s2.length()+1];
		
		for(int k =0; k <=tk; k++) {
			 
			for(int row = s1.length()-1; row >=0; row--) {
					for(int col = s2.length()-1; col >=0; col--) {
						int ans =0;
						if(s1.charAt(row) == s2.charAt(col)){
							ans =strg[k][row+1][col+1] +1;
						}else {
							int o1 =strg[k][row][col+1];
							int o2 =strg[k][row+1][col];
							int o3 = 0;
							
							if(k>=1)
								o3= strg[k-1][row+1][col+1] +1;
						
							ans = Math.max(o1, Math.max(o2,o3));
						}
						strg[k][row][col] = ans;
					}
			}
		}
		return strg[tk][0][0];
	}
}
