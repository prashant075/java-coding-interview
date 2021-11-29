package com.codingBlock.array;

public class SelectionSort {

	public static void main(String[] args) {
		int [] array ={50,40,30,20,10};
		for(int arr: array)
			System.out.println(arr);
			System.out.println("After Sort");
			
		for(int i=0;i<array.length-1;i++){
			int min =i;
			for(int j=i+1;j<=array.length-1;j++){
				if(array[j] <array[min]){
					min =j;
				}
			}
			int temp =array[min];
			array[min] =array[i];
			array[i]=temp;
		}
		
		for(int arr: array)
			System.out.println(arr);
	}

}
