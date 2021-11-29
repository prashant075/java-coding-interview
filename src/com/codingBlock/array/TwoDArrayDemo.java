package com.codingBlock.array;

import java.util.Scanner;

public class TwoDArrayDemo {
	
	public static void main(String[] args){
		int[][] arr = new int[3][3]; //or new int
		/*
		display(arr);
		arr[0][0] =10;
		arr[2][0] =20;
		display(arr);
		*/
		int [][] arr1 = takeInput();
		displayIn(arr1);
	}
	
	private static int[][] takeInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = sc.nextInt();
		int[][] arr = new int[rows][];
		for(int row=0; row<rows;row++){
			System.out.println("Enter the number of cols for row"+row);
			int cols= sc.nextInt();
			arr[row] = new int[cols];
			for(int col =0; col < cols;col++){
				System.out.println("Enter the value for row" + row+" and"+col);
				arr[row][col]= sc.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j =0; j<arr.length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void displayIn(int[][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col =0; col<arr[row].length;col++){
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
	}

}
