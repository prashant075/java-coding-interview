package com.codingBlock.timeandSpace;

public class QuickSort {
	
	public static void quicksort(int arr[], int lo, int hi){
		int mid = (lo+hi)/2;
		int pivot = arr[mid];
		
		if(lo >= hi){
			return;
		}
		int left = lo;
		int right = hi;
		
		while(left <= right){
			while(pivot > arr[left]){
				left++;
			}
			while(pivot < arr[right]){
				right--;
			}
			
			if(left <=right){
				
				int temp = arr[left];
				arr[left]=arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quicksort(arr,lo, right);
		quicksort(arr,left, hi);
	}
	
	public static void main(String[] args){
		int array[] = {20,30,10,50,40,90,70,80,60};
		quicksort(array,0,array.length-1);
		for(int val: array){
			System.out.print(val+" ");
		}
	}
}
