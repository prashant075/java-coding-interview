package com.codingBlock.practice;

public class reachingPoint {
	public static void main(String[] args) {
		
		
	}
public static int MPRecursion(int cr, int cc, int er, int ec) {
		
		if(cc ==er && cc == ec) {
			return 1;
		}
		
		if(cr > er || cc > ec) {
			return 0;
		}
		int ch = MPRecursion(cr, cc+1, er, ec);
		int cv = MPRecursion(cr+1, cc, er, ec);
		
		return ch + cv;
	}
}
