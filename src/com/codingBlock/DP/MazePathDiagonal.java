package com.codingBlock.DP;

import java.util.Arrays;

public class MazePathDiagonal {
	public static void main(String[] args) {
		int n =2;
		System.out.println(MPDRecusion(0,0,n,n));
		System.out.println(MPTD(0,0,n,n,new int[n+1][n+1]));
		System.out.println(MPDBU(n,n));
		System.out.println(MPDBUSEF(n,n));
	}
	
	public static int MPDRecusion(int cr, int cc, int er , int ec) {
		
		if(cr==er && cc == ec) {
			return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		
		int ch = MPDRecusion(cr,cc+1,er,ec);
		int cv = MPDRecusion(cc+1,cr,er,ec);
		int cd = MPDRecusion(cc+1,cr+1,er,ec);
		return ch+cv+cd;
	}
	
	public static int MPTD(int cr, int cc, int er , int ec, int [][] strg) {
		
		if(cr==er && cc == ec) {
			return 1;
		}
		if(cr > er || cc > ec) {
			return 0;
		}
		if(strg[cr][cc] !=0) {
			return strg[cr][cc];
		}
		
		int ch = MPTD(cr,cc+1,er,ec,strg);
		int cv = MPTD(cc+1,cr,er,ec,strg);
		int cd = MPTD(cc+1,cr+1,er,ec,strg);
		strg[cr][cc]= ch+cv+cd;
		return ch+cv+cd;
	}
	
public static int MPDBU( int er , int ec ) {
		
		int [][] strg = new int [er+2][ec+2];
		
		for(int row =er; row >=0;row--) {
			for(int col = ec; col>=0;col--) {
				if(row ==er && col ==ec) {
					strg[row][col] =1;
				}else {
					strg[row][col] = strg[row+1][col]+strg[row][col+1]+strg[row+1][col+1];
				}
			}
		}
		return strg[0][0];
		
	}

public static int MPDBUSEF( int er , int ec ) {
	
	int [] strg = new int [1+Math.max(er,ec)];
	
	Arrays.fill(strg, 1);
	int diag =0;
	for(int slide =er -1; slide >=0;slide--) {
		for(int col = ec; col>=0;col--) {
			if(col ==ec) {
				strg[col] =1;
				diag =1;
			}else {
				int val =strg[col] + strg[col+1]+ diag;
				diag = strg[col];
				strg[col]=val;
			}
		}
	}
	return strg[0];
	
}
}
