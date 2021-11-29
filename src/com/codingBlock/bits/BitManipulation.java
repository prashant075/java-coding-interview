package com.codingBlock.bits;

public class BitManipulation {

	// 2^3, 2^2, 2^1, 2^0
	public static int extractBit(int n, int k) {
		k = 1 << k - 1;
		n = n & k;
		return (n == 0 ? 0 : 1);
	}

	public static int setBit(int n, int k) {
		k = 1 << k - 1;
		n = n | k;
		return n;
	}

	public static int resetBit(int n, int k) {
		k = ~(1 << k - 1);
		n = n & k;
		return n;
	}

	public static int rightMostsetBit(int n) {
		int pos = 1;
		int mask = 1;
		while ((n & mask) == 0) {
			pos++;
			mask = mask << 1;
		}
		return pos;
	}

	public static int getSingle(int arr[]) {
		int i = 0, n = 0;
		while (i < arr.length) {
			n = n ^ arr[i];
			i++;
		}
		return n;
	}

	public static int addOne(int n) {
		int mask = 1;
		while ((n & mask) != 0) {
			n = n ^ mask;
			mask = mask << 1;
		}
		n = n ^ mask;
		return n;
	}

	/*
	 * 001 => 5 010 => 25 011 => 30 100 => 125 101 => 130 110 => 150 111 => 155
	 * 
	 * Power or Unique Power of Sum is a Magic Number
	 */
	public static int magicNo(int i) {
		int ans = 0;
		int pow = 1;
		while (i != 0) {

			pow = pow * 5;
			
			if ((i & 1) != 0) {
				ans += pow;
			}
			i=i>>1;
		}
		return ans;
	}
	/*
	 * 1           =>1st Row => 2^0
	 * 1 1		   =>2st Row => 2^1
	 * 1 2 1	   =>3rd Row => 2^2
	 * 1 3 3 1     =>4th Row => 2^3
	 * 1 4 6 4 1
	 * 1 5 10 10 5 1
	 * Power or Unique Power of Sum is a Magic Number
	 */
	public static int pascalSum(int n) {
		
		return ((1<<n)-1);
	}
	
	public static boolean powerOfTwo(int n) {
		
		if(n !=0){
			if((n&(n-1))==0){
				return true;
			}
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		System.out.println(extractBit(8, 4));
		System.out.println(setBit(8, 2));
		System.out.println(resetBit(8, 4));
		System.out.println(rightMostsetBit(20));

		int arr[] = { 2, 2, 4, 4, 5, 1, 1 };
		System.out.println(getSingle(arr));
		System.out.println(addOne(20));
		System.out.println(magicNo(5));
		System.out.println(pascalSum(4));
		System.out.println(powerOfTwo(1));
	}

}
