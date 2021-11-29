package com.codingBlock.Stack;

import java.util.Stack;

public class NextGreaterElement {
	
	public static void main(String[] args){
		
		int[] arr = {4,1,3,5};
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0; i<arr.length;i++){
			while(!stack.isEmpty() && arr[i] >stack.peek()){
				int rv = stack.pop();
				System.out.println(rv +"->"+arr[i]);
			}
			stack.push(arr[i]);
		}
		while(!stack.isEmpty()){
			int rv = stack.pop();
			System.out.println(rv +"->"+-1);
		}
	}

}
