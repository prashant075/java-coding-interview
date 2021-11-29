package com.codingBlock.array;

public class UpperBound {

	public static void main(String[] args) {
		int[] array={1,2,2,2,2,3,3,3,5,6,6};
		System.out.println(upperBound(array,2));

	}

	private static int upperBound(int[] array, int val) {
		
		int low =0, ans =-1;
		int high = array.length-1;
		for(int i=0;i<array.length;i++){
			int mid = (low+high)/2;
			if(array[mid] > val){
				high = mid -1;
			}else if(array[mid] <val){
				low = mid +1;
			}else{
				ans =mid;
				low = mid +1;
			}
		}
		
		return ans;
	}


}
