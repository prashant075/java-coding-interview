package com.codingBlock.array;

public class ArrayOp {

	public static void main(String[] args) {
		int[] array = {10,20,30,40,50,60};
		int max;
		
		max =Max(array);
		System.out.println(max);
		System.out.println(LinearSearch(array,30));
		
	}
	
	static int Max(int[] array){
		
		int max =  Integer.MIN_VALUE;
		for(int i=0; i<array.length;i++){
			if(array[i] > max){
				max = array[i];
			}
			
		}
		return max;
	}
	
static int LinearSearch(int[] array, int val){
		for(int i=0; i<array.length;i++){
			if(array[i] == val){
				return i;
			}
		}
		return -1;
	}

}
