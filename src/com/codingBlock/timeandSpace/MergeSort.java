package com.codingBlock.timeandSpace;

public class MergeSort {
	
	public static int [] merge(int [] arr1, int [] arr2){
		int [] res = new int[arr1.length + arr2.length];
		int i=0, j=0,k=0;
		
		while(i < arr1.length && j < arr2.length){
			if(arr1[i] < arr2[j]){
				res[k]= arr1[i];
				i++;
				k++;
			}else{
				res[k] =arr2[j];
				k++;
				j++;
			}
		}
		
		if(i ==arr1.length){
			while(j <arr2.length){
				res[k]=arr2[j];
				k++;
				j++;
			}
		}
		if(j ==arr2.length){
			while(i <arr1.length){
				res[k]=arr1[i];
				k++;
				i++;
			}
		}
		return res;
	}
	
	public static int [] mergesort(int [] arr, int low, int high){
		
		if(low ==high){
			int [] br = new int[1];
			br[0]= arr[low];
			return br;
		}
		
		int mid =(low+high)/2;
		
		int arr1[] =mergesort(arr, low, mid);
		int arr2[] =mergesort(arr,mid+1, high);
		int ans[]  =merge(arr1,arr2);
		return ans;
	}
	
	public static void main(String[] args){
		int arr1[] = {10,20,30,90};
		int arr2[] = {40,50,60};
		
		int ans[] = merge(arr1,arr2);
		
		for(int val : ans){
			System.out.print(val+" ");
		}
		System.out.print("\n");
		int array[] = {20,30,10,50,40,90,70,80,60};
		int answer[] = mergesort(array,0,array.length-1);
		for(int val: answer){
			System.out.print(val+" ");
		}

	}
}