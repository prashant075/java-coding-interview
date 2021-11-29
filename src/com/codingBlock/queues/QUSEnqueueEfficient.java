package com.codingBlock.queues;

import com.codingBlock.Stack.DynamicStack;
import com.codingBlock.Stack.StackUsingArray;

public class QUSEnqueueEfficient {
		private DynamicStack primary;
		private DynamicStack secondary;
		
		public QUSEnqueueEfficient() throws Exception{
			this.primary = new DynamicStack();
			this.secondary = new DynamicStack();
		}
		
		public boolean isEmpty(){
			return this.primary.isEmpty();
		}
		public int size(){
			return this.primary.size();
		}
		
		
		//o(1)
		public void enqueue(int data) throws Exception{
			this.primary.push(data);
		}
		
		
		//o(n)
		public int dequeue() throws Exception{
			while((primary.size() != 1)){
				secondary.push(primary.pop());
			}
			
			int rv = primary.pop();
			while((!secondary.isEmpty())){
				primary.push(secondary.pop());
			}
			return rv;
		}
		//o(n)
		public int Front() throws Exception{
			while((primary.size() != 1)){
				secondary.push(primary.pop());
			}
			
			int rv = primary.top();
			while((!secondary.isEmpty())){
				primary.push(secondary.pop());
			}
			return rv;
		}
		
		//o(n)
		public void display() throws Exception{
			reverseStack(primary,secondary, 0);
			primary.display();
			reverseStack(primary,secondary, 0);
		}
		
		private static void reverseStack(DynamicStack stack, DynamicStack helper, int index) throws Exception {
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
