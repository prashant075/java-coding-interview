package com.codingBlock.Stack;

public class DynamicStackClient {
	public static void main(String[] args) throws Exception{
		DynamicStack stack = new DynamicStack(5); 
		stack.push(10);
		stack.display();
		stack.push(20);
		stack.display();
		stack.push(40);
		stack.display();
		stack.push(60);
		stack.display();
		stack.push(80);
		stack.display();
		stack.push(100);
		stack.display();
		System.out.println(stack.top());
		stack.pop();
		stack.display();
		
	}

}
