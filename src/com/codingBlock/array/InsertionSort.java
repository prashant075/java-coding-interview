package com.codingBlock.array;

public class InsertionSort {

	public static void main(String[] args) {
		int [] array ={88,66,34,32,11};
		
		for(int i =1;i<=array.length-1;i++){
			int val =array[i];
			
			int j = i-1;
			while(j>=0 && array[j]>val){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=val;
		}
		
		for(int arr: array){
			System.out.println(arr);
		}

	}

}
