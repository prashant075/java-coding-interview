package com.codingBlock.Stack;

public class Client {
	
	public static void main(String[] args) throws Exception{
		StackUsingArray stack = new StackUsingArray(5); 
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
		//stack.push(100);
		System.out.println(stack.top());
		stack.pop();
		stack.push(80);
		stack.display();
		StackUsingArray helper = new StackUsingArray(5);
		reverseStack(stack, helper,0);
		stack.display();
		
	
	}

	private static void reverseStack(StackUsingArray stack, StackUsingArray helper, int index) throws Exception {
		if(stack.isEmpty()){
			return;
		}
		int item = stack.pop();
		reverseStack(stack,helper,index+1);
		helper.push(item);
		if(index ==0){
			while(!helper.isEmpty()){
				stack.push(helper.pop());
			}
		}
		
		
	}

}
