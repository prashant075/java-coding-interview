package com.codingBlock.array;

public class BubbleSort {

	public static void main(String[] args) {
		int [] array ={50,40,30,20,10};
		for(int arr: array)
		System.out.println(arr);
		System.out.println("After Sort");
		
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j] > array[j+1]){
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j]=temp;
			}
				}
		}
		
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}

}
