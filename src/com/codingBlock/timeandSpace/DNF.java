package com.codingBlock.timeandSpace;

public class DNF {
	
	public static void main(String[] args){
		
		int arr[] = {0,1,1,0,2,1,2};
		
		int low =0;
		int mid =0;
		int high = arr.length-1;
		
		while(mid <=high){
			if(arr[mid] ==0){
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] =temp;
				low++;
				mid++;
			}else if(arr[mid]==1){
				mid++;
			}else{
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] =temp;
				high--;
			}
		}

		
		for(int val:arr){
			System.out.print(val+" ");
		}
	}
}
