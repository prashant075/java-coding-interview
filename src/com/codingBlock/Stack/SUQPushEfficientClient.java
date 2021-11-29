package com.codingBlock.Stack;

public class SUQPushEfficientClient {
	
	public static void main(String[] args){
		SUQPushEfficient stack = new SUQPushEfficient();
			
		for(int i = 1; i<=6 ;i++){
			stack.push(i*10);
		}
		stack.display();
		System.out.println(stack.pop());
		System.out.println(stack.top());
		
		stack.display();
	
	}

}
