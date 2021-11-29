package com.codingBlock.DP;

import java.util.Arrays;

public class LISN2 {
	
	public static void main(String[] args) {
		int[] arr = {3,4,-1,0,6,2,3};
		System.out.println(LISBU(arr));
		System.out.println(LISBUNlogN(arr));
	}
	
	public static int LISBU(int[] arr) {
		
		int[] strg = new int[arr.length];
		
		Arrays.fill(strg,1);
		
		int max =1;
		for(int i=0; i < strg.length;i++) {
			for(int j =0; j <i ;j++) {
				if(arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j]+1);
				
					max = Math.max(max, strg[i]);
				}
			}
		}
		
		return max;
	}
	
public static int LISBUNlogN(int[] arr) {
		
		int[] le = new int[arr.length];
		
		le[0]=arr[0];
		int len =1;
		
	
		for(int i=1; i < arr.length;i++) {
			if(arr[i] >le[len-1]) {
				le[len] = arr[i];
				len++;
			}else {
				int idx = binarySearch(le, 0, len-1, arr[i]);
				le[idx] = arr[i];
			}
		}
		
		return len;
	}

	public static int binarySearch(int le[], int si, int ei, int item) {
		int low = si;
		int high = ei;
		
		
		while(low <=high) {
			int mid = (low + high) /2;
			if(item > le[mid]) {
				low = mid +1;
			}else {
				high = mid -1;
			}
		}
		
		return low;
	}
}
