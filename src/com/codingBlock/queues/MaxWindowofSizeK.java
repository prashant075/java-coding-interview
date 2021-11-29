package com.codingBlock.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class MaxWindowofSizeK {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i =0; i<arr.length;i++){
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		printMax(arr, k);
	}

	private static void printMax(int[] arr, int k) {
		Deque<Integer> q = new LinkedList<>();
		int i;
		for( i =0; i<k ;i++){
			while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
				q.removeLast();
			}
			q.addLast(i);
		}
		
		for(;i<arr.length;i++){
			System.out.println(arr[q.getFirst()] + " ");
			
			while(!q.isEmpty() && q.getFirst() <=i-k){
				q.removeFirst();
			}
			
			while(!q.isEmpty() && arr[i]>arr[q.getLast()]){
				q.removeLast();
			}
			q.addLast(i);
			
		}
		System.out.println(arr[q.getFirst()] + " ");
		
	}

}
