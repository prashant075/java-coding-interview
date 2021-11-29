package com.codingBlock.HashTable;

import java.util.HashMap;

public class SubArrayWithSumZero {
	public static void main(String [] args){
		int [] arr={3,-5,-8,9,-1};
		System.out.println(SubArrayZero(arr));
	}

	private static boolean SubArrayZero(int[] arr) {
		HashMap<Integer,Boolean> map = new HashMap<>();
		int presum =0;
		for(int i=0;i<arr.length;i++){
			presum+=arr[i];
			if(presum==0 || map.containsKey(presum)){
				return true;
			}else{
				map.put(presum, true);
			}
		}
		return false;
	}
	
	
}
