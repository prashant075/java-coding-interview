package com.codingBlock.array;

public class BinarySearch {
	public static void main(String[] args){
		int [] array = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(array,6));
	}

	private static int binarySearch(int[] array, int value) {
		int low =0;
		int high = array.length -1;
		
		while(low<=high){
			int mid = (low+high)/2;
			if(array[mid] <value){
				low = mid+1;
			}else if(array[mid]>value){
				high = mid -1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
