package com.codingBlock.array;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {
		int[] array = null;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Array Size \n");
		n = sc.nextInt();
		 array = new int[n];
		 for(int i=0; i<n;i++){
			 System.out.println("Enter Value at "+i +"Index");
			 array[i]= sc.nextInt();
			 
		 }
		 
		 for(int val: array){
			 System.out.println(val);
		 }
		 System.out.println("Before Array Swap");
		 Swap(array[0],array[1]);
		 for(int val: array){
			 System.out.println(val);
		 }
		 
		 int []swapArray=Swap(array,1,2);
		 
		 for(int val: array){
			 System.out.println(val);
		 }
		 

	}
	
	public static void Swap(int i, int j){
		int temp =i;
		i=j;
		j = temp;
	}
	
	public static int[] Swap(int[] arr, int i, int j){
		int temp =arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
		return arr;
	}

}
