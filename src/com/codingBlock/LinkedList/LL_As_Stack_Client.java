package com.codingBlock.LinkedList;

public class LL_As_Stack_Client {
	public static void main(String[] args) throws Exception{
		LL_AS_Stack stack = new LL_AS_Stack();
		stack.push(10);
		stack.display();
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.size()); 
	}
}
